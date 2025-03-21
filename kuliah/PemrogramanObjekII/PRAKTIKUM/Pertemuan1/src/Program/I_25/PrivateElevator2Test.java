package Program.I_25;

public class PrivateElevator2Test {
    public static void main(String args[]) {
        PrivateElevator2 privElevator = new PrivateElevator2();
        privElevator.buka();
        privElevator.tutup();
        privElevator.turun();
        privElevator.naik();
        privElevator.naik();
        privElevator.buka();
        privElevator.tutup();
        privElevator.turun();
        privElevator.buka();
        privElevator.turun();
        privElevator.tutup();
        privElevator.turun();
        privElevator.turun();

        int lantai = privElevator.getLantai();

        if (lantai != 5 && !privElevator.getStatusPintu()) {
            privElevator.setLantai(5);
        }

        privElevator.setLantai(10);
        privElevator.buka();
    }
}
