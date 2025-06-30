package org.example.action;
import org.example.entity.UserInfo;
import org.example.service.UserInfoService;
import java.util.List;

public class CheckLogin {
    public static boolean checkUser(String fileName, String username, String password) {
        List<UserInfo> list = UserInfoService.readAllUsers(fileName);
        if (list.isEmpty()) {
            return false;
        }
        for (UserInfo info : list) {
            if (info.getUser().getUserName().equals(username)
                    && info.getUser().getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }
}
