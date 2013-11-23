CS356 Lab0
Hyunchel Kim
hk6674

Ex0 server number: 9781674, 9781675
Ex1 server numbers: 9498663, 2544461, 2544461

I have printed out some message(to the console) for myself to see.
Then I also copied and pasted what the log files.
Here are the summary.


========================
Exercise 0
========================
(output from computer)

Client info.:  ('128.83.130.109', 33758)
Server (paris) info.:  ('128.83.144.56', 35602)

Client:  ex0 128.83.144.56-35602 128.83.130.109-33758 4346 H.Kim
Server:  CS 356 Server Wed Oct 09 14:45:21 CDT 2013
Server:  OK 4347 H.Kim 9781674
Client:  ex0 4347 9781675
Server:  CS 356 Server Wed Oct 09 14:45:21 CDT 2013 OK 9781675

------------------------------------------------------------
(from log)

charity.cs.utexas.edu
Client -> Server: ex0 128.83.144.56-35602 128.83.130.109-33758 4346 H.Kim
Server -> Client: CS 356 Server Wed Oct 09 14:45:21 CDT 2013
Server -> Client: OK 4347 H.Kim 9781674
Client -> Server: ex0 4347 9781675
Server -> Client: CS 356 Server Wed Oct 09 14:45:21 CDT 2013 OK 9781675



========================
Exercise 1
========================
(output from computer)

Client info.:  ('128.83.130.109', 33663)
Server (paris) info.:  ('128.83.144.56', 35602)

Host:  ('128.83.130.109', 43738)
Client (paris):  ('128.83.144.56', 35602)
Client:  ex1 128.83.144.56-35602 128.83.130.109-43738 5257 H.Kim
Server:  CS 356 Server Wed Oct 09 14:43:42 CDT 2013
Server:  OK 5258 H.Kim 9498663

CS356 server sent 2544460
OK	2042061

------------------------------------------------------------
(from log)

charity.cs.utexas.edu
Client -> Server: ex1 128.83.144.56-35602 128.83.130.109-43738 5257 H.Kim
Server -> Client: CS 356 Server Wed Oct 09 14:43:42 CDT 2013
Server -> Client: OK 5258 H.Kim 9498663
Server -> Client: Connected to a client(128.83.130.109-43738)
Server -> Client: CS 356 server calling 2544460
Client -> Server(servernum+1 newservernum+1): 9498664 2544461
Server -> Client: OK	2042061


