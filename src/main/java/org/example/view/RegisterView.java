package org.example.view;
import org.example.controller.RegisterController;
import org.example.entity.UserInfo;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import java.awt.Font;
import java.awt.Color;

public class RegisterView extends JFrame {
    private JLabel imgDesktop;
    private JLabel lblTitle;
    private JTextField fullNameField;
    private JTextField userNameField;
    private JPasswordField passwordField;
    private JTextField emailField;
    private JTextField phoneField;
    private JPasswordField comfirmPasswordField;
    private JLabel lblInfor;
    private JButton btnRegister;

    public RegisterView() {
        initComponents();
        btnRegister.addActionListener(e -> RegisterController.handleRegister(this));
    }

    private void initComponents() {
        setTitle("Đăng ký tài khoản");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1200, 800);
        setResizable(false);
        setLocationRelativeTo(null);

        imgDesktop = new JLabel(new ImageIcon("src/main/java/org/example/img/register.png"));
        imgDesktop.setLayout(null);
        imgDesktop.setBounds(0, 0, 1200, 800);

        lblTitle = new JLabel("Đăng ký tài khoản");
        lblTitle.setFont(new Font("Arial", Font.BOLD, 16));
        lblTitle.setForeground(new Color(0, 200, 0));
        int widthTitle = lblTitle.getFontMetrics(lblTitle.getFont()).stringWidth(lblTitle.getText());
        lblTitle.setBounds(600 - widthTitle / 2, 170, widthTitle, 30);
        imgDesktop.add(lblTitle);

        fullNameField = new JTextField();
        fullNameField.setFont(new Font("Arial", Font.PLAIN, 12));
        fullNameField.setBounds(440, 255, 320, 33);
        fullNameField.putClientProperty("JTextField.placeholderText", "Nhập tên khách hàng");
        imgDesktop.add(fullNameField);

        userNameField = new JTextField();
        userNameField.setFont(new Font("Arial", Font.PLAIN, 12));
        userNameField.setBounds(440, 315, 320, 33);
        userNameField.putClientProperty("JTextField.placeholderText", "Nhập tên tài khoản");
        imgDesktop.add(userNameField);

        passwordField = new JPasswordField();
        passwordField.setFont(new Font("Arial", Font.PLAIN, 12));
        passwordField.setBounds(440, 375, 320, 33);
        passwordField.putClientProperty("JTextField.placeholderText", "Nhập mật khẩu");
        imgDesktop.add(passwordField);

        emailField = new JTextField();
        emailField.setFont(new Font("Arial", Font.PLAIN, 12));
        emailField.setBounds(440, 435, 320, 33);
        emailField.putClientProperty("JTextField.placeholderText", "Nhập email");
        imgDesktop.add(emailField);

        phoneField = new JTextField();
        phoneField.setFont(new Font("Arial", Font.PLAIN, 12));
        phoneField.setBounds(440, 495, 320, 33);
        phoneField.putClientProperty("JTextField.placeholderText", "Nhập số điện thoại");
        imgDesktop.add(phoneField);

        comfirmPasswordField = new JPasswordField();
        comfirmPasswordField.setFont(new Font("Arial", Font.PLAIN, 12));
        comfirmPasswordField.setBounds(440, 555, 320, 33);
        comfirmPasswordField.putClientProperty("JTextField.placeholderText", "Nhập lại mật khẩu");
        imgDesktop.add(comfirmPasswordField);

        lblInfor = new JLabel("");
        lblInfor.setFont(new Font("Arial", Font.PLAIN, 12));
        imgDesktop.add(lblInfor);

        btnRegister = new JButton("Đăng ký");
        btnRegister.setFont(new Font("Arial", Font.BOLD, 12));
        btnRegister.setBounds(440, 655, 320, 33);
        imgDesktop.add(btnRegister);

        setContentPane(imgDesktop);
    }

    public UserInfo getUserInfo() {
        String fullName = fullNameField.getText().trim();
        String username = userNameField.getText().trim();
        String password = String.valueOf(passwordField.getPassword()).trim();
        String email = emailField.getText().trim();
        String phone = phoneField.getText().trim();
        return new UserInfo(fullName, username, password, email, phone);
    }

    public void showError(String message) {
        lblInfor.setText(message);
        int width = lblInfor.getFontMetrics(lblInfor.getFont()).stringWidth(message);
        lblInfor.setBounds(600 - width / 2, 605, width, 28);
    }

    public String getConfirmPassword() {
        return String.valueOf(comfirmPasswordField.getPassword()).trim();
    }
}




