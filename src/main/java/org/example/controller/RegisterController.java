package org.example.controller;
import org.example.action.CheckRegister;
import org.example.entity.UserInfo;
import org.example.service.UserInfoService;
import org.example.view.RegisterFinishView;
import org.example.view.RegisterView;
import javax.swing.Timer;

public class RegisterController {
    public static void handleRegister(RegisterView view) {
        UserInfo info = view.getUserInfo();
        String fullName = info.getFullName();
        String userName = info.getUserName();
        String password = info.getPassword();
        String email = info.getEmail();
        String phone = info.getPhoneNumber();
        String confirmPassword = view.getConfirmPassword();
        String error = CheckRegister.checkRegis(fullName, userName, password, email, phone, confirmPassword);

        if (error != null) {
            view.showError(error);
        } else {
            UserInfoService.saveUser(info, "userinfos.xml");
            Timer timer = new Timer(1000, e -> {
                view.dispose();
                new RegisterFinishView().setVisible(true);
            });
            timer.setRepeats(false);
            timer.start();
        }
    }
}
