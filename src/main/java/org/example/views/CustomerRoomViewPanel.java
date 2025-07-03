package org.example.views;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class CustomerRoomViewPanel extends JPanel {
    private JTable roomTable;
    private DefaultTableModel tableModel;

    public CustomerRoomViewPanel() {
        setLayout(new BorderLayout());

        String[] columns = {"Room ID", "Loại phòng", "Giá", "Tình trạng"};
        tableModel = new DefaultTableModel(columns, 0);
        roomTable = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(roomTable);

        add(scrollPane, BorderLayout.CENTER);

        loadRoomData();
    }

    private void loadRoomData() {
        // TODO: load danh sách phòng cho user xem
        tableModel.setRowCount(0);
        tableModel.addRow(new Object[]{"R201", "Phòng đơn", "500,000 VND", "Trống"});
        tableModel.addRow(new Object[]{"R202", "Phòng đôi", "800,000 VND", "Đã thuê"});
    }
}
