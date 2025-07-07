package org.example.views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AdminContainerPanel extends JPanel {

    private MainFrame mainFrame;
    private CardLayout adminCardLayout;
    private JPanel adminPanelContainer;
    private JButton selectedButton;
    private JLabel userLabel;

    private DashboardAdminPanel dashboardAdminPanel;

    public AdminContainerPanel(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
        setLayout(new BorderLayout());

        adminCardLayout = new CardLayout();
        adminPanelContainer = new JPanel(adminCardLayout);

        dashboardAdminPanel = new DashboardAdminPanel();

        RoomManagementPanel roomManagementPanel = new RoomManagementPanel(() -> dashboardAdminPanel.reloadRooms());

        adminPanelContainer.add(dashboardAdminPanel, "DASHBOARD");
        adminPanelContainer.add(roomManagementPanel, "ROOM");
        adminPanelContainer.add(new BookingManagementPanel(), "BOOKING");
        adminPanelContainer.add(new GuestManagementPanel(), "GUEST");
        adminPanelContainer.add(new PaymentManagementPanel(), "PAYMENT");

        add(adminPanelContainer, BorderLayout.CENTER);

        JToolBar toolbar = new JToolBar(JToolBar.VERTICAL);
        toolbar.setFloatable(false);
        toolbar.setBackground(new Color(0x2c3e50));
        toolbar.setPreferredSize(new Dimension(240, 800));
        toolbar.setLayout(new BoxLayout(toolbar, BoxLayout.Y_AXIS));

        userLabel = new JLabel(" ");
        userLabel.setForeground(Color.WHITE);
        userLabel.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        userLabel.setMaximumSize(new Dimension(Integer.MAX_VALUE, 30));
        userLabel.setHorizontalAlignment(SwingConstants.CENTER);
        userLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        toolbar.add(Box.createVerticalStrut(20));
        toolbar.add(userLabel);
        toolbar.add(Box.createVerticalStrut(30));

        JButton btnDashboard = createSidebarButton("Trang chủ", "DASHBOARD");
        JButton btnRoom = createSidebarButton("Quản lý phòng", "ROOM");
        JButton btnBooking = createSidebarButton("Quản lý đặt phòng", "BOOKING");
        JButton btnGuest = createSidebarButton("Quản lý khách", "GUEST");
        JButton btnPayment = createSidebarButton("Thanh toán", "PAYMENT");
        JButton btnLogout = createSidebarButton("Thoát", null); // <== đổi từ "Đăng xuất"

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
                if ("DASHBOARD".equals(cardName)) {
                    dashboardAdminPanel.reloadRooms();
                }
                adminCardLayout.show(adminPanelContainer, cardName);
            } else {
                int confirm = JOptionPane.showConfirmDialog(
                        this,
                        "Bạn có chắc chắn muốn thoát?",
                        "Xác nhận thoát", // <== đổi tiêu đề
                        JOptionPane.YES_NO_OPTION
                );
                if (confirm == JOptionPane.YES_OPTION) {
                    JOptionPane.showMessageDialog(this, "Thoát thành công!");
                    mainFrame.showLoginPanel();
                } else {
                    btn.setForeground(normalColor);
                    if (selectedButton != null) selectedButton.setForeground(hoverColor);
                }
            }
        });

        return btn;
    }

    public void loadData(String username) {
        userLabel.setText("Xin chào, " + username + "!");
        dashboardAdminPanel.reloadRooms();
        adminCardLayout.show(adminPanelContainer, "DASHBOARD");
    }
}
