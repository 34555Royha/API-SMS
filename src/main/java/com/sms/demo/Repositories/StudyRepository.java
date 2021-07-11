package com.sms.demo.Repositories;

import java.util.List;

import com.sms.demo.Model.Study.Study;
import com.sms.demo.Model.Study.StudyCreate;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

@Repository
public interface StudyRepository {
    
    @Select("SELECT * FROM `tbl_Study`")
    public List<Study> List();

    @Select("SELECT * FROM `tbl_Study` WHERE `Id` = #{id}")
    public Study getById(String id);

    @Delete("DELETE FROM `tbl_Study` WHERE `Id` = #{id}")
    public Boolean Delete(String id);

    @Insert("INSERT INTO `tbl_Study`(`StudyType`) VALUES (#{StudyType})")
    public Boolean Create(StudyCreate studyCreate);

    @Update("UPDATE `tbl_Study` SET `StudyType`= #{StudyType} WHERE `Id` = #{Id}")
    public Boolean Update(Study study);

    @Select("SELECT * FROM `tbl_Study` WHERE StudyType LIKE '%'  #{StudyType}  '%'")
    public List<Study> Search(String StudyType);

}
