package org.example.view.admin;

import org.example.entity.Room;
import org.example.entity.RoomXML;

import javax.swing.*;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import java.awt.*;
import java.io.File;
import java.util.List;

public class AdminRoomViewPanel extends JPanel {

    public AdminRoomViewPanel() {
        setLayout(null);
        setPreferredSize(new Dimension(900, 800));

        // Panel lưới phòng
        JPanel gridPanel = new JPanel(new GridLayout(5, 6, 5, 5));
        gridPanel.setBounds(0, 0, 900, 600);

        int countAvailable = 0;
        int countOccupied = 0;
        int countMaintenance = 0;
        int countDeleted = 0;

        List<Room> rooms = loadRoomsFromXML("room.xml");
        if (rooms != null) {
            for (Room room : rooms) {
                // Đếm thống kê
                switch (room.getStatus()) {
                    case "Trống":
                        countAvailable++;
                        break;
                    case "Có khách":
                        countOccupied++;
                        break;
                    case "Sửa chữa":
                        countMaintenance++;
                        break;
                    case "Đã xóa":
                        countDeleted++;
                        break;
                }

                JButton btn = new JButton(String.valueOf(room.getRoomNumber()));
                btn.setPreferredSize(new Dimension(100, 80));
                btn.setFocusPainted(false);
                btn.setFont(new Font("Segoe UI", Font.BOLD, 14));
                btn.setForeground(Color.WHITE);

                // Màu trạng thái
                switch (room.getStatus()) {
                    case "Trống":
                        btn.setBackground(new Color(0x3498db));
                        break;
                    case "Có khách":
                        btn.setBackground(new Color(0xf39c12));
                        break;
                    case "Sửa chữa":
                        btn.setBackground(new Color(0xe74c3c));
                        break;
                    default:
                        btn.setBackground(Color.GRAY);
                }

                btn.addActionListener(e -> {
                    JOptionPane.showMessageDialog(this,
                            "Phòng: " + room.getRoomNumber() +
                                    "\nTrạng thái: " + room.getStatus() +
                                    "\nLoại: " + room.getRoomType() +
                                    "\nGiá: " + room.getPricePerNight() + " VNĐ");
                });

                gridPanel.add(btn);
            }
        }

        add(gridPanel);

        // Panel thống kê
        JPanel statPanel = new JPanel(new GridLayout(3, 1));
        statPanel.setBounds(0, 620, 900, 150);
        statPanel.setBackground(new Color(0xd5f5e3));
        statPanel.setBorder(BorderFactory.createLineBorder(Color.GRAY));

        JLabel lblTitle = new JLabel("Thống kê phòng", SwingConstants.CENTER);
        lblTitle.setFont(new Font("Segoe UI", Font.BOLD, 16));
        lblTitle.setForeground(new Color(0x145a32));

        JPanel row1 = new JPanel(new FlowLayout(FlowLayout.CENTER, 50, 5));
        row1.setOpaque(false);

        JLabel squareAvailable = createColorSquare(new Color(0x3498db));
        JLabel lblAvailable = new JLabel("Trống: " + countAvailable);
        lblAvailable.setFont(new Font("Segoe UI", Font.PLAIN, 14));

        JLabel squareOccupied = createColorSquare(new Color(0xf39c12));
        JLabel lblOccupied = new JLabel("Có khách: " + countOccupied);
        lblOccupied.setFont(new Font("Segoe UI", Font.PLAIN, 14));

        row1.add(squareAvailable);
        row1.add(lblAvailable);
        row1.add(squareOccupied);
        row1.add(lblOccupied);

        JPanel row2 = new JPanel(new FlowLayout(FlowLayout.CENTER, 50, 5));
        row2.setOpaque(false);

        JLabel squareMaintenance = createColorSquare(new Color(0xe74c3c));
        JLabel lblMaintenance = new JLabel("Sửa chữa: " + countMaintenance);
        lblMaintenance.setFont(new Font("Segoe UI", Font.PLAIN, 14));

        JLabel squareDeleted = createColorSquare(new Color(0x7f8c8d));
        JLabel lblDeleted = new JLabel("Đã xóa: " + countDeleted);
        lblDeleted.setFont(new Font("Segoe UI", Font.PLAIN, 14));

        row2.add(squareMaintenance);
        row2.add(lblMaintenance);
        row2.add(squareDeleted);
        row2.add(lblDeleted);

        statPanel.add(lblTitle);
        statPanel.add(row1);
        statPanel.add(row2);

        add(statPanel);
    }

    private JLabel createColorSquare(Color color) {
        JLabel lbl = new JLabel();
        lbl.setOpaque(true);
        lbl.setBackground(color);
        lbl.setPreferredSize(new Dimension(15, 15));
        return lbl;
    }

    private List<Room> loadRoomsFromXML(String filePath) {
        try {
            JAXBContext context = JAXBContext.newInstance(RoomXML.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            RoomXML wrapper = (RoomXML) unmarshaller.unmarshal(new File(filePath));
            return wrapper.getRooms();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
