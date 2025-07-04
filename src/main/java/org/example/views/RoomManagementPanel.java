
package org.example.views;
import javax.swing.*;
import java.awt.*;

public class RoomManagementPanel extends JPanel {
    public RoomManagementPanel() {
        setLayout(new BorderLayout());
        JLabel label = new JLabel("Quản lý phòng", SwingConstants.CENTER);
        label.setFont(new Font("Segoe UI", Font.BOLD, 24));
        add(label, BorderLayout.CENTER);

        // TODO: Thêm bảng quản lý phòng, các nút thêm sửa xóa ở đây
    }
}
