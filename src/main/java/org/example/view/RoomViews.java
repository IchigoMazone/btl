package org.example.view;

import com.formdev.flatlaf.FlatLightLaf;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class RoomViews extends JFrame {
    private JButton selectedButton;

    public RoomViews() {
        try {
            UIManager.setLookAndFeel(new FlatLightLaf());
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        setTitle("Quản lý Phòng Khách Sạn");
        setSize(1200, 800);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        // Toolbar
        JToolBar toolbar = createToolbar();
        add(toolbar);

        // Panel chứa các nút phòng
        JPanel roomPanel = new JPanel(new GridLayout(5, 6, 10, 10));
        roomPanel.setBounds(260, 20, 900, 500);
        roomPanel.setBackground(Color.WHITE);

        // Thêm 30 phòng
        for (int i = 0; i < 30; i++) {
            int row = i / 6 + 1;
            int col = i % 6 + 1;
            String roomCode = row + "0" + col;
            JButton btn = new JButton("Phòng " + roomCode);
            btn.setPreferredSize(new Dimension(140, 80));
            btn.setFont(new Font("Segoe UI", Font.PLAIN, 14));

            // Giả lập trạng thái (bạn có thể load từ XML)
            String status;
            if (i % 3 == 0) {
                status = "Có khách";
                btn.setBackground(new Color(0x3498db));
            } else if (i % 3 == 1) {
                status = "Trống";
                btn.setBackground(new Color(0x2ecc71));
            } else {
                status = "Sửa chữa";
                btn.setBackground(new Color(0xe74c3c));
            }
            btn.setOpaque(true);
            btn.setBorderPainted(false);
            btn.setForeground(Color.WHITE);
            btn.addActionListener(e ->
                    JOptionPane.showMessageDialog(this,
                            "Bạn đã chọn phòng " + roomCode + " - Trạng thái: " + status)
            );

            roomPanel.add(btn);
        }

        add(roomPanel);

        // Panel thống kê
        JPanel statsPanel = createStatsPanel();
        add(statsPanel);
    }

    private JToolBar createToolbar() {
        JToolBar toolbar = new JToolBar(JToolBar.VERTICAL);
        toolbar.setFloatable(false);
        toolbar.setBounds(0, 0, 240, 800);
        toolbar.setBackground(new Color(0x34495e));

        JButton btnHome = createToolbarButton("Trang chủ", () ->
                JOptionPane.showMessageDialog(this, "Bạn đang ở Trang chủ.")
        );
        JButton btnRoom = createToolbarButton("Quản lý phòng", () ->
                JOptionPane.showMessageDialog(this, "Quản lý phòng.")
        );
        JButton btnGuest = createToolbarButton("Quản lý khách", () ->
                JOptionPane.showMessageDialog(this, "Quản lý khách.")
        );
        JButton btnBooking = createToolbarButton("Đặt phòng", () ->
                JOptionPane.showMessageDialog(this, "Đặt phòng.")
        );
        JButton btnLogout = createToolbarButton("Đăng xuất", () -> {
            dispose();
            JOptionPane.showMessageDialog(null, "Đăng xuất thành công!");
        });

        selectedButton = btnHome;
        btnHome.setForeground(new Color(0xf1c40f));

        toolbar.add(Box.createVerticalStrut(30));
        toolbar.add(btnHome);
        toolbar.add(Box.createVerticalStrut(20));
        toolbar.add(btnRoom);
        toolbar.add(Box.createVerticalStrut(20));
        toolbar.add(btnGuest);
        toolbar.add(Box.createVerticalStrut(20));
        toolbar.add(btnBooking);
        toolbar.add(Box.createVerticalStrut(20));
        toolbar.add(btnLogout);

        return toolbar;
    }

    private JButton createToolbarButton(String text, Runnable action) {
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
            action.run();
        });

        return btn;
    }

    private JPanel createStatsPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBounds(760, 550, 400, 200);
        panel.setBackground(new Color(0xecf0f1));
        panel.setBorder(BorderFactory.createTitledBorder("Thống kê phòng"));

        panel.add(createStatRow("Phòng trống", new Color(0x2ecc71), 10));
        panel.add(createStatRow("Có khách", new Color(0x3498db), 12));
        panel.add(createStatRow("Sửa chữa", new Color(0xe74c3c), 8));

        return panel;
    }

    private JPanel createStatRow(String label, Color color, int count) {
        JPanel row = new JPanel(new FlowLayout(FlowLayout.LEFT));
        row.setOpaque(false);

        JLabel colorBox = new JLabel();
        colorBox.setOpaque(true);
        colorBox.setBackground(color);
        colorBox.setPreferredSize(new Dimension(20, 20));

        JLabel text = new JLabel(label + ": " + count);
        text.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        text.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 0));

        row.add(colorBox);
        row.add(text);

        return row;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new RoomViews().setVisible(true));
    }
}
