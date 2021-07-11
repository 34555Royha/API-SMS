package com.sms.demo.RestController;

import java.util.Base64;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.sms.demo.Model.User.UserCreate;
import com.sms.demo.Model.User.UserGetById;
import com.sms.demo.Model.User.UserUpdate;
import com.sms.demo.Model.auth.login;
import com.sms.demo.Service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Authorization;

@RestController
// @RequestMapping("/api/v1/user")
public class UserRestController {

    private UserService userService;

    public UserRestController(UserService userService) {
        this.userService = userService;
    }

    @Bean
    public PasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("/generate")
    public String password() {
        String password = passwordEncoder.encode("123");
        return password;
    }

    @GetMapping("/user/")
    @ApiOperation(value = "List", authorizations = { @Authorization(value = "BasicAuth") })
    public ResponseEntity<?> List() {
        Map<String, Object> response = new HashMap<>();
        List<UserGetById> users = this.userService.List();

        if (users.size() >= 0) {
            response.put("Users", users);
            response.put("Count", users.size());
            response.put("Status", HttpStatus.OK);
            response.put("Message", "Success");
            return ResponseEntity.status(HttpStatus.OK).body(response);
        } else {
            response.put("Message", "Not Found");
            response.put("Status", HttpStatus.NOT_FOUND);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
    }

    @PostMapping("/login")
    @ApiOperation(value = "Auth", authorizations = { @Authorization(value = "BasicAuth") })
    public ResponseEntity<?> Login(@RequestBody login logins) {
        String basicKey = "Basic "
                + Base64.getUrlEncoder().encodeToString((logins.getUsername() + ":" + logins.getPassword()).getBytes());
        Map<String, Object> response = new HashMap<>();
        UserGetById userusernaeAndPassword = this.userService.login(basicKey);
        if (userusernaeAndPassword != null) {
            response.put("status", HttpStatus.OK);
            response.put("message", "Login Success");
            response.put("User", userusernaeAndPassword);
            return ResponseEntity.status(HttpStatus.OK).body(response);
        } else {
            response.put("message", "Invalid Username and Password");
            response.put("status", HttpStatus.NOT_FOUND);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
    }

    @PostMapping("/register")
    @ApiOperation(value = "Register", authorizations = { @Authorization(value = "BasicAuth") })
    public ResponseEntity<?> Create(@RequestBody UserCreate userCreate) {
        Map<String, Object> response = new HashMap<>();

        if (userCreate != null) {
            userCreate.setApiKey("Basic " + Base64.getUrlEncoder()
                    .encodeToString((userCreate.getUsername() + ":" + userCreate.getPassword()).getBytes()));
            userCreate.setPassword(passwordEncoder.encode(userCreate.getPassword()));
            if (this.userService.Create(userCreate)) {
                response.put("status", HttpStatus.OK);
                response.put("role", userCreate);
                response.put("message", "Insert Success");
            } else {
                response.put("status", HttpStatus.INTERNAL_SERVER_ERROR);
                response.put("role", userCreate);
                response.put("message", "Insert failed");
            }
            return ResponseEntity.status(HttpStatus.OK).body(response);
        } else {
            response.put("status", HttpStatus.NOT_FOUND);
            response.put("message", "Please input value");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
    }

    @GetMapping("/api/v1/user/{id}")
    @ApiOperation(value = "GetById", authorizations = { @Authorization(value = "BasicAuth") })
    public ResponseEntity<?> GetById(@PathVariable(required = true) String id) {
        Map<String, Object> response = new HashMap<>();
        UserGetById userGetById = this.userService.GetById(id);

        if (userGetById != null) {
            response.put("status", HttpStatus.OK);
            response.put("message", "Get Success");
            response.put("User", userGetById);
            return ResponseEntity.status(HttpStatus.OK).body(response);
        } else {
            response.put("status", HttpStatus.NOT_FOUND);
            response.put("message", "Id: " + id.toString() + " Not Found");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
    }

    @PutMapping("/api/v1/user/")
    @ApiOperation(value = "Update", authorizations = { @Authorization(value = "BasicAuth") })
    public ResponseEntity<?> Update(@RequestBody UserUpdate userUpdate) {

        Map<String, Object> response = new HashMap<>();

        if (userUpdate.getId() != null) {
            userUpdate.setApiKey("Basic " + Base64.getUrlEncoder()
                    .encodeToString((userUpdate.getUsername() + ":" + userUpdate.getPassword()).getBytes()));
            if (this.userService.Update(userUpdate)) {
                response.put("status", HttpStatus.OK);
                response.put("message", "Updated Success");
                response.put("User", userUpdate);
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

    @DeleteMapping("/api/v1/user/{id}")
    @ApiOperation(value = "Delete", authorizations = { @Authorization(value = "BasicAuth") })
    public ResponseEntity<?> Delete(@PathVariable(required = true) String id) {

        Map<String, Object> response = new HashMap<>();
        UserGetById userGetById = this.userService.GetById(id);

        if (id != null) {
            if (this.userService.Delete(id)) {
                response.put("status", HttpStatus.OK);
                response.put("message", "Delete id: " + id + " Success");
                response.put("User", userGetById);
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

    @GetMapping("/api/v1/user/search")
    @ApiOperation(value = "Search", authorizations = { @Authorization(value = "BasicAuth") })
    public ResponseEntity<?> Search(@RequestParam(required = false, defaultValue = "") String username) {

        Map<String, Object> response = new HashMap<>();

        if (username.equals("")) {
            List<UserGetById> userGetByIds = this.userService.List();
            response.put("users", userGetByIds);
            response.put("status", HttpStatus.OK);
            response.put("message", "Get success");
            response.put("Count", userGetByIds.size());
            return ResponseEntity.status(HttpStatus.OK).body(response);
        } else {
            List<UserGetById> userGetByIds = this.userService.search(username);
            if (userGetByIds.size() > 0) {

                response.put("users", userGetByIds);
                response.put("status", HttpStatus.OK);
                response.put("message", "Get success");
                response.put("Count", userGetByIds.size());
                return ResponseEntity.status(HttpStatus.OK).body(response);
            } else {
                response.put("status", HttpStatus.NOT_FOUND);
                response.put("message", "Not Found");
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
            }
        }
    }

    public static void main(String[] args) {
        String username = "vina";
        String pasword = "123";
        String basicKey = "Basic " + Base64.getUrlEncoder().encodeToString((username + ":" + pasword).getBytes());
        System.out.println(basicKey);
    }

}