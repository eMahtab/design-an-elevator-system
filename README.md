# Design an elevator system


# Elevator Scheduling Algorithm
## First Come First Serve (FCFS)
The simplest method for the elevator to serve passengers’ requests is on a first-come-first-serve basis. The requests made by the passengers are added in a queue, as shown by the Request Queue in the diagram below. 
For simplicity, let’s assume that there are 11 floors in a building and a single elevator to serve requests. Suppose, a passenger on floor 2 wants to go down. This request is added to the queue. Next, a passenger on floor 4 wants to go up. This request is also added to the queue. More requests are added to the queue as they come in.

![1](1.png?raw=true)

In the FCFS algorithm, requests are served in the order they were added to the queue. This means that the elevator will go to the passenger on floor 2 first and drop them to their destination. Next, the elevator will go to floor 4 and take the passenger up to their destination, before going to floor 3 and so on. On the graph below, you can see the position of the elevator and the time elapsed as the elevator serves requests.

![2](2.png?raw=true)



# References :
https://www.youtube.com/watch?v=siqiJAJWUVg
