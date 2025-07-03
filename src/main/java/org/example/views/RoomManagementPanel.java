package org.example.views;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class RoomManagementPanel extends JPanel {
    private JTable roomTable;
    private DefaultTableModel tableModel;
    private JButton btnAdd, btnEdit, btnDelete, btnSearch;
    private JTextField searchField;

    public RoomManagementPanel() {
        setLayout(new BorderLayout());

        String[] columns = {"Room ID", "Loại phòng", "Giá", "Tình trạng"};
        tableModel = new DefaultTableModel(columns, 0);
        roomTable = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(roomTable);

        JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        searchField = new JTextField(20);
        btnSearch = new JButton("Tìm kiếm");
        topPanel.add(new JLabel("Tìm kiếm phòng:"));
        topPanel.add(searchField);
        topPanel.add(btnSearch);

        JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        btnAdd = new JButton("Thêm");
        btnEdit = new JButton("Sửa");
        btnDelete = new JButton("Xóa");
        bottomPanel.add(btnAdd);
        bottomPanel.add(btnEdit);
        bottomPanel.add(btnDelete);

        add(topPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.SOUTH);

        loadRoomData();

        btnSearch.addActionListener(e -> searchRoom());
        btnAdd.addActionListener(e -> addRoom());
        btnEdit.addActionListener(e -> editRoom());
        btnDelete.addActionListener(e -> deleteRoom());
    }

    private void loadRoomData() {
        // TODO: load dữ liệu phòng
        tableModel.setRowCount(0);
        tableModel.addRow(new Object[]{"R101", "Phòng đơn", "500,000 VND", "Trống"});
        tableModel.addRow(new Object[]{"R102", "Phòng đôi", "800,000 VND", "Đã thuê"});
    }

    private void searchRoom() {
        String keyword = searchField.getText().trim();
        if (keyword.isEmpty()) {
            loadRoomData();
            return;
        }
        // TODO: tìm kiếm phòng
        JOptionPane.showMessageDialog(this, "Tìm kiếm phòng: " + keyword);
    }

    private void addRoom() {
        JOptionPane.showMessageDialog(this, "Mở form thêm phòng (chưa cài đặt)");
    }

    private void editRoom() {
        int selectedRow = roomTable.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn phòng để sửa");
            return;
        }
        String roomId = (String) tableModel.getValueAt(selectedRow, 0);
        JOptionPane.showMessageDialog(this, "Mở form sửa phòng " + roomId + " (chưa cài đặt)");
    }

    private void deleteRoom() {
        int selectedRow = roomTable.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn phòng để xóa");
            return;
        }
        String roomId = (String) tableModel.getValueAt(selectedRow, 0);
        int confirm = JOptionPane.showConfirmDialog(this, "Bạn có chắc muốn xóa phòng " + roomId + "?", "Xác nhận xóa", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            // TODO: xóa phòng thật
            tableModel.removeRow(selectedRow);
            JOptionPane.showMessageDialog(this, "Đã xóa phòng " + roomId);
        }
    }
}
