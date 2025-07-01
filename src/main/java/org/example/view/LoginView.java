package org.example.view;
import org.example.entity.User;
import org.example.controller.LoginController;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JFrame;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Color;

public class LoginView extends JFrame {
    private JLabel imgDesktop;
    private JLabel lblTitle;
    private JTextField userNameField;
    private JPasswordField passwordField;
    private JButton btnLogin;
    private JButton btnRegister;
    private JLabel lblInfor;

    public LoginView() {
        initComponents();
        btnLogin.addActionListener(e -> LoginController.handleLogin(this));
        btnRegister.addActionListener(e -> LoginController.openRegister(this));
    }

    private void initComponents() {
        setTitle("Đăng nhập");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1200, 800);
        setResizable(false);
        setLocationRelativeTo(null);

        imgDesktop = new JLabel(new ImageIcon("src/main/java/org/example/img/login.png"));
        imgDesktop.setLayout(null);
        imgDesktop.setBounds(0,0,1200,800);

        lblTitle = new JLabel("Đăng nhập hệ thống");
        lblTitle.setFont(new Font("Arial", Font.BOLD, 20));
        lblTitle.setForeground(new Color(240,240,240));
        lblTitle.setBounds(500, 400, 300, 30);
        imgDesktop.add(lblTitle);

        lblInfor = new JLabel("");
        lblInfor.setFont(new Font("Arial", Font.BOLD, 15));
        lblInfor.setForeground(new Color(30, 144, 255));
        imgDesktop.add(lblInfor);

        userNameField = new JTextField();
        userNameField.setFont(new Font("Arial", Font.PLAIN, 14));
        userNameField.setBounds(440, 460, 320, 33);
        userNameField.putClientProperty("JTextField.placeholderText", "Nhập tên đăng nhập");
        imgDesktop.add(userNameField);

        passwordField = new JPasswordField();
        passwordField.setFont(new Font("Arial", Font.PLAIN, 14));
        passwordField.setBounds(440, 520, 320, 33);
        passwordField.putClientProperty("JTextField.placeholderText", "Nhập mật khẩu");
        imgDesktop.add(passwordField);

        btnLogin = new JButton("Đăng nhập");
        btnLogin.setFont(new Font("Arial", Font.BOLD, 12));
        btnLogin.setBackground(new Color(46, 204, 113));
        btnLogin.setForeground(new Color(240,240,240));
        btnLogin.setBounds(440, 580, 150, 33);
        imgDesktop.add(btnLogin);

        btnRegister = new JButton("Đăng ký");
        btnRegister.setFont(new Font("Arial", Font.BOLD, 12));
        btnRegister.setBounds(610, 580, 150, 33);
        btnRegister.setBackground(new Color(46, 204, 113));
        btnRegister.setForeground(new Color(240,240,240));
        imgDesktop.add(btnRegister);

        setContentPane(imgDesktop);
    }

    public User getUser() {
        return new User(
                userNameField.getText().trim(),
                String.valueOf(passwordField.getPassword()).trim()
        );
    }

    public void showError(String message) {
        lblInfor.setText(message);
        int width = lblInfor.getFontMetrics(lblInfor.getFont()).stringWidth(message);
        lblInfor.setBounds(600 - width / 2, 670, width, 30);
    }
}
