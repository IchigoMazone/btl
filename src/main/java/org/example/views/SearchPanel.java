package org.example.views;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class SearchPanel extends JPanel {
    private JTextField searchField;
    private JButton btnSearch;
    private JTable resultTable;
    private DefaultTableModel tableModel;

    public SearchPanel() {
        setLayout(new BorderLayout());

        JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        searchField = new JTextField(25);
        btnSearch = new JButton("Tìm kiếm");
        topPanel.add(new JLabel("Tìm kiếm phòng:"));
        topPanel.add(searchField);
        topPanel.add(btnSearch);

        String[] columns = {"Room ID", "Loại phòng", "Giá", "Tình trạng"};
        tableModel = new DefaultTableModel(columns, 0);
        resultTable = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(resultTable);

        add(topPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);

        btnSearch.addActionListener(e -> performSearch());
    }

    private void performSearch() {
        String keyword = searchField.getText().trim();
        if (keyword.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập từ khóa tìm kiếm.");
            return;
        }
        // TODO: tìm kiếm phòng theo từ khóa
        tableModel.setRowCount(0);
        // Demo data kết quả
        tableModel.addRow(new Object[]{"R301", "Phòng đơn", "550,000 VND", "Trống"});
        JOptionPane.showMessageDialog(this, "Tìm kiếm với từ khóa: " + keyword);
    }
}
