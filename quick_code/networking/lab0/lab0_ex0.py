from socket import *
from random import randint

## excercise 0
print "\n========================"
print "Exercise 0"
print "========================\n"

# initialize server status
serverName = 'paris.cs.utexas.edu'
serverPort = 35602

# create a socket and connect to the server
clientSocket = socket(AF_INET, SOCK_STREAM)
clientSocket.connect( (serverName, serverPort) )

# print out client and server information
print "Client info.: ", clientSocket.getsockname()
print "Server (paris) info.: ", clientSocket.getpeername(), "\n"

# save names and ports of both client and server for later use
client_name, client_port = clientSocket.getsockname()
server_name, server_port = clientSocket.getpeername()


# generate a random number and initialize username
usernum = randint(0,9000)
username = "H.Kim"

# create client's initial request
my_request = "ex0" + " " + server_name + "-" + str(server_port) + " " + client_name + "-" + str(client_port) + " " + str(usernum) + " " + str(username) + "\n"
print "Client: ", my_request,

# send the initial request
clientSocket.send(my_request)

# receive confiramtion sent by server (two parts)
confirm_1 = clientSocket.recv(1024)
confirm_2 = clientSocket.recv(1024)

print "Server: ", confirm_1,
print "Server: ", confirm_2,


# split by white spaces
response = confirm_2.split()
# save server number
servernum = int(response[-1]) + 1

# validate OK & usernum value
if (response[0] == "OK") and (response[1] == str(usernum+1)) : 
	# create a new acknowledgement request
	my_request = "ex0" + " " + response[1] + " " + str(servernum) + "\n"
	print "Client: ", my_request,
else :
	# otherwise, throw error and print
	print "ERROR! ",
	print confirm_1, confirm_2

# send newly created request to the server
clientSocket.send(my_request)

# receive another confirmation from the server
confirm_1 = clientSocket.recv(1024)
print "Server: ", confirm_1

# split the confirmation string by white spaces
response = confirm_1.split()
if (response[-2] == "OK") and (response[-1] == str(servernum)) :
	# if OK and server number is correct, done.
	pass
else :
	# otherwise, throw error and print
	print "ERROR!"
	print confirm_1
	

clientSocket.close()
