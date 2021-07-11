package com.sms.demo.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.sms.demo.Model.Role.Role;
import com.sms.demo.Model.Role.RoleUpdate;
import com.sms.demo.Service.RoleService;

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
@RequestMapping("/api/v1//role")
public class RoleRestController {

    private RoleService roleService;
    @Autowired
    public RoleRestController(RoleService roleService) {
        this.roleService = roleService;
    }



    @GetMapping("")
    @ApiOperation(value = "List",authorizations = {@Authorization(value = "BasicAuth")})
    public ResponseEntity<?> list(){

        Map<String, Object> response = new HashMap<>();
        List<Role> roles = this.roleService.getList();

        if(roles.size()>=0){
            response.put("Roles", roles);
            response.put("Count", roles.size());
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
    public ResponseEntity<?> Create(@RequestBody String role){
        Map<String, Object> response = new HashMap<>(); 

        if(role != null ){
            if(this.roleService.Creat(role)){
            response.put("status", HttpStatus.OK);
            response.put("role", role);
            response.put("message", "Insert Success");
            }else{
                response.put("status", HttpStatus.INTERNAL_SERVER_ERROR);
                response.put("role", role);
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
    @ApiOperation(value = "GetByID",authorizations = {@Authorization(value = "BasicAuth")})
    public ResponseEntity<?> GetByID(@PathVariable(required = true) String id){

        Map<String, Object> response = new HashMap<>(); 
        Role role = this.roleService.GetByID(id);

        if(role != null ){
            response.put("status", HttpStatus.OK);
            response.put("message", "Get Success");
            response.put("role", role);
            return ResponseEntity.status(HttpStatus.OK).body(response);
        }else{
            response.put("status", HttpStatus.NOT_FOUND);
            response.put("message", "Id: "+ id.toString() +" Not Found");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
    }

    @PutMapping("")
    @ApiOperation(value = "Update",authorizations = {@Authorization(value = "BasicAuth")})
    public ResponseEntity<?> Update(@RequestBody RoleUpdate roleUpdate){

        Map<String, Object> response = new HashMap<>(); 
        
        if(roleUpdate.getId() != null){
            if(this.roleService.Update(roleUpdate) == true){
                response.put("status", HttpStatus.OK);
                response.put("message", "Updated Success");
                response.put("role", roleUpdate); 
            }else{
                response.put("status", HttpStatus.NOT_FOUND);
                response.put("message", "Updated failed");
            }
        return ResponseEntity.status(HttpStatus.OK).body(response);
        }else{
            response.put("status", HttpStatus.NOT_FOUND);
            response.put("message", "Please Input Value");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Delete",authorizations = {@Authorization(value = "BasicAuth")})
    public ResponseEntity<?> Delete(@PathVariable(required = true) String id){

        Map<String, Object> response = new HashMap<>(); 
        
        if(id != null){
            if(this.roleService.Delete(id)){
                response.put("status", HttpStatus.OK);
                response.put("message", "Delete id: "+id+" Success");
                // response.put("ROle", this.roleService.GetByID(id));
            }else{
                response.put("status", HttpStatus.INTERNAL_SERVER_ERROR);
                response.put("message", "Delete failed");
            }
        return ResponseEntity.status(HttpStatus.OK).body(response);
        }else{
            response.put("status", HttpStatus.NOT_FOUND);
            response.put("message", "Please Input ID");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
    }

    @GetMapping("/search")
    @ApiOperation(value = "Search",authorizations = {@Authorization(value = "BasicAuth")})
    public ResponseEntity<?> Search(@RequestParam(required = false,defaultValue = "") String role){

        Map<String, Object> response = new HashMap<>(); 

        
        if(role.equals("")){
        List<Role> roles = this.roleService.getList();
                response.put("roles", roles);
                response.put("status", HttpStatus.OK);
                response.put("message", "Get success");
                response.put("Count", roles.size());
                return ResponseEntity.status(HttpStatus.OK).body(response);
        }else{
         List<Role> roles = this.roleService.search(role);
        if(roles.size()>0){

                response.put("roles", roles);
                response.put("status", HttpStatus.OK);
                response.put("message", "Get success");
                response.put("Count", roles.size());
                return ResponseEntity.status(HttpStatus.OK).body(response);
        }else{
            response.put("status", HttpStatus.NOT_FOUND);
             response.put("message", "Get success");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
        }
    }
}
