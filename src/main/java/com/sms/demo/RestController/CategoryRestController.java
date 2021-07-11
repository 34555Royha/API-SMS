package com.sms.demo.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.sms.demo.Model.Category.Category;
import com.sms.demo.Model.Category.CategoryCreate;
import com.sms.demo.Model.Course.Course;
import com.sms.demo.Service.CategoryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Authorization;

@RestController
@RequestMapping("/api/v1/category")
public class CategoryRestController {
    
    private CategoryService categoryService;

    @Autowired
    public CategoryRestController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/")
    @ApiOperation(value = "List",authorizations = {@Authorization(value = "BasicAuth")})
    public ResponseEntity<?> List(){
        Map<String, Object> response = new HashMap<>();
        List<Category> categories = this.categoryService.List();

        if(categories.size()>=0){
            response.put("categories", categories);
            response.put("Count", categories.size());
            response.put("Status", HttpStatus.OK);
            response.put("Message", "Success");
            return ResponseEntity.status(HttpStatus.OK).body(response);
        }else{
            response.put("Message", "Not Found");
            response.put("Status", HttpStatus.NOT_FOUND);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
    }

    @GetMapping("/{Cate_Id}")
    @ApiOperation(value = "GetById",authorizations = {@Authorization(value = "BasicAuth")})
    public ResponseEntity<?> GetById(@PathVariable(required = true) String Cate_Id){
        Map<String, Object> response = new HashMap<>();
        List<Course> courses = this.categoryService.getByIds(Cate_Id);

        if(courses.size()>=0){
            response.put("courses", courses);
            response.put("Count", courses.size());
            response.put("Status", HttpStatus.OK);
            response.put("Message", "Success");
            return ResponseEntity.status(HttpStatus.OK).body(response);
        }else{
            response.put("Message", "Not Found");
            response.put("Status", HttpStatus.NOT_FOUND);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Delete",authorizations = {@Authorization(value = "BasicAuth")})
    public ResponseEntity<?> Delete(@PathVariable(required = true) String id){

        Map<String, Object> response = new HashMap<>(); 
        Category category = this.categoryService.getById(id);
        
        if(id != null){
            if(this.categoryService.Delete(id)){
                response.put("status", HttpStatus.OK);
                response.put("message", "Delete id: "+id+" Success");
                response.put("category", category);
            }else{
                response.put("status", HttpStatus.INTERNAL_SERVER_ERROR);
                response.put("message", "Delete failed, Because Not Found or your record Connect ot other record");
            }
        return ResponseEntity.status(HttpStatus.OK).body(response);
        }else{
            response.put("status", HttpStatus.NOT_FOUND);
            response.put("message", "Please Input ID");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
    }

    @PostMapping("")
    @ApiOperation(value = "Create",authorizations = {@Authorization(value = "BasicAuth")})
    public ResponseEntity<?> Create(@RequestBody CategoryCreate categoryCreate){
        Map<String, Object> response = new HashMap<>(); 

        if(categoryCreate != null ){
            if(this.categoryService.Create(categoryCreate)){
            response.put("status", HttpStatus.OK);
            response.put("category", categoryCreate);
            response.put("message", "Insert Success");
            }else{
                response.put("status", HttpStatus.INTERNAL_SERVER_ERROR);
                response.put("category", categoryCreate);
                response.put("message", "Insert failed");
            }
            return ResponseEntity.status(HttpStatus.OK).body(response);
        }else{
            response.put("status", HttpStatus.NOT_FOUND);
            response.put("message", "Please input value");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
    } 

    @PutMapping("")
    @ApiOperation(value = "Update",authorizations = {@Authorization(value = "BasicAuth")})
    public ResponseEntity<?> Update(@RequestBody Category category){

        Map<String, Object> response = new HashMap<>(); 
        
        if(category.getId() != null){
            if(this.categoryService.Update(category)){
                response.put("status", HttpStatus.OK);
                response.put("message", "Updated Success");
                response.put("category after updated", category); 
            }else{
                response.put("status", HttpStatus.NOT_FOUND);
                response.put("message", "Updated failed");
            }
        return ResponseEntity.status(HttpStatus.OK).body(response);
        }else{
            response.put("status", HttpStatus.NOT_FOUND);
            response.put("message", "Please Input Id");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
    }

    @GetMapping("/search")
    @ApiOperation(value = "Search",authorizations = {@Authorization(value = "BasicAuth")})
    public ResponseEntity<?> Search(@RequestParam(required = false,defaultValue = "") String name){

        Map<String, Object> response = new HashMap<>(); 

        
        if(name.equals("")){
            List<Category> categories = this.categoryService.List();
                response.put("categories", categories);
                response.put("status", HttpStatus.OK);
                response.put("message", "Get success");
                response.put("Count", categories.size());
                return ResponseEntity.status(HttpStatus.OK).body(response);
        }else{
            List<Category> categories = this.categoryService.Search(name);
            if(categories.size()>0){
                    response.put("categories", categories);
                    response.put("status", HttpStatus.OK);
                    response.put("message", "Get success");
                    response.put("Count", categories.size());
                    return ResponseEntity.status(HttpStatus.OK).body(response);
            }else{
                response.put("status", HttpStatus.NOT_FOUND);
                response.put("message", "Not Found");
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
            }
        }
    }




}
