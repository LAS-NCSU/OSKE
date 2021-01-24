from __future__ import absolute_import, division, print_function, unicode_literals
from collections import Counter, defaultdict
from decimal import Decimal
import logging
import textacy 
import spacy

import itertools
import math
from operator import itemgetter

from cytoolz import itertoolz
from fuzzywuzzy.fuzz import token_sort_ratio
import networkx as nx
import numpy as np

from textacy import extract
from textacy import vsm
from textacy.network import terms_to_semantic_network
from textacy.spacier import utils as spacy_utils

logging.basicConfig(format='%(asctime)s : %(levelname)s : %(message)s', level=logging.INFO)

# own sgrank function as invalid arguments in the predefined one at extract.ngrams, updated here
def mySgRank(doc, window_width=1500, n_keyterms=10, idf=None):
    if isinstance(n_keyterms, float):
        if not 0.0 < n_keyterms <= 1.0:
            raise ValueError('`n_keyterms` must be an int, or a float between 0.0 and 1.0')
    n_toks = len(doc)
    min_term_freq = min(n_toks // 1500, 4)

    # build full list of candidate terms
    terms = list(itertoolz.concat(
        extract.ngrams(doc, n, filter_stops=True, filter_punct=True, filter_nums=False,
                        min_freq=min_term_freq)
        for n in range(1, 7)))
    # if inverse document frequencies available, also add verbs
    # verbs without IDF downweighting dominate the results, and not in a good way
    if idf:
        terms.extend(itertoolz.concat(
            extract.ngrams(doc, n, filter_stops=True, filter_punct=True, filter_nums=False,
                            min_freq=min_term_freq)
            for n in range(1, 7)))

    terms_as_strs = {id(term): spacy_utils.normalized_str(term)
                     for term in terms}

    # pre-filter terms to the top 20% ranked by TF or modified TF*IDF, if available
    n_top_20pct = int(len(terms) * 0.2)
    term_counts = Counter(terms_as_strs[id(term)] for term in terms)
    if idf:
        mod_tfidfs = {term: count * idf[term] if ' ' not in term else count
                      for term, count in term_counts.items()}
        top_term_texts = {term for term, _ in sorted(
            mod_tfidfs.items(), key=itemgetter(1), reverse=True)[:n_top_20pct]}
    else:
        top_term_texts = {term for term, _ in term_counts.most_common(n_top_20pct)}

    terms = [term for term in terms
             if terms_as_strs[id(term)] in top_term_texts]

    # compute term weights from statistical attributes
    term_weights = {}
    set_terms_as_str = {terms_as_strs[id(terms)] for terms in terms}
    n_toks_plus_1 = n_toks + 1
    for term in terms:
        term_str = terms_as_strs[id(term)]
        pos_first_occ_factor = math.log(n_toks_plus_1 / (term.start + 1))
        # TODO: assess if len(t) puts too much emphasis on long terms
        # alternative: term_len = 1 if ' ' not in term else math.sqrt(len(term))
        term_len = 1 if ' ' not in term else len(term)
        term_count = term_counts[term_str]
        subsum_count = sum(term_counts[t2] for t2 in set_terms_as_str
                           if t2 != term_str and term_str in t2)
        term_freq_factor = (term_count - subsum_count)
        if idf and ' ' not in term_str:
            term_freq_factor *= idf[term_str]
        term_weights[term_str] = term_freq_factor * pos_first_occ_factor * term_len

    # filter terms to only those with positive weights
    terms = [term for term in terms
             if term_weights[terms_as_strs[id(term)]] > 0]

    n_coocs = defaultdict(lambda: defaultdict(int))
    sum_logdists = defaultdict(lambda: defaultdict(float))

    # iterate over windows
    for start_ind in range(n_toks):
        end_ind = start_ind + window_width
        window_terms = (term for term in terms
                        if start_ind <= term.start <= end_ind)
        # get all token combinations within window
        for t1, t2 in itertools.combinations(window_terms, 2):
            if t1 is t2:
                continue
            n_coocs[terms_as_strs[id(t1)]][terms_as_strs[id(t2)]] += 1
            try:
                sum_logdists[terms_as_strs[id(t1)]][terms_as_strs[id(t2)]] += \
                    math.log(window_width / abs(t1.start - t2.start))
            except ZeroDivisionError:  # HACK: pretend that they're 1 token apart
                sum_logdists[terms_as_strs[id(t1)]][terms_as_strs[id(t2)]] += \
                    math.log(window_width)
        if end_ind > n_toks:
            break

    # compute edge weights between co-occurring terms (nodes)
    edge_weights = defaultdict(lambda: defaultdict(float))
    for t1, t2s in sum_logdists.items():
        for t2 in t2s:
            edge_weights[t1][t2] = (sum_logdists[t1][t2] / n_coocs[t1][t2]) * term_weights[t1] * term_weights[t2]
    # normalize edge weights by sum of outgoing edge weights per term (node)
    norm_edge_weights = []
    for t1, t2s in edge_weights.items():
        sum_edge_weights = sum(t2s.values())
        norm_edge_weights.extend((t1, t2, {'weight': weight / sum_edge_weights})
                                 for t2, weight in t2s.items())

    # build the weighted directed graph from edges, rank nodes by pagerank
    graph = nx.DiGraph()
    graph.add_edges_from(norm_edge_weights)
    term_ranks = nx.pagerank_scipy(graph)

    if isinstance(n_keyterms, float):
        n_keyterms = int(len(term_ranks) * n_keyterms)

    return sorted(term_ranks.items(), key=itemgetter(1), reverse=True)[:n_keyterms]

textacy.sgrank = mySgRank


'''
file = open('filename.txt', 'r')
text = file.read();
'''

text = "Thomas A. Anderson is a man living two lives. By day he is an " + \
    "average computer programmer and by night a hacker known as " + \
    "Neo. Neo has always questioned his reality, but the truth is " + \
    "far beyond his imagination. Neo finds himself targeted by the " + \
    "police when he is contacted by Morpheus, a legendary computer " + \
    "hacker branded a terrorist by the government. Morpheus awakens " + \
    "Neo to the real world, a ravaged wasteland where most of " + \
    "humanity have been captured by a race of machines that live " + \
    "off of the humans' body heat and electrochemical energy and " + \
    "who imprison their minds within an artificial reality known as " + \
    "the Matrix. As a rebel against the machines, Neo must return to " + \
    "the Matrix and confront the agents: super-powerful computer " + \
    "programs devoted to snuffing out Neo and the entire human " + \
    "rebellion. "


#print getSummary(text);
'''
doc = textacy.Doc(unicode(text))
a = mySgRank(doc)

for i in a:
	print(i[0],i[1])

'''




