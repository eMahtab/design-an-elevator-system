package net.mahtabalam.elevator1;

class FloorButton {
    private int floorNumber;
    private Direction direction;
    private Elevator targetElevator;

    public FloorButton(int floorNumber, Direction direction, Elevator targetElevator) {
        this.floorNumber = floorNumber;
        this.direction = direction;
        this.targetElevator = targetElevator;
    }

    public void press() {
        System.out.println(direction + " button pressed on floor " + floorNumber + " for Elevator " + targetElevator.getId());
        Request request = new Request(floorNumber, direction);
        targetElevator.addRequest(request);
    }
}
