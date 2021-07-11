package com.sms.demo.ServiceImpl;

import com.sms.demo.Model.Teacher.Teacher;
import com.sms.demo.Model.Teacher.TeacherCreate;
import com.sms.demo.Repositories.TeacherRepository;
import com.sms.demo.Service.TeacherService;

import org.springframework.stereotype.Service;


@Service
public class TeacherServiceImpl implements TeacherService{

    private TeacherRepository teacherRepository;


    public TeacherServiceImpl(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    @Override
    public java.util.List<Teacher> List() {
        return this.teacherRepository.List();
    }

    @Override
    public Boolean Create(TeacherCreate teacherCreate) {
        return this.teacherRepository.Create(teacherCreate);
    }

    @Override
    public Teacher getById(String id) {
        return this.teacherRepository.getById(id);
    }

    @Override
    public Boolean Delete(String id) {
        return this.teacherRepository.Delete(id);
    }

    @Override
    public Boolean Update(Teacher teacher) {
        return this.teacherRepository.Update(teacher);
    }

    @Override
    public java.util.List<Teacher> Search(String name) {
        return this.teacherRepository.Search(name);
    }
}
