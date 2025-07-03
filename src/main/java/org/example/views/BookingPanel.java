package org.example.views;

import javax.swing.*;
import java.awt.*;

public class BookingPanel extends JPanel {
    public BookingPanel() {
        setLayout(new BorderLayout());
        JLabel label = new JLabel("Đặt phòng", SwingConstants.CENTER);
        label.setFont(new Font("Arial", Font.BOLD, 24));
        add(label, BorderLayout.CENTER);
    }
}
