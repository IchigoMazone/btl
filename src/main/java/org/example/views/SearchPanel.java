package org.example.views;

import javax.swing.*;
import java.awt.*;

public class SearchPanel extends JPanel {
    public SearchPanel() {
        setLayout(new BorderLayout());
        JLabel label = new JLabel("Tìm kiếm phòng", SwingConstants.CENTER);
        label.setFont(new Font("Arial", Font.BOLD, 24));
        add(label, BorderLayout.CENTER);
    }
}
