package com.sms.demo.ServiceImpl;

import com.sms.demo.Model.Room.Room;
import com.sms.demo.Model.Room.RoomCreate;
import com.sms.demo.Repositories.RoomeRepository;
import com.sms.demo.Service.RoomService;

import org.springframework.stereotype.Service;

@Service
public class RoomServiceImpl implements RoomService{

    private RoomeRepository roomeRepository;

    

    public RoomServiceImpl(RoomeRepository roomeRepository) {
        this.roomeRepository = roomeRepository;
    }



    @Override
    public java.util.List<Room> List() {
        return this.roomeRepository.List();
    }



    @Override
    public Room getById(String id) {
        return this.roomeRepository.getById(id);
    }



    @Override
    public Boolean Delete(String id) {
        return this.roomeRepository.Delete(id);
    }



    @Override
    public Boolean Create(RoomCreate roomCreate) {
        return this.roomeRepository.Create(roomCreate);
    }



    @Override
    public Boolean Update(Room room) {
        return this.roomeRepository.Update(room);
    }



    @Override
    public java.util.List<Room> Search(String RoomNumber) {
        return this.roomeRepository.Search(RoomNumber);
    }
}
