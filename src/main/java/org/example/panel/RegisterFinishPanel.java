package org.example.panel;

import javax.swing.*;
import java.awt.*;

public class RegisterFinishPanel extends JPanel {
    private MainFrame mainFrame;

    public RegisterFinishPanel(MainFrame frame) {
        this.mainFrame = frame;
        initComponents();
    }

    private void initComponents() {
        setLayout(null);
        JLabel img = new JLabel(new ImageIcon("src/main/java/org/example/img/registerfinish.png"));
        img.setBounds(0,0,1200,800);
        img.setLayout(null);

        JButton btnLogin = new JButton("Đăng nhập ngay");
        btnLogin.setBounds(475, 685, 250, 33);
        btnLogin.setBackground(new Color(46,204,113));
        btnLogin.setForeground(Color.WHITE);
        img.add(btnLogin);

        btnLogin.addActionListener(e -> mainFrame.showPanel("login"));

        add(img);
    }
}
