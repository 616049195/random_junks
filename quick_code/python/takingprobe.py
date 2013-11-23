# imports
import sys


def netflix_run (r, w) :

	# dictionary
	big_list = {}

	# movieID
	movieID = 0

	for line in read(r):
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



	# --------
	#  our code 
	# --------

def netflix_start (r, w) :

	# dictionary
	big_list = {}

	# movieID
	movieID = 0

	for line in read(r):
		if ':' in line :
			# this is a movie number
			movieID = line
			big_list[movieID] = []

		else :
			# this is a customer id
			big_list[movieID].append(line)


	print big_list

# this is for on-fly 
def netflix_do_on_the_fly (r, w) :

	# dictionary
	# big_list = {}

	# movieID
	movieID = 0

	for line in read(r):
		if ':' in line :
			# this is a movie number
			movieID = line
			# big_list[movieID] = []

			print movieID

		else :
			# this is a customer id
			# big_list[movieID].append(line)

			# do something with customerID
			rating = do_someting(line)
			# done

			print rating


def read (r) :
	for s in r :
		yield s


## main ##

movie = 1234
movie2 = 23456

id1 = 111112
id2 = 111111

# _alist = {}

# _alist[movie] = [id1]
# print _alist

# _alist[movie].append(id2)
# print _alist


# _alist[movie] = []
# print _alist

# _alist[movie].append(22222)
# _alist[movie].append(333333)
# print _alist


netflix_start(sys.stdin, sys.stdout)