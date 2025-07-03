//package org.example.views;
//
//import javax.swing.*;
//import java.awt.*;
//
//public class LoginPanel extends JPanel {
//    private MainFrame mainFrame;
//
//    private JTextField userNameField;
//    private JPasswordField passwordField;
//    private JButton btnLogin;
//    private JButton btnRegister;
//    private JButton btnForgotPassword;
//    private JLabel lblInfo;
//
//    public LoginPanel(MainFrame mainFrame) {
//        this.mainFrame = mainFrame;
//        setLayout(null);
//        initComponents();
//    }
//
//    private void initComponents() {
//        JLabel title = new JLabel("Đăng nhập hệ thống");
//        title.setFont(new Font("Arial", Font.BOLD, 22));
//        title.setBounds(460, 100, 300, 30);
//        add(title);
//
//        userNameField = new JTextField();
//        userNameField.setBounds(400, 160, 350, 30);
//        userNameField.putClientProperty("JTextField.placeholderText", "Tên đăng nhập");
//        add(userNameField);
//
//        passwordField = new JPasswordField();
//        passwordField.setBounds(400, 210, 350, 30);
//        passwordField.putClientProperty("JTextField.placeholderText", "Mật khẩu");
//        add(passwordField);
//
//        btnLogin = new JButton("Đăng nhập");
//        btnLogin.setBounds(400, 260, 350, 30);
//        add(btnLogin);
//
//        btnRegister = new JButton("Đăng ký");
//        btnRegister.setBounds(400, 310, 170, 30);
//        add(btnRegister);
//
//        btnForgotPassword = new JButton("Quên mật khẩu");
//        btnForgotPassword.setBounds(580, 310, 170, 30);
//        add(btnForgotPassword);
//
//        lblInfo = new JLabel("", SwingConstants.CENTER);
//        lblInfo.setForeground(Color.RED);
//        lblInfo.setBounds(400, 350, 350, 30);
//        add(lblInfo);
//
//        // Action listeners
//        btnLogin.addActionListener(e -> loginAction());
//        btnRegister.addActionListener(e -> mainFrame.showRegisterPanel());
//        btnForgotPassword.addActionListener(e -> mainFrame.showForgotPasswordPanel());
//    }
//
//    private void loginAction() {
//        String username = userNameField.getText().trim();
//        String password = new String(passwordField.getPassword()).trim();
//
//        // TODO: replace with real authentication & role checking
//        if (username.isEmpty() || password.isEmpty()) {
//            lblInfo.setText("Vui lòng nhập đầy đủ thông tin!");
//            return;
//        }
//        // Giả lập đăng nhập
//        if ("admin".equals(username) && "admin".equals(password)) {
//            lblInfo.setText("");
//            mainFrame.showAdminContainerPanel(username);
//        } else if ("user".equals(username) && "user".equals(password)) {
//            lblInfo.setText("");
//            mainFrame.showUserContainerPanel(username);
//        } else {
//            lblInfo.setText("Sai tên đăng nhập hoặc mật khẩu!");
//        }
//    }
//}

package org.example.views;

