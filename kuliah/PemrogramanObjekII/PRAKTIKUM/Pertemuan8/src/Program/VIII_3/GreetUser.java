package Program.VIII_3;

public class GreetUser {
    //some code
    //lengkapi dan selesaikan
    //program menerima sebuah string atau kata
    System.out.println("Hi, what's your name?");
    String name;
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    name = br.readLine();
    System.out.println("Nice to meet you, " + name + "! :)");
    //some code
}
