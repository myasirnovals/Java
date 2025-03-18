package Tugas.I_8;

class Point {
    private double x;
    private double y;
    private double z;
    public static int jumKoordinat = 0;

    public Point(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
        jumKoordinat++;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getZ() {
        return z;
    }

    public void cetakKoordinat() {
        System.out.println("Koordinat Point:");
        System.out.println("x = " + x);
        System.out.println("y = " + y);
        System.out.println("z = " + z);
    }

    public static void main(String[] args) {
        Point point = new Point(3.5, 4.2, 7.8);
        point.cetakKoordinat();
    }
}

