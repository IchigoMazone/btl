package org.example.views;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class PaymentManagementPanel extends JPanel {
    private JTable paymentTable;
    private DefaultTableModel tableModel;
    private JButton btnAdd, btnEdit, btnDelete, btnSearch;
    private JTextField searchField;

    public PaymentManagementPanel() {
        setLayout(new BorderLayout());

        String[] columns = {"Payment ID", "Booking ID", "Amount", "Date", "Status"};
        tableModel = new DefaultTableModel(columns, 0);
        paymentTable = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(paymentTable);

        JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        searchField = new JTextField(20);
        btnSearch = new JButton("Tìm kiếm");
        topPanel.add(new JLabel("Tìm kiếm thanh toán:"));
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

        loadPaymentData();

        btnSearch.addActionListener(e -> searchPayment());
        btnAdd.addActionListener(e -> addPayment());
        btnEdit.addActionListener(e -> editPayment());
        btnDelete.addActionListener(e -> deletePayment());
    }

    private void loadPaymentData() {
        // TODO: load dữ liệu thanh toán
        tableModel.setRowCount(0);
        tableModel.addRow(new Object[]{"P001", "B001", "1,000,000 VND", "2025-07-01", "Paid"});
        tableModel.addRow(new Object[]{"P002", "B002", "500,000 VND", "2025-07-10", "Pending"});
    }

    private void searchPayment() {
        String keyword = searchField.getText().trim();
        if (keyword.isEmpty()) {
            loadPaymentData();
            return;
        }
        // TODO: tìm kiếm thanh toán
        JOptionPane.showMessageDialog(this, "Tìm kiếm thanh toán: " + keyword);
    }

    private void addPayment() {
        JOptionPane.showMessageDialog(this, "Mở form thêm thanh toán (chưa cài đặt)");
    }

    private void editPayment() {
        int selectedRow = paymentTable.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn thanh toán để sửa");
            return;
        }
        String paymentId = (String) tableModel.getValueAt(selectedRow, 0);
        JOptionPane.showMessageDialog(this, "Mở form sửa thanh toán " + paymentId + " (chưa cài đặt)");
    }

    private void deletePayment() {
        int selectedRow = paymentTable.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn thanh toán để xóa");
            return;
        }
        String paymentId = (String) tableModel.getValueAt(selectedRow, 0);
        int confirm = JOptionPane.showConfirmDialog(this, "Bạn có chắc muốn xóa thanh toán " + paymentId + "?", "Xác nhận xóa", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            // TODO: xóa thanh toán thật
            tableModel.removeRow(selectedRow);
            JOptionPane.showMessageDialog(this, "Đã xóa thanh toán " + paymentId);
        }
    }
}
