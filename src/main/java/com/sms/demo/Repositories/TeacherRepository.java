package com.sms.demo.Repositories;

import java.util.List;

import com.sms.demo.Model.Teacher.Teacher;
import com.sms.demo.Model.Teacher.TeacherCreate;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRepository {
    
    @Select("SELECT * FROM tbl_Teacher")
    public List<Teacher> List();

    @Insert("INSERT INTO `tbl_Teacher`(`Name`, `Sex`, `DateOfBirth`, `Address`, `Phone`) VALUES (#{Name},#{Sex},#{DateOfBirth},#{Address},#{Phone})")
    public Boolean Create(TeacherCreate teacherCreate);

    @Select("SELECT * FROM `tbl_Teacher` WHERE `Id` = #{id}")
    public Teacher getById(String id);

    @Delete("DELETE FROM `tbl_Teacher` WHERE `Id` = #{id}")
    public Boolean Delete(String id);

    @Update("UPDATE `tbl_Teacher` SET `Name`=#{Name},`Sex`=#{Sex},`DateOfBirth`=#{DateOfBirth},`Address`=#{Address},`Phone`=#{Phone} WHERE `Id` = #{Id}")
    public Boolean Update(Teacher teacher);

    @Select("SELECT * FROM tbl_Teacher WHERE name LIKE '%'  #{name}  '%'")
    public List<Teacher> Search(String name);
}
