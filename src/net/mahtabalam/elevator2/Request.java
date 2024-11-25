package net.mahtabalam.elevator2;

class Request {
    private int floorNumber;
    private Direction direction;

    public Request(int floorNumber, Direction direction) {
        this.floorNumber = floorNumber;
        this.direction = direction;
    }

    public int getFloorNumber() {
        return floorNumber;
    }

    public Direction getDirection() {
        return direction;
    }
}