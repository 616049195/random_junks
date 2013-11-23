from socket import *

serverPort = 35602

serverSocket = socket(AF_INET, SOCK_STREAM)

serverSocket.bind( ('', serverPort) )

serverSocket.listen(1)

print "The server is not ready to receive..."

while 1 :
	connectionSocket, addr = serverSocket.accept()
	print "accepted!"
	sentence = connectionSocket.rec(1024)
	capitalizedSentence = sentence.upper()
	connectionSocket.send(capitalizedSentence)
	connectionSocket.close()