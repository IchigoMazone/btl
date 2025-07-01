package org.example.controller;
import org.example.view.LoginView;
import org.example.view.AdminView;
import javax.swing.Timer;

public class AdminController {
    public static void Logout(AdminView view) {
        Timer timer = new Timer(1000, e -> {
            view.dispose();
            new LoginView().setVisible(true);
        });
        timer.setRepeats(false);
        timer.start();
    }
}
