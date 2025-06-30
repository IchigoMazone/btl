package org.example.controller;
import org.example.action.CheckLogin;
import org.example.entity.User;
import org.example.view.LoginView;
import org.example.view.RegisterView;

import javax.swing.*;

public class LoginController {

    public static void handleLogin(LoginView view) {
        User user = view.getUser();

        JLabel lblInfor = view.getLblInfor();

        if (user.getUserName().equals("admin") && user.getPassword().equals("123456")) {
            lblInfor.setText("Đăng nhập với quyền Admin");
        } else if (CheckLogin.checkUser("userinfos.xml", user.getUserName(), user.getPassword())) {
            lblInfor.setText("Đăng nhập với quyền User.");
        } else {
            lblInfor.setText("Tài khoản hoặc mật khẩu không chính xác.");
        }

        int width = lblInfor.getFontMetrics(lblInfor.getFont()).stringWidth(lblInfor.getText());
        lblInfor.setBounds(600 - width / 2, 670, width, 30);
    }

    public static void openRegister(LoginView view) {
        view.dispose();
        new RegisterView().setVisible(true);
    }
}
