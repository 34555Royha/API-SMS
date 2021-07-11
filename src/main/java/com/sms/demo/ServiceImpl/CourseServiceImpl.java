package com.sms.demo.ServiceImpl;

import com.sms.demo.Model.Category.Category;
import com.sms.demo.Model.Course.Course;
import com.sms.demo.Model.Course.CourseCreate;
import com.sms.demo.Model.Course.CourseList;
import com.sms.demo.Repositories.CourseRepository;
import com.sms.demo.Service.CourseService;

import org.springframework.stereotype.Service;


@Service
public class CourseServiceImpl implements CourseService{

    private CourseRepository courseRepository;

    public CourseServiceImpl(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Override
    public java.util.List<CourseList> List() {
        return this.courseRepository.List();
    }

    @Override
    public Course getById(String id) {
        return this.courseRepository.getById(id);
    }

    @Override
    public Boolean Delete(String id) {
        return this.courseRepository.Delete(id);
    }

    @Override
    public Boolean Create(CourseCreate courseCreate) {
        return this.courseRepository.Create(courseCreate);
    }

    @Override
    public Boolean Update(Course course) {
        return this.courseRepository.Update(course);
    }

    @Override
    public java.util.List<Course> Search(String name) {
        return this.courseRepository.Search(name);
    }

    @Override
    public java.util.List<Category> categories() {
        return this.courseRepository.categories();
    }    
}
