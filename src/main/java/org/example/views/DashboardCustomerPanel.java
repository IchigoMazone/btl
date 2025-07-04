package org.example.views;

import com.formdev.flatlaf.FlatLightLaf;
import org.example.entity.Room;
import org.example.service.RoomService;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class DashboardCustomerPanel extends JPanel {

    private List<Room> roomList;

    public DashboardCustomerPanel() {
        try {
            UIManager.setLookAndFeel(new FlatLightLaf());
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        setLayout(new BorderLayout());
        setBackground(Color.WHITE);

        roomList = RoomService.readAllRooms("room.xml");

        JPanel roomsPanel = createRoomsPanel();
        add(roomsPanel, BorderLayout.CENTER);

        JPanel statsPanel = createStatsPanel();
        statsPanel.setPreferredSize(new Dimension(920, 130));

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

        for (Room room : roomList) {
            JButton btn = new JButton("Phòng " + room.getRoomNumber());
            btn.setPreferredSize(new Dimension(140, 80));
            btn.setFont(new Font("Segoe UI", Font.PLAIN, 14));

            String status = room.getStatus();
            switch (status) {
                case "Có khách" -> btn.setBackground(new Color(0x3498db));
                case "Trống" -> btn.setBackground(new Color(0x2ecc71));
                default -> btn.setBackground(new Color(0xe74c3c));
            }

            btn.setOpaque(true);
            btn.setBorderPainted(false);
            btn.setForeground(Color.WHITE);

            btn.addActionListener(e -> {
                String message;
                switch (room.getStatus()) {
                    case "Trống" -> message = "Phòng " + room.getRoomNumber() + " : đang trống.\n"
                            + "Loại: " + room.getRoomType()
                            + "\nGiá / đêm: " + room.getPricePerNight() + " VND";
                    case "Có khách" -> message = "Phòng " + room.getRoomNumber() + " : đang có khách!.\n"
                            + "Loại: " + room.getRoomType()
                            + "\nGiá / đêm: " + room.getPricePerNight() + " VND";
                    default -> message = "Phòng " + room.getRoomNumber() + " có chưa hoạt động.";
                }

                JOptionPane.showMessageDialog(this, message);
            });

            panel.add(btn);
        }

        return panel;
    }


    private JPanel createStatsPanel() {
        int emptyCount = 0, occupiedCount = 0, RoomCount = 0;

        for (Room room : roomList) {
            switch (room.getStatus()) {
                case "Trống" -> emptyCount++;
                case "Có khách" -> occupiedCount++;
                default -> RoomCount++;
            }
        }

        JPanel panel = new JPanel();
        panel.setBackground(new Color(0xecf0f1));
        panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
        panel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createEmptyBorder(0, 0, 0, 0),
                BorderFactory.createEmptyBorder(5, 10, 5, 10)
        ));

        panel.add(createStatItem("Phòng trống ", new Color(0x2ecc71), emptyCount));
        panel.add(Box.createHorizontalStrut(30));
        panel.add(createStatItem("Có khách ", new Color(0x3498db), occupiedCount));
        panel.add(Box.createHorizontalStrut(30));
        panel.add(createStatItem("Chưa hoạt động ", new Color(0xe74c3c), RoomCount));

        return panel;
    }

    private JPanel createStatItem(String label, Color color, int count) {
        JPanel item = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 5));
        item.setOpaque(false);

        JLabel colorBox = new JLabel();
        colorBox.setOpaque(true);
        colorBox.setBackground(color);
        colorBox.setPreferredSize(new Dimension(20, 20));

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

            JFrame frame = new JFrame("Dashboard Customer Panel");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(950, 720);
            frame.setLocationRelativeTo(null);
            frame.setContentPane(new DashboardCustomerPanel());
            frame.setVisible(true);
        });
    }
}
