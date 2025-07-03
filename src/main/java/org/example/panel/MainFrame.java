package org.example.panel;
import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    private CardLayout cardLayout;
    private JPanel mainPanel;

    // Khai báo tất cả các panel
    private LoginPanel loginPanel;
    private RegisterPanel registerPanel;
    private RegisterFinishPanel registerFinishPanel;
    private AccountPanel accountPanel;
    private PasswordPanel passwordPanel;
    private AdminPanel adminPanel;
    private UserPanel userPanel;

    public MainFrame() {
        setTitle("Ứng dụng quản lý");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1200, 800);
        setLocationRelativeTo(null);

        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);

        // Khởi tạo panel
        loginPanel = new LoginPanel(this);
        registerPanel = new RegisterPanel(this);
        registerFinishPanel = new RegisterFinishPanel(this);
        accountPanel = new AccountPanel(this);
        passwordPanel = new PasswordPanel(this, "");
        adminPanel = new AdminPanel(this);
        userPanel = new UserPanel(this);

        // Thêm panel vào mainPanel
        mainPanel.add(loginPanel, "login");
        mainPanel.add(registerPanel, "register");
        mainPanel.add(registerFinishPanel, "registerFinish");
        mainPanel.add(accountPanel, "account");
        mainPanel.add(passwordPanel, "password");
        mainPanel.add(adminPanel, "admin");
        mainPanel.add(userPanel, "user");

        setContentPane(mainPanel);
        showPanel("login");
    }

    public void showPanel(String name) {
        cardLayout.show(mainPanel, name);
    }

    public PasswordPanel getPasswordPanel(String username) {
        this.passwordPanel = new PasswordPanel(this, username);
        mainPanel.add(passwordPanel, "password");
        return passwordPanel;
    }
}
