package com.sms.demo.Repositories;

import java.util.List;

import com.sms.demo.Model.UserWithRole.ParameterRoleId;
import com.sms.demo.Model.UserWithRole.ParameterUserId;
import com.sms.demo.Model.UserWithRole.UserWithRole;
import com.sms.demo.Model.UserWithRole.UserWithRoleGetById;
import com.sms.demo.Model.UserWithRole.UserWithRoleList;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

@Repository
public interface UserWithRoleRepository {

    @Select("SELECT tur.id,tu.username AS Username, tr.role AS Role FROM tbl_UserId_RoleId tur INNER JOIN tbl_user tu INNER JOIN tbl_role tr ON tur.user_id = tu.id AND tur.role_id = tr.id")
    public List<UserWithRoleList> List();

    @Select("SELECT * FROM tbl_UserId_RoleId WHERE id = #{id}")
    public UserWithRoleGetById getById(String id);

    @Insert("INSERT INTO tbl_UserId_RoleId(user_id, role_id) VALUES (#{user_id}, #{role_id})")
    public Boolean Create(UserWithRole userWithRole);

    @Select("SELECT id, username FROM tbl_user")
    public List<ParameterUserId> parameterUserIds();

    @Select("SELECT id, role FROM tbl_role")
    public List<ParameterRoleId> parameterRoleIds();

    @Delete("DELETE FROM tbl_UserId_RoleId WHERE id = #{id}")
    public Boolean Delete(String id);

    @Update("UPDATE tbl_UserId_RoleId SET user_id=#{user_id},role_id=#{role_id} WHERE id = #{id}")
    public Boolean Update(UserWithRoleGetById userWithRoleGetById);


    @Select("SELECT tur.id,tu.username AS Username, tr.role AS Role FROM tbl_UserId_RoleId tur INNER JOIN tbl_user tu INNER JOIN tbl_role tr ON tur.user_id = tu.id AND tur.role_id = tr.id WHERE tur.Id = #{id}")
    public List<UserWithRoleList> search(String id);
}