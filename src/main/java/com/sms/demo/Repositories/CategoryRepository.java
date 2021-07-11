package com.sms.demo.Repositories;

import java.util.List;

import com.sms.demo.Model.Category.Category;
import com.sms.demo.Model.Category.CategoryCreate;
import com.sms.demo.Model.Course.Course;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository {

    @Select("SELECT * FROM `tbl_CategoryCourse`")
    public List<Category> List();

    @Select("SELECT * FROM `tbl_CategoryCourse` WHERE `id` = #{id}")
    public Category getById(String id);

    @Select("SELECT * FROM `tbl_Course` WHERE `Cate_Id` = #{Cate_Id}")
    public List<Course> getByIds(String Cate_Id);

    @Delete("DELETE FROM `tbl_CategoryCourse` WHERE `id` = #{id}")
    public Boolean Delete(String id);

    @Insert("INSERT INTO `tbl_CategoryCourse`(`name`, `Description`) VALUES (#{Name},#{Description})")
    public Boolean Create(CategoryCreate categoryCreate);

    @Update("UPDATE `tbl_CategoryCourse` SET `name`=#{Name},`Description`=#{Description} WHERE `id` = #{Id}")
    public Boolean Update(Category category);

    @Select("SELECT * FROM `tbl_CategoryCourse` WHERE name LIKE '%'  #{name}  '%'")
    public List<Category> Search(String name);
}
