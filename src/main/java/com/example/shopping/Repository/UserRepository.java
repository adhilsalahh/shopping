package com.example.shopping.Repository;

import com.example.shopping.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
     User findBygmail(String gmail);
     User findBygmailAndPassword(String gmail, String password);



}
