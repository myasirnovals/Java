class Main {
    public static void main(String[] args) {
        int jam = 22;
        
        if (jam < 10) {
            System.out.println("Selamat pagi");
        } else if (jam < 14) {
            System.out.println("Selamat siang");
        } else if (jam < 18) {
            System.out.println("Selamat sore");
        } else {
            System.out.println("Selamat malam");
        }
    }
}
