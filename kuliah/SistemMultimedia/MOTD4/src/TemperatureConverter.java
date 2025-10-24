public class TemperatureConverter {
    private static final double MAX_TEMP_CELSIUS = 50.0;
    private static final double MIN_TEMP_CELSIUS = 0.0;
    private static final int ADC_RESOLUTION = 8;
    private static final int MAX_DIGITAL_VALUE = (int) Math.pow(2, ADC_RESOLUTION) - 1;
    
    public static double getMaxTempCelsius() {
        return MAX_TEMP_CELSIUS;
    }

    public static double getMinTempCelsius() {
        return MIN_TEMP_CELSIUS;
    }

    public static int getADCResolution() {
        return ADC_RESOLUTION;
    }

    public static int getMaxDigitalValue() {
        return MAX_DIGITAL_VALUE;
    }

    public static int analogToDigital(double currentTemp) {
        if (currentTemp < MIN_TEMP_CELSIUS) {
            currentTemp = MIN_TEMP_CELSIUS;
        }

        if (currentTemp > MAX_TEMP_CELSIUS) {
            currentTemp = MAX_TEMP_CELSIUS;
        }

        double digitalValue = (currentTemp * MAX_DIGITAL_VALUE) / MAX_TEMP_CELSIUS;

        return (int) Math.round(digitalValue);
    }

    public static double digitalToAnalog(int digitalValue) {
        if (digitalValue < 0) {
            digitalValue = 0;
        }

        if (digitalValue > MAX_DIGITAL_VALUE) {
            digitalValue = MAX_DIGITAL_VALUE;
        }

        return (digitalValue * MAX_TEMP_CELSIUS) / MAX_DIGITAL_VALUE;
    }
}
