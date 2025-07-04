
package org.example.views;
import javax.swing.*;
import java.awt.*;

public class PaymentManagementPanel extends JPanel {
    public PaymentManagementPanel() {
        setLayout(new BorderLayout());
        JLabel label = new JLabel("Quản lý thanh toán", SwingConstants.CENTER);
        label.setFont(new Font("Segoe UI", Font.BOLD, 24));
        add(label, BorderLayout.CENTER);

        // TODO: Thêm bảng thanh toán, xử lý phiếu thu, lịch sử giao dịch
    }
}
