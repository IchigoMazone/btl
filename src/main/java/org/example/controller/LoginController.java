package org.example.controller;
import org.example.action.CheckLogin;
import org.example.entity.User;
import org.example.view.LoginView;
import org.example.view.RegisterView;

import javax.swing.*;

public class LoginController {

    public static void handleLogin(LoginView view) {
        User user = view.getUser();

        //JLabel lblInfor = view.getLblInfor();
        String error = CheckLogin.checkUser("userinfos.xml", user.getUserName(), user.getPassword());

        if (user.getUserName().equals("admin") && user.getPassword().equals("123456")) {
            //lblInfor.setText("Đăng nhập với quyền Admin");
            view.showError("Đăng nhập với quyền Admin");
        }

        else if (error != null) {
            view.showError(error);
        }

        else {
            view.showError("Đăng nhập với quyền User");
        }
    }

    public static void openRegister(LoginView view) {
        view.dispose();
        new RegisterView().setVisible(true);
    }
}
