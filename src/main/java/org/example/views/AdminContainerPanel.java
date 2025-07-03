package org.example.views;

import javax.swing.*;
import java.awt.*;

public class AdminContainerPanel extends JPanel {
    private MainFrame mainFrame;
    private CardLayout adminCardLayout;
    private JPanel adminPanelContainer;

    // Giả lập các panel admin (bạn nên thay thế bằng panel thực tế sau)
    private JPanel bookingManagementPanel;
    private JPanel guestManagementPanel;
    private JPanel paymentManagementPanel;
    private JPanel roomManagementPanel;
    private JPanel adminRoomViewPanel;

    public AdminContainerPanel(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
        setLayout(new BorderLayout());

        // Tạo container panel admin với CardLayout
        adminCardLayout = new CardLayout();
        adminPanelContainer = new JPanel(adminCardLayout);

        // Khởi tạo các panel admin đúng cách (dùng JPanel thay vì JLabel)
        bookingManagementPanel = createPlaceholderPanel("Quản lý đặt phòng");
        guestManagementPanel = createPlaceholderPanel("Quản lý khách hàng");
        paymentManagementPanel = createPlaceholderPanel("Quản lý thanh toán");
        roomManagementPanel = createPlaceholderPanel("Quản lý phòng");
        adminRoomViewPanel = createPlaceholderPanel("Xem danh sách phòng");

        // Thêm vào container với tên để điều hướng
        adminPanelContainer.add(bookingManagementPanel, "BOOKING");
        adminPanelContainer.add(guestManagementPanel, "GUEST");
        adminPanelContainer.add(paymentManagementPanel, "PAYMENT");
        adminPanelContainer.add(roomManagementPanel, "ROOM");
        adminPanelContainer.add(adminRoomViewPanel, "ROOM_VIEW");

        // Bố cục trái phải
        add(createSidebar(), BorderLayout.WEST);
        add(adminPanelContainer, BorderLayout.CENTER);
    }

    private JPanel createSidebar() {
        JPanel sidebar = new JPanel(new GridLayout(6, 1, 0, 10));
        sidebar.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JButton btnBooking = new JButton("Quản lý đặt phòng");
        JButton btnGuest = new JButton("Quản lý khách");
        JButton btnPayment = new JButton("Quản lý thanh toán");
        JButton btnRoom = new JButton("Quản lý phòng");
        JButton btnRoomView = new JButton("Xem phòng");
        JButton btnLogout = new JButton("Đăng xuất");

        btnBooking.addActionListener(e -> adminCardLayout.show(adminPanelContainer, "BOOKING"));
        btnGuest.addActionListener(e -> adminCardLayout.show(adminPanelContainer, "GUEST"));
        btnPayment.addActionListener(e -> adminCardLayout.show(adminPanelContainer, "PAYMENT"));
        btnRoom.addActionListener(e -> adminCardLayout.show(adminPanelContainer, "ROOM"));
        btnRoomView.addActionListener(e -> adminCardLayout.show(adminPanelContainer, "ROOM_VIEW"));
        btnLogout.addActionListener(e -> mainFrame.showLoginPanel());

        sidebar.add(btnBooking);
        sidebar.add(btnGuest);
        sidebar.add(btnPayment);
        sidebar.add(btnRoom);
        sidebar.add(btnRoomView);
        sidebar.add(btnLogout);

        return sidebar;
    }

    /**
     * Tạo panel placeholder với nội dung hiển thị ở giữa màn hình
     */
    private JPanel createPlaceholderPanel(String title) {
        JPanel panel = new JPanel(new BorderLayout());
        JLabel label = new JLabel(title, SwingConstants.CENTER);
        label.setFont(new Font("Arial", Font.BOLD, 20));
        panel.add(label, BorderLayout.CENTER);
        return panel;
    }

    public void loadData(String username) {
        // TODO: load dữ liệu thật từ DB, file, ...
        System.out.println("Admin container loaded for: " + username);
        adminCardLayout.show(adminPanelContainer, "BOOKING");
    }
}
