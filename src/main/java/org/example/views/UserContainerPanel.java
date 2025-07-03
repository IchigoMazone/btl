package org.example.views;

import javax.swing.*;
import java.awt.*;

public class UserContainerPanel extends JPanel {
    private MainFrame mainFrame;
    private CardLayout userCardLayout;
    private JPanel userPanelContainer;

    // Giả lập các panel user
    private JPanel bookingPanel;
    private JPanel myBookingsPanel;
    private JPanel userRoomViewPanel;
    private JPanel searchPanel;

    public UserContainerPanel(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
        setLayout(new BorderLayout());

        userCardLayout = new CardLayout();
        userPanelContainer = new JPanel(userCardLayout);

        // Sử dụng JPanel chứa JLabel thay vì JLabel trực tiếp
        bookingPanel = createPlaceholderPanel("Đặt phòng");
        myBookingsPanel = createPlaceholderPanel("Lịch sử đặt phòng");
        userRoomViewPanel = createPlaceholderPanel("Xem danh sách phòng");
        searchPanel = createPlaceholderPanel("Tìm kiếm phòng");

        userPanelContainer.add(bookingPanel, "BOOKING");
        userPanelContainer.add(myBookingsPanel, "MY_BOOKINGS");
        userPanelContainer.add(userRoomViewPanel, "ROOM_VIEW");
        userPanelContainer.add(searchPanel, "SEARCH");

        add(createSidebar(), BorderLayout.WEST);
        add(userPanelContainer, BorderLayout.CENTER);
    }

    private JPanel createSidebar() {
        JPanel sidebar = new JPanel(new GridLayout(5, 1, 0, 10));
        sidebar.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JButton btnBooking = new JButton("Đặt phòng");
        JButton btnMyBookings = new JButton("Lịch sử đặt phòng");
        JButton btnRoomView = new JButton("Xem phòng");
        JButton btnSearch = new JButton("Tìm kiếm");
        JButton btnLogout = new JButton("Đăng xuất");

        btnBooking.addActionListener(e -> userCardLayout.show(userPanelContainer, "BOOKING"));
        btnMyBookings.addActionListener(e -> userCardLayout.show(userPanelContainer, "MY_BOOKINGS"));
        btnRoomView.addActionListener(e -> userCardLayout.show(userPanelContainer, "ROOM_VIEW"));
        btnSearch.addActionListener(e -> userCardLayout.show(userPanelContainer, "SEARCH"));
        btnLogout.addActionListener(e -> mainFrame.showLoginPanel());

        sidebar.add(btnBooking);
        sidebar.add(btnMyBookings);
        sidebar.add(btnRoomView);
        sidebar.add(btnSearch);
        sidebar.add(btnLogout);

        return sidebar;
    }

    /**
     * Tạo panel tạm thời với JLabel hiển thị trung tâm
     */
    private JPanel createPlaceholderPanel(String title) {
        JPanel panel = new JPanel(new BorderLayout());
        JLabel label = new JLabel(title, SwingConstants.CENTER);
        label.setFont(new Font("Arial", Font.BOLD, 20));
        panel.add(label, BorderLayout.CENTER);
        return panel;
    }

    public void loadData(String username) {
        // TODO: Load dữ liệu người dùng nếu cần
        System.out.println("User container loaded for: " + username);
        userCardLayout.show(userPanelContainer, "BOOKING");
    }
}
