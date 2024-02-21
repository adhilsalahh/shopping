package com.example.shopping.Controller;

import com.example.shopping.Model.User;
import com.example.shopping.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")


@CrossOrigin(origins = {"http://127.0.0.1:5502", "https://your-trusted-frontend-domain.com"}) // Allow specific, trusted origins
public class LogingController {

        @Autowired
        private UserService userService;

//        @PostMapping("/login1")
//        public UserDetailResponse loging(@RequestBody LogingRequst userDetailRequest){
//            return  userService.loging(userDetailRequest);
//        }

        @RequestMapping(value = "/add", method = RequestMethod.POST)
        public ResponseEntity<String> addUser(@RequestBody User user) { // Use RequestBody for data integrity
                try {
                        userService.adduser(user);
                        return ResponseEntity.ok("User added successfully.");
                } catch (Exception e) {
                        return ResponseEntity.badRequest().body("Error adding user: " + e.getMessage());
                }
        }
}




//        @GetMapping("/login1")
//      public String getLoginPage() {
//            return "login"; // Return the login Thymeleaf template
//
//        }
//            @PostMapping("/login2")
//            public String login (@RequestParam String gmail, @RequestParam String password){
//                System.out.print("api");
//                if (userService.authenticate(gmail, password)) {
//
//                    return "redirect:/home";
//                } else {
//
//                    return "redirect:/login?error=true";
//                }
//            }
//
//
