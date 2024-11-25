package net.mahtabalam.elevator2;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

class ElevatorDispatcher {
    private List<Elevator> elevators;
    private PriorityQueue<Request> upQueue;
    private PriorityQueue<Request> downQueue;
    private ElevatorDispatchStrategy elevatorDispatchStrategy;

    public ElevatorDispatcher(List<Elevator> elevators, ElevatorDispatchStrategy strategy) {
        this.elevators = elevators;
        this.elevatorDispatchStrategy = strategy;
        this.upQueue = new PriorityQueue<>(Comparator.comparingInt(Request::getFloorNumber));
        this.downQueue = new PriorityQueue<>(Comparator.comparingInt(Request::getFloorNumber).reversed());
    }

    public void setElevatorDispatchStrategy(ElevatorDispatchStrategy strategy) {
        this.elevatorDispatchStrategy = strategy;
    }

    public void handleRequest(Request request) {
        if (request.getDirection() == Direction.UP) {
            upQueue.add(request);
        } else if (request.getDirection() == Direction.DOWN) {
            downQueue.add(request);
        }
        assignRequests();
    }

    public void assignRequests() {
        // Assign requests from upQueue
        while (!upQueue.isEmpty()) {
            Request request = upQueue.poll();
            Elevator bestElevator = elevatorDispatchStrategy.dispatchElevator(request, elevators);
            bestElevator.moveToFloor(request.getFloorNumber());
        }

        // Assign requests from downQueue
        while (!downQueue.isEmpty()) {
            Request request = downQueue.poll();
            Elevator bestElevator = elevatorDispatchStrategy.dispatchElevator(request, elevators);
            bestElevator.moveToFloor(request.getFloorNumber());
        }
    }

    public boolean hasPendingRequests() {
        return !upQueue.isEmpty() || !downQueue.isEmpty() || elevators.stream().anyMatch(elevator -> elevator.getStatus() != ElevatorStatus.IDLE);
    }
}
