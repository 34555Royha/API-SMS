package com.sms.demo.ServiceImpl;

import com.sms.demo.Model.Category.Category;
import com.sms.demo.Model.Category.CategoryCreate;
import com.sms.demo.Model.Course.Course;
import com.sms.demo.Repositories.CategoryRepository;
import com.sms.demo.Service.CategoryService;

import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl implements CategoryService{

    private CategoryRepository categoryRepository;

    

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }



    @Override
    public java.util.List<Category> List() {
        return this.categoryRepository.List();
    }



    @Override
    public java.util.List<Course> getByIds(String Cate_Id) {
        return this.categoryRepository.getByIds(Cate_Id);
    }



    @Override
    public Boolean Delete(String id) {
        return this.categoryRepository.Delete(id);
    }



    @Override
    public Category getById(String id) {
        return this.categoryRepository.getById(id);
    }



    @Override
    public Boolean Create(CategoryCreate categoryCreate) {
        return this.categoryRepository.Create(categoryCreate);
    }



    @Override
    public Boolean Update(Category category) {
        return this.categoryRepository.Update(category);
    }



    @Override
    public java.util.List<Category> Search(String name) {
        return this.categoryRepository.Search(name);
    }
    
}
