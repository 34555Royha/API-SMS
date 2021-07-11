package com.sms.demo.Repositories;

import java.util.List;

import com.sms.demo.Model.Invoice.Invoice;
import com.sms.demo.Model.Invoice.InvoiceCreate;
import com.sms.demo.Model.Invoice.InvoiceList;
import com.sms.demo.Model.Invoice.Dropdown.Course;
import com.sms.demo.Model.Invoice.Dropdown.Room;
import com.sms.demo.Model.Invoice.Dropdown.Schedule;
import com.sms.demo.Model.Invoice.Dropdown.Student;
import com.sms.demo.Model.Invoice.Dropdown.Study;
import com.sms.demo.Model.Invoice.Dropdown.Teacher;
import com.sms.demo.Model.Invoice.Dropdown.Time;
import com.sms.demo.Model.Invoice.Dropdown.User;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

@Repository
public interface InvoiceRepository {

    @Select("SELECT tiv.Id,tus.username as Username,tsd.Name as StudenName,tcu.Name CourseName ,tiv.Fee as Fee,tiv.Qty as Qty,ttc.Name as TeacherName,tsdy.StudyType as StudyType, trm.RoomNumber as RoomNumber, ttm.Time as Time, tsh.Schedule as Schedule FROM tbl_Invoice tiv INNER JOIN tbl_user tus INNER JOIN tbl_Student tsd INNER JOIN tbl_Teacher ttc INNER JOIN tbl_Course tcu INNER JOIN tbl_Study tsdy INNER JOIN tbl_Room trm INNER JOIN tbl_Time ttm INNER JOIN tbl_Schedule tsh ON tiv.UserId = tus.id AND tiv.StudentId = tsd.Id AND tiv.TeacherId = ttc.Id AND tiv.CourseId = tcu.Id AND tiv.StudyTypeId = tsdy.Id AND tiv.RoomId = trm.Id AND tiv.TimeId = ttm.Id AND tiv.ScheduleID = tsh.Id")
    public List<InvoiceList> List();

    @Select("SELECT * FROM `tbl_Invoice` WHERE `Id` = #{id}")
    public Invoice getById(String id);

    @Delete("DELETE FROM `tbl_Invoice` WHERE `Id` = #{id}")
    public Boolean Delete(String id);

    @Insert("INSERT INTO `tbl_Invoice`(`UserId`, `StudentId`, `TeacherId`, `CourseId`, `StudyTypeId`, `Fee`, `Qty`, `RoomId`, `TimeId`, `ScheduleID`, `InvoiceDate`) VALUES (#{UserId},#{StudentId},#{TeacherId},#{CourseId},#{StudyTypeId},#{Fee},#{Qty},#{RoomId},#{TimeId},#{ScheduleId},#{InvoiceDate})")
    public Boolean Create(InvoiceCreate invoiceCreate);

    @Update("UPDATE `tbl_Invoice` SET `UserId`=#{UserId},`StudentId`=#{StudentId},`TeacherId`=#{TeacherId},`CourseId`=#{CourseId},`StudyTypeId`=#{StudyTypeId},`Fee`=#{Fee},`Qty`=#{Qty},`RoomId`=#{RoomId},`TimeId`=#{TimeId},`ScheduleID`=#{ScheduleId},`InvoiceDate`=#{InvoiceDate} WHERE `Id` = #{Id}")
    public Boolean Update(Invoice invoice);

    // Dropdown

    @Select("SELECT `Id`,`Name` FROM `tbl_Course`")
    List<Course> courses();
    @Select("SELECT `Id`,`RoomNumber` FROM `tbl_Room`")
    List<Room> rooms();
    @Select("SELECT `Id`,`Schedule` FROM `tbl_Schedule`")
    List<Schedule> schedules();
    @Select("SELECT `Id`,`Name` FROM `tbl_Student`")
    List<Student> students();
    @Select("SELECT `Id`,`StudyType` FROM `tbl_Study`")
    List<Study> studies();
    @Select("SELECT `Id`,`Name` FROM `tbl_Teacher`")
    List<Teacher> teachers();
    @Select("SELECT `Id`,`Time` FROM `tbl_Time` ")
    List<Time> times();
    @Select("SELECT `id`,`username` FROM `tbl_user`")
    List<User> users();

}
