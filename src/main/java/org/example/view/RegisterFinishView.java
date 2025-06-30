package org.example.view;
import org.example.controller.RegisterFinishController;
import javax.swing.*;
import java.awt.*;

public class RegisterFinishView extends JFrame {
    private JLabel Desktop;
    private JButton Login;

    public RegisterFinishView() {
        initComponents();
        Login.addActionListener(e -> RegisterFinishController.openLogin(this));
    }

    private void initComponents() {
        setTitle("Đăng ký thành công");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1200, 800);
        setResizable(false);
        setLocationRelativeTo(null);

        Desktop = new JLabel(new ImageIcon("src/main/java/org/example/img/registerfinish.png"));
        Desktop.setLayout(null);
        Desktop.setBounds(0,0,1200,800);

        Login = new JButton("Đăng nhập ngay");
        Login.setFont(new Font("Arial", Font.BOLD, 12));
        Login.setBackground(new Color(46, 204, 113));
        Login.setForeground(new Color(240,240,240));
        Login.setBounds(475, 685, 250, 33);
        Desktop.add(Login);

        setContentPane(Desktop);
    }
}
