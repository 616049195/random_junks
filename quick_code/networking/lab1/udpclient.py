# imports
from socket import *
import struct
import binascii
import array
import random
import re


# functions
def packPkt(ar): 
	pkt = '' 
	for i in range(0, len(ar)): 
		pkt = pkt + struct.pack('!H', ar[i]) 
	print "PKT: ", binascii.hexlify(pkt)
	return pkt

def splitNum(num): 
	higherB = num >> 16 
	lowerB = num - (higherB << 16) 
	return higherB, lowerB

def checksum() :
	# initialzie checksum to be 0
	checksum = 0x0000 
	result = 0x0000


def printPkt (pkt) :
	print "------------- printing packets ---------------"
	print "Length of pkt: ", len(pkt)
	for msg in pkt :
		_hex = struct.unpack('!B', msg)
		# print "msg in int: ", _hex
		# _hex = struct.unpack('!c', msg)
		print "msg in char: ", _hex
		# _hex = struct.unpack('!s', msg)
		# print "msg in string..?: ", _hex
		print type(_hex)
		# print "Hex: ", binascii.hexlify(_hex)
		print 
	print "----------------------------------------------"



	# take the message as eight 16bit integers


## main ##

# construct and initialize 
# serverName = 'charity.cs.utexas.edu'
serverName = 'paris.cs.utexas.edu'

# serverPort = 12000
serverPort = 35605
clientSocket = socket(AF_INET, SOCK_DGRAM)

print "My socket name: ", getfqdn("charity.cs.utexas.edu")
# client_name, client_port = clientSocket.getsockname()
# server_name, server_port = clientSocket.getpeername()


# init array 
ar = array.array('l')

# needed variables = 7 fields (separated by space)
# message type
m_type = 0x00
# response/request flag
rr_flag = 0x00
# 356
cs356 = 356 # in bits...

# lab number
lab = 0x01

# version
version = 0x07

# cookie
cookie = random.randint(0,5000)

# ssn
ssn = int(raw_input("Enter SSN(no dash): "))

# checksum
checksum = '0000 0000 0000 0000' # in bits

# result
result = '0000 0000 0000 0000' # in bits


# prints
print "m_type: ", m_type
print "rr_flag: ", rr_flag
print "cs356: ", cs356
print "lab: ", lab
print "version: ", version
print "cookie: ", cookie
print "ssn: ", ssn
print "checksum: ", checksum
print "result: ", result

print "-----------------"

ar.append(0x0164) # field 1
ar.append(0x0107) # field 2
# cookie
ar.append(0x0000)
# ar.append(0x00) # field 3
# ar.append(0x00) # field 3
ar.append(0xffff) # field 3
# sssn
ar.append(0x0111)
ar.append(0x1234)
ar.append(0x0000)
# ar.append(0xEA50)
# result
ar.append(0x0000)
pkt1 = packPkt(ar)

"""
[Client -> CS356 Server] Request
[0-3] 01 64 01 07
[4-7] 00 00 FF FF
[8-11] 01 11 12 34
[12-15] 11 11 00 00

[Client -> CS356 Server] Request
[0-3] 01 64 01 07
[4-7] 00 00 00 00
[8-11] FF FF 01 11
[12-15] 12 34 11 11
"""

print "-----------------"


# testing
int_var = 65
a = struct.pack('B', int_var)
hex_string = binascii.hexlify(a)
print "just a: ", a
print "hex_string: ", hex_string


printPkt(pkt1)

# generate client cookie = 32 bits..

# prompt user for ssn = 10 + 7 + 14 + 1 bits?? = 32 bits..

# pack the array into packets

# send
clientSocket.sendto(pkt1, (serverName, serverPort))
server_message, serverAddress = clientSocket.recvfrom(2048)

clientSocket.close()

print "Done."
