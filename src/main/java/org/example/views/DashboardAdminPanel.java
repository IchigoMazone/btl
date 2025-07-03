package org.example.views;

import com.formdev.flatlaf.FlatLightLaf;

import javax.swing.*;
import java.awt.*;

public class DashboardAdminPanel extends JPanel {

    public DashboardAdminPanel() {
        try {
            UIManager.setLookAndFeel(new FlatLightLaf());
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        setLayout(new BorderLayout());
        setBackground(Color.WHITE);

        JPanel roomsPanel = createRoomsPanel();
        add(roomsPanel, BorderLayout.CENTER);

        JPanel statsPanel = createStatsPanel();
        statsPanel.setPreferredSize(new Dimension(920, 130)); // chiều cao panel thống kê

        JPanel wrapper = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 0));
        wrapper.setBackground(Color.WHITE);
        wrapper.setBorder(BorderFactory.createEmptyBorder(0, 0, 15, 0));

        wrapper.add(statsPanel);
        add(wrapper, BorderLayout.SOUTH);

    }

    private JPanel createRoomsPanel() {
        JPanel panel = new JPanel(new GridLayout(5, 6, 10, 10));
        panel.setBackground(Color.WHITE);
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        for (int i = 0; i < 30; i++) {
            int row = i / 6 + 1;
            int col = i % 6 + 1;
            String roomCode = row + "0" + col;

            JButton btn = new JButton("Phòng " + roomCode);
            btn.setPreferredSize(new Dimension(140, 80)); // giống RoomViews
            btn.setFont(new Font("Segoe UI", Font.PLAIN, 14));

            String status;
            if (i % 3 == 0) {
                status = "Có khách";
                btn.setBackground(new Color(0x3498db));
            } else if (i % 3 == 1) {
                status = "Trống";
                btn.setBackground(new Color(0x2ecc71));
            } else {
                status = "Sửa chữa";
                btn.setBackground(new Color(0xe74c3c));
            }

            btn.setOpaque(true);
            btn.setBorderPainted(false);
            btn.setForeground(Color.WHITE);

            btn.addActionListener(e ->
                    JOptionPane.showMessageDialog(this,
                            "Bạn đã chọn phòng " + roomCode + " - Trạng thái: " + status)
            );

            panel.add(btn);
        }

        return panel;
    }

    private JPanel createStatsPanel() {
        JPanel panel = new JPanel();
        panel.setBackground(new Color(0xecf0f1));
        panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
        panel.setBorder(BorderFactory.createTitledBorder("Thống kê phòng"));
        panel.setBorder(BorderFactory.createEmptyBorder());

        panel.setBorder(BorderFactory.createCompoundBorder(
                panel.getBorder(),
                BorderFactory.createEmptyBorder(5, 10, 5, 10))
        );

        panel.add(createStatItem("Phòng trống", new Color(0x2ecc71), 10));
        panel.add(Box.createHorizontalStrut(30));
        panel.add(createStatItem("Có khách", new Color(0x3498db), 12));
        panel.add(Box.createHorizontalStrut(30));
        panel.add(createStatItem("Sửa chữa", new Color(0xe74c3c), 8));

        return panel;
    }

    private JPanel createStatItem(String label, Color color, int count) {
        JPanel item = new JPanel();
        item.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 5));
        item.setOpaque(false);

        JLabel colorBox = new JLabel();
        colorBox.setOpaque(true);
        colorBox.setBackground(color);
        colorBox.setPreferredSize(new Dimension(20, 20)); // ô vuông màu

        JLabel text = new JLabel(label + ": " + count);
        text.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        text.setBorder(BorderFactory.createEmptyBorder(0, 5, 0, 0));

        item.add(colorBox);
        item.add(text);

        return item;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                UIManager.setLookAndFeel(new FlatLightLaf());
            } catch (Exception e) {
                e.printStackTrace();
            }

            JFrame frame = new JFrame("Dashboard Admin Panel");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(950, 720); // ✅ Kích thước đúng yêu cầu
            frame.setLocationRelativeTo(null);
            frame.setContentPane(new DashboardAdminPanel());
            frame.setVisible(true);
        });
    }
}


