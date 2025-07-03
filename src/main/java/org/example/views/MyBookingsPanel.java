package org.example.views;

import javax.swing.*;
import java.awt.*;

public class MyBookingsPanel extends JPanel {
    public MyBookingsPanel() {
        setLayout(new BorderLayout());
        JLabel label = new JLabel("Lịch sử đặt phòng", SwingConstants.CENTER);
        label.setFont(new Font("Arial", Font.BOLD, 24));
        add(label, BorderLayout.CENTER);
    }
}
