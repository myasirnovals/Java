package util;

public class PlayerSelection {
    // default ship
    private static int selectedShipIndex = 0;

    public static void setSelectedShipIndex(int index) {
        selectedShipIndex = index;
    }

    public static int getSelectedShipIndex() {
        return selectedShipIndex;
    }
}
