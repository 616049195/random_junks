from socket import *
serverName = 'paris.cs.utexas.edu'
serverPort = 35604
clientSocket = socket(AF_INET, SOCK_DGRAM)
# message = raw_input('Input lowercase sentence: ')
message = '0000 0001 0110 0100 0000 0001 0000 0111'
clientSocket.sendto(message, (serverName, serverPort))
modifiedMessage, serverAddress = clientSocket.recvfrom(2048)
print modifiedMessage
clientSocket.close()