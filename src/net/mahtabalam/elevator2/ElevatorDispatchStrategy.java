package net.mahtabalam.elevator2;

import java.util.List;

public interface ElevatorDispatchStrategy {
	Elevator dispatchElevator(Request request, List<Elevator> elevators);
}
