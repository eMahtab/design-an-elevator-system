package net.mahtabalam.elevator1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Floor {
    private int floorNumber;
    private Map<Elevator, List<FloorButton>> elevatorButtons;

    public Floor(int floorNumber, List<Elevator> elevators) {
        this.floorNumber = floorNumber;
        this.elevatorButtons = new HashMap<>();
        for (Elevator elevator : elevators) {
            List<FloorButton> buttons = new ArrayList<>();
            buttons.add(new FloorButton(floorNumber, Direction.UP, elevator));
            buttons.add(new FloorButton(floorNumber, Direction.DOWN, elevator));
            elevatorButtons.put(elevator, buttons);
        }
    }

    public int getFloorNumber() {
		return floorNumber;
	}

	public void pressUpButton(Elevator elevator) {
        elevatorButtons.get(elevator).get(0).press(); // Press the UP button
    }

    public void pressDownButton(Elevator elevator) {
        elevatorButtons.get(elevator).get(1).press(); // Press the DOWN button
    }
}
