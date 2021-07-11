package com.sms.demo.Model.Room;

public class Room {
    private String Id;
    private String RoomNumber;
    private String RoomType;

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getRoomNumber() {
        return RoomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        RoomNumber = roomNumber;
    }

    public String getRoomType() {
        return RoomType;
    }

    public void setRoomType(String roomType) {
        RoomType = roomType;
    }

    public Room(String id, String roomNumber, String roomType) {
        Id = id;
        RoomNumber = roomNumber;
        RoomType = roomType;
    }

    @Override
    public String toString() {
        return "Rome [Id=" + Id + ", RoomNumber=" + RoomNumber + ", RoomType=" + RoomType + "]";
    }

    public Room() {
    }

}
