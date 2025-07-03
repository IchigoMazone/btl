package org.example.panel;
import com.formdev.flatlaf.FlatLightLaf;
import javax.swing.UIManager;

public class AppLaucher {
    public static void main(String[] args) {
        try {
            FlatLightLaf.setup();
            UIManager.put("TextComponent.arc", 5);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        new MainFrame().setVisible(true);
    }
}
