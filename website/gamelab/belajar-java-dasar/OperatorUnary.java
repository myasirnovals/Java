class Main {
  public static void main(String[] args) {
      int a = 5;
      boolean b = false;
      int c = 10;
      
      int hasil;
      boolean hasil_boolean;
      
      hasil = a++;
      System.out.println("a++ bernilai " + hasil);
      
      hasil_boolean = !b;
      System.out.println("!b bernilai " + hasil_boolean);
      
      hasil = -c;
      System.out.println("-c bernilai " + hasil);
  }
}
