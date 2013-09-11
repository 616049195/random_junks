
# Hyunchel Kim
# 9/1/2013


"""
Peter wants to generate some prime numbers for his cryptosystem. Help him! Your task is to generate all prime numbers between two given numbers!

Input

The input begins with the number t of test cases in a single line (t<=10). In each of the next t lines there are two numbers m and n (1 <= m <= n <= 1000000000, n-m<=100000) separated by a space.

Output

For every test case print all prime numbers p such that m <= p <= n, one number per line, test cases separated by an empty line.

Example

Input:
2
1 10
3 5

Output:
2
3
5
7

3
5
"""

# import
import sys


def get_input (read) :
	print "hello"

	for value in read :
		_list = value.split()
		b = _list[0]
		e = _list[1]
		print "done......."
		yield [b, e]

def get_prime (r1, r2) :
	for num in range(r1, r2+1) :
		if is_prime(num):
			print num

def is_prime (num) :
	# if num is prime, return true
	for div in range(2, num):
		if num % div == 0:
			return False
	return True


# another file...?
for next_thing in get_input(sys.stdin) :
	print next_thing

print "HI"
print is_prime(4)
