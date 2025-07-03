//package org.example.views;
//
//import javax.swing.*;
//import java.awt.*;
//
//public class RegisterPanel extends JPanel {
//    private MainFrame mainFrame;
//
//    private JTextField fullNameField;
//    private JTextField userNameField;
//    private JPasswordField passwordField;
//    private JPasswordField confirmPasswordField;
//    private JButton btnRegister;
//    private JButton btnBack;
//    private JLabel lblInfo;
//
//    public RegisterPanel(MainFrame mainFrame) {
//        this.mainFrame = mainFrame;
//        setLayout(null);
//        initComponents();
//    }
//
//    private void initComponents() {
//        JLabel title = new JLabel("Đăng ký tài khoản");
//        title.setFont(new Font("Arial", Font.BOLD, 22));
//        title.setBounds(460, 50, 300, 30);
//        add(title);
//
//        fullNameField = new JTextField();
//        fullNameField.setBounds(400, 100, 350, 30);
//        fullNameField.putClientProperty("JTextField.placeholderText", "Họ tên");
//        add(fullNameField);
//
//        userNameField = new JTextField();
//        userNameField.setBounds(400, 140, 350, 30);
//        userNameField.putClientProperty("JTextField.placeholderText", "Tên đăng nhập");
//        add(userNameField);
//
//        passwordField = new JPasswordField();
//        passwordField.setBounds(400, 180, 350, 30);
//        passwordField.putClientProperty("JTextField.placeholderText", "Mật khẩu");
//        add(passwordField);
//
//        confirmPasswordField = new JPasswordField();
//        confirmPasswordField.setBounds(400, 220, 350, 30);
//        confirmPasswordField.putClientProperty("JTextField.placeholderText", "Xác nhận mật khẩu");
//        add(confirmPasswordField);
//
//        btnRegister = new JButton("Đăng ký");
//        btnRegister.setBounds(400, 270, 350, 30);
//        add(btnRegister);
//
//        btnBack = new JButton("Quay lại");
//        btnBack.setBounds(400, 310, 350, 30);
//        add(btnBack);
//
//        lblInfo = new JLabel("", SwingConstants.CENTER);
//        lblInfo.setForeground(Color.RED);
//        lblInfo.setBounds(400, 350, 350, 30);
//        add(lblInfo);
//
//        btnRegister.addActionListener(e -> registerAction());
//        btnBack.addActionListener(e -> mainFrame.showLoginPanel());
//    }
//
//    private void registerAction() {
//        String fullName = fullNameField.getText().trim();
//        String username = userNameField.getText().trim();
//        String password = new String(passwordField.getPassword()).trim();
//        String confirmPassword = new String(confirmPasswordField.getPassword()).trim();
//
//        if (fullName.isEmpty() || username.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
//            lblInfo.setText("Vui lòng nhập đầy đủ thông tin!");
//            return;
//        }
//
//        if (!password.equals(confirmPassword)) {
//            lblInfo.setText("Mật khẩu xác nhận không đúng!");
//            return;
//        }
//
//        // TODO: xử lý đăng ký tài khoản (lưu vào DB, file,...)
//
//        lblInfo.setText("");
//        mainFrame.showRegisterFinishPanel();
//    }
//}

package org.example.views;

import org.example.entity.UserInfo;

import javax.swing.*;
import java.awt.*;

public class RegisterPanel extends JPanel {
    private final MainFrame mainFrame;

    private JTextField fullNameField;
    private JTextField userNameField;
    private JPasswordField passwordField;
    private JPasswordField confirmPasswordField;
    private JTextField emailField;
    private JTextField phoneField;
    private JLabel lblInfor;
    private JButton btnRegister;
    private JButton btnBack;

    public RegisterPanel(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
        setLayout(null);
        initComponents();

        btnRegister.addActionListener(e -> RegisterController.handleRegister(this));
        btnBack.addActionListener(e -> mainFrame.showLoginPanel());
    }

