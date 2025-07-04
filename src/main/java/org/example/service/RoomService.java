package org.example.service;

import org.example.entity.Room;
import org.example.entity.RoomXML;
import org.example.utils.FileUtils;

import java.util.ArrayList;
import java.util.List;

public class RoomService {

    // Đọc toàn bộ danh sách phòng từ file XML
    public static List<Room> readAllRooms(String fileName) {
        RoomXML data = (RoomXML) FileUtils.readXMLFile(fileName, RoomXML.class);
        if (data != null && data.getRoom() != null) {
            return data.getRoom();
        } else {
            return new ArrayList<>();
        }
    }

    // Lưu danh sách phòng mới (ghi đè toàn bộ)
    public static void writeAllRooms(String fileName, List<Room> rooms) {
        RoomXML wrapper = new RoomXML();
        wrapper.setRoom(rooms);
        FileUtils.writeXMLtoFile(fileName, wrapper);
    }

    // Cập nhật trạng thái phòng theo số phòng
    public static void updateRoomStatus(String fileName, int roomNumber, String newStatus) {
        RoomXML data = (RoomXML) FileUtils.readXMLFile(fileName, RoomXML.class);
        if (data != null && data.getRoom() != null) {
            for (Room room : data.getRoom()) {
                if (room.getRoomNumber() == roomNumber) {
                    room.setStatus(newStatus);
                    break;
                }
            }
            FileUtils.writeXMLtoFile(fileName, data);
        }
    }

    // Tìm phòng theo trạng thái (Trống, Có khách, Sửa chữa)
    public static List<Room> findRoomsByStatus(String fileName, String status) {
        List<Room> all = readAllRooms(fileName);
        List<Room> result = new ArrayList<>();
        for (Room room : all) {
            if (room.getStatus().equalsIgnoreCase(status)) {
                result.add(room);
            }
        }
        return result;
    }

    // Đếm số phòng theo trạng thái
    public static int countRoomsByStatus(String fileName, String status) {
        return (int) readAllRooms(fileName).stream()
                .filter(room -> room.getStatus().equalsIgnoreCase(status))
                .count();
    }
}
