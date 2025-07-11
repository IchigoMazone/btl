package org.example.controller;
import org.example.view.LoginView;
import org.example.view.RegisterFinishView;
import javax.swing.Timer;

public class RegisterFinishController {
    public static void openLogin(RegisterFinishView view) {
        Timer timer = new Timer(1000, e -> {
            view.dispose();
            new LoginView().setVisible(true);
        });
        timer.setRepeats(false);
        timer.start();
    }
}
