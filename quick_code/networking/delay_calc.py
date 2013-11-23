def get_nodal_delay (prop_d, p_d, n) :
	# nodal_delay = process_delay + transmission_delay + queueing_delay + propagation_delay 
	
	# prop_d is given
	# p_d is proc_d + que_d

	# constants
	p_length = 10000
	p_header = 100
	capacity = 1000000
	
	# trans_d
	trans_d = float(( (p_length / n)  + p_header )) / capacity 
	"""
	print "p_length: ", p_length
	print "p_header: ", p_header
	print "capacity: ", capacity
	print "print (p_length / n): ", p_length/n
	print "print ( (p_length/n) + p_header ): ", (p_length / n) + p_header
	print "print ( (p_length/n) + p_header ) / capacity ): ", trans_d	
	print "here is trans_d: ", trans_d
	"""
	nodal_d = trans_d + prop_d + p_d
	return nodal_d

def get_total_delay (num, prop_d, p_d, n) :
	# total_delay = propagation_delay + N * nodal_delay
	total_delay = prop_d + ( num * get_nodal_delay(prop_d, p_d, n) ) 
	return total_delay


### main ###


# some testings
print "#1:  ",
print get_total_delay(10, 0.001, 0.001, 1)

print "#2: ",
print get_total_delay(10, 0.001, 0.001, 20)

print "#3: ",
print get_total_delay(4, 0.001, 0.001, 1)

print "#4: ",
print get_total_delay(4, 0.001, 0.001, 20)

print "----------looks good-----------"
print

for i in range(1, 41) :
	print get_total_delay(10, 0.001, 0.001, i)

print "----------dones with #1 --------"

for j in range(1, 21) :
	print get_total_delay(j, 0.001, 0.001, 20)

print "----------done with #2 ---------"

for k in range(1, 41) :
	print k
for x in range(1, 21) :
	print x
