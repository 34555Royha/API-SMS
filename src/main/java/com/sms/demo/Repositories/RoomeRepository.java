package com.sms.demo.Repositories;

import java.util.List;

import com.sms.demo.Model.Room.Room;
import com.sms.demo.Model.Room.RoomCreate;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomeRepository {
    
    @Select("SELECT * FROM `tbl_Room`")
    public List<Room> List();

    @Select("SELECT * FROM `tbl_Room` WHERE `Id` = #{id}")
    public Room getById(String id);

    @Delete("DELETE FROM `tbl_Room` WHERE `Id` = #{id}")
    public Boolean Delete(String id);

    @Insert("INSERT INTO `tbl_Room`(`RoomNumber`, `RoomType`) VALUES (#{RoomNumber},#{RoomType})")
    public Boolean Create(RoomCreate roomCreate);

    @Update("UPDATE `tbl_Room` SET `RoomNumber`=#{RoomNumber},`RoomType`=#{RoomType} WHERE `Id` = #{Id}")
    public Boolean Update(Room room);

    @Select("SELECT * FROM `tbl_Room`  WHERE RoomNumber LIKE '%'  #{RoomNumber}  '%'")
    public List<Room> Search(String RoomNumber);
}
