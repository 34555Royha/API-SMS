// package com.sms.demo.RestController;

// import java.util.HashMap;
// import java.util.Map;

// import com.sms.demo.Model.User.UserGetById;
// import com.sms.demo.Model.auth.login;
// import com.sms.demo.Service.UserService;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.context.annotation.Bean;
// import org.springframework.http.HttpStatus;
// import org.springframework.http.ResponseEntity;
// import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
// import org.springframework.security.crypto.password.PasswordEncoder;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.RestController;

// import io.swagger.annotations.ApiOperation;
// import io.swagger.annotations.Authorization;

// @RestController
// public class authResController {
// private UserService userService;

// public authResController(UserService userService) {
// this.userService = userService;
// }

// @Bean
// public PasswordEncoder encoder() {
// return new BCryptPasswordEncoder();
// }

// @Autowired
// private PasswordEncoder passwordEncoder;

// @GetMapping("/generate")
// public String password() {
// String password = passwordEncoder.encode("123");
// return password;
// }

// @PostMapping("/login")
// @ApiOperation(value = "Auth", authorizations = { @Authorization(value =
// "BasicAuth") })
// public ResponseEntity<?> GetById(@RequestBody login logins) {
// Map<String, Object> response = new HashMap<>();
// logins.setPassword(passwordEncoder.encode(logins.getPassword()));
// UserGetById userusernaeAndPassword = this.userService.login(logins);
// if (userusernaeAndPassword != null) {
// response.put("status", HttpStatus.OK);
// response.put("message", "Get Success");
// response.put("User", userusernaeAndPassword);
// return ResponseEntity.status(HttpStatus.OK).body(response);
// } else {
// response.put("status", HttpStatus.NOT_FOUND);
// response.put("User", userusernaeAndPassword);
// return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
// }
// }
// }