package org.example.views;

import com.formdev.flatlaf.FlatLightLaf;
import org.example.entity.Room;
import org.example.service.RoomService;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class RoomManagementPanel extends JPanel {

    private JTable table;
    private DefaultTableModel tableModel;
    private List<Room> roomList;
    private final String fileName = "rooms.xml";
    private Runnable onDataChanged; // Callback để reload Dashboard

    public RoomManagementPanel(Runnable onDataChanged) {
        this.onDataChanged = onDataChanged;

        try {
            UIManager.setLookAndFeel(new FlatLightLaf());
        } catch (Exception e) {
            e.printStackTrace();
        }

        setLayout(new BorderLayout());
        setBackground(Color.WHITE);

        roomList = RoomService.readAllRooms(fileName);

        initTable();

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBorder(BorderFactory.createEmptyBorder());

        JPanel scrollPanelWrapper = new JPanel(new BorderLayout());
        scrollPanelWrapper.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 0));
        scrollPanelWrapper.add(scrollPane, BorderLayout.CENTER);

        add(scrollPanelWrapper, BorderLayout.CENTER);
        add(createButtonPanel(), BorderLayout.SOUTH);
    }

    private void initTable() {
        String[] columns = {"Số phòng", "Trạng thái", "Loại phòng", "Giá/đêm (VND)"};
        tableModel = new DefaultTableModel(columns, 0);
        table = new JTable(tableModel);
        table.setRowHeight(28);
        loadTableData();
    }

    private void loadTableData() {
        roomList = RoomService.readAllRooms(fileName);
        roomList.sort((a, b) -> Integer.compare(a.getRoomNumber(), b.getRoomNumber()));
        tableModel.setRowCount(0);
        for (Room r : roomList) {
            tableModel.addRow(new Object[]{
                    r.getRoomNumber(),
                    r.getStatus(),
                    r.getRoomType(),
                    r.getPricePerNight()
            });
        }
    }

    private JPanel createButtonPanel() {
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 10));
        panel.setBackground(Color.WHITE);

        JButton addBtn = new JButton("Thêm");
        JButton editBtn = new JButton("Sửa");
        JButton deleteBtn = new JButton("Xóa");

        addBtn.addActionListener(e -> addRoom());
        editBtn.addActionListener(e -> editRoom());
        deleteBtn.addActionListener(e -> deleteRoom());

        panel.add(addBtn);
        panel.add(editBtn);
        panel.add(deleteBtn);

        return panel;
    }

    private void addRoom() {
        Room room = showRoomForm(null);
        if (room != null) {
            // Kiểm tra trùng số phòng
            for (Room r : roomList) {
                if (r.getRoomNumber() == room.getRoomNumber()) {
                    JOptionPane.showMessageDialog(this, "Phòng đã tồn tại!");
                    return;
                }
            }

            roomList.add(room);
            roomList.sort((a, b) -> Integer.compare(a.getRoomNumber(), b.getRoomNumber())); // Sắp xếp
            RoomService.writeAllRooms(fileName, roomList);
            loadTableData();
            if (onDataChanged != null) onDataChanged.run(); // Gọi callback
        }
    }

    private void editRoom() {
        int row = table.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Chọn phòng để sửa.");
            return;
        }

        Room room = roomList.get(row);
        Room updated = showRoomForm(room);
        if (updated != null) {
            roomList.set(row, updated);
            roomList.sort((a, b) -> Integer.compare(a.getRoomNumber(), b.getRoomNumber())); // Sắp xếp
            RoomService.writeAllRooms(fileName, roomList);
            loadTableData();
            if (onDataChanged != null) onDataChanged.run(); // Gọi callback
        }
    }

    private void deleteRoom() {
        int row = table.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Chọn phòng để xóa.");
            return;
        }

        Room room = roomList.get(row);
        if (!"Chưa hoạt động".equalsIgnoreCase(room.getStatus())) {
            JOptionPane.showMessageDialog(this, "Chỉ được xóa phòng có trạng thái 'Chưa hoạt động'");
            return;
        }

        int confirm = JOptionPane.showConfirmDialog(this, "Xác nhận xóa phòng?", "Xác nhận", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            roomList.remove(row);
            roomList.sort((a, b) -> Integer.compare(a.getRoomNumber(), b.getRoomNumber())); // Sắp xếp
            RoomService.writeAllRooms(fileName, roomList);
            loadTableData();
            if (onDataChanged != null) onDataChanged.run(); // Gọi callback
        }
    }

    private Room showRoomForm(Room roomInput) {
        JTextField tfRoomNumber = new JTextField();
        JTextField tfRoomType = new JTextField();
        JTextField tfPrice = new JTextField();
        JComboBox<String> cbStatus = new JComboBox<>(new String[]{"Đang hoạt động", "Chưa hoạt động"});

        if (roomInput != null) {
            tfRoomNumber.setText(String.valueOf(roomInput.getRoomNumber()));
            tfRoomNumber.setEnabled(false);
            tfRoomType.setText(roomInput.getRoomType());
            tfPrice.setText(String.valueOf(roomInput.getPricePerNight()));
            cbStatus.setSelectedItem(roomInput.getStatus());
        }

        JPanel panel = new JPanel(new GridLayout(4, 2, 10, 10));
        panel.add(new JLabel("Số phòng:"));
        panel.add(tfRoomNumber);
        panel.add(new JLabel("Loại phòng:"));
        panel.add(tfRoomType);
        panel.add(new JLabel("Giá/đêm:"));
        panel.add(tfPrice);
        panel.add(new JLabel("Trạng thái:"));
        panel.add(cbStatus);

        int result = JOptionPane.showConfirmDialog(this, panel, "Thông tin phòng",
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

        if (result == JOptionPane.OK_OPTION) {
            try {
                int number = Integer.parseInt(tfRoomNumber.getText().trim());
                String type = tfRoomType.getText().trim();
                int price = Integer.parseInt(tfPrice.getText().trim());
                String status = (String) cbStatus.getSelectedItem();

                if (type.isEmpty() || price <= 0) {
                    throw new IllegalArgumentException();
                }

                return new Room(number, status, type, price);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Dữ liệu không hợp lệ!");
            }
        }
        return null;
    }
}
