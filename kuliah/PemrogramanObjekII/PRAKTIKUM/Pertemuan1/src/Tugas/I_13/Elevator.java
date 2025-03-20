package Tugas.I_13;

public class Elevator {
    public boolean doorOpen = false;
    private int floor = 1;
    public final int TOP_FLOOR = 5;
    public final int BOTTOM_FLOOR = 1;

    public void openDoor() {
        System.out.println("Opening door.");
        doorOpen = true;
        System.out.println("Door is open.");
    }

    public void closeDoor() {
        System.out.println("Closing door.");
        doorOpen = false;
        System.out.println("Door is closed.");
    }

    public void goUp() {
        System.out.println("Going up one floor.");
        floor++;
        System.out.println("Floor: " + floor);
    }

    public void goDown() {
        System.out.println("Going down one floor.");
        floor--;
        System.out.println("Floor: " + floor);
    }

    public void setFloor(int desiredFloor) {
        while (floor != desiredFloor) {
            if (floor < desiredFloor) {
                goUp();
            } else {
                goDown();
            }
        }
    }

    public int getFloor() {
        return floor;
    }

    public boolean checkDoorStatus() {
        return doorOpen;
    }
}
