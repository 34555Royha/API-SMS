package com.sms.demo.Service;

import java.util.List;

import com.sms.demo.Model.Category.Category;
import com.sms.demo.Model.Category.CategoryCreate;
import com.sms.demo.Model.Course.Course;

import org.springframework.stereotype.Service;


@Service
public interface CategoryService {
    List<Category> List();
    List<Course> getByIds(String Cate_Id);
    Boolean Delete(String id);
    Category getById(String id);
    Boolean Create(CategoryCreate categoryCreate);
    Boolean Update(Category category);
    List<Category> Search(String name);
}
