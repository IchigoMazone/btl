package org.example.view.customer;
import com.formdev.flatlaf.FlatLightLaf;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class CustomerMainFrame extends JFrame {

    private JPanel contentPanel;
    private CardLayout cardLayout;
    private JButton selectedButton;

    public CustomerMainFrame() {
        // Look and Feel
        try {
            UIManager.setLookAndFeel(new FlatLightLaf());
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        setTitle("Hệ thống đặt phòng khách sạn - Khách hàng");
        setSize(1200, 800);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // CardLayout trung tâm
        cardLayout = new CardLayout();
        contentPanel = new JPanel(cardLayout);

        // Thêm các panel
        contentPanel.add(new CustomerRoomViewPanel(), "Dashboard"); // Dùng chung panel 30 phòng
        contentPanel.add(new SearchPanel(), "Search");
        contentPanel.add(new BookingPanel(), "Booking");
        contentPanel.add(new MyBookingsPanel(), "MyBookings");

        add(contentPanel, BorderLayout.CENTER);

        // Toolbar dọc bên trái
        JToolBar toolbar = new JToolBar(JToolBar.VERTICAL);
        toolbar.setFloatable(false);
        toolbar.setBackground(new Color(0x34495e));
        toolbar.setPreferredSize(new Dimension(240, 800));

        // Tạo nút
        JButton btnDashboard = createToolbarButton("Trang chủ", "Dashboard");
        JButton btnSearch = createToolbarButton("Tìm kiếm", "Search");
        JButton btnBooking = createToolbarButton("Đặt phòng", "Booking");
        JButton btnMyBookings = createToolbarButton("Danh sách", "MyBookings");
        JButton btnLogout = createToolbarButton("Đăng xuất", null);

        // Mặc định Trang chủ được chọn
        selectedButton = btnDashboard;
        btnDashboard.setForeground(new Color(0xf1c40f));

        // Thêm nút vào toolbar
        toolbar.add(Box.createVerticalStrut(30));
        toolbar.add(btnDashboard);
        toolbar.add(Box.createVerticalStrut(20));
        toolbar.add(btnSearch);
        toolbar.add(Box.createVerticalStrut(20));
        toolbar.add(btnBooking);
        toolbar.add(Box.createVerticalStrut(20));
        toolbar.add(btnMyBookings);
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
            CustomerMainFrame frame = new CustomerMainFrame();
            frame.setVisible(true);
        });
    }
}
