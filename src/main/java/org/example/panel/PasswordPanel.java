package org.example.panel;

import org.example.action.CheckAccount;
import org.example.service.UserInfoService;

import javax.swing.*;
import java.awt.*;

public class PasswordPanel extends JPanel {
    private MainFrame mainFrame;
    private String username;
    private JPasswordField passwordField, confirmPasswordField;
    private JLabel lblInfo;

    public PasswordPanel(MainFrame frame, String username) {
        this.mainFrame = frame;
        this.username = username;
        initComponents();
    }

    private void initComponents() {
        setLayout(null);
        JLabel img = new JLabel(new ImageIcon("src/main/java/org/example/img/password.png"));
        img.setBounds(0,0,1200,800);
        img.setLayout(null);

        JLabel lblTitle = new JLabel("Tạo mật khẩu mới");
        lblTitle.setBounds(500,370,250,30);
        lblTitle.setFont(new Font("Arial", Font.BOLD,22));
        lblTitle.setForeground(new Color(135,206,235));
        img.add(lblTitle);

        passwordField = new JPasswordField();
        passwordField.setBounds(440,430,320,33);
        img.add(passwordField);

        confirmPasswordField = new JPasswordField();
        confirmPasswordField.setBounds(440,490,320,33);
        img.add(confirmPasswordField);

        lblInfo = new JLabel("", SwingConstants.CENTER);
        lblInfo.setForeground(Color.WHITE);
        img.add(lblInfo);

        JButton btnConfirm = new JButton("Xác nhận");
        btnConfirm.setBounds(440,560,320,33);
        btnConfirm.setBackground(new Color(255,105,180));
        btnConfirm.setForeground(Color.WHITE);
        img.add(btnConfirm);

        btnConfirm.addActionListener(e -> handleConfirm());

        add(img);
    }

    private void handleConfirm() {
        String pw = String.valueOf(passwordField.getPassword()).trim();
        String confirm = String.valueOf(confirmPasswordField.getPassword()).trim();

        String error = CheckAccount.validateNewPassword(pw, confirm);
        if (error != null) {
            lblInfo.setText(error);
            int w = lblInfo.getFontMetrics(lblInfo.getFont()).stringWidth(error);
            lblInfo.setBounds(600 - w/2,620,w,30);
        } else {
            UserInfoService.updatePassword("userinfos.xml", username, pw);
            mainFrame.showPanel("registerFinish");
        }
    }
}
