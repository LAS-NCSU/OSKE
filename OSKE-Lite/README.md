# OSKE-Lite
OSKE-Lite is a minimal install version of Open Source Knowledge Enrichment (OSKE) designed to be run on a single server
with a default user that does not require authentication.

## Data directories
OSKE-Lite requires three directories to be available, two levels up from this directory

Directory | Owner UUID | Description
--- | --- | ---
oske/data | 1000 | Used by the collector daemon and web application.  contains raw data collected, logs
oske/database | 999 | PostreSQL database directory
oske/elasticsearch | 1000 | Elasticsearch data directory

## Available services
This process will install the following services at the specified ports:

Service Name | Port | Description
--- | --- | ---
WebApp     | 80   | http://server<br>Web application for OpenKE
ElasticSearch | 9200 | Stores the enriched data
Kibana | 5601 | Provides visualizations of the data stored in ElasticSearch
PostgreSQL | 5432 | Primary meta-data storage for the application.  User: openke_user, Password: openkepassword
WordNet | 5679 | REST based WordNet Service - https://github.com/jacopofar/wordnet-as-a-service
Voyant     | 80   | http://server/voyant <br>Text analysis toolkit
DBPedia-Spotlight | 2222 | Discovers links to dbpedia entries within unstructured text.
GeoTagging Service | 9904 | Extracts locations from unstructured text
Google Search | 9015 | Implements the a slightly customized version googleapi from https://github.com/abenassi/Google-Search-API
Microformat Service | 9009 | Extracts microformat data from HTML pages. http://microformats.org/
NLP Service | 9006 | Extracts named entities and relations from unstructured text using Stanford CoreNLP and minIE
Spacy Service | 9012 | Extracts named entities from unstructured text using the Spacy library service
Textrank Service | 8000 | Generates keywords, keyphrases, summaries, and discovery indexes
Topic Service | 9005 | Executes LDA (https://en.wikipedia.org/wiki/Latent_Dirichlet_allocation) to extract topics from a series of documents
WhoIS Service | 9008 | Retrieves WhoIS data for a domain

## Install
1. Provision a server.  These instructions assume a CentOS distribution.  sudo privileges are required.  The install requires a minimum of 40 gb of storage and 32 gb of RAM.
1. Access the server and install your github private key such that your can access this repository
1. Execute the following steps to prepare the server and install docker. The "sysctl" line is necessary to run ElasticSearh within docker.  The echo line will make it permanent for any reboots and images. These commands are also available within the file "install_docker.sh".
```
yum update -y
yum install -y yum-utils   device-mapper-persistent-data   lvm2 git iptables
yum-config-manager     --add-repo     https://download.docker.com/linux/centos/docker-ce.repo
yum install -y docker-ce
curl -L "https://github.com/docker/compose/releases/download/1.27.4/docker-compose-$(uname -s)-$(uname -m)" -o /usr/local/bin/docker-compose
chmod +x /usr/local/bin/docker-compose
systemctl enable docker
systemctl start docker
echo "vm.max_map_count=262144" >> /etc/sysctl.conf
sysctl -w vm.max_map_count=262144
docker -v
docker-compose --version
```

  Note: depending upon your linux version(e.g., Centos 7), you may need to put the sysctl.conf setting in alternate file.  Example: echo "vm.max_map_count=262144" > /etc/sysctl.d/max_map_count.conf

4. Clone the software repository
```
cd <your install location>
git clone https://github.com/LAS-NCSU/OSKE.git
```

5. Setup the data directories
```
cd <your install location>
mkdir oske oske/data oske/database  oske/elasticsearch
chown 1000 oske/data oske/elasticsearch
chown  999 oske/database
```
6. Edit the docker-compose.yml file in OSKE/OSKE-Lite.  
  - Change the value for POSTGRES_PASSWORD from MUST_CHANGE_PASSWORD to some other value.

7. In OSKE/Collector/scripts/docker_start
  - Change the value for PGPASSWORD from MUST_CHANGE_PASSWORD to the password used in the prior step.


8. In OSKE/Collector/system_properties.json.docker change
   the parameter for "password" (under "database") from REQUIRED_PASSWORD_CHANGE
   to the same password utilized in the last two steps.

9. Start the system.  This step will take well over 30 minutes to execute the first time as the docker images are downloaded and built.  Once the images are available(built) and for subsequent runs, the system should start within 30 seconds.
```
cd <your install location>/OSKE/OSKE-Lite
docker-compose up -d
```

  Once the build process is complete, you may want to delete some of the intermediate builds that are not necessary to save some disk space:
```
docker system prune
```

10. Once the system has been installed and is running, you can access the site at http://*yourServerAddress*

11. To stop the system
```
docker-compose down
```

## Docker Swarm
You can utilize the docker-compose.yml file with Docker Swarm.  However, you will want to first build all of the images, then remove the "base" configuration from the file or remove that service once the swarm starts.  Otherwise, the "base" service will constantly attempt to restart itself. (The base image only exists as a building block for the other services.)

View "[Deploy a stack to a swarm](https://docs.docker.com/engine/swarm/stack-deploy/)" for more information.

## Information Links
The following links are informational sources for Docker, Elasticsearch, Kibana, and PostgreSQL:
* https://docs.docker.com/install/linux/docker-ce/centos/
* https://docs.docker.com/compose/install/
* https://www.elastic.co/guide/en/elasticsearch/reference/current/docker.html
* https://www.elastic.co/guide/en/kibana/current/docker.html
* https://docs.docker.com/samples/library/postgres/#-via-docker-stack-deploy-or-docker-compose
