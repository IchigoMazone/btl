package org.example.run;
import com.formdev.flatlaf.FlatLightLaf;
import org.example.view.LoginView;
import javax.swing.UIManager;
import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {
        try {
            FlatLightLaf.setup();
            UIManager.put("TextComponent.arc", 5);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        SwingUtilities.invokeLater(() -> new LoginView().setVisible(true));
    }
}
