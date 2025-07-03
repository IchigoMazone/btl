//package org.example.views;
//
//import javax.swing.*;
//import java.awt.*;
//
//public class RegisterFinishPanel extends JPanel {
//    private MainFrame mainFrame;
//
//    private JLabel lblMessage;
//    private JButton btnLogin;
//
//    public RegisterFinishPanel(MainFrame mainFrame) {
//        this.mainFrame = mainFrame;
//        setLayout(null);
//        initComponents();
//    }
//
//    private void initComponents() {
//        lblMessage = new JLabel("Đăng ký thành công!", SwingConstants.CENTER);
//        lblMessage.setFont(new Font("Arial", Font.BOLD, 22));
//        lblMessage.setBounds(400, 200, 350, 40);
//        add(lblMessage);
//
//        btnLogin = new JButton("Đăng nhập ngay");
//        btnLogin.setBounds(475, 260, 200, 35);
//        add(btnLogin);
//
//        btnLogin.addActionListener(e -> mainFrame.showLoginPanel());
//    }
//}

package org.example.views;

import javax.swing.*;
import java.awt.*;

public class RegisterFinishPanel extends JPanel {
    private MainFrame mainFrame;
    private JButton btnLogin;
    private JLabel background;

    public RegisterFinishPanel(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
        setLayout(null);
        initComponents();
    }

    private void initComponents() {
        background = new JLabel(new ImageIcon("src/main/java/org/example/img/registerfinish.png"));
        background.setLayout(null);
        background.setBounds(0, 0, 1200, 800);
        add(background);

        btnLogin = new JButton("Đăng nhập ngay");
        btnLogin.setFont(new Font("Arial", Font.BOLD, 12));
        btnLogin.setBackground(new Color(46, 204, 113));
        btnLogin.setForeground(new Color(240, 240, 240));
        btnLogin.setBounds(475, 685, 250, 33);
        background.add(btnLogin);

        btnLogin.addActionListener(e -> openLogin());
    }

    private void openLogin() {
        // Đóng panel hiện tại, chuyển về panel đăng nhập trong MainFrame
        mainFrame.showLoginPanel();
    }
}

