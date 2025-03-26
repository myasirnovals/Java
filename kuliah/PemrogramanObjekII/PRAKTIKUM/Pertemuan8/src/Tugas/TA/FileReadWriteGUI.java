package Tugas.TA;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class FileReadWriteGUI {
    public static void main(String[] args) {
        JFrame frame = new JFrame("File Reader and Writer");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());

        JButton readButton = new JButton("Baca File");
        JButton writeButton = new JButton("Tulis File");

        panel.add(readButton);
        panel.add(writeButton);

        frame.add(panel, BorderLayout.CENTER);

        frame.setVisible(true);

        readButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                int result = fileChooser.showOpenDialog(frame);

                if (result == JFileChooser.APPROVE_OPTION) {
                    File file = fileChooser.getSelectedFile();
                    try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                        StringBuilder fileContent = new StringBuilder();
                        String line;
                        while ((line = reader.readLine()) != null) {
                            fileContent.append(line).append("\n");
                        }

                        JTextArea textArea = new JTextArea(fileContent.toString());
                        textArea.setEditable(false);
                        JScrollPane scrollPane = new JScrollPane(textArea);
                        scrollPane.setPreferredSize(new Dimension(350, 200));
                        JOptionPane.showMessageDialog(frame, scrollPane, "Isi File", JOptionPane.INFORMATION_MESSAGE);

                    } catch (IOException ex) {
                        JOptionPane.showMessageDialog(frame, "Kesalahan saat membaca file: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });

        writeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                int result = fileChooser.showSaveDialog(frame);

                if (result == JFileChooser.APPROVE_OPTION) {
                    File file = fileChooser.getSelectedFile();
                    try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
                        JTextArea textArea = new JTextArea();
                        JScrollPane scrollPane = new JScrollPane(textArea);
                        scrollPane.setPreferredSize(new Dimension(350, 200));
                        int option = JOptionPane.showConfirmDialog(frame, scrollPane, "Tulis Isi File", JOptionPane.OK_CANCEL_OPTION);

                        if (option == JOptionPane.OK_OPTION) {
                            writer.write(textArea.getText());
                            JOptionPane.showMessageDialog(frame, "File berhasil disimpan!", "Sukses", JOptionPane.INFORMATION_MESSAGE);
                        }

                    } catch (IOException ex) {
                        JOptionPane.showMessageDialog(frame, "Kesalahan saat menulis file: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });
    }
}
