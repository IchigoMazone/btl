package org.example.panel;

import org.example.action.CheckAccount;

import javax.swing.*;
import java.awt.*;

public class AccountPanel extends JPanel {
    private MainFrame mainFrame;
    private JTextField userNameField, emailField;
    private JLabel lblInfo;

    public AccountPanel(MainFrame frame) {
        this.mainFrame = frame;
        initComponents();
    }

    private void initComponents() {
        setLayout(null);
        JLabel img = new JLabel(new ImageIcon("src/main/java/org/example/img/account.png"));
        img.setBounds(0,0,1200,800);
        img.setLayout(null);

        JLabel lblTitle = new JLabel("Xác minh tài khoản");
        lblTitle.setBounds(500,370,220,30);
        lblTitle.setFont(new Font("Arial", Font.BOLD,22));
        lblTitle.setForeground(new Color(135,206,235));
        img.add(lblTitle);

        userNameField = new JTextField();
        userNameField.setBounds(440,430,320,33);
        img.add(userNameField);

        emailField = new JTextField();
        emailField.setBounds(440,490,320,33);
        img.add(emailField);

        lblInfo = new JLabel("",SwingConstants.CENTER);
        lblInfo.setForeground(Color.WHITE);
        img.add(lblInfo);

        JButton btnBack = new JButton("Quay lại");
        btnBack.setBounds(610,560,150,33);
        btnBack.setBackground(new Color(0,102,204));
        btnBack.setForeground(Color.WHITE);
        img.add(btnBack);

        JButton btnConfirm = new JButton("Xác nhận");
        btnConfirm.setBounds(440,560,150,33);
        btnConfirm.setBackground(new Color(0,102,204));
        btnConfirm.setForeground(Color.WHITE);
        img.add(btnConfirm);

        btnBack.addActionListener(e -> mainFrame.showPanel("login"));
        btnConfirm.addActionListener(e -> handleConfirm());

        add(img);
    }

    private void handleConfirm() {
        String username = userNameField.getText().trim();
        String email = emailField.getText().trim();
        String error = CheckAccount.checkForgotPassword("userinfos.xml", username, email);
        if (error != null) {
            lblInfo.setText(error);
            int w = lblInfo.getFontMetrics(lblInfo.getFont()).stringWidth(error);
            lblInfo.setBounds(600 - w/2,620,w,30);
        } else {
            mainFrame.getPasswordPanel(username);
            mainFrame.showPanel("password");
        }
    }
}
