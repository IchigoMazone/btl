package org.example.entity;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Room")
@XmlAccessorType(XmlAccessType.FIELD)
public class Room {

    @XmlElement(name = "roomNumber")
    private int roomNumber;

    @XmlElement(name = "status")
    private String status;

    @XmlElement(name = "roomType")
    private String roomType;

    @XmlElement(name = "pricePerNight")
    private int pricePerNight;

    public Room() {
    }

    public Room(int roomNumber, String status, String roomType, int pricePerNight) {
        this.roomNumber = roomNumber;
        this.status = status;
        this.roomType = roomType;
        this.pricePerNight = pricePerNight;
    }

    // Getters và Setters
    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public int getPricePerNight() {
        return pricePerNight;
    }

    public void setPricePerNight(int pricePerNight) {
        this.pricePerNight = pricePerNight;
    }
}
