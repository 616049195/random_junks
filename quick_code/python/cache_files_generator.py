# imports
import sys
import time

"""
Training Data:
17,770 movies
480,189 customers
about 100,000,000 ratings
about 5,600 ratings per movie
about 200 ratings per customer

"""

# user ID = 1 - 2,649,429 with gaps
# user ID total = 480,189 

# movie ID = 17,770



# compute avg rating of a movie!
def movie_rating_avg (big_list) :

	# rating_avg list
	avg = {}
	rating = 0.0

	print big_list

	# ranger vs xrange?
	# for i in range(1, 17771) :
		# for user in iter(big_list[i]) :
			# rating += big_list[i][user_key][0]
		# avg[i] = rating/len(big_list[i])
	return avg



# read!
# @ a simple generator that returns line by line
def read (r) :
	for s in r :
		yield s

# -----
# read_training
# @ if the line contains ':', it returns movie ID as an int.
# @ if the line does not contain ':', then it returns a list with items seperated by comma.
# -----
def read_training (lines) :
	for s in lines :
		if ':' in s :
			# get number and return it as an int
			yield(int(s.replace(':', '')))
		else :
			# split by comma and return
			_list = s.split(",")
			yield (_list)


# this will generate cache files!
def netflix_run (r, w) :

	# dictionary
	big_list = {}

	# movieID
	movieID = 0

	for line in read_training(r):
		# if line is an int, it's a movie ID

		if type(line) is int :
			movieID = line
			print movieID
		# if line is a list, it contains customer ID, ratings (or not), date
		else :
			if movieID in big_list : # put this first since this will happen more frequently.
				# assuming that we are reading training set. NOT qualifying set.
				# for qualifying set, edit 'line[1:3]' to line[1:2]
				big_list[movieID][line[0]] = line[1:3] 
			else :
				# initial step in creating a list.
				big_list[movieID] = {line[0] : line[1:3]}

	# now, after this forloop, our dictionary is filled with all of our data
	# do something 

	# info = big_list[movieID]
	# user's rating and date = info[userID]

	print movie_rating_avg(big_list)


	#-- resources --#
	# training set
	# movie info



## main ##

# _ex = {}
# _ex[123] = {}
# _ex[123]["222"] = [333, 2-2-3]
# _ex[123]["555"] = [5123, 2-3-5]
# for s in iter(_ex[123]) :
# 	print _ex[123][s][0]


b = time.clock()
netflix_run(sys.stdin, sys.stdout)
e = time.clock()
print b-e