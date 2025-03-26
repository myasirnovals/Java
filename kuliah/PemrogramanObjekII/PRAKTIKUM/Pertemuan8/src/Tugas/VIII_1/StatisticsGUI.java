package Tugas.VIII_1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;

public class StatisticsGUI {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Statistik Nilai");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        JLabel inputLabel = new JLabel("Masukkan nilai (pisahkan dengan koma):");
        JTextField inputField = new JTextField();
        JButton calculateButton = new JButton("Hitung");
        JTextArea resultArea = new JTextArea();
        resultArea.setEditable(false);

        JPanel inputPanel = new JPanel(new GridLayout(3, 1));
        inputPanel.add(inputLabel);
        inputPanel.add(inputField);
        inputPanel.add(calculateButton);

        frame.add(inputPanel, BorderLayout.NORTH);
        frame.add(new JScrollPane(resultArea), BorderLayout.CENTER);

        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String inputText = inputField.getText();
                BufferedReader br = new BufferedReader(new StringReader(inputText));
                try {
                    String line = br.readLine();
                    String[] values = line.split(",");
                    ArrayList<Double> numbers = new ArrayList<>();

                    for (String value : values) {
                        numbers.add(Double.parseDouble(value.trim()));
                    }

                    double sum = 0;
                    for (double num : numbers) {
                        sum += num;
                    }
                    double mean = sum / numbers.size();

                    double varianceSum = 0;
                    for (double num : numbers) {
                        varianceSum += Math.pow(num - mean, 2);
                    }
                    double standardDeviation = Math.sqrt(varianceSum / numbers.size());

                    resultArea.setText("Rata-rata: " + mean + "\n"
                            + "Standar Deviasi: " + standardDeviation);
                } catch (IOException | NumberFormatException ex) {
                    resultArea.setText("Terjadi kesalahan: " + ex.getMessage());
                }
            }
        });

        frame.setVisible(true);
    }
}