import org.example.entity.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class LoginPanel extends JPanel {
    private final MainFrame mainFrame;

    private JLabel lblTitle;
    private JTextField userNameField;
    private JPasswordField passwordField;
    private JButton btnLogin;
    private JButton btnRegister;
    private JButton btnForgotPassword;
    private JLabel lblInfor;
    private JLabel lblSpace;

    public LoginPanel(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
        setLayout(null);
        initComponents();

        // Gắn controller vào các nút
        btnLogin.addActionListener(e -> LoginController.handleLogin(this));
        btnRegister.addActionListener(e -> LoginController.openRegister(this));
        btnForgotPassword.addActionListener(e -> LoginController.openForgotPassword(this));
    }

    private void initComponents() {
        JLabel imgBackground = new JLabel(new ImageIcon("src/main/java/org/example/img/login.png"));
        imgBackground.setLayout(null);
        imgBackground.setBounds(0, 0, 1200, 800);
        this.add(imgBackground);

        lblTitle = new JLabel("Đăng nhập hệ thống");
        lblTitle.setFont(new Font("Arial", Font.BOLD, 22));
        lblTitle.setForeground(new Color(135, 206, 235));
        lblTitle.setBounds(495, 380, 250, 30);
        imgBackground.add(lblTitle);

        lblInfor = new JLabel("");
        lblInfor.setFont(new Font("Arial", Font.PLAIN, 13));
        lblInfor.setForeground(Color.WHITE);
        imgBackground.add(lblInfor);

        userNameField = new JTextField();
        userNameField.setFont(new Font("Arial", Font.PLAIN, 14));
        userNameField.setBounds(440, 440, 320, 33);
        userNameField.putClientProperty("JTextField.placeholderText", "Nhập tên đăng nhập");
        imgBackground.add(userNameField);

        passwordField = new JPasswordField();
        passwordField.setFont(new Font("Arial", Font.PLAIN, 14));
        passwordField.setBounds(440, 500, 320, 33);
        passwordField.putClientProperty("JTextField.placeholderText", "Nhập mật khẩu");
        imgBackground.add(passwordField);

        btnLogin = new JButton("Đăng nhập");
        btnLogin.setFont(new Font("Arial", Font.PLAIN, 12));
        btnLogin.setBackground(new Color(46, 204, 113));
        btnLogin.setForeground(Color.WHITE);
        btnLogin.setBounds(440, 570, 320, 33);
        imgBackground.add(btnLogin);

        btnRegister = new JButton("Đăng ký tài khoản");
        btnRegister.setFont(new Font("Arial", Font.PLAIN, 12));
        btnRegister.setForeground(Color.WHITE);
        btnRegister.setContentAreaFilled(false);
        btnRegister.setBorderPainted(false);
        btnRegister.setFocusPainted(false);
        btnRegister.setBounds(600, 628, 150, 28);
        addHoverEffect(btnRegister);
        imgBackground.add(btnRegister);

        btnForgotPassword = new JButton("Quên mật khẩu?");
        btnForgotPassword.setFont(new Font("Arial", Font.PLAIN, 12));
        btnForgotPassword.setForeground(Color.WHITE);
        btnForgotPassword.setContentAreaFilled(false);
        btnForgotPassword.setBorderPainted(false);
        btnForgotPassword.setFocusPainted(false);
        btnForgotPassword.setBounds(450, 628, 150, 28);
        addHoverEffect(btnForgotPassword);
        imgBackground.add(btnForgotPassword);

        lblSpace = new JLabel("||");
        lblSpace.setFont(new Font("Arial", Font.BOLD, 20));
        lblSpace.setForeground(new Color(240, 240, 240));
        lblSpace.setBounds(590, 620, 20, 30);
        imgBackground.add(lblSpace);
    }

    private void addHoverEffect(JButton button) {
        Color normalColor = button.getForeground();
        Color hoverColor = new Color(52, 152, 219);

        button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                button.setForeground(hoverColor);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                button.setForeground(normalColor);
            }
        });
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

    public MainFrame getMainFrame() {
        return mainFrame;
    }

    public void resetForm() {
        userNameField.setText("");
        passwordField.setText("");
        lblInfor.setText("");
    }

    public static class LoginController {

        public static void handleLogin(LoginPanel view) {
            User user = view.getUser();

            if (user.getUserName().isEmpty() || user.getPassword().isEmpty()) {
                view.showError("Vui lòng nhập đầy đủ thông tin!");
                return;
            }

            // Giả lập xác thực
            if ("admin".equals(user.getUserName()) && "admin".equals(user.getPassword())) {
                view.getMainFrame().showAdminContainerPanel(user.getUserName());
            } else if ("user".equals(user.getUserName()) && "user".equals(user.getPassword())) {
                view.getMainFrame().showUserContainerPanel(user.getUserName());
            } else {
                view.showError("Sai tên đăng nhập hoặc mật khẩu!");
            }
        }

        public static void openRegister(LoginPanel view) {
            view.getMainFrame().showRegisterPanel();
        }

        public static void openForgotPassword(LoginPanel view) {
            view.getMainFrame().showForgotPasswordPanel();
        }
    }
}
