# imports
import sys
import time
from math import sqrt


# MovieIDs go up to 17770 and UserIDs go up to 2649429
# Array sizes are these +1 so we don't have to worry about adjusting the numbers
# I've reduced the arrays to their smallest possible size so that the code will run faster.
movie_average = [0] * 17771
user_average = [0] * 2649430

# This would get very ugly if it weren't a dictionary
user_average_decade = dict()
movie_decade = [0] * 17771


def read (r) :
    for s in r :
    	yield s

def rmse (a, p) :
    v = 0.0
    s = len(p)
    for i in range(0, s) :
        v += (a[i] - p[i]) ** 2
    return sqrt(v/s)   

def score (movie, user) :
    movieScore = movie_average[movie]
    userScore = user_average_decade[user][movie_decade[movie]]

    # algorithm #1
    """
    return (movieScore + userScore)/2
    """
    # algorithm #7
    weighted_ms = movieScore * 0.5
    weighted_us = userScore * 1.5
    bonus = (movieScore - userScore) / 2
    return ((weighted_ms + weighted_us) + bonus) / 2


    # I like #7 but I hope that this small improvement makes it better



def netflix_run (r) :
    
    ## initializing our data ##

    # save arguments (cache files) as string
    file_name_ma = sys.argv[1]
    file_name_ua = sys.argv[2]
    file_name_ra = sys.argv[3]
    file_name_decade = sys.argv[4]
    file_name_movieyears = sys.argv[5]

    # movie average
    f = open(file_name_ma)
    for line in f :
    	_l = line.split()
    # save it as an index
	_l[0] = int(_l[0])
	movie_average[_l[0]] = float(_l[1])
    f.close()


    # user average
    f = open(file_name_ua)
    for line in f :
    	_l = line.split()
    # save it as an index
	_l[0] = int(_l[0])
	user_average[_l[0]] = float(_l[1])
    f.close()

    # user average per decade of movie release
    f = open(file_name_decade)
    for line in f : 
        _l = line.split()

        # use the first item of the list as the key and remove it from the rest of the list
	user_key = int(_l.pop(0))
	
	# convert strings to floats

        for i in range(len(_l)) :
            _l[i] = float(_l[i])
	
	# then add the rest of the list (the decade information) to the dictionary

        user_average_decade[user_key] = _l
    f.close()

    # populate Movie Decade list
    f = open(file_name_movieyears)

    for line in f : 
        _l = line.split(',')

	# print len(_l)
        if _l[1] == "NULL" : 
            _l[1] = "1960"

        # debugging prints
	# print int(_l[0])
	# print _l[1]
	assert _l[1] != ''
        # print int(_l[1])
	# print int(_l[1])/10
	# print (int(_l[1])/10) % 10

        # we only need the movie number and the decade
        # 0 = 2000s, 1 = 1910s, 2 = 1920s... etc
        # Yes, that's strange, but that's the way the user_ratings_by_decade file is set up
        movie_decade [int(_l[0])] = ((int(_l[1]) / 10) % 10)
        # movie_decade [1] = (int(10 / 10) % 10)
        
    f.close()

    ## done with initializing our data ##

    ## get real data to compare
    # our lists
    actual = []
    predicted = []

    f = open(file_name_ra)
    for line in f :
	if ':' not in line :
	    actual.append(float(line))
    f.close()

    # compare
    movieID = 0

    for line in read(r):
    	if ':' in line :
	     # This is a movie number
	     movieID = int(line.replace(":",""))
             # print movieID, ":"
    	else :
            # This is a customer ID
            result = score(movieID, int(line))
            predicted.append(result)
            # print result


    # print results
    print "\nPredicted Length: ", len(predicted)
    print "Actual Length: ", len(actual)
    print "RMSE: %f" % rmse(actual, predicted)



    """
		This code may be useful for other stuff.

	     # s_line = line.split(",")
	     # print "Movie: ", movieID, "User: ", s_line[0], "Rating: ", s_line[1], "Date: ", s_line[
             # big_list[movieID][int(s_line[0])][0] = s_line[1]
             # big_list[movieID][int(s_line[0])][1] = s_line[2]
    """          




## main ##
b = time.clock()
netflix_run(sys.stdin)
e = time.clock()
print "\nTime it took: ", (e-b)*1000, " milliseconds"
