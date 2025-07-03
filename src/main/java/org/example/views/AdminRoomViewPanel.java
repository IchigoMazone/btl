package org.example.views;
import javax.swing.*;
import java.awt.*;

public class AdminRoomViewPanel extends JPanel {

    public AdminRoomViewPanel() {
        setLayout(new BorderLayout());

        JLabel label = new JLabel("Giao diện xem phòng của Admin", SwingConstants.CENTER);
        label.setFont(new Font("Arial", Font.BOLD, 20));
        add(label, BorderLayout.CENTER);

        // TODO: hiện danh sách phòng theo cách khác, ví dụ card view hoặc bảng chi tiết
    }
}
