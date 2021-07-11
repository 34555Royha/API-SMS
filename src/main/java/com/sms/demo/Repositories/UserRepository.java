package com.sms.demo.Repositories;

import java.util.List;

import com.sms.demo.Model.Role.Role;
import com.sms.demo.Model.User.User;
import com.sms.demo.Model.User.UserCreate;
import com.sms.demo.Model.User.UserGetById;
import com.sms.demo.Model.User.UserUpdate;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository {

        @Select("SELECT * FROM tbl_user WHERE username = #{username}")
        @Results({ @Result(property = "id", column = "id"), @Result(property = "profileImg", column = "profile_image"),
                        @Result(property = "roles", column = "id", many = @Many(select = "GetRoleById")) })
        public User loadUserByUsername(String username);

        @Select("select tr.id, tr.role from tbl_role tr inner join tbl_UserId_RoleId tur on tr.id = tur.role_id where tur.user_id = #{id}")
        public List<Role> GetRoleById(Integer id);

        @Select("SELECT * FROM tbl_user WHERE id = #{id}")
        @Results({ @Result(property = "id", column = "id"), @Result(property = "profileImg", column = "profile_image"),
                        @Result(property = "roles", column = "id", many = @Many(select = "GetRole")) })
        public UserGetById GetById(String id);

        @Select("select tr.id, tr.role from tbl_role tr inner join tbl_UserId_RoleId tur on tr.id = tur.role_id where tur.user_id = #{id}")
        public List<Role> GetRole(Integer id);

        @Select("SELECT * FROM tbl_user")
        @Results({ @Result(property = "id", column = "id"), @Result(property = "profileImg", column = "profile_image"),
                        @Result(property = "roles", column = "id", many = @Many(select = "GetListRole")) })
        public List<UserGetById> List();

        @Select("select tr.id, tr.role from tbl_role tr inner join tbl_UserId_RoleId tur on tr.id = tur.role_id where tur.user_id = #{id}")
        public List<Role> GetListRole(Integer id);

        @Insert("INSERT INTO tbl_user(username, password, status, profile_image, apiKey) VALUES (#{username},#{password},#{status},#{profileImg} ,#{apiKey})")
        public Boolean Create(UserCreate userCreate);

        @Update("UPDATE tbl_user SET username=#{username}, password=#{password}, apiKey = #{apiKey}, status = #{status}, profile_image = #{profileImg} WHERE id = #{id}")
        public Boolean Update(UserUpdate userUpdate);

        @Delete("DELETE FROM tbl_user WHERE id = #{id}")
        public Boolean Delete(String id);

        @Select("SELECT * FROM tbl_user WHERE username LIKE '%'  #{username}  '%'")
        @Results({ @Result(property = "id", column = "id"), @Result(property = "profileImg", column = "profile_image"),
                        @Result(property = "roles", column = "id", many = @Many(select = "searchRole")) })
        public List<UserGetById> search(String username);

        @Select("select tr.id, tr.role from tbl_role tr inner join tbl_UserId_RoleId tur on tr.id = tur.role_id where tur.user_id = #{id}")
        public List<Role> searchRole(Integer id);

        @Select("SELECT * FROM tbl_user WHERE apiKey = #{apiKey}")
        @Results({ @Result(property = "profileImg", column = "profile_image"), })
        public UserGetById login(String apiKey);

}
