//package org.example.views;
//
//import javax.swing.*;
//import javax.swing.table.DefaultTableModel;
//import java.awt.*;
//import java.awt.event.*;
//
//public class BookingManagementPanel extends JPanel {
//    private JTable bookingTable;
//    private DefaultTableModel tableModel;
//    private JButton btnAdd, btnEdit, btnDelete, btnSearch;
//    private JTextField searchField;
//
//    public BookingManagementPanel() {
//        setLayout(new BorderLayout());
//
//        // Table model & JTable
//        String[] columns = {"Booking ID", "Guest Name", "Room", "Check-in", "Check-out"};
//        tableModel = new DefaultTableModel(columns, 0);
//        bookingTable = new JTable(tableModel);
//        JScrollPane scrollPane = new JScrollPane(bookingTable);
//
//        // Top panel with search
//        JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
//        searchField = new JTextField(20);
//        btnSearch = new JButton("Tìm kiếm");
//        topPanel.add(new JLabel("Tìm kiếm booking:"));
//        topPanel.add(searchField);
//        topPanel.add(btnSearch);
//
//        // Bottom panel with buttons
//        JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
//        btnAdd = new JButton("Thêm");
//        btnEdit = new JButton("Sửa");
//        btnDelete = new JButton("Xóa");
//        bottomPanel.add(btnAdd);
//        bottomPanel.add(btnEdit);
//        bottomPanel.add(btnDelete);
//
//        add(topPanel, BorderLayout.NORTH);
//        add(scrollPane, BorderLayout.CENTER);
//        add(bottomPanel, BorderLayout.SOUTH);
//
//        loadBookingData();
//
//        btnSearch.addActionListener(e -> searchBooking());
//        btnAdd.addActionListener(e -> addBooking());
//        btnEdit.addActionListener(e -> editBooking());
//        btnDelete.addActionListener(e -> deleteBooking());
//    }
//
//    private void loadBookingData() {
//        // TODO: load dữ liệu booking từ DB hoặc file
//        tableModel.setRowCount(0);
//        // Demo data
//        tableModel.addRow(new Object[]{"B001", "Nguyen Van A", "101", "2025-07-01", "2025-07-05"});
//        tableModel.addRow(new Object[]{"B002", "Tran Thi B", "102", "2025-07-10", "2025-07-12"});
//    }
//
//    private void searchBooking() {
//        String keyword = searchField.getText().trim();
//        if (keyword.isEmpty()) {
//            loadBookingData();
//            return;
//        }
//        // TODO: thực hiện tìm kiếm trong dữ liệu thật
//        JOptionPane.showMessageDialog(this, "Tìm kiếm booking: " + keyword);
//    }
//
//    private void addBooking() {
//        JOptionPane.showMessageDialog(this, "Mở form thêm booking (chưa cài đặt)");
//        // TODO: mở form thêm booking
//    }
//
//    private void editBooking() {
//        int selectedRow = bookingTable.getSelectedRow();
//        if (selectedRow == -1) {
//            JOptionPane.showMessageDialog(this, "Vui lòng chọn booking để sửa");
//            return;
//        }
//        String bookingId = (String) tableModel.getValueAt(selectedRow, 0);
//        JOptionPane.showMessageDialog(this, "Mở form sửa booking " + bookingId + " (chưa cài đặt)");
//        // TODO: mở form sửa booking
//    }
//
//    private void deleteBooking() {
//        int selectedRow = bookingTable.getSelectedRow();
//        if (selectedRow == -1) {
//            JOptionPane.showMessageDialog(this, "Vui lòng chọn booking để xóa");
//            return;
//        }
//        String bookingId = (String) tableModel.getValueAt(selectedRow, 0);
//        int confirm = JOptionPane.showConfirmDialog(this, "Bạn có chắc muốn xóa booking " + bookingId + "?", "Xác nhận xóa", JOptionPane.YES_NO_OPTION);
//        if (confirm == JOptionPane.YES_OPTION) {
//            // TODO: xóa booking thật
//            tableModel.removeRow(selectedRow);
//            JOptionPane.showMessageDialog(this, "Đã xóa booking " + bookingId);
//        }
//    }
//}

package org.example.views;

import javax.swing.*;
import java.awt.*;

public class BookingManagementPanel extends JPanel {
    public BookingManagementPanel() {
        setLayout(new BorderLayout());
        JLabel label = new JLabel("Quản lý đặt phòng", SwingConstants.CENTER);
        label.setFont(new Font("Segoe UI", Font.BOLD, 24));
        add(label, BorderLayout.CENTER);

        // TODO: Thêm bảng đặt phòng, xử lý trạng thái booking
    }
}
