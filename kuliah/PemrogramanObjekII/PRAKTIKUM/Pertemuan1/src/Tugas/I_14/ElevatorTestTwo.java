package Tugas.I_14;

public class ElevatorTestTwo {
    public static void main(String[] args) {
        Elevator elevator = new Elevator();
        elevator.openDoor();
        elevator.closeDoor();
        elevator.goUp();
        elevator.goUp();
        elevator.goUp();
        elevator.openDoor();
        elevator.closeDoor();
        elevator.goDown();
        elevator.openDoor();
        elevator.closeDoor();
        elevator.goDown();
        int currentFloor = elevator.getFloor();
        System.out.println("Current floor: " + currentFloor);
        elevator.setFloor(currentFloor + 1);
        elevator.openDoor();
    }
}
