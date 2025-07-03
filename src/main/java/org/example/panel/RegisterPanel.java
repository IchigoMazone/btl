package org.example.panel;

import org.example.entity.UserInfo;
import org.example.action.CheckRegister;
import org.example.service.UserInfoService;

import javax.swing.*;
import java.awt.*;

public class RegisterPanel extends JPanel {
    private MainFrame mainFrame;
    private JTextField fullNameField, userNameField, emailField, phoneField;
    private JPasswordField passwordField, confirmPasswordField;
    private JLabel lblInfo;

    public RegisterPanel(MainFrame frame) {
        this.mainFrame = frame;
        initComponents();
    }

    private void initComponents() {
        setLayout(null);
        JLabel img = new JLabel(new ImageIcon("src/main/java/org/example/img/register.png"));
        img.setBounds(0,0,1200,800);
        img.setLayout(null);

        JLabel lblTitle = new JLabel("Đăng ký tài khoản");
        lblTitle.setFont(new Font("Arial", Font.BOLD, 18));
        lblTitle.setForeground(new Color(135, 206, 235));
        lblTitle.setBounds(500, 150, 250, 30);
        img.add(lblTitle);

        fullNameField = createField(img, "Nhập tên khách hàng", 255);
        userNameField = createField(img, "Nhập tên tài khoản", 315);
        passwordField = createPassword(img, "Nhập mật khẩu", 375);
        confirmPasswordField = createPassword(img, "Nhập lại mật khẩu", 435);
        emailField = createField(img, "Nhập email", 495);
        phoneField = createField(img, "Nhập số điện thoại", 555);

        lblInfo = new JLabel("");
        lblInfo.setForeground(Color.RED);
        lblInfo.setFont(new Font("Arial", Font.PLAIN, 13));
        img.add(lblInfo);

        JButton btnRegister = new JButton("Đăng ký");
        btnRegister.setBounds(440, 620, 320, 35);
        btnRegister.setBackground(new Color(131,198,159));
        btnRegister.setForeground(Color.WHITE);
        img.add(btnRegister);

        btnRegister.addActionListener(e -> handleRegister());

        add(img);
    }

    private JTextField createField(JLabel parent, String placeholder, int y) {
        JTextField tf = new JTextField();
        tf.setBounds(440, y, 320, 33);
        tf.putClientProperty("JTextField.placeholderText", placeholder);
        parent.add(tf);
        return tf;
    }

    private JPasswordField createPassword(JLabel parent, String placeholder, int y) {
        JPasswordField pf = new JPasswordField();
        pf.setBounds(440, y, 320, 33);
        pf.putClientProperty("JTextField.placeholderText", placeholder);
        parent.add(pf);
        return pf;
    }

    private void handleRegister() {
        UserInfo info = new UserInfo(
                fullNameField.getText().trim(),
                userNameField.getText().trim(),
                String.valueOf(passwordField.getPassword()).trim(),
                emailField.getText().trim(),
                phoneField.getText().trim()
        );
        String confirm = String.valueOf(confirmPasswordField.getPassword()).trim();

        String error = CheckRegister.checkRegis(
                info.getFullName(),
                info.getUserName(),
                info.getPassword(),
                info.getEmail(),
                info.getPhoneNumber(),
                confirm
        );

        if (error != null) {
            lblInfo.setText(error);
            int w = lblInfo.getFontMetrics(lblInfo.getFont()).stringWidth(error);
            lblInfo.setBounds(600 - w/2, 580, w, 28);
        } else {
            UserInfoService.saveUser(info, "userinfos.xml");
            mainFrame.showPanel("registerFinish");
        }
    }
}
