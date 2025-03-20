package Tugas.I_13;

public class ElevatorTest {
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
        elevator.setFloor(elevator.TOP_FLOOR);
        System.out.println("Current floor: " + elevator.getFloor());
        System.out.println("Door status: " + elevator.checkDoorStatus());
    }
}
