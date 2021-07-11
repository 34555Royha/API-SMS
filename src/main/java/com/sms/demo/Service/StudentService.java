package com.sms.demo.Service;

import java.util.List;

import com.sms.demo.Model.Student.Student;
import com.sms.demo.Model.Student.StudentCreate;

import org.springframework.stereotype.Service;

@Service
public interface StudentService {
    List<Student> List();
    Boolean Create(StudentCreate studentCreate);
    Boolean addPhoto(String Photo);
    Student getById(String id);
    Boolean Update(Student student);
    Boolean Delete(String id);
    List<Student> Search(String name);
}
