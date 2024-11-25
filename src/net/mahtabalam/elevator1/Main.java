package net.mahtabalam.elevator1;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        // Create elevators
        Elevator elevator1 = new Elevator(1);
        Elevator elevator2 = new Elevator(2);

        // Create floors with the elevators
        Floor floor1 = new Floor(1, Arrays.asList(elevator1, elevator2));
        Floor floor2 = new Floor(2, Arrays.asList(elevator1, elevator2));
        Floor floor3 = new Floor(3, Arrays.asList(elevator1, elevator2));
        Floor floor4 = new Floor(4, Arrays.asList(elevator1, elevator2));

        // Add floors to the building
        Building building = new Building(new ArrayList<>(Arrays.asList(floor1, floor2, floor3, floor4)));

        // Simulate pressing buttons
        System.out.println("Simulating elevator button presses:");
        floor1.pressUpButton(elevator1); // Request elevator1 to go UP from floor 1
        floor3.pressDownButton(elevator2); // Request elevator2 to go DOWN from floor 3

        // Simulate elevator movements
        System.out.println("\nSimulating elevator movements:");
        while (elevator1.getStatus() != ElevatorStatus.IDLE || elevator2.getStatus() != ElevatorStatus.IDLE) {
            elevator1.move();
            elevator2.move();
        }

        floor4.pressDownButton(elevator1);
        while (elevator1.getStatus() != ElevatorStatus.IDLE) {
            elevator1.move();
        }
    }
}
