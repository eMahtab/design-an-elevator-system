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


## Shortest Seek Time First (SSTF)
This algorithm aims at serving the requests with the shortest seek time first. This approach can be implemented by generating a Minheap from the passengers’ requests, based on the distance between the source floor and the elevator’s current floor. The topmost request is picked from the heap and served first. The minheap will change continuously as the position of the elevator changes. In the figure below, the distance of a request from the elevator’s current position is calculated as d.

![3](3.png?raw=true)

Alternatively, an array can be generated for the requests, as shown in the diagram above. For each request, the system pre-calculates the distance of the request from the elevator and then serves the one with the minimum distance.

## Advantages and Drawbacks of SSTF Algorithm
There are some advantages of SSTF over FCFS algorithm. It clearly lowers the average response time of the elevator. Also, the movement of the elevator is significantly reduced. One major flaw of the design is the possibility of starvation for some of the requests. Starvation implies that large wait times may be involved for passengers that have a higher seek time (or distance from the elevator) as compared to the other incoming requests. So if there is a passenger on the top floor and most of the passengers are on the lower floors, the elevator will keep on serving those and ignore the request from the topmost floor. Also, as is the case with the FCFS algorithm, SSTF is not capable of serving requests in parallel.

## Elevator Algorithm (SCAN)
SCAN is a disk scheduling algorithm that very closely reflects how an actual elevator functions, which is why it’s also sometimes called the Elevator Algorithm. Consequently, it’s an excellent approach to pick for designing your elevator scheduling algorithm. The concept aims to serve multiple requests in parallel, unlike the algorithms discussed above.

The elevator will move all the way up, serving all the requests that come in its way. Only once it reaches the top floor, the elevator will change its direction, moving all the way to the last floor, serving all the requests that come in its way.

![4](4.jpg?raw=true)

# References :
https://www.youtube.com/watch?v=siqiJAJWUVg
