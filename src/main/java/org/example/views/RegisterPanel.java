package org.example.views;

import javax.swing.*;
import java.awt.*;

public class RegisterPanel extends JPanel {
    private MainFrame mainFrame;

    private JTextField fullNameField;
    private JTextField userNameField;
    private JPasswordField passwordField;
    private JPasswordField confirmPasswordField;
    private JButton btnRegister;
    private JButton btnBack;
    private JLabel lblInfo;

    public RegisterPanel(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
        setLayout(null);
        initComponents();
    }

    private void initComponents() {
        JLabel title = new JLabel("Đăng ký tài khoản");
        title.setFont(new Font("Arial", Font.BOLD, 22));
        title.setBounds(460, 50, 300, 30);
        add(title);

        fullNameField = new JTextField();
        fullNameField.setBounds(400, 100, 350, 30);
        fullNameField.putClientProperty("JTextField.placeholderText", "Họ tên");
        add(fullNameField);

        userNameField = new JTextField();
        userNameField.setBounds(400, 140, 350, 30);
        userNameField.putClientProperty("JTextField.placeholderText", "Tên đăng nhập");
        add(userNameField);

        passwordField = new JPasswordField();
        passwordField.setBounds(400, 180, 350, 30);
        passwordField.putClientProperty("JTextField.placeholderText", "Mật khẩu");
        add(passwordField);

        confirmPasswordField = new JPasswordField();
        confirmPasswordField.setBounds(400, 220, 350, 30);
        confirmPasswordField.putClientProperty("JTextField.placeholderText", "Xác nhận mật khẩu");
        add(confirmPasswordField);

        btnRegister = new JButton("Đăng ký");
        btnRegister.setBounds(400, 270, 350, 30);
        add(btnRegister);

        btnBack = new JButton("Quay lại");
        btnBack.setBounds(400, 310, 350, 30);
        add(btnBack);

        lblInfo = new JLabel("", SwingConstants.CENTER);
        lblInfo.setForeground(Color.RED);
        lblInfo.setBounds(400, 350, 350, 30);
        add(lblInfo);

        btnRegister.addActionListener(e -> registerAction());
        btnBack.addActionListener(e -> mainFrame.showLoginPanel());
    }

    private void registerAction() {
        String fullName = fullNameField.getText().trim();
        String username = userNameField.getText().trim();
        String password = new String(passwordField.getPassword()).trim();
        String confirmPassword = new String(confirmPasswordField.getPassword()).trim();

        if (fullName.isEmpty() || username.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
            lblInfo.setText("Vui lòng nhập đầy đủ thông tin!");
            return;
        }

        if (!password.equals(confirmPassword)) {
            lblInfo.setText("Mật khẩu xác nhận không đúng!");
            return;
        }

        // TODO: xử lý đăng ký tài khoản (lưu vào DB, file,...)

        lblInfo.setText("");
        mainFrame.showRegisterFinishPanel();
    }
}
