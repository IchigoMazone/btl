package org.example.action;
import org.example.entity.UserInfo;
import org.example.service.UserInfoService;
import java.util.List;

public class CheckLogin {
    public static String checkUser(String fileName, String userName, String password) {
        if (userName.isEmpty() || password.isEmpty()) {
            return "Vui lòng nhập đầy đủ thông tin!";
        }

        String userError = CheckRegister.validateUsername(userName);
        if (userError != null) {
            return userError;
        }

        String passError = CheckRegister.validatePassword(password);
        if (passError != null) {
            return passError;
        }

        List<UserInfo> list = UserInfoService.readAllUsers(fileName);
        if (list.isEmpty()) {
            return "Tài khoản hoặc mật khẩu không chính xác.";
        }

        for (UserInfo info : list) {
            if (info.getUserName().equals(userName)
                    && info.getPassword().equals(password)) {
                return null;
            }
        }
        return "Tài khoản hoặc mật khẩu không chính xác.";
    }
}
