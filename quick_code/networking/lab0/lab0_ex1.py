from socket import *
from random import randint

## excercise 1 ##
print "\n========================"
print "Exercise 1"
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


# generate random
usernum = randint(0,9000)
username = "H.Kim"

# create a new socket
psock = socket(AF_INET, SOCK_STREAM)

# print "HOST NAME: ", gethostname()
# print "HOST ADDR: ", gethostbyname(gethostname())

host_name_real = gethostname()
host_fqdn = getfqdn(host_name_real)

# bind the socket with host_port (0 is a default)
psock.bind( (host_fqdn, 0) )


# save names and ports of both host and client
host_name, host_port = psock.getsockname()
client_name, client_port = clientSocket.getpeername()

# print host and client info
print "Host: ", psock.getsockname()
print "Client (paris): ", clientSocket.getpeername()


# server is now ready to receive.
psock.listen(1)

# create client's initial request
my_request = "ex1" + " " + client_name + "-" + str(client_port) + " " + host_name + "-" + str(host_port) + " " + str(usernum) + " " + str(username) + "\n"
print "Client: ", my_request,

# sent with original socket
clientSocket.send(my_request)

confirm_1 = clientSocket.recv(1024)
confirm_2 = clientSocket.recv(1024)
print "Server: ", confirm_1,
print "Server: ", confirm_2

response_1 = confirm_2.split()

# validate that it is OK and save random number
if response_1[0] == "OK" :
	old_server_number = int(response_1[-1])
else :
	print "ERROR!"
	clientSocket.close()
	exit()


## switching server-client roles from here... ##

# receive a new connection from the server
newsock, client_addr = psock.accept()


paris_sent = newsock.recv(1024)
response_2 = paris_sent.split()

new_server_number = int(response_2[-1])

print "CS356 server sent " + response_2[-1]

# create a new request
my_request = str(old_server_number+1) + " " + str(new_server_number+1) + "\n"
newsock.send(my_request)
newsock.close()

# receive from the original socket
confirm_3 = clientSocket.recv(1024)
print confirm_3

clientSocket.close()

