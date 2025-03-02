public class BIgSmall {
    int value1;
    int value2;

    public void PrintMessage() {
        if (this.value1 > this.value2) {
            System.out.println(this.value1 + " lebih besar dari " + this.value2);
        } else {
            System.out.println(this.value2 + " lebih besar dari " + this.value1);
        }
    }
}
