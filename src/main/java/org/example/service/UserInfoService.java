package org.example.service;

import org.example.entity.UserInfo;
import org.example.entity.UserInfoXML;
import org.example.utils.FileUtils;

import java.util.ArrayList;
import java.util.List;

public class UserInfoService {

    public static void saveUser(UserInfo newUser, String fileName) {
        UserInfoXML data = (UserInfoXML) FileUtils.readXMLFile(fileName, UserInfoXML.class);
        List<UserInfo> list;
        if (data == null || data.getUserInfos() == null) {
            list = new ArrayList<>();
        } else {
            list = data.getUserInfos();
        }
        list.add(newUser);
        UserInfoXML newData = new UserInfoXML();
        newData.setUserInfos(list);
        FileUtils.writeXMLtoFile(fileName, newData);
    }

    public static List<UserInfo> readAllUsers(String fileName) {
        UserInfoXML data = (UserInfoXML) FileUtils.readXMLFile(fileName, UserInfoXML.class);
        if (data != null && data.getUserInfos() != null) {
            return data.getUserInfos();
        } else {
            return new ArrayList<>();
        }
    }

    public static void updatePassword(String fileName, String userName, String newPassword) {
        UserInfoXML data = (UserInfoXML) FileUtils.readXMLFile(fileName, UserInfoXML.class);
        if (data != null && data.getUserInfos() != null) {
            for (UserInfo user : data.getUserInfos()) {
                if (user.getUserName().equals(userName)) {
                    user.setPassword(newPassword);
                    break;
                }
            }
            FileUtils.writeXMLtoFile(fileName, data);
        }
    }
}
