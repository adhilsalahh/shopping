package com.example.shopping.Service;

import com.example.shopping.Model.Admin;
import com.example.shopping.Model.Product;
import com.example.shopping.Model.User;
import com.example.shopping.Repository.AdminRepository;
import com.example.shopping.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AdminSerice {


    @Autowired
    AdminRepository adminRepository;



    public Admin createAdmin(Admin admin) {
        // Additional logic for validation, password hashing, etc. can be added here
        return adminRepository.save(admin);
    }

    public String editpassword(int adminId, String password) {
        Admin admin = adminRepository.findById(adminId).get();
        admin.setPassword(password);
        adminRepository.save(admin);
        return "Successfull";
    }

    public String deleteid(int adminId) {
        Admin admin = adminRepository.findById(adminId).get();
        adminRepository.deleteById(adminId);
        return "Successfull";
    }

    public String editname(int adminId, String name) {
        Admin admin = adminRepository.findById(adminId).get();
        admin.setName(name);
        adminRepository.save(admin);
        return "successfull";

    }

    public Admin getgmailpassword(String gmail, String password) {
        return adminRepository.findBygmailAndPassword(gmail, password);
    }
}