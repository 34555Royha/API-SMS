package com.sms.demo.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.sms.demo.Model.Schedule.Schedule;
import com.sms.demo.Model.Schedule.ScheduleCreate;
import com.sms.demo.Service.ScheduleService;

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
@RequestMapping("/api/v1/schedule")
public class ScheduleRestController {

    private ScheduleService scheduleService;

    @Autowired
    public ScheduleRestController(ScheduleService service) {
        this.scheduleService = service;
    }

    @GetMapping("/")
    @ApiOperation(value = "List",authorizations = {@Authorization(value = "BasicAuth")})
    public ResponseEntity<?> List(){
        Map<String, Object> response = new HashMap<>();
        List<Schedule> schedules = this.scheduleService.List();

        if(schedules.size()>=0){
            response.put("schedules", schedules);
            response.put("Count", schedules.size());
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

        Schedule schedule = this.scheduleService.getById(id);

        if(schedule != null ){
            response.put("status", HttpStatus.OK);
            response.put("message", "Get Success");
            response.put("schedule", schedule);
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
        Schedule schedule = this.scheduleService.getById(id);
        
        if(id != null){
            if(this.scheduleService.Delete(id)){
                response.put("status", HttpStatus.OK);
                response.put("message", "Delete id: "+id+" Success");
                response.put("schedule", schedule);
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
    public ResponseEntity<?> Create(@RequestBody ScheduleCreate scheduleCreate){
        Map<String, Object> response = new HashMap<>(); 

        if(scheduleCreate != null ){
            if(this.scheduleService.Create(scheduleCreate)){
            response.put("status", HttpStatus.OK);
            response.put("schedule", scheduleCreate);
            response.put("message", "Insert Success");
            }else{
                response.put("status", HttpStatus.INTERNAL_SERVER_ERROR);
                response.put("schedule", scheduleCreate);
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
    public ResponseEntity<?> Update(@RequestBody Schedule schedule){

        Map<String, Object> response = new HashMap<>(); 
        
        if(schedule.getId() != null){
            if(this.scheduleService.Update(schedule)){
                response.put("status", HttpStatus.OK);
                response.put("message", "Updated Success");
                response.put("schedule after updated", schedule); 
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
    public ResponseEntity<?> Search(@RequestParam(required = false,defaultValue = "") String Schedule){

        Map<String, Object> response = new HashMap<>(); 

        
        if(Schedule.equals("")){
            List<Schedule> schedules = this.scheduleService.List();
                response.put("schedules", schedules);
                response.put("status", HttpStatus.OK);
                response.put("message", "Get success");
                response.put("Count", schedules.size());
                return ResponseEntity.status(HttpStatus.OK).body(response);
        }else{
            List<Schedule> schedules = this.scheduleService.Search(Schedule);
            if(schedules.size()>0){
                    response.put("schedules", schedules);
                    response.put("status", HttpStatus.OK);
                    response.put("message", "Get success");
                    response.put("Count", schedules.size());
                    return ResponseEntity.status(HttpStatus.OK).body(response);
            }else{
                response.put("status", HttpStatus.NOT_FOUND);
                response.put("message", "Not Found");
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
            }
        }
    }


}