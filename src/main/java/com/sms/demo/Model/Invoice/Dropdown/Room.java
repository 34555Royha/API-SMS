package com.sms.demo.Model.Invoice.Dropdown;

public class Room {
    private String Id;
    private String RoomNumber;
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
    public Room(String id, String roomNumber) {
        Id = id;
        RoomNumber = roomNumber;
    }
    @Override
    public String toString() {
        return "Room [Id=" + Id + ", RoomNumber=" + RoomNumber + "]";
    }

    
}
