# testing input skeletons

# imports
import sys

def test (i, o) :
	for s in i :
		print s,


def example () :
	yield 1
	print "HELLO"
	yield 2
	print "WHATUP"
	yield 3

def example_1 () :
	i = 0
	while True:
		i += 1
		yield i


def test1 (line)  :
	print ':' in line
	_l = line.split(',')
	print _l




def read (reader) :
	for s in reader :
		if ':' in s:
			# get number and return it
			yield(s.strip(':'))
		else:	
			# split by comma and return
			_list = s.split(",")
			yield (_list)


# main #


# 2043:
# 716091,2,2003-10-02
# 1990901,5,2001-09-27

line = "1990901,5,2001-09-27"
# test1(line)

lines = ["2043:", "716091,2,2003-10-02", "1990901,5,2001-09-27"]

for i in read(lines) :
	print i
# pseudo-code

# find ':' in line.
	# if found, 