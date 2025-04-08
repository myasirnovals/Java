import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Lime App");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setLayout(new BorderLayout());

        // header start
        JPanel header = new JPanel();
        header.setLayout(new FlowLayout(FlowLayout.LEFT));
        header.setBackground(Color.DARK_GRAY);

        JLabel logo = new JLabel("Lime");
        logo.setForeground(Color.WHITE);
        logo.setFont(new Font("Arial", Font.BOLD, 20));
        JTextField searchBar = new JTextField(20);
        JButton profileButton = new JButton("Profile");
        JButton settingsButton = new JButton("Settings");

        header.add(logo);
        header.add(searchBar);
        header.add(profileButton);
        header.add(settingsButton);

        // sidebar start
        JPanel sidebar = new JPanel();
        sidebar.setLayout(new GridLayout(5, 1));
        sidebar.setBackground(Color.LIGHT_GRAY);

        JButton homeButton = new JButton("Home");
        JButton messagesButton = new JButton("Messages");
        JButton notificationsButton = new JButton("Notifications");
        JButton settingsSidebarButton = new JButton("Settings");
        JButton logoutButton = new JButton("Logout");

        sidebar.add(homeButton);
        sidebar.add(messagesButton);
        sidebar.add(notificationsButton);
        sidebar.add(settingsSidebarButton);
        sidebar.add(logoutButton);

        // feed start
        JPanel feed = new JPanel();
        feed.setLayout(new BoxLayout(feed, BoxLayout.Y_AXIS));
        feed.setBackground(Color.WHITE);

        JLabel feedTitle = new JLabel("Welcome to the Lime Feed!");
        feedTitle.setFont(new Font("Arial", Font.BOLD, 18));
        feedTitle.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel post1 = new JLabel("Post 1: This is an example post.");
        post1.setAlignmentX(Component.CENTER_ALIGNMENT);
        JLabel post2 = new JLabel("Post 2: Another example post.");
        post2.setAlignmentX(Component.CENTER_ALIGNMENT);

        feed.add(feedTitle);
        feed.add(Box.createRigidArea(new Dimension(0, 10)));
        feed.add(post1);
        feed.add(Box.createRigidArea(new Dimension(0, 10)));
        feed.add(post2);

        // footer start
        JPanel footer = new JPanel();
        footer.setBackground(Color.DARK_GRAY);

        JLabel footerLabel = new JLabel("© 2025 Lime App");
        footerLabel.setForeground(Color.WHITE);
        footer.add(footerLabel);

        // add panel
        frame.add(header, BorderLayout.NORTH);
        frame.add(sidebar, BorderLayout.WEST);
        frame.add(feed, BorderLayout.CENTER);
        frame.add(footer, BorderLayout.SOUTH);

        // dispay frame
        frame.setVisible(true);
    }
}