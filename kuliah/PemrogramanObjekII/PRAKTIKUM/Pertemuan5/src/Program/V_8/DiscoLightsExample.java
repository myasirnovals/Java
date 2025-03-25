package Program.V_8;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class DiscoLightsExample extends JFrame implements ActionListener {
    private final String ACTION_ON = "LIGHT ON";
    private final String ACTION_OFF = "LIGHT OFF";
    private final String ACTION_CYCLE = "CYCLE COLOR";
    private final Color[] COLORS = new Color[]{
            Color.white,
            Color.green,
            Color.red,
            Color.yellow,
            Color.orange,
            Color.pink
    };

    private int currentColor = 0;
    private boolean isLightOn = false;

    public DiscoLightsExample() {
        setTitle("Disco Light Party Frame");
        setLayout(new FlowLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JButton btnOffOn = new JButton("Lights On");
        JButton btnColor = new JButton("Cycle Color");

        btnOffOn.setActionCommand(ACTION_ON);
        btnColor.setActionCommand(ACTION_CYCLE);
        btnOffOn.addActionListener(this);
        btnColor.addActionListener(this);

        getContentPane().add(btnOffOn);
        getContentPane().add(btnColor);

        pack();
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ev) {
        String action = ev.getActionCommand();
        System.err.println("Got action " + action);

        switch (action) {
            case ACTION_ON:
                isLightOn = true;

                getContentPane().setBackground(COLORS[currentColor]);
                ((JButton) ev.getSource()).setText("Lights Off");
                ((JButton) ev.getSource()).setActionCommand(ACTION_OFF);
                break;
            case ACTION_OFF:
                isLightOn = false;
                getContentPane().setBackground(Color.black);
                ((JButton) ev.getSource()).setText("Lights On");
                ((JButton) ev.getSource()).setActionCommand(ACTION_ON);
                break;
            case ACTION_CYCLE:
                if (isLightOn)
                    getContentPane().setBackground(COLORS[++currentColor % COLORS.length]);
                break;
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new DiscoLightsExample();
            }
        });
    }
}
