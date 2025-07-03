package org.example.views;

import javax.swing.*;
import java.awt.*;

public class ForgotPasswordPanel extends JPanel {
    private MainFrame mainFrame;

    private JTextField usernameField;
    private JTextField emailField;
    private JButton btnConfirm;
    private JButton btnBack;
    private JLabel lblInfo;

    public ForgotPasswordPanel(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
        setLayout(null);
        initComponents();
    }

    private void initComponents() {
        JLabel title = new JLabel("Quên mật khẩu");
        title.setFont(new Font("Arial", Font.BOLD, 22));
        title.setBounds(460, 100, 300, 30);
        add(title);

        usernameField = new JTextField();
        usernameField.setBounds(400, 150, 350, 30);
        usernameField.putClientProperty("JTextField.placeholderText", "Tên đăng nhập");
        add(usernameField);

        emailField = new JTextField();
        emailField.setBounds(400, 190, 350, 30);
        emailField.putClientProperty("JTextField.placeholderText", "Email");
        add(emailField);

        btnConfirm = new JButton("Xác nhận");
        btnConfirm.setBounds(400, 230, 350, 30);
        add(btnConfirm);

        btnBack = new JButton("Quay lại");
        btnBack.setBounds(400, 270, 350, 30);
        add(btnBack);

        lblInfo = new JLabel("", SwingConstants.CENTER);
        lblInfo.setForeground(Color.RED);
        lblInfo.setBounds(400, 310, 350, 30);
        add(lblInfo);

        btnConfirm.addActionListener(e -> confirmAction());
        btnBack.addActionListener(e -> mainFrame.showLoginPanel());
    }

    private void confirmAction() {
        String username = usernameField.getText().trim();
        String email = emailField.getText().trim();

        if (username.isEmpty() || email.isEmpty()) {
            lblInfo.setText("Vui lòng nhập đầy đủ thông tin!");
            return;
        }

        // TODO: kiểm tra username và email tồn tại

        boolean userExists = true; // Giả lập user có thật
        if (!userExists) {
            lblInfo.setText("Tài khoản hoặc email không đúng!");
            return;
        }

        lblInfo.setText("");
        mainFrame.showPasswordResetPanel(username);
    }
}
