package com.example.shopping.Controller;

import com.example.shopping.Model.Admin;
import com.example.shopping.Service.AdminSerice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    AdminSerice adminSerice;



    @PostMapping("/add")
    public Admin createAdmin(@RequestBody Admin admin) {
        return adminSerice.createAdmin(admin);
    };
    @PutMapping("/editPassword") // id use cheythitt password edit cheyann vendeee
    public String editpassword(@RequestParam ("adminId") int adminId ,
                               @RequestParam ("password") String password ){
        return adminSerice.editpassword(adminId,password);
    }
    @DeleteMapping("/delete/{id}")
    public  String deleteid (@PathVariable ("adminId") int adminId){
        return adminSerice.deleteid(adminId);
    }
    @PutMapping("/editName")
    public String editname(@RequestParam ("adminId") int adminId  ,
                           @RequestParam ("name") String name  ){
        return adminSerice.editname(adminId,name);
    }




}

