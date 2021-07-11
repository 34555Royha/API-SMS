package com.sms.demo.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.sms.demo.Model.Teacher.Teacher;
import com.sms.demo.Model.Teacher.TeacherCreate;
import com.sms.demo.Service.TeacherService;

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
@RequestMapping("/api/v1/teacher")
public class TeacherRestController {
    private TeacherService teacherService;

    @Autowired
    public TeacherRestController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @GetMapping("/")
    @ApiOperation(value = "List",authorizations = {@Authorization(value = "BasicAuth")})
    public ResponseEntity<?> List(){
        Map<String, Object> response = new HashMap<>();
        List<Teacher> teachers = this.teacherService.List();

        if(teachers.size()>=0){
            response.put("teachers", teachers);
            response.put("Count", teachers.size());
            response.put("Status", HttpStatus.OK);
            response.put("Message", "Success");
            return ResponseEntity.status(HttpStatus.OK).body(response);
        }else{
            response.put("Message", "Not Found");
            response.put("Status", HttpStatus.NOT_FOUND);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
    }

    @PostMapping("")
    @ApiOperation(value = "Create",authorizations = {@Authorization(value = "BasicAuth")})
    public ResponseEntity<?> Create(@RequestBody TeacherCreate teacherCreate){
        Map<String, Object> response = new HashMap<>(); 

        if(teacherCreate != null ){
            if(this.teacherService.Create(teacherCreate)){
            response.put("status", HttpStatus.OK);
            response.put("teacher", teacherCreate);
            response.put("message", "Insert Success");
            }else{
                response.put("status", HttpStatus.INTERNAL_SERVER_ERROR);
                response.put("userwithrole", teacherCreate);
                response.put("message", "Insert failed");
            }
            return ResponseEntity.status(HttpStatus.OK).body(response);
        }else{
            response.put("status", HttpStatus.NOT_FOUND);
            response.put("message", "Please input value");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "GetById",authorizations = {@Authorization(value = "BasicAuth")})
    public ResponseEntity<?> GetById(@PathVariable(required = true) String id){
        Map<String, Object> response = new HashMap<>();
        Teacher teacher = this.teacherService.getById(id);

        if(teacher != null ){
            response.put("status", HttpStatus.OK);
            response.put("message", "Get Success");
            response.put("teacher", teacher);
            return ResponseEntity.status(HttpStatus.OK).body(response);
        }else{
            response.put("status", HttpStatus.NOT_FOUND);
            response.put("message", "Id: "+ id.toString()+" Not Found");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }    
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Delete",authorizations = {@Authorization(value = "BasicAuth")})
    public ResponseEntity<?> Delete(@PathVariable(required = true) String id){

        Map<String, Object> response = new HashMap<>(); 
        Teacher teacher = this.teacherService.getById(id);
        
        if(id != null){
            if(this.teacherService.Delete(id)){
                response.put("status", HttpStatus.OK);
                response.put("message", "Delete id: "+id+" Success");
                response.put("teacher", teacher);
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

    @PutMapping("")
    @ApiOperation(value = "Update",authorizations = {@Authorization(value = "BasicAuth")})
    public ResponseEntity<?> Update(@RequestBody Teacher teacher){

        Map<String, Object> response = new HashMap<>(); 
        System.out.println(teacher.getId());
        
        if(teacher.getId() != null){
            if(this.teacherService.Update(teacher)){
                response.put("status", HttpStatus.OK);
                response.put("message", "Updated Success");
                response.put("teacher after updated", teacher); 
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
            List<Teacher> teachers = this.teacherService.List();
                response.put("teachers", teachers);
                response.put("status", HttpStatus.OK);
                response.put("message", "Get success");
                response.put("Count", teachers.size());
                return ResponseEntity.status(HttpStatus.OK).body(response);
        }else{
            List<Teacher> teachers = this.teacherService.Search(name);
            if(teachers.size()>0){
                    response.put("teachers", teachers);
                    response.put("status", HttpStatus.OK);
                    response.put("message", "Get success");
                    response.put("Count", teachers.size());
                    return ResponseEntity.status(HttpStatus.OK).body(response);
            }else{
                response.put("status", HttpStatus.NOT_FOUND);
                response.put("message", "Not Found");
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
            }
        }
    }

}