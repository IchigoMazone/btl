package org.example.view.admin;

import javax.swing.*;
import java.awt.*;

public class PaymentManagementPanel extends JPanel {

    public PaymentManagementPanel() {
        setLayout(new BorderLayout());

        JLabel title = new JLabel("Quản lý Thanh Toán", SwingConstants.CENTER);
        title.setFont(new Font("Segoe UI", Font.BOLD, 24));
        title.setForeground(new Color(0x2c3e50));

        JTextArea infoArea = new JTextArea("Danh sách hóa đơn và thanh toán sẽ hiển thị ở đây.");
        infoArea.setEditable(false);
        infoArea.setFont(new Font("Segoe UI", Font.PLAIN, 16));

        add(title, BorderLayout.NORTH);
        add(new JScrollPane(infoArea), BorderLayout.CENTER);
    }
}
