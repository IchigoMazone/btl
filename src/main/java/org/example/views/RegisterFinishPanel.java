package org.example.views;

import javax.swing.*;
import java.awt.*;

public class RegisterFinishPanel extends JPanel {
    private MainFrame mainFrame;

    private JLabel lblMessage;
    private JButton btnLogin;

    public RegisterFinishPanel(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
        setLayout(null);
        initComponents();
    }

    private void initComponents() {
        lblMessage = new JLabel("Đăng ký thành công!", SwingConstants.CENTER);
        lblMessage.setFont(new Font("Arial", Font.BOLD, 22));
        lblMessage.setBounds(400, 200, 350, 40);
        add(lblMessage);

        btnLogin = new JButton("Đăng nhập ngay");
        btnLogin.setBounds(475, 260, 200, 35);
        add(btnLogin);

        btnLogin.addActionListener(e -> mainFrame.showLoginPanel());
    }
}
