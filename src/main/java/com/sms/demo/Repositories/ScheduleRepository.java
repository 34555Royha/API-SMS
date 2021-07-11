package com.sms.demo.Repositories;

import java.util.List;

import com.sms.demo.Model.Schedule.Schedule;
import com.sms.demo.Model.Schedule.ScheduleCreate;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

@Repository
public interface ScheduleRepository {
    
    @Select("SELECT * FROM `tbl_Schedule`")
    public List<Schedule> List();

    @Select("SELECT * FROM `tbl_Schedule` WHERE `Id` = #{id}")
    public Schedule getById(String id);

    @Delete("DELETE FROM `tbl_Schedule` WHERE `Id` = #{id}")
    public Boolean Delete(String id);

    @Insert("INSERT INTO `tbl_Schedule`(`Schedule`, `Description`) VALUES (#{Schedule},#{Description})")
    public Boolean Create(ScheduleCreate scheduleCreate);

    @Update("UPDATE `tbl_Schedule` SET `Schedule`= #{Schedule},`Description`=#{Description} WHERE `Id` = #{Id}")
    public Boolean Update(Schedule schedule);

    @Select("SELECT * FROM `tbl_Schedule` WHERE Schedule LIKE '%'  #{Schedule}  '%'")
    public List<Schedule> Search(String Schedule);
}
