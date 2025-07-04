
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
