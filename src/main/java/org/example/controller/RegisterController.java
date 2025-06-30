package org.example.controller;
import org.example.action.CheckRegister;
import org.example.entity.UserInfo;
import org.example.service.UserInfoService;
import org.example.view.LoginView;
import org.example.view.RegisterFinishView;
import org.example.view.RegisterView;

public class RegisterController {
    public static void handleRegister(RegisterView view) {
        UserInfo info = view.getUserInfo();
        String fullName = info.getFullName();
        String userName = info.getUser().getUserName();
        String password = info.getUser().getPassword();
        String email = info.getEmail();
        String phone = info.getPhoneNumber();
        String confirmPassword = view.getConfirmPassword();

        String error = CheckRegister.checkRegis(fullName, userName, password, confirmPassword, email, phone);

        if (error != null) {
            view.showError(error);
        } else {
            UserInfoService.saveUser(info, "userinfos.xml");
            view.dispose();
            new RegisterFinishView().setVisible(true);
        }
    }

    public static void handleBack(RegisterView view) {
        view.dispose();
        new LoginView().setVisible(true);
    }
}
