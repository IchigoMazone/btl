package org.example.panel;

import javax.swing.*;
import java.awt.*;

public class AdminPanel extends JPanel {
    private MainFrame mainFrame;

    public AdminPanel(MainFrame frame) {
        this.mainFrame = frame;
        initComponents();
    }

    private void initComponents() {
        setLayout(null);
        JLabel img = new JLabel(new ImageIcon("src/main/java/org/example/img/bgr1.png"));
        img.setBounds(0,0,1200,800);
        img.setLayout(null);

        JButton btnLogout = new JButton("Đăng xuất");
        btnLogout.setBounds(1000,700,150,40);
        btnLogout.setForeground(Color.WHITE);
        btnLogout.setBackground(new Color(0,102,204));
        img.add(btnLogout);

        btnLogout.addActionListener(e -> mainFrame.showPanel("login"));

        add(img);
    }
}
