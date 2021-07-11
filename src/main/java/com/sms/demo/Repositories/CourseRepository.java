package com.sms.demo.Repositories;

import java.util.List;

import com.sms.demo.Model.Category.Category;
import com.sms.demo.Model.Course.Course;
import com.sms.demo.Model.Course.CourseCreate;
import com.sms.demo.Model.Course.CourseList;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository {
    
    @Select("select * from tbl_Course tc inner join tbl_CategoryCourse tcc on tcc.id = tc.Cate_Id")
    @Results({
        @Result(property = "Cate_Name",column = "name")
    })
    public List<CourseList> List();

    @Select("SELECT * FROM `tbl_Course` WHERE `Id` = #{id}")
    public Course getById(String id);

    @Delete("DELETE FROM `tbl_Course` WHERE `Id` = #{id}")
    public Boolean Delete(String id);

    @Insert("INSERT INTO `tbl_Course`(`Name`, `Fee`, `Other`, `Cate_Id`) VALUES (#{Name},#{Fee},#{Other},#{Cate_Id})")
    public Boolean Create(CourseCreate courseCreate);

    @Update("UPDATE `tbl_Course` SET `Name`=#{Name},`Fee`=#{Fee},`Other`=#{Other},`Cate_Id`=#{Cate_Id} WHERE `Id` = #{Id}")
    public  Boolean Update(Course course);

    @Select("SELECT * FROM `tbl_Course` WHERE Name LIKE '%'  #{name}  '%'")
    public List<Course> Search(String name);

    @Select("SELECT * FROM `tbl_CategoryCourse`")
    public List<Category> categories();
}
