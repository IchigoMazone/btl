package org.example.view;
import org.example.action.CheckAccount;
import org.example.entity.UserInfo;
import org.example.service.UserInfoService;

import javax.swing.*;
import java.awt.*;

public class PasswordView extends JFrame {
    private JPasswordField passwordField;
    private JPasswordField confirmPasswordField;
    private JLabel lblInfo;
    private JButton btnConfirm;
    private JLabel imgDesktop;
    private String username;

    public PasswordView(String username) {
        this.username = username;

        setTitle("Đặt lại mật khẩu");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1200, 800);
        setResizable(false);
        setLocationRelativeTo(null);

        imgDesktop = new JLabel(new ImageIcon("src/main/java/org/example/img/password.png"));
        imgDesktop.setLayout(null);
        imgDesktop.setBounds(0, 0, 1200, 800);

        JLabel lblTitle = new JLabel("Tạo mật khẩu mới");
        lblTitle.setFont(new Font("Arial", Font.BOLD, 22));
        lblTitle.setForeground(new Color(135, 206, 235));
        lblTitle.setBounds(500, 370, 250, 30);
        imgDesktop.add(lblTitle);

        passwordField = new JPasswordField();
        passwordField.setFont(new Font("Arial", Font.PLAIN, 14));
        passwordField.setBounds(440, 430, 320, 33);
        passwordField.putClientProperty("JTextField.placeholderText", "Mật khẩu mới");
        imgDesktop.add(passwordField);

        confirmPasswordField = new JPasswordField();
        confirmPasswordField.setFont(new Font("Arial", Font.PLAIN, 14));
        confirmPasswordField.setBounds(440, 490, 320, 33);
        confirmPasswordField.putClientProperty("JTextField.placeholderText", "Xác nhận mật khẩu");
        imgDesktop.add(confirmPasswordField);

        lblInfo = new JLabel("", SwingConstants.CENTER);
        lblInfo.setForeground(Color.WHITE);
        lblInfo.setFont(new Font("Arial", Font.PLAIN, 13));
        imgDesktop.add(lblInfo);

        btnConfirm = new JButton("Xác nhận");
        btnConfirm.setFont(new Font("Arial", Font.PLAIN, 12));
        btnConfirm.setBackground(new Color(255, 105, 180));
        btnConfirm.setForeground(Color.WHITE);
        btnConfirm.setBounds(440, 560, 320, 33);
        imgDesktop.add(btnConfirm);

        btnConfirm.addActionListener(e -> {
            String password = String.valueOf(passwordField.getPassword()).trim();
            String confirmPassword = String.valueOf(confirmPasswordField.getPassword()).trim();

//            UserInfo tempUser = new UserInfo();
//            tempUser.setUserName(username);

            String error = CheckAccount.validateNewPassword(password, confirmPassword);
            if (error != null) {
                lblInfo.setText(error);
                int width = lblInfo.getFontMetrics(lblInfo.getFont()).stringWidth(error);
                lblInfo.setBounds(600 - width / 2, 620, width, 30);
            } else {
                UserInfoService.updatePassword("userinfos.xml", username, password);
                dispose();
                new RegisterFinishView().setVisible(true);
            }
        });

        setContentPane(imgDesktop);
    }
}
