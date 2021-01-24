# Name: open_ms_textrank
# Purpose: Textrank service to producde keywords, keyphrases, summaries, and back of the book index
# requires: redis server available listening with service_name of openke_redis
# Notes: Attempted to use python3.7.0-strech as the the base image, but could not compile cld2-cffi
#
# Version: 1.0
# History
# 20170405 Initial creation
#
# Build Command:
#     docker build -t="openke_ms_textrank" .
#
FROM centos:7.5.1804

RUN yum group install -y "Development Tools"
RUN yum install -y xz-devel zlib-devel bzip2-devel sqlite sqlite-devel openssl-devel libffi-devel python-tools tk-devel tcl-devel wget curl git

# Install python 3.7.3 from source
RUN mkdir /install
RUN wget -q --directory-prefix=/install https://www.python.org/ftp/python/3.7.3/Python-3.7.3.tgz
RUN cd /install && tar xf Python-3.7.3.tgz && cd Python-3.7.3 && ./configure && make install
RUN rm -rf /install

RUN pip3.7 install --upgrade pip
RUN pip3.7 install flask gensim nltk==3.3 matplotlib
RUN pip3.7 install pattern3 fuzzywuzzy cld2-cffi

RUN pip3.7 install textacy[all]
RUN python3.7 -c "import nltk;nltk.download('book', download_dir='/usr/share/nltk_data', halt_on_error=False)"
RUN pip3.7 install  gunicorn json-logging-py zulu redis

COPY . /root/install/OpenKE

RUN mkdir /opt/textAnalysis && \
    mkdir /opt/textAnalysis/gunicorn && \
    cp /root/install/OpenKE/*.py /opt/textAnalysis/ && \
    cp /root/install/OpenKE/gunicorn/* /opt/textAnalysis/gunicorn && \
    rm -rf /root/install /root/.ssh

WORKDIR /opt/textAnalysis

USER 1000

ENTRYPOINT ["/usr/local/bin/gunicorn", "--config", "/opt/textAnalysis/gunicorn/gunicorn.conf.py", "--log-config", "/opt/textAnalysis/gunicorn/logging.conf", "-b", ":8000", "app:app"]
EXPOSE 8000
