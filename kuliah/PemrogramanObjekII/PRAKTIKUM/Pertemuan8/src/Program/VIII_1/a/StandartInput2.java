package Program.VIII_1.a;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StandartInput2 {
    public static void main(String[] args) {
        try {
            System.out.println("Hi, what's your favorite character?");

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            char favChar = (char) br.read();

            System.out.println(favChar + " is a good choice!");
        } catch (IOException e) {
            System.out.println("An error occurred while reading input: " + e.getMessage());
        }
    }
}