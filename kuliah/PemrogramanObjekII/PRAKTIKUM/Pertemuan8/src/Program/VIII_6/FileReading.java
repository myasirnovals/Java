package Program.VIII_6;

class FileReading {
    //code
    String line = "", fileContent = "";
    try {
        BufferedReader fileInput = new BufferedReader(new FileReader(new File("D:/=POL 2018/Praktikum/Modul08/bin/belajarbaca.txt")));
        line = fileInput.readLine();
        fileContent = line + "\n";
        while (line != null) {
            line = fileInput.readLine();
            if (line != null) fileContent += line + "\n";
        }
        fileInput.close();
    } catch(EOFException eofe) {
        System.out.println("No more lines to read.");
        System.exit(0);
    } catch(IOException ioe) {
        System.out.println("Error reading file.");
        System.exit(0);
    }
        System.out.println(fileContent);
    }
}