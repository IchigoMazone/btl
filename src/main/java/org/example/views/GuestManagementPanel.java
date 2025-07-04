
package org.example.views;
import javax.swing.*;
import java.awt.*;

public class GuestManagementPanel extends JPanel {
    public GuestManagementPanel() {
        setLayout(new BorderLayout());
        JLabel label = new JLabel("Quản lý khách hàng", SwingConstants.CENTER);
        label.setFont(new Font("Segoe UI", Font.BOLD, 24));
        add(label, BorderLayout.CENTER);

        // TODO: Thêm bảng thông tin khách hàng, tìm kiếm khách, chỉnh sửa
    }
}
