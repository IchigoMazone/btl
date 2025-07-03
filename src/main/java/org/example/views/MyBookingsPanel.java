package org.example.views;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class MyBookingsPanel extends JPanel {
    private JTable bookingTable;
    private DefaultTableModel tableModel;
    private JButton btnCancel;

    public MyBookingsPanel() {
        setLayout(new BorderLayout());

        String[] columns = {"Booking ID", "Room", "Check-in", "Check-out", "Status"};
        tableModel = new DefaultTableModel(columns, 0);
        bookingTable = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(bookingTable);

        JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        btnCancel = new JButton("Hủy đặt phòng");
        bottomPanel.add(btnCancel);

        add(scrollPane, BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.SOUTH);

        loadMyBookings();

        btnCancel.addActionListener(e -> cancelBooking());
    }

    private void loadMyBookings() {
        // TODO: load booking của user đang đăng nhập
        tableModel.setRowCount(0);
        tableModel.addRow(new Object[]{"B201", "201", "2025-07-20", "2025-07-22", "Confirmed"});
        tableModel.addRow(new Object[]{"B202", "202", "2025-08-01", "2025-08-05", "Pending"});
    }

    private void cancelBooking() {
        int selectedRow = bookingTable.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn đặt phòng để hủy");
            return;
        }
        String bookingId = (String) tableModel.getValueAt(selectedRow, 0);
        int confirm = JOptionPane.showConfirmDialog(this, "Bạn có chắc muốn hủy đặt phòng " + bookingId + "?", "Xác nhận hủy", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            // TODO: hủy booking thật
            tableModel.removeRow(selectedRow);
            JOptionPane.showMessageDialog(this, "Đã hủy đặt phòng " + bookingId);
        }
    }
}
