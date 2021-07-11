package com.sms.demo.Service;

import java.util.List;

import com.sms.demo.Model.Room.Room;
import com.sms.demo.Model.Room.RoomCreate;

import org.springframework.stereotype.Service;

@Service
public interface RoomService {
    List<Room> List();
    Room getById(String id);
    Boolean Delete(String id);
    Boolean Create(RoomCreate roomCreate);
    Boolean Update(Room room);
    List<Room> Search(String RoomNumber);
}
