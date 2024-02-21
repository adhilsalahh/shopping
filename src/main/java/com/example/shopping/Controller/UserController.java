package com.example.shopping.Controller;

import com.example.shopping.Dto.LogingRequst;
import com.example.shopping.Dto.LogingResponse;
import com.example.shopping.Dto.UserResponse;
import com.example.shopping.Model.User;
import com.example.shopping.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "http://127.0.0.1:5502")

public class UserController {


    @Autowired
    UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/add")
    public User createuser(@RequestBody User user) {
        return userService.createuser(user);
    }

    @PostMapping("/editpassord")
    public String editpassword(@RequestParam("userId") int userId,
                               @RequestParam("password") String password) {
        return userService.editpassword(userId, password);
    }

    @GetMapping("/get/{userId}")
    public User getuserId(@PathVariable("userId") int userId) {
        return userService.getuserid(userId);
    }

    @GetMapping("/users")
    public List<UserResponse> getalluser() {
        return userService.getall();
    }


    @RequestMapping(value = "/user/add", method = RequestMethod.POST)
    public String addUser() {
        // Add user logic
        return "User added successfullyz";
    }


    @PostMapping("/loginguser")
    public ResponseEntity<String> login(@RequestBody User user) {
        boolean isAuthenticated = userService.authenticateUser(user);
        if (isAuthenticated) {
            return ResponseEntity.status(HttpStatus.ACCEPTED).body("Login successful"); // Updated response status
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid username or password"); // Updated response status
        }
    }



    @PostMapping("/login") // Use @PostMapping instead of @GetMapping
    public ResponseEntity<User> login(@RequestBody LogingRequst loginRequest) {
        User user = userService.getUserBygmailAndPassword(loginRequest.getGmail(), loginRequest.getPassword());
        if (user != null) {
            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
