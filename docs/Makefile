SHELL := /bin/bash

.PHONY: all serve clean_serve clean
	
# all: serve
# 
# serve:
# 	python3 -m http.server 9000

.PHONY: clean serve clean_serve

all: clean_serve

clean:
	rm -rf _site

serve:
	bundle exec jekyll serve --incremental

clean_serve: clean serve

