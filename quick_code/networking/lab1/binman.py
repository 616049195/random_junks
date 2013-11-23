# imports
from socket import *
import struct
import binascii
import array
import random
import re



def packPkt(ar): 
	pkt = '' 
	for i in range(0, len(ar)): 
		pkt = pkt + struct.pack('!H', ar[i]) 
	print "PKT: ", binascii.hexlify(pkt)
	return pkt

def unpackPkt(pkt):
	pass

# doing bit manipulation

## main ##
ar = array.array('l')
# ar.append(0x0164)
int_bit = int('00010001', 2)

byte0 = 356
byte1 = hex(356)
print "byte: ", byte1
byte2 = 0x1
byte3 = 0x7
byte4 = 0xf
byte5 = 0xaaaa
byte6 = 0xffff

hex_string1 = binascii.hexlify(struct.pack('!H', byte5))
binary_string1 = binascii.unhexlify(hex_string1)
hex_string2 = binascii.hexlify(struct.pack('!H', byte6))
binary_string2 = binascii.unhexlify(hex_string2)

# print "hex_string: ", hex_string
# print "binary_string: ", binary_string # not in printable form


# bin1 = \x0100
print 0011100
print type(struct.pack('>I', 1000))
# ar.append(int_bit)
ar.append(byte0)
ar.append(byte2)
ar.append(byte3)
ar.append(byte4)
ar.append(byte5)
ar.append(3892)
packet1 = packPkt(ar)
unpackPkt(packet1)