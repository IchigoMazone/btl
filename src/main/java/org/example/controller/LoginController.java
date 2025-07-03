package org.example.controller;

import org.example.action.CheckLogin;
import org.example.entity.User;
import org.example.view.AdminView;
import org.example.view.UserView;
import org.example.view.RegisterView;
import org.example.view.LoginView;
import org.example.view.AccountView;

import javax.swing.Timer;

public class LoginController {

    public static void handleLogin(LoginView view) {
        User user = view.getUser();
        String error = CheckLogin.checkUser("userinfos.xml", user.getUserName(), user.getPassword());

        if (user.getUserName().equals("admin") && user.getPassword().equals("123456")) {
            Timer timer = new Timer(1000, e -> {
                view.dispose();
                new AdminView().setVisible(true);
            });
            timer.setRepeats(false);
            timer.start();
        }

        else if (error != null) {
            view.showError(error);
        }

        else {
            Timer timer = new Timer(1000, e -> {
                view.dispose();
                new UserView().setVisible(true);
            });
            timer.setRepeats(false);
            timer.start();
        }
    }

    public static void openRegister(LoginView view) {
        Timer timer = new Timer(1000, e -> {
            view.dispose();
            new RegisterView().setVisible(true);
        });
        timer.setRepeats(false);
        timer.start();
    }

    // Mở trang Quên mật khẩu
    public static void openForgotPassword(LoginView view) {
        Timer timer = new Timer(500, e -> {
            view.dispose();
            new AccountView().setVisible(true);
        });
        timer.setRepeats(false);
        timer.start();
    }
}
