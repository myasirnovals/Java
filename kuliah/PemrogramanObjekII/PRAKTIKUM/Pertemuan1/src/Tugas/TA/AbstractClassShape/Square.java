package Tugas.TA.AbstractClassShape;

public class Square extends Shape {
    private double side;

    public Square() {
        super();
    }

    public Square(String name) {
        super(name);
    }

    public Square(String name, double side) {
        super(name);
        this.side = side;
    }

    public double getSide() {
        return side;
    }

    public void setSide(double side) {
        this.side = side;
    }

    @Override
    public double getArea() {
        return Math.pow(side, 2);
    }
}
