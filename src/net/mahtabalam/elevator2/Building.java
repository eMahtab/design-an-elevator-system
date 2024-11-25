package net.mahtabalam.elevator2;

import java.util.List;

public class Building {
    List<Floor> floorList;
    ElevatorDispatcher elevatorDispatcher;

    Building(List<Floor> floors, ElevatorDispatcher elevatorDispatcher){
        this.floorList = floors;
        this.elevatorDispatcher = elevatorDispatcher;
    }

    public void addFloors(Floor newFloor){
        floorList.add(newFloor);
    }

    public void removeFloors(Floor removeFloor){
        floorList.remove(removeFloor);
    }

    List<Floor> getAllFloorList(){
        return floorList;
    }
    
    public ElevatorDispatcher getElevatorDispatcher() {
    	return elevatorDispatcher;
    }
}
