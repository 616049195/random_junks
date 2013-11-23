all:
	
clean: 
	rm -f *.pyc

run:
	python netflix_load.py /u/lara/cs373-netflix-tests/cmlinac-movies_average_rating.txt /u/lara/cs373-netflix-tests/ghawk88-users_average_rating.txt /u/lara/cs373-netflix-tests/yutianli_ashley-probe.out < /u/downing/cs/netflix/probe.txt > probe.out

run_mac:
	python netflix_load.py cmlinac-movies_average_rating.txt ghawk88-users_average_rating.txt yutianli_ashley-probe.out rdavies-avg_rating_by_decade.txt movie_titles.txt < probe.txt > probe.out
