package net.mahtabalam.elevator2;

class Elevator {
    private int id;
    private int currentFloor;
    private Direction direction;
    private ElevatorStatus status;

    public Elevator(int id) {
        this.id = id;
        this.currentFloor = 0; // Assume ground floor initially
        this.direction = Direction.NONE;
        this.status = ElevatorStatus.IDLE;
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

    public void moveToFloor(int targetFloor) {
        System.out.println("Elevator " + id + " moving from floor " + currentFloor + " to floor " + targetFloor);
        while (currentFloor < targetFloor) {
            currentFloor++;
            System.out.println("Elevator " + id + " moving UP to floor " + currentFloor);
        }
        while (currentFloor > targetFloor) {
            currentFloor--;
            System.out.println("Elevator " + id + " moving DOWN to floor " + currentFloor);
        }
        stopAtFloor(targetFloor);
    }

    private void stopAtFloor(int floor) {
        System.out.println("Elevator " + id + " stopping at floor " + floor);
        currentFloor = floor;
        status = ElevatorStatus.IDLE;
    }
}