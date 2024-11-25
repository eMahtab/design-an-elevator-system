package net.mahtabalam.elevator2;

import java.util.List;

class ClosestIdleDispatchStrategy implements ElevatorDispatchStrategy {
    @Override
    public Elevator dispatchElevator(Request request, List<Elevator> elevators) {
        Elevator closestElevator = null;
        int minDistance = Integer.MAX_VALUE;

        for (Elevator elevator : elevators) {
            if (elevator.getStatus() == ElevatorStatus.IDLE) {
                int distance = Math.abs(elevator.getCurrentFloor() - request.getFloorNumber());
                if (distance < minDistance) {
                    minDistance = distance;
                    closestElevator = elevator;
                }
            }
        }

        return closestElevator;
    }
}