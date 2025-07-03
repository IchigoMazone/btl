//package org.example.views;
//
//import javax.swing.*;
//import java.awt.*;
//
//public class PasswordResetPanel extends JPanel {
//    private MainFrame mainFrame;
//    private String username;
//
//    private JPasswordField passwordField;
//    private JPasswordField confirmPasswordField;
//    private JButton btnConfirm;
//    private JButton btnBack;
//    private JLabel lblInfo;
//
//    public PasswordResetPanel(MainFrame mainFrame) {
//        this.mainFrame = mainFrame;
//        setLayout(null);
//        initComponents();
//    }
//
//    public void setUsername(String username) {
//        this.username = username;
//        lblInfo.setText("");
//        passwordField.setText("");
//        confirmPasswordField.setText("");
//    }
//
//    private void initComponents() {
//        JLabel title = new JLabel("Đặt lại mật khẩu");
//        title.setFont(new Font("Arial", Font.BOLD, 22));
//        title.setBounds(460, 100, 300, 30);
//        add(title);
//
//        passwordField = new JPasswordField();
//        passwordField.setBounds(400, 150, 350, 30);
//        passwordField.putClientProperty("JTextField.placeholderText", "Mật khẩu mới");
//        add(passwordField);
//
//        confirmPasswordField = new JPasswordField();
//        confirmPasswordField.setBounds(400, 190, 350, 30);
//        confirmPasswordField.putClientProperty("JTextField.placeholderText", "Xác nhận mật khẩu");
//        add(confirmPasswordField);
//
//        btnConfirm = new JButton("Xác nhận");
//        btnConfirm.setBounds(400, 230, 350, 30);
//        add(btnConfirm);
//
//        btnBack = new JButton("Quay lại");
//        btnBack.setBounds(400, 270, 350, 30);
//        add(btnBack);
//
//        lblInfo = new JLabel("", SwingConstants.CENTER);
//        lblInfo.setForeground(Color.RED);
//        lblInfo.setBounds(400, 310, 350, 30);
//        add(lblInfo);
//
//        btnConfirm.addActionListener(e -> confirmAction());
//        btnBack.addActionListener(e -> mainFrame.showLoginPanel());
//    }
//
//    private void confirmAction() {
//        String password = new String(passwordField.getPassword()).trim();
//        String confirmPassword = new String(confirmPasswordField.getPassword()).trim();
//
//        if (password.isEmpty() || confirmPassword.isEmpty()) {
//            lblInfo.setText("Vui lòng nhập đầy đủ thông tin!");
//            return;
//        }
//
//        if (!password.equals(confirmPassword)) {
//            lblInfo.setText("Mật khẩu xác nhận không đúng!");
//            return;
//        }
//
//        // TODO: cập nhật mật khẩu cho user username
//
//        lblInfo.setText("");
//        JOptionPane.showMessageDialog(this, "Đặt lại mật khẩu thành công!");
//        mainFrame.showLoginPanel();
//    }
//}

package org.example.views;

import org.example.action.CheckAccount;
import org.example.service.UserInfoService;

import javax.swing.*;
import java.awt.*;

public class PasswordResetPanel extends JPanel {
    private MainFrame mainFrame;
    private String username;

    private JPasswordField passwordField;
    private JPasswordField confirmPasswordField;
    private JLabel lblInfo;
    private JButton btnConfirm;
    private JLabel background;

    public PasswordResetPanel(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
        setLayout(null);
        initComponents();
    }

    private void initComponents() {
        background = new JLabel(new ImageIcon("src/main/java/org/example/img/password.png"));
        background.setLayout(null);
        background.setBounds(0, 0, 1200, 800);
        add(background);

        JLabel lblTitle = new JLabel("Tạo mật khẩu mới");
        lblTitle.setFont(new Font("Arial", Font.BOLD, 22));
        lblTitle.setForeground(new Color(135, 206, 235));
        lblTitle.setBounds(500, 380, 250, 30);
        background.add(lblTitle);

        passwordField = new JPasswordField();
        passwordField.setFont(new Font("Arial", Font.PLAIN, 14));
        passwordField.setBounds(440, 440, 320, 33);
        passwordField.putClientProperty("JTextField.placeholderText", "Mật khẩu mới");
        background.add(passwordField);

        confirmPasswordField = new JPasswordField();
        confirmPasswordField.setFont(new Font("Arial", Font.PLAIN, 14));
        confirmPasswordField.setBounds(440, 500, 320, 33);
        confirmPasswordField.putClientProperty("JTextField.placeholderText", "Xác nhận mật khẩu");
        background.add(confirmPasswordField);

        lblInfo = new JLabel("", SwingConstants.CENTER);
        lblInfo.setForeground(Color.WHITE);
        lblInfo.setFont(new Font("Arial", Font.PLAIN, 13));
        background.add(lblInfo);

        btnConfirm = new JButton("Xác nhận");
        btnConfirm.setFont(new Font("Arial", Font.PLAIN, 12));
        btnConfirm.setBackground(new Color(255, 105, 180));
        btnConfirm.setForeground(Color.WHITE);
        btnConfirm.setBounds(440, 570, 320, 33);
        background.add(btnConfirm);

        btnConfirm.addActionListener(e -> confirmAction());
    }

    public void setUsername(String username) {
        this.username = username;
    }

    private void confirmAction() {
        String password = String.valueOf(passwordField.getPassword()).trim();
        String confirmPassword = String.valueOf(confirmPasswordField.getPassword()).trim();

        String error = CheckAccount.validateNewPassword(password, confirmPassword);
        if (error != null) {
            showError(error);
        } else {
            UserInfoService.updatePassword("userinfos.xml", username, password);
            clearFields();
            clearError();
            mainFrame.showRegisterFinishPanel();
        }
    }

    private void showError(String message) {
        lblInfo.setText(message);
        int width = lblInfo.getFontMetrics(lblInfo.getFont()).stringWidth(message);
        lblInfo.setBounds(600 - width / 2, 630, width, 30);
    }

    private void clearError() {
        lblInfo.setText("");
    }

    private void clearFields() {
        passwordField.setText("");
        confirmPasswordField.setText("");
    }

    public void resetForm() {
        passwordField.setText("");
        confirmPasswordField.setText("");
        lblInfo.setText("");
    }
}
