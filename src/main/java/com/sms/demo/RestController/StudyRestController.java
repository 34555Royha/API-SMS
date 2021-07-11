package com.sms.demo.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.sms.demo.Model.Study.Study;
import com.sms.demo.Model.Study.StudyCreate;
import com.sms.demo.Service.StudyService;

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
@RequestMapping("/api/v1/study")
public class StudyRestController {

    private StudyService studyService;

    public StudyRestController(StudyService studyService) {
        this.studyService = studyService;
    }

    @GetMapping("/")
    @ApiOperation(value = "List",authorizations = {@Authorization(value = "BasicAuth")})
    public ResponseEntity<?> List(){
        Map<String, Object> response = new HashMap<>();
        List<Study> studies = this.studyService.List();

        if(studies.size()>=0){
            response.put("studies", studies);
            response.put("Count", studies.size());
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
        Study study = this.studyService.getById(id);

        if(study != null ){
            response.put("status", HttpStatus.OK);
            response.put("message", "Get Success");
            response.put("study", study);
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
        Study study = this.studyService.getById(id);
        
        if(id != null){
            if(this.studyService.Delete(id)){
                response.put("status", HttpStatus.OK);
                response.put("message", "Delete id: "+id+" Success");
                response.put("study", study);
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
    public ResponseEntity<?> Create(@RequestBody StudyCreate studyCreate){
        Map<String, Object> response = new HashMap<>(); 

        if(studyCreate != null ){
            if(this.studyService.Create(studyCreate)){
            response.put("status", HttpStatus.OK);
            response.put("study", studyCreate);
            response.put("message", "Insert Success");
            }else{
                response.put("status", HttpStatus.INTERNAL_SERVER_ERROR);
                response.put("study", studyCreate);
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
    public ResponseEntity<?> Update(@RequestBody Study study){

        Map<String, Object> response = new HashMap<>(); 
        
        if(study.getId() != null || study.getId().isEmpty()){
            if(this.studyService.Update(study)){
                response.put("status", HttpStatus.OK);
                response.put("message", "Updated Success");
                response.put("study after updated", study); 
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
    public ResponseEntity<?> Search(@RequestParam(required = false,defaultValue = "") String StudyType){

        Map<String, Object> response = new HashMap<>(); 

        
        if(StudyType.equals("")){
            List<Study> studies = this.studyService.List();
                response.put("studies", studies);
                response.put("status", HttpStatus.OK);
                response.put("message", "Get success");
                response.put("Count", studies.size());
                return ResponseEntity.status(HttpStatus.OK).body(response);
        }else{
            List<Study> studies = this.studyService.Search(StudyType);
            if(studies.size()>0){
                    response.put("studies", studies);
                    response.put("status", HttpStatus.OK);
                    response.put("message", "Get success");
                    response.put("Count", studies.size());
                    return ResponseEntity.status(HttpStatus.OK).body(response);
            }else{
                response.put("status", HttpStatus.NOT_FOUND);
                response.put("message", "Not Found");
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
            }
        }
    }



}