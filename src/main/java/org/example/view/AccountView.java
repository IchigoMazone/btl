package org.example.view;

import org.example.action.CheckAccount;

import javax.swing.*;
import java.awt.*;

public class AccountView extends JFrame {
    private JTextField userNameField;
    private JTextField emailField;
    private JLabel lblInfo;
    private JButton btnBack;
    private JButton btnConfirm;
    private JLabel imgDesktop;

    public AccountView() {
        setTitle("Quên mật khẩu");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1200, 800);
        setResizable(false);
        setLocationRelativeTo(null);

        imgDesktop = new JLabel(new ImageIcon("src/main/java/org/example/img/account.png"));
        imgDesktop.setLayout(null);
        imgDesktop.setBounds(0, 0, 1200, 800);

        JLabel lblTitle = new JLabel("Xác minh tài khoản");
        lblTitle.setFont(new Font("Arial", Font.BOLD, 22));
        lblTitle.setForeground(new Color(135, 206, 235));
        lblTitle.setBounds(500, 370, 220, 30);
        imgDesktop.add(lblTitle);

        userNameField = new JTextField();
        userNameField.setFont(new Font("Arial", Font.PLAIN, 14));
        userNameField.setBounds(440, 430, 320, 33);
        userNameField.putClientProperty("JTextField.placeholderText", "Tên đăng nhập");
        imgDesktop.add(userNameField);

        emailField = new JTextField();
        emailField.setFont(new Font("Arial", Font.PLAIN, 14));
        emailField.setBounds(440, 490, 320, 33);
        emailField.putClientProperty("JTextField.placeholderText", "Email");
        imgDesktop.add(emailField);

        lblInfo = new JLabel("", SwingConstants.CENTER);
        lblInfo.setForeground(Color.WHITE);
        lblInfo.setFont(new Font("Arial", Font.PLAIN, 13));
        imgDesktop.add(lblInfo);

        btnBack = new JButton("Quay lại");
        btnBack.setFont(new Font("Arial", Font.PLAIN, 12));
        btnBack.setBackground(new Color(0, 102, 204));
        btnBack.setForeground(Color.WHITE);
        btnBack.setBounds(610, 560, 150, 33);
        imgDesktop.add(btnBack);

        btnConfirm = new JButton("Xác nhận");
        btnConfirm.setFont(new Font("Arial", Font.PLAIN, 12));
        btnConfirm.setBackground(new Color(0, 102, 204));
        btnConfirm.setForeground(Color.WHITE);
        btnConfirm.setBounds(440, 560, 150, 33);
        imgDesktop.add(btnConfirm);

        btnBack.addActionListener(e -> {
            dispose();
            new LoginView().setVisible(true);
        });

        btnConfirm.addActionListener(e -> {
            String username = userNameField.getText().trim();
            String email = emailField.getText().trim();
            String error = CheckAccount.checkForgotPassword("userinfos.xml", username, email);
            if (error != null) {
                lblInfo.setText(error);
                int width = lblInfo.getFontMetrics(lblInfo.getFont()).stringWidth(error);
                lblInfo.setBounds(600 - width / 2, 620, width, 30);
            } else {
                dispose();
                new PasswordView(username).setVisible(true);
            }
        });

        setContentPane(imgDesktop);
    }
}
