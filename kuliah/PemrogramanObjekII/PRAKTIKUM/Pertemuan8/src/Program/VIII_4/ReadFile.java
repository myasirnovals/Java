package Program.VIII_4;

import java.io.*;

public class ReadFile {
    public ReadFile() {
    }

    public static void main(String args[]) throws IOException {
        System.out.println("What is the name of the file to read from ? ");
        String filename;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        filename = br.readLine();
        System.out.println("Now reading from " + filename + "...");
        FileInputStream fis = null;

        try {
            fis = new FileInputStream(filename);
        } catch (FileNotFoundException ex) {
            System.out.println("File not found.");
        }

        try {
            char data;
            int temp;
            do {
                temp = fis.read();
                data = (char) temp;
                if (temp != -1) {
                    System.out.print(data);
                }
            } while (temp != -1);
        } catch (IOException ex) {
            System.out.println("Problem in reading from the  file.");
        }
    }
}
