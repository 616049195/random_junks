# imports
import sys
import time


# read!
# @ a simple generator that returns line by line
def read (r) :
	for s in r :
		yield s


### algorithms ####

def do_something (movieID, userID) :

	"""
	for some reason, the only way MOVIEID and _l[0] to be equal is to convert them into ints...

	"""
	
	movieID = int(movieID)
	userID = int(userID)

	movie_avg = 0.0
	user_avg = 0.0

	"""
	# avg of a movie
	file_name_1 = sys.argv[1]

	f = open(file_name_1, 'r')
	for line in f :
		_l = line.split()

		# integer-ize _l[0]
		_l[0] = int(_l[0])

		if _l[0] == movieID :# movie name
			movie_avg = _l[1] # avg rating
	
	# print movieID
	# print movie_avg
	f.close()
	"""

	# avg of a user's ratings
	file_name_2 = sys.argv[2]

	f = open(file_name_2, 'r')

	for line in f :
		_l = line.split()

		# integer-ize _l[0]
		_l[0] = int(_l[0])

		if _l[0] == userID :
			user_avg = _l[1]
			f.close()
			return user_avg
		
	# print userID
	# print user_avg
	f.close()

	# print "\n\n"
	return -1

	

### --------- ####

# project netflix (require no dictionary)
def netflix_do_on_the_fly (r, w) :

	# dictionary
	# big_list = {}

	# movieID
	movieID = 0

	for line in read(r):
		if ':' in line :
			# this is a movie number
			movieID = line.replace(":", "")
			# big_list[movieID] = []
			print line,

		else :
			# this is a customer id
			# big_list[movieID].append(line)

			# do something with customerID
			rating = do_something(movieID, line)
			print rating
			# done





## main ##

b = time.clock()
netflix_do_on_the_fly(sys.stdin, sys.stdout)
e = time.clock()
print "\nTime it took: ", (e-b)*1000, " milliseconds"