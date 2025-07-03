package org.example.view.admin;

import javax.swing.*;
import java.awt.*;

public class RoomManagementPanel extends JPanel {

    public RoomManagementPanel() {
        setLayout(new BorderLayout());

        JLabel title = new JLabel("Quản lý phòng", SwingConstants.CENTER);
        title.setFont(new Font("Segoe UI", Font.BOLD, 24));
        title.setForeground(new Color(0x2c3e50));

        JTextArea infoArea = new JTextArea("Chức năng quản lý phòng sẽ hiển thị ở đây.");
        infoArea.setEditable(false);
        infoArea.setFont(new Font("Segoe UI", Font.PLAIN, 16));

        add(title, BorderLayout.NORTH);
        add(new JScrollPane(infoArea), BorderLayout.CENTER);
    }
}
