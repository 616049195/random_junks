# import
from math import sqrt
import time
import sys
from random import randint, seed


def rmse_1 (a, p) :
	# iterate through
	v = 0.0
	s = len(a)
	for i, j in zip(a, p) :
		v += (i-j)**2
	return sqrt(v/s)

def rmse_2 (a, p) :
	v = 0.0
	s = len(a)
	z = zip(a, p)
	for i, j in z :
		v += (i-j)**2
	return sqrt(v/s)

def rmse_3 (a, p) :
	v = 0.0
	s = len(a)
	for i in range(0, s) :
		v += (a[i] - p[i]) ** 2
	return sqrt(v/s)

def rmse_4 (a, p) :
	s = len(a)
	z = zip(a, p)
	# for i,j in z :
	v = reduce(lambda v, (x,y): v + (x-y) ** 2, z, 0.0)
	return sqrt(v/s)

def tester (f, s, a, p) :

	assert(f([1,2,3], [1,2,3]) == 0)
	assert(f([1,2,3], [2,3,4]) == 1)
	assert(str(f([1,2,3], [3,5,7])) == str(3.10912635103))

	time_s = time.clock()
	f(a, p)
	time_e = time.clock()

	time_it_took = time_e - time_s
	time_it_took = time_it_took * 1000

	print "Function ", s, " took: ", str(time_it_took), " milliseconds"



## main ##
seed()
a = []
p = []
for num in range(0, 1000000) :
	a.append(randint(1, 10))
	p.append(randint(1, 10))


print sys.version

tester(rmse_1, "#1 		", a, p)
tester(rmse_2, "zip saved	", a, p)
tester(rmse_3, "indexing ", a, p)
tester(rmse_4, "reduce   ", a, p)
