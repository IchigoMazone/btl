package org.example.view.customer;

import javax.swing.*;
import java.awt.*;

public class BookingPanel extends JPanel {
    public BookingPanel() {
        setLayout(new BorderLayout());

        JLabel title = new JLabel("Đặt phòng", SwingConstants.CENTER);
        title.setFont(new Font("Segoe UI", Font.BOLD, 24));
        title.setForeground(new Color(0x2c3e50));

        JTextArea infoArea = new JTextArea("Chức năng đặt phòng sẽ hiển thị ở đây.");
        infoArea.setEditable(false);
        infoArea.setFont(new Font("Segoe UI", Font.PLAIN, 16));

        add(title, BorderLayout.NORTH);
        add(new JScrollPane(infoArea), BorderLayout.CENTER);
    }
}
