package org.example.views;

import com.formdev.flatlaf.FlatLightLaf;
import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    private CardLayout mainCardLayout;
    private JPanel mainPanel;

    public static final String LOGIN = "LOGIN";
    public static final String REGISTER = "REGISTER";
    public static final String FORGOT_PASSWORD = "FORGOT_PASSWORD";
    public static final String PASSWORD_RESET = "PASSWORD_RESET";
    public static final String REGISTER_FINISH = "REGISTER_FINISH";
    public static final String ADMIN_CONTAINER = "ADMIN_CONTAINER";
    public static final String USER_CONTAINER = "USER_CONTAINER";

    private LoginPanel loginPanel;
    private RegisterPanel registerPanel;
    private ForgotPasswordPanel forgotPasswordPanel;
    private PasswordResetPanel passwordResetPanel;
    private RegisterFinishPanel registerFinishPanel;

    private AdminContainerPanel adminContainerPanel;
    private UserContainerPanel userContainerPanel;

    private String loggedInUsername;
    private boolean isAdmin;

    public MainFrame() {
        setTitle("Hotel Management System");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1200, 800);
        setLocationRelativeTo(null);
        setResizable(false);

        mainCardLayout = new CardLayout();
        mainPanel = new JPanel(mainCardLayout);

        // Khởi tạo các panel và truyền this nếu cần để callback
        loginPanel = new LoginPanel(this);
        registerPanel = new RegisterPanel(this);
        forgotPasswordPanel = new ForgotPasswordPanel(this);
        passwordResetPanel = new PasswordResetPanel(this);
        registerFinishPanel = new RegisterFinishPanel(this);

        adminContainerPanel = new AdminContainerPanel(this);
        userContainerPanel = new UserContainerPanel(this);

        // Thêm các panel vào mainPanel theo CardLayout
        mainPanel.add(loginPanel, LOGIN);
        mainPanel.add(registerPanel, REGISTER);
        mainPanel.add(forgotPasswordPanel, FORGOT_PASSWORD);
        mainPanel.add(passwordResetPanel, PASSWORD_RESET);
        mainPanel.add(registerFinishPanel, REGISTER_FINISH);
        mainPanel.add(adminContainerPanel, ADMIN_CONTAINER);
        mainPanel.add(userContainerPanel, USER_CONTAINER);

        setContentPane(mainPanel);

        showLoginPanel();
        setVisible(true);
    }

    public void showLoginPanel() {
        loginPanel.resetForm();  // Đảm bảo LoginPanel có method resetForm()
        mainCardLayout.show(mainPanel, LOGIN);
    }

    public void showRegisterPanel() {
        registerPanel.resetForm();
        mainCardLayout.show(mainPanel, REGISTER);
    }

    public void showForgotPasswordPanel() {
        forgotPasswordPanel.resetForm();
        mainCardLayout.show(mainPanel, FORGOT_PASSWORD);
    }

    public void showPasswordResetPanel(String username) {
        passwordResetPanel.resetForm();
        passwordResetPanel.setUsername(username);
        mainCardLayout.show(mainPanel, PASSWORD_RESET);
    }

    public void showRegisterFinishPanel() {
        mainCardLayout.show(mainPanel, REGISTER_FINISH);
    }

    public void showAdminContainerPanel(String username) {
        this.loggedInUsername = username;
        this.isAdmin = true;
        adminContainerPanel.loadData(username);  // đảm bảo có loadData()
        mainCardLayout.show(mainPanel, ADMIN_CONTAINER);
    }

    public void showUserContainerPanel(String username) {
        this.loggedInUsername = username;
        this.isAdmin = false;
        userContainerPanel.loadData(username);
        mainCardLayout.show(mainPanel, USER_CONTAINER);
    }

    public String getLoggedInUsername() {
        return loggedInUsername;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(new FlatLightLaf());
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }
        SwingUtilities.invokeLater(MainFrame::new);
    }
}
