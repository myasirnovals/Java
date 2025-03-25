package Program.V_1;

public class SwingApplication {
    //some code
    JButton button = new JButton("I'm a Swing button!");
    button.addActionListener(this);

    //some code
    public void actionPerformed(ActionEvent e) {
        numClicks++;
        label.setText(labelPrefix + numClicks);
    }
}
