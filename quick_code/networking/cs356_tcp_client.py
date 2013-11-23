from socket import *
from random import randint

serverName = 'paris.cs.utexas.edu'
# serverName = 'charity.cs.utexas.edu'
serverPort = 35602

clientSocket = socket(AF_INET, SOCK_STREAM)
clientSocket.connect( (serverName, serverPort) )

print "Clinet: ", clientSocket.getsockname()
print "Server: ", clientSocket.getpeername()
print "Client info: ", clientSocket.getsockname()
print "Server info: ", clientSocket.getpeername()

client_name, client_port = clientSocket.getsockname()
server_name, server_port = clientSocket.getpeername()


# sentence = raw_input("Input in lowercase!: ")


# generate random
usernum = randint(0,9000)

username = "H.Kim"

# client's initail request
# ex0 128.83.144.56-35603 128.83.144.248-10356 4321 I.M.Student\n
my_request = "ex0" + " " + server_name + "-" + str(server_port) + " " + client_name + "-" + str(client_port) + " " + str(usernum) + " " + str(username) + "\n"
print "Sending...\n"
print "Client: ", my_request,

clientSocket.send(my_request)

# confiramtion sent by server
# CS 356 Server Tue Feb 10 16:29:00 CDT 2005\n
# OK 4322 I.M.Student 1601812701\n

# if okay, client sends acknowledgement
# request type WS usernum+1 WS servernum+1 newline
# ex0 4322 1601812702\n

# server receives ack, and if the format is okay, it writes OK
# CS 356 Server Tue Feb 10 16:29:02 CDT 2005 OK 1601812702\n



server_response_1 = clientSocket.recv(1024)
server_response_2 = clientSocket.recv(1024)

print server_response_1,
print server_response_2,

res = server_response_2.split()
# res = res[-1]
if server_response_2[0:2] == "OK" : 
	my_request = "ex0" + " " + str(usernum+1) + " " + str(int(res[-1])+1) + "\n"
	print "Client: ", my_request,

clientSocket.send(my_request)

server_response_1 = clientSocket.recv(1024)
print server_response_1

res = server_response_1.split()
if res[-2] == "OK" :
	print "Done."

clientSocket.send(sentence)

print "Sent!"
print "Now waiting for a response..."

modifiedSentence = clientSocket.recv(4096)

print "Done!"


clientSocket.close()

