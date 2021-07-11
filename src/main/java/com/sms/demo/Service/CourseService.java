package com.sms.demo.Service;

import java.util.List;

import com.sms.demo.Model.Category.Category;
import com.sms.demo.Model.Course.Course;
import com.sms.demo.Model.Course.CourseCreate;
import com.sms.demo.Model.Course.CourseList;

import org.springframework.stereotype.Service;

@Service
public interface CourseService {
    List<CourseList> List();
    Course getById(String id);
    Boolean Delete(String id);
    Boolean Create(CourseCreate courseCreate);
    Boolean Update(Course course);
    List<Course> Search(String name);
    List<Category> categories();
}