    private void initComponents() {
        JLabel imgBackground = new JLabel(new ImageIcon("src/main/java/org/example/img/register.png"));
        imgBackground.setLayout(null);
        imgBackground.setBounds(0, 0, 1200, 800);
        this.add(imgBackground);

        JLabel lblTitle = new JLabel("Đăng ký tài khoản");
        lblTitle.setFont(new Font("Arial", Font.BOLD, 16));
        lblTitle.setForeground(new Color(135, 206, 235));
        int widthTitle = lblTitle.getFontMetrics(lblTitle.getFont()).stringWidth(lblTitle.getText());
        lblTitle.setBounds(600 - widthTitle / 2, 170, widthTitle, 30);
        imgBackground.add(lblTitle);

        fullNameField = new JTextField();
        fullNameField.setFont(new Font("Arial", Font.PLAIN, 12));
        fullNameField.setBounds(440, 255, 320, 33);
        fullNameField.putClientProperty("JTextField.placeholderText", "Nhập tên khách hàng");
        imgBackground.add(fullNameField);

        userNameField = new JTextField();
        userNameField.setFont(new Font("Arial", Font.PLAIN, 12));
        userNameField.setBounds(440, 315, 320, 33);
        userNameField.putClientProperty("JTextField.placeholderText", "Nhập tên tài khoản");
        imgBackground.add(userNameField);

        passwordField = new JPasswordField();
        passwordField.setFont(new Font("Arial", Font.PLAIN, 12));
        passwordField.setBounds(440, 375, 320, 33);
        passwordField.putClientProperty("JTextField.placeholderText", "Nhập mật khẩu");
        imgBackground.add(passwordField);

        emailField = new JTextField();
        emailField.setFont(new Font("Arial", Font.PLAIN, 12));
        emailField.setBounds(440, 435, 320, 33);
        emailField.putClientProperty("JTextField.placeholderText", "Nhập email");
        imgBackground.add(emailField);

        phoneField = new JTextField();
        phoneField.setFont(new Font("Arial", Font.PLAIN, 12));
        phoneField.setBounds(440, 495, 320, 33);
        phoneField.putClientProperty("JTextField.placeholderText", "Nhập số điện thoại");
        imgBackground.add(phoneField);

        confirmPasswordField = new JPasswordField();
        confirmPasswordField.setFont(new Font("Arial", Font.PLAIN, 12));
        confirmPasswordField.setBounds(440, 555, 320, 33);
        confirmPasswordField.putClientProperty("JTextField.placeholderText", "Nhập lại mật khẩu");
        imgBackground.add(confirmPasswordField);

        lblInfor = new JLabel("");
        lblInfor.setFont(new Font("Arial", Font.PLAIN, 12));
        lblInfor.setForeground(new Color(255, 112, 67));
        imgBackground.add(lblInfor);

        btnRegister = new JButton("Đăng ký");
        btnRegister.setFont(new Font("Arial", Font.PLAIN, 12));
        btnRegister.setForeground(Color.WHITE);
        btnRegister.setBackground(new Color(131, 198, 159));
        btnRegister.setBounds(440, 655, 320, 33);
        imgBackground.add(btnRegister);

        btnBack = new JButton("Quay lại");
        btnBack.setFont(new Font("Arial", Font.PLAIN, 12));
        btnBack.setBounds(440, 695, 320, 30);

        btnBack.setContentAreaFilled(false);
        btnBack.setBorderPainted(false);
        btnBack.setFocusPainted(false);

        btnBack.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnBack.setForeground(new Color(169, 169, 169)); // màu hồng khi hover
            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnBack.setForeground(new Color(0, 102, 204)); // màu xanh lại khi rời chuột
            }
        });

        imgBackground.add(btnBack);
    }

    // Lấy thông tin đăng ký
    public UserInfo getUserInfo() {
        return new UserInfo(
                fullNameField.getText().trim(),
                userNameField.getText().trim(),
                String.valueOf(passwordField.getPassword()).trim(),
                emailField.getText().trim(),
                phoneField.getText().trim()
        );
    }

    public String getConfirmPassword() {
        return String.valueOf(confirmPasswordField.getPassword()).trim();
    }

    public void showError(String message) {
        lblInfor.setText(message);
        int width = lblInfor.getFontMetrics(lblInfor.getFont()).stringWidth(message);
        lblInfor.setBounds(600 - width / 2, 605, width, 28);
    }

    public void resetForm() {
        fullNameField.setText("");
        userNameField.setText("");
        passwordField.setText("");
        emailField.setText("");
        phoneField.setText("");
        confirmPasswordField.setText("");
        lblInfor.setText("");
    }

    // -------------------------------
    // Controller nội bộ
    // -------------------------------
    public static class RegisterController {

        public static void handleRegister(RegisterPanel view) {
            UserInfo info = view.getUserInfo();
            String confirmPass = view.getConfirmPassword();

            if (info.getFullName().isEmpty() || info.getUserName().isEmpty() ||
                    info.getPassword().isEmpty() || confirmPass.isEmpty() ||
                    info.getEmail().isEmpty() || info.getPhoneNumber().isEmpty()) {

                view.showError("Vui lòng điền đầy đủ thông tin!");
                return;
            }

            if (!info.getPassword().equals(confirmPass)) {
                view.showError("Mật khẩu xác nhận không khớp!");
                return;
            }

            // TODO: xử lý lưu thông tin người dùng (DB, file, v.v.)

            view.showError(""); // Xóa lỗi nếu có
            view.mainFrame.showRegisterFinishPanel();
        }
    }
}
