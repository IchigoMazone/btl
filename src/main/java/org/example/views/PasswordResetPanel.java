package org.example.views;

import javax.swing.*;
import java.awt.*;

public class PasswordResetPanel extends JPanel {
    private MainFrame mainFrame;
    private String username;

    private JPasswordField passwordField;
    private JPasswordField confirmPasswordField;
    private JButton btnConfirm;
    private JButton btnBack;
    private JLabel lblInfo;

    public PasswordResetPanel(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
        setLayout(null);
        initComponents();
    }

    public void setUsername(String username) {
        this.username = username;
        lblInfo.setText("");
        passwordField.setText("");
        confirmPasswordField.setText("");
    }

    private void initComponents() {
        JLabel title = new JLabel("Đặt lại mật khẩu");
        title.setFont(new Font("Arial", Font.BOLD, 22));
        title.setBounds(460, 100, 300, 30);
        add(title);

        passwordField = new JPasswordField();
        passwordField.setBounds(400, 150, 350, 30);
        passwordField.putClientProperty("JTextField.placeholderText", "Mật khẩu mới");
        add(passwordField);

        confirmPasswordField = new JPasswordField();
        confirmPasswordField.setBounds(400, 190, 350, 30);
        confirmPasswordField.putClientProperty("JTextField.placeholderText", "Xác nhận mật khẩu");
        add(confirmPasswordField);

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
        String password = new String(passwordField.getPassword()).trim();
        String confirmPassword = new String(confirmPasswordField.getPassword()).trim();

        if (password.isEmpty() || confirmPassword.isEmpty()) {
            lblInfo.setText("Vui lòng nhập đầy đủ thông tin!");
            return;
        }

        if (!password.equals(confirmPassword)) {
            lblInfo.setText("Mật khẩu xác nhận không đúng!");
            return;
        }

        // TODO: cập nhật mật khẩu cho user username

        lblInfo.setText("");
        JOptionPane.showMessageDialog(this, "Đặt lại mật khẩu thành công!");
        mainFrame.showLoginPanel();
    }
}
