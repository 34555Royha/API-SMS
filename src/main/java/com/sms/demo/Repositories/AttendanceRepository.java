package com.sms.demo.Repositories;

import java.util.List;

import com.sms.demo.Model.Attendance.AttendList;
import com.sms.demo.Model.Attendance.Attendance;
import com.sms.demo.Model.Attendance.AttendanceCreate;
import com.sms.demo.Model.Attendance.AttendanceGetById;
import com.sms.demo.Model.Attendance.dropdown.Student;
import com.sms.demo.Model.Attendance.dropdown.Teacher;
import com.sms.demo.Model.Attendance.dropdown.course;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

@Repository
public interface AttendanceRepository {

    @Select("select ta.Id,ta.Date, ta.status,ts.Name as StudenName,tt.Name as TeacherName,tcou.Name as CourseName from tbl_Attendance ta inner join tbl_Student ts inner join tbl_Teacher tt inner join tbl_Course tcou on ta.Studen_Id = ts.Id AND ta.Teacher_Id = tt.Id AND ta.Course_Id = tcou.Id")
    public List<AttendList> List();

    @Select("SELECT * FROM `tbl_Attendance` WHERE `Id` = #{id}")
    public AttendanceGetById getById(String id);

    @Delete("DELETE FROM `tbl_Attendance` WHERE `Id` = #{id}")
    public Boolean Delete(String id);

    @Insert("INSERT INTO `tbl_Attendance`(`Date`, `Studen_Id`, `Status`, `Teacher_Id`, `Course_Id`) VALUES (#{Date},#{Student_Id},#{Status},#{Teacher_Id},#{Course_Id})")
    public Boolean Create(AttendanceCreate attendanceCreate);

    @Update("UPDATE `tbl_Attendance` SET`Date`=#{Date},`Studen_Id`=#{Student_Id},`Status`=#{Status},`Teacher_Id`=#{Teacher_Id},`Course_Id`=#{Course_Id} WHERE `Id` = #{Id}")
    public Boolean Update(Attendance attendance);

    @Select("SELECT * FROM `tbl_Student`")
    public List<Student> students();

    @Select("SELECT * FROM `tbl_Teacher`")
    public List<Teacher> teachers();

    @Select("SELECT * FROM `tbl_Course`")
    public List<course> courses();

    @Select("SELECT * FROM `tbl_Attendance` WHERE `Studen_Id` = #{Student_Id}")
    public List<Attendance> Filter(String Student_Id);
}
