package org.example.views;

import com.formdev.flatlaf.FlatLightLaf;
import org.example.entity.Room;
import org.example.service.RoomService;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class DashboardCustomerPanel extends JPanel {
    private List<Room> roomList;
    private JPanel roomsPanel;

    public DashboardCustomerPanel() {
        try {
            UIManager.setLookAndFeel(new FlatLightLaf());
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        setLayout(new BorderLayout());
        setBackground(Color.WHITE);

        roomsPanel = new JPanel();
        roomsPanel.setLayout(new GridLayout(0, 5, 10, 10));
        roomsPanel.setBackground(Color.WHITE);
        roomsPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JScrollPane scrollPane = new JScrollPane(roomsPanel);
        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        add(scrollPane, BorderLayout.CENTER);

        JPanel statsPanel = createStatsPanel();
        statsPanel.setPreferredSize(new Dimension(920, 100));

        JPanel wrapper = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 0));
        wrapper.setBackground(Color.WHITE);
        wrapper.setBorder(BorderFactory.createEmptyBorder(0, 0, 15, 0));
        wrapper.add(statsPanel);

        add(wrapper, BorderLayout.SOUTH);

        loadRooms();
    }

    public void loadRooms() {
        roomList = RoomService.readAllRooms("rooms.xml");
        roomsPanel.removeAll();

        for (Room room : roomList) {
            JButton btn = new JButton("Phòng " + room.getRoomNumber());
            btn.setPreferredSize(new Dimension(140, 80));
            btn.setFont(new Font("Segoe UI", Font.PLAIN, 14));

            String status = room.getStatus();
            switch (status) {
                case "Đang hoạt động" -> btn.setBackground(new Color(0x2ecc71));
                case "Chưa hoạt động" -> btn.setBackground(Color.GRAY);
                default -> btn.setBackground(Color.LIGHT_GRAY);
            }

            btn.setOpaque(true);
            btn.setBorderPainted(false);
            btn.setForeground(Color.WHITE);

            btn.addActionListener(e ->
                    JOptionPane.showMessageDialog(this,
                            "Phòng: " + room.getRoomNumber() +
                                    "\nTình trạng: " + room.getStatus() +
                                    "\nLoại phòng: " + room.getRoomType() +
                                    "\nGiá/đêm: " + room.getPricePerNight() + " VND")
            );

            roomsPanel.add(btn);
        }

        roomsPanel.revalidate();
        roomsPanel.repaint();

        updateStatsPanel();
    }

    private JPanel statsPanel;

    private JPanel createStatsPanel() {
        statsPanel = new JPanel();
        statsPanel.setBackground(new Color(0xecf0f1));
        statsPanel.setLayout(new BoxLayout(statsPanel, BoxLayout.X_AXIS));
        statsPanel.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
        updateStatsPanel();
        return statsPanel;
    }

    private void updateStatsPanel() {
        statsPanel.removeAll();

        int activeCount = 0;
        int inactiveCount = 0;

        if (roomList != null) {
            for (Room room : roomList) {
                if ("Đang hoạt động".equals(room.getStatus())) {
                    activeCount++;
                } else if ("Chưa hoạt động".equals(room.getStatus())) {
                    inactiveCount++;
                }
            }
        }

        statsPanel.add(createStatItem("Đang hoạt động", new Color(0x2ecc71), activeCount));
        statsPanel.add(Box.createHorizontalStrut(30));
        statsPanel.add(createStatItem("Chưa hoạt động", Color.GRAY, inactiveCount));

        statsPanel.revalidate();
        statsPanel.repaint();
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

    public void reloadRooms() {
        loadRooms();
    }
}
