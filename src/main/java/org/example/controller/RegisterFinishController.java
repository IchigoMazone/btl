package org.example.controller;
import org.example.view.LoginView;
import org.example.view.RegisterFinishView;

public class RegisterFinishController {
    public static void openLogin(RegisterFinishView view) {
        view.dispose();
        new LoginView().setVisible(true);
    }
}
