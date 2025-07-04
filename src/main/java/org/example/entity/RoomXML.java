package org.example.entity;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAccessType;
import java.util.List;

@XmlRootElement(name = "Rooms")
@XmlAccessorType(XmlAccessType.FIELD)
public class RoomXML {

    private List<Room> Room;

    public RoomXML() {}

    public RoomXML(List<Room> Room) {
        this.Room = Room;
    }

    public List<Room> getRoom() { return Room; }
    public void setRoom(List<Room> Room) { this.Room = Room; }
}
