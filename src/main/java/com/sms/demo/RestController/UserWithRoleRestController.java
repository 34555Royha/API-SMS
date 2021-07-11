package com.sms.demo.RestController;

import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.sms.demo.Model.UserWithRole.ParameterRoleId;
import com.sms.demo.Model.UserWithRole.ParameterUserId;
import com.sms.demo.Model.UserWithRole.UserWithRole;
import com.sms.demo.Model.UserWithRole.UserWithRoleGetById;
import com.sms.demo.Model.UserWithRole.UserWithRoleList;
import com.sms.demo.Service.UserWithRoleService;

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

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Authorization;



@RestController
@RequestMapping("/api/v1/userwithrole")
public class UserWithRoleRestController {

    private UserWithRoleService userWithRoleService;

    @Autowired
    public UserWithRoleRestController(UserWithRoleService userWithRoleService) {
        this.userWithRoleService = userWithRoleService;
    }

    @GetMapping("/")
    @ApiOperation(value = "List",authorizations = {@Authorization(value = "BasicAuth")})
    public ResponseEntity<?> List(){
        Map<String, Object> response = new HashMap<>();
        List<UserWithRoleList> userWithRoles = this.userWithRoleService.List();

        if(userWithRoles.size()>=0){
            response.put("userwithrole", userWithRoles);
            response.put("Count", userWithRoles.size());
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
        UserWithRoleGetById userWithRoleGetById = this.userWithRoleService.getById(id);

        if(userWithRoleGetById != null ){
            response.put("status", HttpStatus.OK);
            response.put("message", "Get Success");
            response.put("userwithrole", userWithRoleGetById);
            return ResponseEntity.status(HttpStatus.OK).body(response);
        }else{
            response.put("status", HttpStatus.NOT_FOUND);
            response.put("message", "Id: "+ id.toString()+" Not Found");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }    
    }

    @PostMapping("")
    @ApiOperation(value = "Create",authorizations = {@Authorization(value = "BasicAuth")})
    public ResponseEntity<?> Create(@RequestBody UserWithRole userWithRole){
        Map<String, Object> response = new HashMap<>(); 

        if(userWithRole != null ){
            if(this.userWithRoleService.Create(userWithRole)){
            response.put("status", HttpStatus.OK);
            response.put("userwithrole", userWithRole);
            response.put("message", "Insert Success");
            }else{
                response.put("status", HttpStatus.INTERNAL_SERVER_ERROR);
                response.put("userwithrole", userWithRole);
                response.put("message", "Insert failed");
            }
            return ResponseEntity.status(HttpStatus.OK).body(response);
        }else{
            response.put("status", HttpStatus.NOT_FOUND);
            response.put("message", "Please input value");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
    }

    @GetMapping("/dropdown")
    @ApiOperation(value = "dropdown",authorizations = {@Authorization(value = "BasicAuth")})
    public ResponseEntity<?> dropdown(){
        Map<String, Object> response = new HashMap<>();
        List<ParameterUserId> parameterUserIds = this.userWithRoleService.parameterUserIds();
        List<ParameterRoleId> parameterRoleIds = this.userWithRoleService.parameterRoleIds();

        if(parameterUserIds.size()>=0&&parameterRoleIds.size()>=0){

            response.put("DropdownUser", parameterUserIds);
            response.put("DropdownRole", parameterRoleIds); 
            response.put("Status", HttpStatus.OK);
            response.put("CountUser", parameterUserIds.size());
            response.put("CountRole", parameterRoleIds.size());
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
        UserWithRoleGetById userWithRoleGetById = this.userWithRoleService.getById(id);
        
        if(id != null){
            if(this.userWithRoleService.Delete(id)){
                response.put("status", HttpStatus.OK);
                response.put("message", "Delete id: "+id+" Success");
                response.put("userwithrole", userWithRoleGetById);
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
    public ResponseEntity<?> Update(@RequestBody UserWithRoleGetById userWithRoleGetById){

        Map<String, Object> response = new HashMap<>(); 
        
        if(userWithRoleGetById.getId() != null){
            if(this.userWithRoleService.Update(userWithRoleGetById)){
                response.put("status", HttpStatus.OK);
                response.put("message", "Updated Success");
                response.put("userwithrole after updated", userWithRoleGetById); 
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
    public ResponseEntity<?> Search(@RequestParam(required = false,defaultValue = "") String user_id){

        Map<String, Object> response = new HashMap<>(); 

        
        if(user_id.equals("")){
            List<UserWithRoleList> userWithRoles = this.userWithRoleService.List();
                response.put("userwithrole", userWithRoles);
                response.put("status", HttpStatus.OK);
                response.put("message", "Get success");
                response.put("Count", userWithRoles.size());
                return ResponseEntity.status(HttpStatus.OK).body(response);
        }else{
            List<UserWithRoleList> userWithRoles = this.userWithRoleService.search(user_id);
            if(userWithRoles.size()>0){
                    response.put("userwithrole", userWithRoles);
                    response.put("status", HttpStatus.OK);
                    response.put("message", "Get success");
                    response.put("Count", userWithRoles.size());
                    return ResponseEntity.status(HttpStatus.OK).body(response);
            }else{
                response.put("status", HttpStatus.NOT_FOUND);
                response.put("message", "Not Found");
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
            }
        }
    }
}
