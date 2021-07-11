package com.sms.demo.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.sms.demo.Model.Attendance.AttendList;
import com.sms.demo.Model.Attendance.Attendance;
import com.sms.demo.Model.Attendance.AttendanceCreate;
import com.sms.demo.Model.Attendance.AttendanceGetById;
import com.sms.demo.Model.Attendance.dropdown.Student;
import com.sms.demo.Model.Attendance.dropdown.Teacher;
import com.sms.demo.Model.Attendance.dropdown.course;
import com.sms.demo.Service.AttendanceService;

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
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Authorization;

@RestController
@RequestMapping("/api/v1/attendance")
public class AttendanceRestController {
    private AttendanceService attendanceService;

    @Autowired
    public AttendanceRestController(AttendanceService attendanceService) {
        this.attendanceService = attendanceService;
    }

    @GetMapping("/")
    @ApiOperation(value = "List",authorizations = {@Authorization(value = "BasicAuth")})
    public ResponseEntity<?> List(){
        Map<String, Object> response = new HashMap<>();
        List<AttendList> attendances = this.attendanceService.List();

        if(attendances.size()>=0){
            response.put("attendances", attendances);
            response.put("Count", attendances.size());
            response.put("Status", HttpStatus.OK);
            response.put("Message", "Success");
            return ResponseEntity.status(HttpStatus.OK).body(response);
        }else{
            response.put("Message", "Not Found");
            response.put("Status", HttpStatus.NOT_FOUND);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "GetById",authorizations = {@Authorization(value = "BasicAuth")})
    public ResponseEntity<?> GetById(@PathVariable(required = true) String id){
        Map<String, Object> response = new HashMap<>();
        AttendanceGetById attendance = this.attendanceService.getById(id);

        if(attendance != null ){
            response.put("status", HttpStatus.OK);
            response.put("message", "Get Success");
            response.put("attendance", attendance);
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
        AttendanceGetById attendanceGetById = this.attendanceService.getById(id);
        
        if(id != null){
            if(this.attendanceService.Delete(id)){
                response.put("status", HttpStatus.OK);
                response.put("message", "Delete id: "+id+" Success");
                response.put("attendance", attendanceGetById);
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
    public ResponseEntity<?> Create(@RequestBody AttendanceCreate attendanceCreate){
        Map<String, Object> response = new HashMap<>(); 

        if(attendanceCreate != null ){
            if(this.attendanceService.Create(attendanceCreate)){
            response.put("status", HttpStatus.OK);
            response.put("attendance", attendanceCreate);
            response.put("message", "Insert Success");
            }else{
                response.put("status", HttpStatus.INTERNAL_SERVER_ERROR);
                response.put("attendance", attendanceCreate);
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
    public ResponseEntity<?> Update(@RequestBody Attendance attendance){

        Map<String, Object> response = new HashMap<>(); 
        
        if(attendance.getId() != null || attendance.getId().isEmpty()){
            if(this.attendanceService.Update(attendance)){
                response.put("status", HttpStatus.OK);
                response.put("message", "Updated Success");
                response.put("attendance after updated", attendance); 
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

    @GetMapping("/dropdown")
    @ApiOperation(value = "dropdown",authorizations = {@Authorization(value = "BasicAuth")})
    public ResponseEntity<?> dropdown(){
        Map<String, Object> response = new HashMap<>();
        List<Teacher> teachers= this.attendanceService.teachers();
        List<Student> students = this.attendanceService.students();
        List<course> courses = this.attendanceService.courses();

        if(teachers.size()>=0&&students.size()>=0&&courses.size()>=0){

            response.put("teachers", teachers);
            response.put("students", students); 
            response.put("courses", courses); 
            response.put("Status", HttpStatus.OK);
            response.put("CountTeachers", teachers.size());
            response.put("CountStudents", students.size());
            response.put("CountCourses", courses.size());
            response.put("Message", "Success");
            return ResponseEntity.status(HttpStatus.OK).body(response);
        }else{
            response.put("Message", "Not Found");
            response.put("Status", HttpStatus.NOT_FOUND);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
    }

    // @GetMapping("/filter")
    // @ApiOperation(value = "filter",authorizations = {@Authorization(value = "BasicAuth")})
    // public ResponseEntity<?> Search(@RequestParam(required = false,defaultValue = "") String Student_Id){

    //     Map<String, Object> response = new HashMap<>(); 

        
    //     if(Student_Id.equals("")){
    //         List<AttendList> attendances = this.attendanceService.List();
    //             response.put("attendances", attendances);
    //             response.put("status", HttpStatus.OK);
    //             response.put("message", "Get success");
    //             response.put("Count", attendances.size());
    //             return ResponseEntity.status(HttpStatus.OK).body(response);
    //     }else{
    //         List<Attendance> attendances = this.attendanceService.Filter(Student_Id);
    //         if(attendances.size()>0){
    //                 response.put("attendances", attendances);
    //                 response.put("status", HttpStatus.OK);
    //                 response.put("message", "Get success");
    //                 response.put("Count", attendances.size());
    //                 return ResponseEntity.status(HttpStatus.OK).body(response);
    //         }else{
    //             response.put("status", HttpStatus.NOT_FOUND);
    //             response.put("message", "Not Found");
    //             return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    //         }
    //     }
    // }

    
}