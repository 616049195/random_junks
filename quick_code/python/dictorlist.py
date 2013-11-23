#!/usr/bin/env python

import sys


list1 = ['203000','5','2004-04-23']
list2 = ['32524','4','2003-12-23']
list3 = ['12312','2','2005-11-11']
list4 = ['121','5','2002-05-23']

movieID1 = 123
movieID2 = 4421

big_list = dict()
small_list = dict()


print type(movieID1) is int

small_list.update(red=54, green=123, yellow=1234123)

# big_list[movieID1][list1[0]] = list1[1:3]
# big_list.update(list2[0]=list2[1:3])



### this works ### but takes an initial step..
big_list[movieID1] = {list1[0] : list1[1:3]}
big_list[movieID1][list2[0]] = list2[1:3]

# inital step
big_list[movieID2] = {list3[0] :list3[1:3]}
# any adds..
big_list[movieID2][list4[0]] = list4[1:3]

# print big_list

def read (lines) :
	for s in lines :
		if ':' in s :
			# get number and return it as an int
			yield(int(s.replace(':', '')))
		else :
			# split by comma and return
			_list = s.split(",")
			yield (_list)




def netflix_run (r, w) :

	# dictionary
	big_list = {}

	# movieID
	movieID = 0

	for line in read(r):
		# if line is an int, it's a movie ID

		if type(line) is int :
			# check if there is a dictionary exist? this is necessary???
			# create a dictionary with movieID
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

	print big_list
	print
	print
	print big_list.keys()
	print big_list.values


netflix_run(sys.stdin, sys.stdout)
