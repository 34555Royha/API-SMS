package com.sms.demo.ServiceImpl;

import com.sms.demo.Model.Student.Student;
import com.sms.demo.Model.Student.StudentCreate;
import com.sms.demo.Repositories.StudentRepository;
import com.sms.demo.Service.StudentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService{

    private StudentRepository studentRepository;

    @Autowired
    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }



    @Override
    public java.util.List<Student> List() {
        return this.studentRepository.List();
    }



    @Override
    public Boolean Create(StudentCreate studentCreate) {
        return this.studentRepository.Create(studentCreate);
    }



    @Override
    public Student getById(String id) {
        return this.studentRepository.getById(id);
    }



    @Override
    public Boolean Update(Student student) {
        return this.studentRepository.Update(student);
    }



    @Override
    public Boolean Delete(String id) {
        return this.studentRepository.Delete(id);
    }



    @Override
    public java.util.List<Student> Search(String name) {
        return this.studentRepository.Search(name);
    }



    @Override
    public Boolean addPhoto(String Photo) {
        return this.studentRepository.addPhoto(Photo);
    }
    
}
