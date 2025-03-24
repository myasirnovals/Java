package Tugas.TA;

public class Rectangle {
    private int p;
    private int l;

    public Rectangle() {

    }

    public Rectangle(int p, int l) {
        this.p = p;
        this.l = l;
    }

    public int getP() {
        return p;
    }

    public void setP(int p) {
        this.p = p;
    }

    public int getL() {
        return l;
    }

    public void setL(int l) {
        this.l = l;
    }

    public int area(int p, int l) {
        return p * l;
    }
}
