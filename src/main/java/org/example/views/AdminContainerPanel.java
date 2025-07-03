package org.example.views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AdminContainerPanel extends JPanel {

    private MainFrame mainFrame;
    private CardLayout cardLayout;
    private JPanel contentPanel;
    private JButton selectedButton;
    private JLabel userLabel;  // Label hiển thị tên người dùng

    public AdminContainerPanel(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
        setLayout(new BorderLayout());

        cardLayout = new CardLayout();
        contentPanel = new JPanel(cardLayout);

        // Thêm các panel con
        contentPanel.add(new DashboardAdminPanel(), "Dashboard");
        contentPanel.add(new RoomManagementPanel(), "Room");
        contentPanel.add(new BookingManagementPanel(), "Booking");
        contentPanel.add(new GuestManagementPanel(), "Guest");
        contentPanel.add(new PaymentManagementPanel(), "Payment");

        add(contentPanel, BorderLayout.CENTER);

        // Toolbar bên trái
        JToolBar toolbar = new JToolBar(JToolBar.VERTICAL);
        toolbar.setFloatable(false);
        toolbar.setBackground(new Color(0x2c3e50));
        toolbar.setPreferredSize(new Dimension(240, 800));
        toolbar.setLayout(new BoxLayout(toolbar, BoxLayout.Y_AXIS));

        // Label chào người dùng
        userLabel = new JLabel(" ");
        userLabel.setForeground(Color.WHITE);
        userLabel.setFont(new Font("Segoe UI", Font.BOLD, 14));
        userLabel.setMaximumSize(new Dimension(Integer.MAX_VALUE, 30));
        userLabel.setHorizontalAlignment(SwingConstants.CENTER);
        userLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        toolbar.add(Box.createVerticalStrut(20));
        toolbar.add(userLabel);
        toolbar.add(Box.createVerticalStrut(30));

        // Các nút menu
        JButton btnDashboard = createSidebarButton("Trang chủ", "Dashboard");
        JButton btnRoom = createSidebarButton("Quản lý phòng", "Room");
        JButton btnBooking = createSidebarButton("Quản lý đặt phòng", "Booking");
        JButton btnGuest = createSidebarButton("Quản lý khách", "Guest");
        JButton btnPayment = createSidebarButton("Thanh toán", "Payment");
        JButton btnLogout = createSidebarButton("Đăng xuất", null); // null dùng để xử lý logout riêng

        selectedButton = btnDashboard;
        btnDashboard.setForeground(new Color(0xf1c40f));

        toolbar.add(btnDashboard);
        toolbar.add(Box.createVerticalStrut(20));
        toolbar.add(btnRoom);
        toolbar.add(Box.createVerticalStrut(20));
        toolbar.add(btnBooking);
        toolbar.add(Box.createVerticalStrut(20));
        toolbar.add(btnGuest);
        toolbar.add(Box.createVerticalStrut(20));
        toolbar.add(btnPayment);
        toolbar.add(Box.createVerticalGlue()); // Đẩy nút logout xuống dưới
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
                // Chuyển tới panel tương ứng
                cardLayout.show(contentPanel, cardName);
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
        System.out.println("Load dữ liệu cho admin: " + username);
        userLabel.setText("Xin chào, " + username + "!");
        cardLayout.show(contentPanel, "Dashboard");
    }
}
