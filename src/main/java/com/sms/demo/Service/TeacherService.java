package com.sms.demo.Service;

import java.util.List;

import com.sms.demo.Model.Teacher.Teacher;
import com.sms.demo.Model.Teacher.TeacherCreate;

import org.springframework.stereotype.Service;

@Service
public interface TeacherService {
    List<Teacher> List();
    Boolean Create(TeacherCreate teacherCreate);
    Teacher getById(String id);
    Boolean Delete(String id);
    Boolean Update(Teacher teacher);
    List<Teacher> Search(String name);
}
