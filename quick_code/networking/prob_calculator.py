from math import factorial
from math import pow

def get_prob (N, n, p) :
	# P = (N! / [n!(N-n)!]) * (p^n) * (1-p)^(N-n)

	# C[N, n] = (N! / [n!(N-n)!]) 
	var_1 = factorial(N) / ( factorial(n) * factorial(N-n) )
	
	# p^n = pow(p, n)
	var_2 = pow(p, n)	

	# (1-p)^(N-n) = pow(1-p, N-n)	
	var_3 = pow(1-p, N-n)
	
	prob = var_1 * var_2 * var_3	
	
	return prob


# main #
print get_prob(35, 12, 0.1)
print get_prob(35, 5, 0.1)

var_N = int( raw_input('Enter N: ') )
var_n = int( raw_input('Enter n: ') )
var_p = float( raw_input('Enter p: ') )
#print "Probability = ", get_prob(var_N, var_n, var_p)
print get_prob(var_n, var_n, var_p)
