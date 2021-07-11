package com.sms.demo.Model.Room;

public class RoomCreate {
    private String RoomNumber;
    private String RoomType;
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
    public RoomCreate(String roomNumber, String roomType) {
        RoomNumber = roomNumber;
        RoomType = roomType;
    }
    @Override
    public String toString() {
        return "RoomCreate [RoomNumber=" + RoomNumber + ", RoomType=" + RoomType + "]";
    }
}
