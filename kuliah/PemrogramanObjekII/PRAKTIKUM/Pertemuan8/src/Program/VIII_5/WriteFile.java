package Program.VIII_5;

import java.io.*;

public class WriteFile {
    public WriteFile() {
    }

    public static void main(String args[]) throws IOException {
        System.out.println("What is the name of the file to be written to ? ");
        String filename;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        filename = br.readLine();
        System.out.println("Enter data to write to " + filename + "...");
        System.out.println("Type q$ to end.");
        FileOutputStream fos = null;

        try {
            fos = new FileOutputStream(filename);
        } catch (FileNotFoundException ex) {
            System.out.println("File cannot be opened for writing.");
        }

        try {
            boolean done = false;
            int data;
            do {
                data = br.read();
                if ((char) data == 'q') {
                    data = br.read();
                    if ((char) data == '$') {
                        done = true;
                    } else {
                        fos.write('q');
                        fos.write(data);
                    }
                } else {
                    fos.write(data);
                }
            } while (!done);
        } catch (IOException ex) {
            System.out.println("Problem in reading from the  file.");
        }
    }
}
