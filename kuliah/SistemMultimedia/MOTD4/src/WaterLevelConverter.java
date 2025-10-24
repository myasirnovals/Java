public class WaterLevelConverter {
    private static final double MAX_HEIGHT_METERS = 2.0;
    private static final int ADC_RESOLUTION = 8;
    private static final int MAX_DIGITAL_VALUE = (int) Math.pow(2, ADC_RESOLUTION) - 1; // Hasilnya 255

    public static int analogToDigital(double analogValue) {
        if (analogValue < 0) {
            analogValue = 0;
        }
        if (analogValue > MAX_HEIGHT_METERS) {
            analogValue = MAX_HEIGHT_METERS;
        }

        double digitalValue = (analogValue * MAX_DIGITAL_VALUE) / MAX_HEIGHT_METERS;

        return (int) Math.round(digitalValue);
    }

    public static double digitalToAnalog(int digitalValue) {
        if (digitalValue < 0) {
            digitalValue = 0;
        }
        if (digitalValue > MAX_DIGITAL_VALUE) {
            digitalValue = MAX_DIGITAL_VALUE;
        }

        return (double) (digitalValue * MAX_HEIGHT_METERS) / MAX_DIGITAL_VALUE;
    }
}