package org.example.views;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class GuestManagementPanel extends JPanel {
    private JTable guestTable;
    private DefaultTableModel tableModel;
    private JButton btnAdd, btnEdit, btnDelete, btnSearch;
    private JTextField searchField;

    public GuestManagementPanel() {
        setLayout(new BorderLayout());

        String[] columns = {"Guest ID", "Tên khách", "Số điện thoại", "Email"};
        tableModel = new DefaultTableModel(columns, 0);
        guestTable = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(guestTable);

        JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        searchField = new JTextField(20);
        btnSearch = new JButton("Tìm kiếm");
        topPanel.add(new JLabel("Tìm kiếm khách:"));
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

        loadGuestData();

        btnSearch.addActionListener(e -> searchGuest());
        btnAdd.addActionListener(e -> addGuest());
        btnEdit.addActionListener(e -> editGuest());
        btnDelete.addActionListener(e -> deleteGuest());
    }

    private void loadGuestData() {
        // TODO: load dữ liệu khách
        tableModel.setRowCount(0);
        tableModel.addRow(new Object[]{"G001", "Nguyen Van A", "0123456789", "a@example.com"});
        tableModel.addRow(new Object[]{"G002", "Tran Thi B", "0987654321", "b@example.com"});
    }

    private void searchGuest() {
        String keyword = searchField.getText().trim();
        if (keyword.isEmpty()) {
            loadGuestData();
            return;
        }
        // TODO: tìm kiếm khách
        JOptionPane.showMessageDialog(this, "Tìm kiếm khách: " + keyword);
    }

    private void addGuest() {
        JOptionPane.showMessageDialog(this, "Mở form thêm khách (chưa cài đặt)");
    }

    private void editGuest() {
        int selectedRow = guestTable.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn khách để sửa");
            return;
        }
        String guestId = (String) tableModel.getValueAt(selectedRow, 0);
        JOptionPane.showMessageDialog(this, "Mở form sửa khách " + guestId + " (chưa cài đặt)");
    }

    private void deleteGuest() {
        int selectedRow = guestTable.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn khách để xóa");
            return;
        }
        String guestId = (String) tableModel.getValueAt(selectedRow, 0);
        int confirm = JOptionPane.showConfirmDialog(this, "Bạn có chắc muốn xóa khách " + guestId + "?", "Xác nhận xóa", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            // TODO: xóa khách thật
            tableModel.removeRow(selectedRow);
            JOptionPane.showMessageDialog(this, "Đã xóa khách " + guestId);
        }
    }
}
