package Program.IV_8;

import javax.swing.*;

public class MyContainer {
    public static void main (String args[]){
        JFrame.setDefaultLookAndFeelDecorated(true);
        JFrame container = new JFrame ("Window Utama");

        container.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        container.setSize(300,100);
        container.setLocation(200,200);
        container.setVisible(true);
    }
}
