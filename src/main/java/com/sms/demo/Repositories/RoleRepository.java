package com.sms.demo.Repositories;

import java.util.List;

import com.sms.demo.Model.Role.Role;
import com.sms.demo.Model.Role.RoleUpdate;
import com.sms.demo.Model.User.User;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;


@Repository
public interface RoleRepository {

    @Select("SELECT * FROM tbl_role")
    public List<Role> getList();

    @Insert("INSERT INTO tbl_role(role) VALUES (#{role})")
    public Boolean Create(String role);

    // @Select("SELECT * FROM tbl_role WHERE id = #{id}")
    // public Role GetByID(String id);

    @Select("SELECT * FROM tbl_role WHERE id LIKE '%'  #{id}  '%'")
    @Results({
        @Result(property = "id",column = "id"),
        @Result(property = "users",column = "id", many = @Many(select = "GetUserByRole"))
    })
    public Role GetByID(String role);

    @Select("select * from tbl_user tu inner join tbl_UserId_RoleId tur on tu.id = tur.role_id where tur.user_id = #{id}")
    @Results({
        @Result(property = "id", column = "id"),
        @Result(property = "profileImg",column = "profile_image"),
    })
    public List<User> GetUserByRole(String id);







    @Update("UPDATE tbl_role SET role=#{role} WHERE id = #{id}")
    public Boolean Update(RoleUpdate roleUpdate);

    @Delete("DELETE FROM tbl_role WHERE id = #{id}")
    public Boolean Delete(String id);

    @Select("SELECT * FROM tbl_role WHERE role LIKE '%'  #{role}  '%'")
    @Results({
        @Result(property = "id",column = "id"),
        @Result(property = "users",column = "id", many = @Many(select = "GetUserByRoles"))
    })
    public List<Role> search(String role);

    @Select("select * from tbl_user tu inner join tbl_UserId_RoleId tur on tu.id = tur.role_id where tur.user_id = #{id}")
    @Results({
        @Result(property = "id", column = "id"),
        @Result(property = "profileImg",column = "profile_image"),
    })
    public List<User> GetUserByRoles(String id);


} 