package Program.VII_17;

import Program.VII_15.ValidateInput;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ValidateGUI {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Input Validator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);
        frame.setLayout(new GridLayout(9, 2, 5, 5));

        JLabel firstNameLabel = new JLabel("First Name:");
        JTextField firstNameField = new JTextField();
        JLabel lastNameLabel = new JLabel("Last Name:");
        JTextField lastNameField = new JTextField();
        JLabel addressLabel = new JLabel("Address:");
        JTextField addressField = new JTextField();
        JLabel cityLabel = new JLabel("City:");
        JTextField cityField = new JTextField();
        JLabel stateLabel = new JLabel("State:");
        JTextField stateField = new JTextField();
        JLabel zipLabel = new JLabel("Zip Code:");
        JTextField zipField = new JTextField();
        JLabel phoneLabel = new JLabel("Phone Number:");
        JTextField phoneField = new JTextField();

        JButton submitButton = new JButton("Validate");
        JLabel resultLabel = new JLabel("");

        frame.add(firstNameLabel);
        frame.add(firstNameField);
        frame.add(lastNameLabel);
        frame.add(lastNameField);
        frame.add(addressLabel);
        frame.add(addressField);
        frame.add(cityLabel);
        frame.add(cityField);
        frame.add(stateLabel);
        frame.add(stateField);
        frame.add(zipLabel);
        frame.add(zipField);
        frame.add(phoneLabel);
        frame.add(phoneField);
        frame.add(submitButton);
        frame.add(resultLabel);

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String firstName = firstNameField.getText().trim();
                String lastName = lastNameField.getText().trim();
                String address = addressField.getText().trim();
                String city = cityField.getText().trim();
                String state = stateField.getText().trim();
                String zip = zipField.getText().trim();
                String phone = phoneField.getText().trim();

                if (!ValidateInput.validateFirstName(firstName)) {
                    resultLabel.setText("Invalid First Name");
                } else if (!ValidateInput.validateLastName(lastName)) {
                    resultLabel.setText("Invalid Last Name");
                } else if (!ValidateInput.validateAddress(address)) {
                    resultLabel.setText("Invalid Address");
                } else if (!ValidateInput.validateCity(city)) {
                    resultLabel.setText("Invalid City");
                } else if (!ValidateInput.validateState(state)) {
                    resultLabel.setText("Invalid State");
                } else if (!ValidateInput.validateZip(zip)) {
                    resultLabel.setText("Invalid Zip Code");
                } else if (!ValidateInput.validatePhone(phone)) {
                    resultLabel.setText("Invalid Phone Number");
                } else {
                    resultLabel.setText("All inputs are valid. Thank you!");
                }
            }
        });

        frame.setVisible(true);
    }
}