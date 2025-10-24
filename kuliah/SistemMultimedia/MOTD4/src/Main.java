public class Main {
    public static void main(String[] args) {
        TemperatureConverter temperature = new TemperatureConverter();

        System.out.println("PROGRAM SENSOR SUHU RUANGAN");
        System.out.println("-------------------------");
        System.out.println("Spesifikasi sistem:");
        System.out.println("Rentang suhu: " + temperature.getMinTempCelsius() + " C hingga " + temperature.getMaxTempCelsius() + " C");
        System.out.println("Resolusi ADC: " + temperature.getADCResolution() + "-bit (nilai 0-" + temperature.getMaxDigitalValue() + ")");
        System.out.println();

        System.out.println("Suhu ruangan 30.5 C");
        double measuredTemp = 30.5;

        int digitalResult = temperature.analogToDigital(measuredTemp);

        System.out.println("Suhu terdektesi: " + measuredTemp + " C");
        System.out.println("Hasil konversi digital: " + digitalResult);

        String binaryString = String.format("%8s", Integer.toBinaryString(digitalResult)).replace(' ', '0');
        System.out.println("Representasi biner: " + binaryString);

        double displayedTemp = temperature.digitalToAnalog(digitalResult);
        System.out.printf("Suhu yang ditampilkan: %.2f C\n", displayedTemp);
    }
}