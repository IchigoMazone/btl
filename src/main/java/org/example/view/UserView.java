package org.example.view;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import org.example.controller.UserController;

public class UserView extends JFrame {
    private JLabel backgroundLabel;
    private JButton btnLogout;

    public UserView() {
        initComponents();
        btnLogout.addActionListener(e -> UserController.Logout(this));
    }

    private void initComponents() {
        setTitle("Admin Dashboard");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1200, 800);
        setResizable(false);
        setLocationRelativeTo(null);
        setLayout(null);

        backgroundLabel = new JLabel(new ImageIcon("src/main/java/org/example/img/registerfinish.png"));
        backgroundLabel.setBounds(0, 0, 1200, 800);
        backgroundLabel.setLayout(null);

        btnLogout = new JButton("Đăng xuất");
        btnLogout.setBounds(1000, 700, 150, 40);
        btnLogout.setBorderPainted(false);
        btnLogout.setContentAreaFilled(false);
        btnLogout.setFocusPainted(false);
        backgroundLabel.add(btnLogout);

        add(backgroundLabel);
    }
}
