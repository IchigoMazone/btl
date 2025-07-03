package org.example.views;

import javax.swing.*;
import java.awt.*;

public class LoginPanel extends JPanel {
    private MainFrame mainFrame;

    private JTextField userNameField;
    private JPasswordField passwordField;
    private JButton btnLogin;
    private JButton btnRegister;
    private JButton btnForgotPassword;
    private JLabel lblInfo;

    public LoginPanel(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
        setLayout(null);
        initComponents();
    }

    private void initComponents() {
        JLabel title = new JLabel("Đăng nhập hệ thống");
        title.setFont(new Font("Arial", Font.BOLD, 22));
        title.setBounds(460, 100, 300, 30);
        add(title);

        userNameField = new JTextField();
        userNameField.setBounds(400, 160, 350, 30);
        userNameField.putClientProperty("JTextField.placeholderText", "Tên đăng nhập");
        add(userNameField);

        passwordField = new JPasswordField();
        passwordField.setBounds(400, 210, 350, 30);
        passwordField.putClientProperty("JTextField.placeholderText", "Mật khẩu");
        add(passwordField);

        btnLogin = new JButton("Đăng nhập");
        btnLogin.setBounds(400, 260, 350, 30);
        add(btnLogin);

        btnRegister = new JButton("Đăng ký");
        btnRegister.setBounds(400, 310, 170, 30);
        add(btnRegister);

        btnForgotPassword = new JButton("Quên mật khẩu");
        btnForgotPassword.setBounds(580, 310, 170, 30);
        add(btnForgotPassword);

        lblInfo = new JLabel("", SwingConstants.CENTER);
        lblInfo.setForeground(Color.RED);
        lblInfo.setBounds(400, 350, 350, 30);
        add(lblInfo);

        // Action listeners
        btnLogin.addActionListener(e -> loginAction());
        btnRegister.addActionListener(e -> mainFrame.showRegisterPanel());
        btnForgotPassword.addActionListener(e -> mainFrame.showForgotPasswordPanel());
    }

    private void loginAction() {
        String username = userNameField.getText().trim();
        String password = new String(passwordField.getPassword()).trim();

        // TODO: replace with real authentication & role checking
        if (username.isEmpty() || password.isEmpty()) {
            lblInfo.setText("Vui lòng nhập đầy đủ thông tin!");
            return;
        }
        // Giả lập đăng nhập
        if ("admin".equals(username) && "admin".equals(password)) {
            lblInfo.setText("");
            mainFrame.showAdminContainerPanel(username);
        } else if ("user".equals(username) && "user".equals(password)) {
            lblInfo.setText("");
            mainFrame.showUserContainerPanel(username);
        } else {
            lblInfo.setText("Sai tên đăng nhập hoặc mật khẩu!");
        }
    }
}
