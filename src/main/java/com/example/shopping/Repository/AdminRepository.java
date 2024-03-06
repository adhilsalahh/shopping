package com.example.shopping.Repository;

import com.example.shopping.Model.Admin;
import com.example.shopping.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends JpaRepository<Admin,Integer> {
    Admin findBygmailAndPassword(String gmail, String password);
}
