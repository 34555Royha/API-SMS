package com.sms.demo.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.sms.demo.Model.Student.Student;
import com.sms.demo.Model.Student.StudentCreate;
import com.sms.demo.Service.StudentService;
import com.sms.demo.Service.UploadService;

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
import org.springframework.web.multipart.MultipartFile;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Authorization;

@RestController
@RequestMapping("/api/v1/student")
public class StudentRestController {

    // StudentCreate studentCreate;

    private StudentService studentService;
    @Autowired
    private UploadService uploadService;

    public StudentRestController(StudentService studentService, UploadService uploadService) {
        this.studentService = studentService;
        this.uploadService = uploadService;
    }

    @GetMapping("/")
    @ApiOperation(value = "List", authorizations = { @Authorization(value = "BasicAuth") })
    public ResponseEntity<?> List() {
        Map<String, Object> response = new HashMap<>();
        List<Student> students = this.studentService.List();

        if (students.size() >= 0) {
            response.put("students", students);
            response.put("Count", students.size());
            response.put("Status", HttpStatus.OK);
            response.put("Message", "Success");
            return ResponseEntity.status(HttpStatus.OK).body(response);
        } else {
            response.put("Message", "Not Found");
            response.put("Status", HttpStatus.INTERNAL_SERVER_ERROR);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }

    @PostMapping("")
    @ApiOperation(value = "Create", authorizations = { @Authorization(value = "BasicAuth") })
    public ResponseEntity<?> Create(@RequestBody StudentCreate studentCreate) {
        Map<String, Object> response = new HashMap<>();

        if (photo != "") {
            studentCreate.setPhoto(photo);
        }

        if (studentCreate != null) {
            if (this.studentService.Create(studentCreate)) {
                response.put("status", HttpStatus.OK);
                response.put("student", studentCreate);
                response.put("message", "Insert Success");
            } else {
                response.put("status", HttpStatus.INTERNAL_SERVER_ERROR);
                response.put("student", studentCreate);
                response.put("message", "Insert failed");
            }
            return ResponseEntity.status(HttpStatus.OK).body(response);
        } else {
            response.put("status", HttpStatus.NOT_FOUND);
            response.put("message", "Please input value");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "GetById", authorizations = { @Authorization(value = "BasicAuth") })
    public ResponseEntity<?> GetById(@PathVariable(required = true) String id) {
        Map<String, Object> response = new HashMap<>();
        Student student = this.studentService.getById(id);

        if (student != null) {
            response.put("status", HttpStatus.OK);
            response.put("message", "Get Success");
            response.put("student", student);
            return ResponseEntity.status(HttpStatus.OK).body(response);
        } else {
            response.put("status", HttpStatus.NOT_FOUND);
            response.put("message", "Id: " + id.toString() + " Not Found");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
    }

    @PutMapping("")
    @ApiOperation(value = "Update", authorizations = { @Authorization(value = "BasicAuth") })
    public ResponseEntity<?> Update(@RequestBody Student student) {

        Map<String, Object> response = new HashMap<>();
        if (photo != "") {
            student.setPhoto(photo);
        }
        if (student.getId() != null || student.getId().isEmpty()) {
            if (this.studentService.Update(student)) {
                response.put("status", HttpStatus.OK);
                response.put("message", "Updated Success");
                response.put("student after updated", student);
            } else {
                response.put("status", HttpStatus.NOT_FOUND);
                response.put("message", "Updated failed");
            }
            return ResponseEntity.status(HttpStatus.OK).body(response);
        } else {
            response.put("status", HttpStatus.NOT_FOUND);
            response.put("message", "Please Input Id");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Delete", authorizations = { @Authorization(value = "BasicAuth") })
    public ResponseEntity<?> Delete(@PathVariable(required = true) String id) {

        Map<String, Object> response = new HashMap<>();
        Student student = this.studentService.getById(id);

        if (id != null) {
            if (this.studentService.Delete(id)) {
                response.put("status", HttpStatus.OK);
                response.put("message", "Delete id: " + id + " Success");
                response.put("student", student);
            } else {
                response.put("status", HttpStatus.INTERNAL_SERVER_ERROR);
                response.put("message", "Delete failed, Because Not Found or your record Connect ot other record");
            }
            return ResponseEntity.status(HttpStatus.OK).body(response);
        } else {
            response.put("status", HttpStatus.NOT_FOUND);
            response.put("message", "Please Input ID");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
    }

    @GetMapping("/search")
    @ApiOperation(value = "Search", authorizations = { @Authorization(value = "BasicAuth") })
    public ResponseEntity<?> Search(@RequestParam(required = false, defaultValue = "") String name) {

        Map<String, Object> response = new HashMap<>();

        if (name.equals("")) {
            List<Student> students = this.studentService.List();
            response.put("students", students);
            response.put("status", HttpStatus.OK);
            response.put("message", "Get success");
            response.put("Count", students.size());
            return ResponseEntity.status(HttpStatus.OK).body(response);
        } else {
            List<Student> students = this.studentService.Search(name);
            if (students.size() > 0) {
                response.put("students", students);
                response.put("status", HttpStatus.OK);
                response.put("message", "Get success");
                response.put("Count", students.size());
                return ResponseEntity.status(HttpStatus.OK).body(response);
            } else {
                response.put("status", HttpStatus.NOT_FOUND);
                response.put("message", "Not Found");
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
            }
        }
    }

    // Updload image

    @PostMapping("/upload")
    @ApiOperation(value = "Upload File", authorizations = { @Authorization(value = "BasicAuth") })
    public Map<String, Object> upload(MultipartFile file) {

        if (file.isEmpty()) {
            return null;
        }

        String filename = this.uploadService.upload(file, "/student/");
        Map<String, Object> response = new HashMap<>();
        if (filename != null) {
            response.put("status", true);
            photo = "/image" + filename;
            response.put("filename", "/image" + filename);
            response.put("message", "Ok upload file looking good!!");
        } else {
            response.put("status", false);
            response.put("message", "Not Ok upload file!!");
        }
        System.out.println(photo);
        return response;
    }

    // @PostMapping("/upload")
    // public Map<String, Object> upload(MultipartFile file) {

    // if (file.isEmpty()) {
    // return null;
    // }

    // String filename = this.uploadService.upload(file, "/student/");
    // Map<String, Object> response = new HashMap<>();
    // if (filename != null) {
    // photo = "/image" + filename;
    // response.put("status", true);
    // response.put("filename", "/image/" + filename);
    // response.put("message", "Ok upload file looking good!!");
    // } else {
    // response.put("status", false);
    // response.put("message", "Not Ok upload file!!");
    // }
    // return response;
    // }

    String photo = "";
}