package org.example.views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class UserContainerPanel extends JPanel {
    private MainFrame mainFrame;
    private CardLayout userCardLayout;
    private JPanel userPanelContainer;
    private JButton selectedButton;
    private JLabel userLabel; // Label hiển thị tên người dùng

    public UserContainerPanel(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
        setLayout(new BorderLayout());

        userCardLayout = new CardLayout();
        userPanelContainer = new JPanel(userCardLayout);

        // Thêm các panel người dùng
        userPanelContainer.add(new DashboardCustomerPanel(), "DASHBOARD");
        userPanelContainer.add(new BookingPanel(), "BOOKING");
        userPanelContainer.add(new MyBookingsPanel(), "MY_BOOKINGS");
        userPanelContainer.add(new SearchPanel(), "SEARCH");

        add(userPanelContainer, BorderLayout.CENTER);

        // Tạo toolbar bên trái
        JToolBar toolbar = new JToolBar(JToolBar.VERTICAL);
        toolbar.setFloatable(false);
        toolbar.setBackground(new Color(0x2c3e50));
        toolbar.setPreferredSize(new Dimension(240, 800));
        toolbar.setLayout(new BoxLayout(toolbar, BoxLayout.Y_AXIS));

        // Label hiển thị tên người dùng
        userLabel = new JLabel(" ");
        userLabel.setForeground(Color.WHITE);
        userLabel.setFont(new Font("Segoe UI", Font.BOLD, 14));
        userLabel.setMaximumSize(new Dimension(Integer.MAX_VALUE, 30));
        userLabel.setHorizontalAlignment(SwingConstants.CENTER);
        userLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        toolbar.add(Box.createVerticalStrut(20));
        toolbar.add(userLabel); // Thêm tên người dùng vào đầu sidebar
        toolbar.add(Box.createVerticalStrut(30));

        // Các nút sidebar
        JButton btnDashboard = createSidebarButton("Trang chủ", "DASHBOARD");
        JButton btnBooking = createSidebarButton("Đặt phòng", "BOOKING");
        JButton btnMyBookings = createSidebarButton("Lịch sử đặt phòng", "MY_BOOKINGS");
        JButton btnSearch = createSidebarButton("Tìm kiếm", "SEARCH");
        JButton btnLogout = createSidebarButton("Đăng xuất", null); // null để xử lý logout riêng

        selectedButton = btnDashboard;
        btnDashboard.setForeground(new Color(0xf1c40f));

        toolbar.add(btnDashboard);
        toolbar.add(Box.createVerticalStrut(20));
        toolbar.add(btnBooking);
        toolbar.add(Box.createVerticalStrut(20));
        toolbar.add(btnMyBookings);
        toolbar.add(Box.createVerticalStrut(20));
        toolbar.add(btnSearch);
        toolbar.add(Box.createVerticalGlue());
        toolbar.add(btnLogout);
        toolbar.add(Box.createVerticalStrut(20));

        add(toolbar, BorderLayout.WEST);
    }

    private JButton createSidebarButton(String text, String cardName) {
        JButton btn = new JButton(text);
        btn.setFont(new Font("Segoe UI", Font.BOLD, 16));
        btn.setForeground(Color.WHITE);
        btn.setContentAreaFilled(false);
        btn.setBorderPainted(false);
        btn.setFocusPainted(false);
        btn.setHorizontalAlignment(SwingConstants.LEFT);
        btn.setMargin(new Insets(10, 20, 10, 20));
        btn.setPreferredSize(new Dimension(220, 50));

        Color hoverColor = new Color(0xf1c40f);
        Color normalColor = Color.WHITE;

        btn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                btn.setForeground(hoverColor);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                if (btn == selectedButton) {
                    btn.setForeground(hoverColor);
                } else {
                    btn.setForeground(normalColor);
                }
            }
        });

        btn.addActionListener(e -> {
            if (selectedButton != null) {
                selectedButton.setForeground(normalColor);
            }
            selectedButton = btn;
            btn.setForeground(hoverColor);

            if (cardName != null) {
                userCardLayout.show(userPanelContainer, cardName);
            } else {
                // Xử lý đăng xuất
                int confirm = JOptionPane.showConfirmDialog(
                        this,
                        "Bạn có chắc chắn muốn đăng xuất?",
                        "Xác nhận đăng xuất",
                        JOptionPane.YES_NO_OPTION
                );
                if (confirm == JOptionPane.YES_OPTION) {
                    JOptionPane.showMessageDialog(this, "Đăng xuất thành công!");
                    mainFrame.showLoginPanel();
                } else {
                    btn.setForeground(normalColor);
                    selectedButton = null;
                }
            }
        });

        return btn;
    }

    public void loadData(String username) {
        System.out.println("User container loaded for: " + username);
        userLabel.setText("Xin chào, " + username + "!");
        userCardLayout.show(userPanelContainer, "DASHBOARD");
    }
}
