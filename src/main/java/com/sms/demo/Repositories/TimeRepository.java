package com.sms.demo.Repositories;

import java.util.List;

import com.sms.demo.Model.Invoice.Invoice;
import com.sms.demo.Model.Time.Time;
import com.sms.demo.Model.Time.TimeCreate;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

@Repository
public interface TimeRepository {

    @Select("SELECT * FROM `tbl_Time`")
    public List<Time> List();

    @Select("SELECT * FROM `tbl_Time` WHERE `Id` = #{id}")
    public Time getById(String id);

    @Select("SELECT * FROM `tbl_Invoice` WHERE `TimeId` = #{TimeId}")
    public List<Invoice> Filter(String TimeId);

    @Delete("DELETE FROM `tbl_Time` WHERE `Id` = #{id}")
    public Boolean Delete(String id);

    @Insert("INSERT INTO `tbl_Time`(`Time`, `Description`) VALUES (#{Time},#{Description})")
    public Boolean Create(TimeCreate timeCreate);

    @Update("UPDATE `tbl_Time` SET `Time`=#{Time},`Description`=#{Description} WHERE `Id` = #{Id}")
    public Boolean Update(Time time);

    @Select("SELECT * FROM `tbl_Time` WHERE Time LIKE '%'  #{time}  '%'")
    public List<Time> Search(String time);
}
