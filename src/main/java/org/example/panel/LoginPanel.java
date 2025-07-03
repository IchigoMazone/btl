package org.example.panel;

import org.example.entity.User;
import org.example.action.CheckLogin;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class LoginPanel extends JPanel {
    private MainFrame mainFrame;
    private JTextField userNameField;
    private JPasswordField passwordField;
    private JLabel lblInfor;

    public LoginPanel(MainFrame frame) {
        this.mainFrame = frame;
        initComponents();
    }

    private void initComponents() {
        setLayout(null);
        JLabel imgDesktop = new JLabel(new ImageIcon("src/main/java/org/example/img/login.png"));
        imgDesktop.setBounds(0, 0, 1200, 800);
        imgDesktop.setLayout(null);

        JLabel lblTitle = new JLabel("Đăng nhập hệ thống");
        lblTitle.setFont(new Font("Arial", Font.BOLD, 22));
        lblTitle.setForeground(new Color(135, 206, 235));
        lblTitle.setBounds(495, 370, 250, 30);
        imgDesktop.add(lblTitle);

        lblInfor = new JLabel("");
        lblInfor.setFont(new Font("Arial", Font.PLAIN, 13));
        lblInfor.setForeground(Color.WHITE);
        imgDesktop.add(lblInfor);

        userNameField = new JTextField();
        userNameField.setFont(new Font("Arial", Font.PLAIN, 14));
        userNameField.setBounds(440, 430, 320, 33);
        imgDesktop.add(userNameField);

        passwordField = new JPasswordField();
        passwordField.setFont(new Font("Arial", Font.PLAIN, 14));
        passwordField.setBounds(440, 490, 320, 33);
        imgDesktop.add(passwordField);

        JButton btnLogin = new JButton("Đăng nhập");
        btnLogin.setBounds(440, 560, 320, 33);
        btnLogin.setBackground(new Color(46, 204, 113));
        btnLogin.setForeground(Color.WHITE);
        imgDesktop.add(btnLogin);

        JButton btnRegister = new JButton("Đăng ký tài khoản");
        btnRegister.setBounds(600, 618, 150, 28);
        btnRegister.setContentAreaFilled(false);
        btnRegister.setBorderPainted(false);
        btnRegister.setFocusPainted(false);
        btnRegister.setForeground(Color.WHITE);
        addHoverEffect(btnRegister);
        imgDesktop.add(btnRegister);

        JButton btnForgot = new JButton("Quên mật khẩu?");
        btnForgot.setBounds(450, 618, 150, 28);
        btnForgot.setContentAreaFilled(false);
        btnForgot.setBorderPainted(false);
        btnForgot.setFocusPainted(false);
        btnForgot.setForeground(Color.WHITE);
        addHoverEffect(btnForgot);
        imgDesktop.add(btnForgot);

        btnLogin.addActionListener(e -> handleLogin());
        btnRegister.addActionListener(e -> mainFrame.showPanel("register"));
        btnForgot.addActionListener(e -> mainFrame.showPanel("account"));

        add(imgDesktop);
    }

    private void addHoverEffect(JButton button) {
        Color normal = button.getForeground();
        Color hover = new Color(52, 152, 219);
        button.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {button.setForeground(hover);}
            public void mouseExited(MouseEvent e) {button.setForeground(normal);}
        });
    }

    private void handleLogin() {
        String username = userNameField.getText().trim();
        String password = String.valueOf(passwordField.getPassword()).trim();
        String error = CheckLogin.checkUser("userinfos.xml", username, password);

        if (username.equals("admin") && password.equals("123456")) {
            mainFrame.showPanel("admin");
        } else if (error != null) {
            lblInfor.setText(error);
            int width = lblInfor.getFontMetrics(lblInfor.getFont()).stringWidth(error);
            lblInfor.setBounds(600 - width / 2, 670, width, 30);
        } else {
            mainFrame.showPanel("user");
        }
    }
}
