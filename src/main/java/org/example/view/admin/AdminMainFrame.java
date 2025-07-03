package org.example.view.admin;

import com.formdev.flatlaf.FlatLightLaf;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AdminMainFrame extends JFrame {

    private JPanel contentPanel;
    private CardLayout cardLayout;
    private JButton selectedButton;

    public AdminMainFrame() {
        // Set Look & Feel
        try {
            UIManager.setLookAndFeel(new FlatLightLaf());
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        setTitle("Hệ thống quản lý khách sạn - Admin");
        setSize(1200, 800);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // CardLayout trung tâm
        cardLayout = new CardLayout();
        contentPanel = new JPanel(cardLayout);

        // Thêm các panel
        contentPanel.add(new AdminRoomViewPanel(), "Dashboard");
        contentPanel.add(new RoomManagementPanel(), "Room");
        contentPanel.add(new BookingManagementPanel(), "Booking");
        contentPanel.add(new GuestManagementPanel(), "Guest");
        contentPanel.add(new PaymentManagementPanel(), "Payment");

        add(contentPanel, BorderLayout.CENTER);

        // Toolbar dọc bên trái
        JToolBar toolbar = new JToolBar(JToolBar.VERTICAL);
        toolbar.setFloatable(false);
        toolbar.setBackground(new Color(0x2c3e50));
        toolbar.setPreferredSize(new Dimension(240, 800));

        // Tạo các nút
        JButton btnDashboard = createToolbarButton("Trang chủ", "Dashboard");
        JButton btnRoom = createToolbarButton("Quản lý phòng", "Room");
        JButton btnBooking = createToolbarButton("Quản lý đặt phòng", "Booking");
        JButton btnGuest = createToolbarButton("Quản lý khách", "Guest");
        JButton btnPayment = createToolbarButton("Thanh toán", "Payment");
        JButton btnLogout = createToolbarButton("Đăng xuất", null);

        // Mặc định Trang chủ được chọn
        selectedButton = btnDashboard;
        btnDashboard.setForeground(new Color(0xf1c40f));

        // Thêm nút vào toolbar
        toolbar.add(Box.createVerticalStrut(30));
        toolbar.add(btnDashboard);
        toolbar.add(Box.createVerticalStrut(20));
        toolbar.add(btnRoom);
        toolbar.add(Box.createVerticalStrut(20));
        toolbar.add(btnBooking);
        toolbar.add(Box.createVerticalStrut(20));
        toolbar.add(btnGuest);
        toolbar.add(Box.createVerticalStrut(20));
        toolbar.add(btnPayment);
        toolbar.add(Box.createVerticalStrut(20));
        toolbar.add(btnLogout);

        add(toolbar, BorderLayout.WEST);
    }

    private JButton createToolbarButton(String text, String cardName) {
        JButton btn = new JButton(text);
        btn.setFocusable(false);
        btn.setFont(new Font("Segoe UI", Font.BOLD, 16));
        btn.setForeground(Color.WHITE);
        btn.setContentAreaFilled(false);
        btn.setBorder(BorderFactory.createEmptyBorder());
        btn.setHorizontalAlignment(SwingConstants.LEFT);
        btn.setMargin(new Insets(10, 20, 10, 20));
        btn.setPreferredSize(new Dimension(220, 50));

        btn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                btn.setForeground(new Color(0xf1c40f));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                if (btn == selectedButton) {
                    btn.setForeground(new Color(0xf1c40f));
                } else {
                    btn.setForeground(Color.WHITE);
                }
            }
        });

        btn.addActionListener(e -> {
            if (selectedButton != null) {
                selectedButton.setForeground(Color.WHITE);
            }
            selectedButton = btn;
            btn.setForeground(new Color(0xf1c40f));

            if (cardName != null) {
                cardLayout.show(contentPanel, cardName);
            } else {
                dispose();
                JOptionPane.showMessageDialog(null, "Đăng xuất thành công!");
            }
        });

        return btn;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            AdminMainFrame frame = new AdminMainFrame();
            frame.setVisible(true);
        });
    }
}
