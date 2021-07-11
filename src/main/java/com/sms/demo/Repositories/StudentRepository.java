package com.sms.demo.Repositories;

import java.util.List;

import com.sms.demo.Model.Student.Student;
import com.sms.demo.Model.Student.StudentCreate;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository {
    
    @Select("SELECT * FROM `tbl_Student`")
    public List<Student> List();

    @Insert("INSERT INTO `tbl_Student`(`Name`, `Sex`, `DateOfBirth`, `Address`, `Phone`, `Photo`) VALUES (#{Name},#{Sex},#{DateOfBirth},#{Address},#{Phone},#{Photo})")
    public Boolean Create(StudentCreate studentCreate);

    @Insert("INSERT INTO `tbl_Student`(`Photo`) VALUES (#{Photo})")
    public Boolean addPhoto(String Photo);

    @Select("SELECT * FROM `tbl_Student` WHERE `Id` = #{id}")
    public Student getById(String id);

    @Update("UPDATE `tbl_Student` SET `Name`=#{Name},`Sex`=#{Sex},`DateOfBirth`=#{DateOfBirth},`Address`=#{Address},`Phone`=#{Phone},`Photo`=#{Photo} WHERE `Id` = #{Id}")
    public Boolean Update(Student student);

    @Delete("DELETE FROM `tbl_Student` WHERE `Id` = #{id}")
    public Boolean Delete(String id);

    @Select("SELECT * FROM `tbl_Student` WHERE Name LIKE '%'  #{name}  '%'")
    public List<Student> Search(String name);
}
