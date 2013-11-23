from socket import *

# serverName = 'paris.cs.utexas.edu'
serverName = 'charity.cs.utexas.edu'
# serverName = '70.114.143.80'
serverPort = 35602

clientSocket = socket(AF_INET, SOCK_STREAM)
clientSocket.connect( (serverName, serverPort) )

sentence = raw_input("Input in lowercase!: ")

print "Sending..."

clientSocket.send(sentence)
print "Sent!"
print "Now waiting for a response..."

modifiedSentence = clientSocket.recv(1024)
print "Done!"

print "From Server: ", modifiedSentence

clientSocket.close()
