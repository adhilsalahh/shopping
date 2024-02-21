package com.example.shopping.Controller;

import com.example.shopping.Dto.LogingRequst;
import com.example.shopping.Dto.LogingResponse;
import com.example.shopping.Dto.UserResponse;
import com.example.shopping.Model.User;
import com.example.shopping.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "http://127.0.0.1:5502")

public class UserController {


    @Autowired
    UserService userService;

    @PostMapping("/add")
    public User  createuser (@RequestBody User user){
        return  userService.createuser(user);
    }

    @PostMapping ("/editpassord")
    public String editpassword (@RequestParam ("userId") int userId,
                              @RequestParam ("password") String password){
        return  userService.editpassword(userId,password);
    }

    @GetMapping("/get/{userId}")
    public User getuserId(@PathVariable("userId") int userId){
        return userService.getuserid(userId);
    }
    @GetMapping("/users")
    public List<UserResponse>getalluser(){
        return userService.getall();
    }


    @RequestMapping(value = "/user/add", method = RequestMethod.POST)
    public String addUser() {
        // Add user logic
        return "User added successfullyz";
    }
    @GetMapping("/login")
    public String getLoginPage() {
        return "login";
    }

//    @PostMapping("/login")
//    public ResponseEntity<String> loginUser(@RequestBody LoginRequest request) {
//        // Validate input... (omitted for brevity)
//        User user = userService.authenticate(request.getUsername(), request.getPassword());
//        if (user == null) {
//            return ResponseEntity.badRequest().body("Invalid credentials.");
//        }
//
//        String token = generateJwtToken(user); // Replace with secure token generation
//        return ResponseEntity.ok(token);
//    }
//



}
