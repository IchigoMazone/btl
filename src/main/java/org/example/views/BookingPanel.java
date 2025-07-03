package org.example.views;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class BookingPanel extends JPanel {
    private JTable bookingTable;
    private DefaultTableModel tableModel;
    private JButton btnBook, btnCancel;
    private JTextField searchField;
    private JButton btnSearch;

    public BookingPanel() {
        setLayout(new BorderLayout());

        String[] columns = {"Booking ID", "Room", "Check-in", "Check-out", "Status"};
        tableModel = new DefaultTableModel(columns, 0);
        bookingTable = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(bookingTable);

        JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        searchField = new JTextField(20);
        btnSearch = new JButton("Tìm kiếm");
        topPanel.add(new JLabel("Tìm kiếm đặt phòng:"));
        topPanel.add(searchField);
        topPanel.add(btnSearch);

        JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        btnBook = new JButton("Đặt phòng");
        btnCancel = new JButton("Hủy đặt");
        bottomPanel.add(btnBook);
        bottomPanel.add(btnCancel);

        add(topPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.SOUTH);

        loadBookingData();

        btnSearch.addActionListener(e -> searchBooking());
        btnBook.addActionListener(e -> bookRoom());
        btnCancel.addActionListener(e -> cancelBooking());
    }

    private void loadBookingData() {
        // TODO: load dữ liệu booking của user
        tableModel.setRowCount(0);
        tableModel.addRow(new Object[]{"B101", "101", "2025-07-05", "2025-07-10", "Confirmed"});
        tableModel.addRow(new Object[]{"B102", "102", "2025-07-15", "2025-07-18", "Pending"});
    }

    private void searchBooking() {
        String keyword = searchField.getText().trim();
        if (keyword.isEmpty()) {
            loadBookingData();
            return;
        }
        // TODO: tìm kiếm booking
        JOptionPane.showMessageDialog(this, "Tìm kiếm đặt phòng: " + keyword);
    }

    private void bookRoom() {
        JOptionPane.showMessageDialog(this, "Mở form đặt phòng (chưa cài đặt)");
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
