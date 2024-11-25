package net.mahtabalam.elevator2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Create elevators
        Elevator elevator1 = new Elevator(1);
        Elevator elevator2 = new Elevator(2);
        
        List<Elevator> elevators = Arrays.asList(elevator1, elevator2);
        ElevatorDispatchStrategy dispatchStrategy = new ClosestIdleDispatchStrategy();
        ElevatorDispatcher elevatorDispatcher = new ElevatorDispatcher(elevators, dispatchStrategy);
        

        List<Floor> floors = new ArrayList<>();
        for (int i = 0; i < 5; i++) { // Assuming 5 floors
            floors.add(new Floor(i, elevatorDispatcher));
        }

     // Simulate button presses
        System.out.println("\n=== Simulating Button Presses ===");
        Floor floor0 = floors.get(0); // Ground floor
        Floor floor4 = floors.get(4); // Top floor
        Floor floor2 = floors.get(2); // Middle floor

        floor0.pressUpButton(); // Request from ground floor to go up
        floor2.pressUpButton(); // Request from the middle floor to go up
        floor4.pressDownButton(); // Request from top floor to go down

        System.out.println("\n=== Simulation Complete ===");
    }
}
