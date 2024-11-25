package net.mahtabalam.elevator1;

import java.util.Collections;
import java.util.PriorityQueue;

class Elevator {
    private int id;
    private int currentFloor;
    private Direction direction;
    private ElevatorStatus status;
    private PriorityQueue<Integer> upQueue;
    private PriorityQueue<Integer> downQueue;

    public Elevator(int id) {
        this.id = id;
        this.currentFloor = 0; // Assume ground floor initially
        this.direction = Direction.NONE;
        this.status = ElevatorStatus.IDLE;

        // Priority queues to process floors in correct order
        this.upQueue = new PriorityQueue<>(); // Ascending order for UP
        this.downQueue = new PriorityQueue<>(Collections.reverseOrder()); // Descending order for DOWN
    }

    public int getId() {
        return id;
    }

    public int getCurrentFloor() {
        return currentFloor;
    }

    public Direction getDirection() {
        return direction;
    }

    public ElevatorStatus getStatus() {
        return status;
    }

    public void addRequest(Request request) {
        if (request.getDirection() == Direction.UP) {
            upQueue.add(request.getFloorNumber());
        } else if (request.getDirection() == Direction.DOWN) {
            downQueue.add(request.getFloorNumber());
        }
        updateStatus();
    }

    private void updateStatus() {
        if (!upQueue.isEmpty()) {
            direction = Direction.UP;
            status = ElevatorStatus.MOVING;
        } else if (!downQueue.isEmpty()) {
            direction = Direction.DOWN;
            status = ElevatorStatus.MOVING;
        } else {
            direction = Direction.NONE;
            status = ElevatorStatus.IDLE;
        }
    }

    public void move() {
        if (status == ElevatorStatus.IDLE) {
            System.out.println("Elevator " + id + " is IDLE at floor " + currentFloor);
            return;
        }

        if (direction == Direction.UP && !upQueue.isEmpty()) {
            int nextFloor = upQueue.peek();
            if (currentFloor < nextFloor) {
                currentFloor++;
                System.out.println("Elevator " + id + " moving UP to floor " + currentFloor);
            } else {
                stopAtFloor(upQueue.poll());
            }
        } else if (direction == Direction.DOWN && !downQueue.isEmpty()) {
            int nextFloor = downQueue.peek();
            if (currentFloor > nextFloor) {
                currentFloor--;
                System.out.println("Elevator " + id + " moving DOWN to floor " + currentFloor);
            } else {
                stopAtFloor(downQueue.poll());
            }
        }

        updateStatus();
    }

    private void stopAtFloor(int floor) {
        System.out.println("Elevator " + id + " stopping at floor " + floor);
        currentFloor = floor;
        status = ElevatorStatus.STOPPED;
    }
}