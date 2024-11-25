package net.mahtabalam.elevator2;

class Floor {
    private int floorNumber;
    private ElevatorDispatcher elevatorDispatcher;

    public Floor(int floorNumber, ElevatorDispatcher elevatorDispatcher) {
        this.floorNumber = floorNumber;
        this.elevatorDispatcher = elevatorDispatcher;
    }

    public int getFloorNumber() {
		return floorNumber;
	}

	public void pressUpButton() {
        System.out.println("Up button pressed on floor " + floorNumber);
        elevatorDispatcher.handleRequest(new Request(floorNumber, Direction.UP));
    }

    public void pressDownButton() {
        System.out.println("Down button pressed on floor " + floorNumber);
        elevatorDispatcher.handleRequest(new Request(floorNumber, Direction.DOWN));
    }
}
