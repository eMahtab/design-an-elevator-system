# Design an elevator system


# Elevator Scheduling Algorithm
## First Come First Serve (FCFS)
The simplest method for the elevator to serve passengers’ requests is on a first-come-first-serve basis. The requests made by the passengers are added in a queue, as shown by the Request Queue in the diagram below. 
For simplicity, let’s assume that there are 11 floors in a building and a single elevator to serve requests. Suppose, a passenger on floor 2 wants to go down. This request is added to the queue. Next, a passenger on floor 4 wants to go up. This request is also added to the queue. More requests are added to the queue as they come in.

![1](1.png?raw=true)

In the FCFS algorithm, requests are served in the order they were added to the queue. This means that the elevator will go to the passenger on floor 2 first and drop them to their destination. Next, the elevator will go to floor 4 and take the passenger up to their destination, before going to floor 3 and so on. On the graph below, you can see the position of the elevator and the time elapsed as the elevator serves requests.

![2](2.png?raw=true)

## Advantages and Drawbacks Of FCFS Algorithm
Though the FCFS algorithm is simple to implement and makes sure all requests get a fair chance, clearly there are flaws. There may be cases where large wait times are involved for passengers, that can be avoided by better solutions. Furthermore, it also involves unnecessary movement of the elevator, resulting in wastage of resources.
For example, in the diagram, the elevator is moving up and the passenger on floor 3 requests for the elevator to take it down. A few moments later, a passenger on floor 6 requests to go down. The elevator will first go down to floor 3, serve the passenger completely and then go to floor 6 to take the passenger down again. Ideally, the elevator should have gone up, picked the passenger on floor 6 first, bringing them down on the way to floor 3 to serve the passenger that placed the request first.

# References :
https://www.youtube.com/watch?v=siqiJAJWUVg
