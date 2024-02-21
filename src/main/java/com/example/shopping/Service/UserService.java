package com.example.shopping.Service;

import com.example.shopping.Dto.UserResponse;
import com.example.shopping.Model.User;
import com.example.shopping.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;


    public User createuser (User user){
        return userRepository.save(user) ;
    }

    public String editpassword ( int userId, String password){
        User user = userRepository.findById( userId).get();
        user.setPassword(password);
        userRepository.save(user);
        return "Successfull" ;

    }

    public User getuserid(int userId){

        return userRepository.findById(userId).get();


    }
    public List<UserResponse>getall(){
        List<User> users=userRepository.findAll();

        List<UserResponse> ls= new ArrayList<>();

        for(int i=0;i<users.size();i++){

           UserResponse st=new UserResponse();
            st.setName(users.get(i).getName());
            st.setPassword(users.get(i).getPassword());
            st.setGmail(users.get(i).getGmail());


            ls.add(st);
        }
        return ls;
    }
//    public boolean authenticate(String gmail, String password) {
////        System.out.println(gmail + password);
//        User user = userRepository.findOneByGmail(gmail);
////        System.out.println(user);
//        if (user == null) {
//            return false; // User not found
//        }
//        if ( user.getPassword().equals(password)){
//            return true;
//        }
//        return true;
//    }
//
//public boolean authenticate(String email, String password) {
//    User user = userRepository.findOneByGmail(email);
//
//    if (user != null) {
//        // Validate password (using secure hashing and salting mechanisms)
//        // ...
//        if (user.getPassword().equals(password)){
//            return true;
//        }
//       // Replace with actual password validation logic
//    } else {
//        return false;
//    }
//    return false;
//}

//    public UserDetailResponse loging(LogingRequst userDetailRequest){
//        User userdetail= new User();
//        userdetail.setPassword(userDetailRequest.getPassword());
//        userdetail.setGmail(userDetailRequest.getGmail());
//
//        UserDetailResponse userDetailResponse=new UserDetailResponse();
//
//        userDetailResponse.setPassword(userdetail.getPassword());
//        userDetailResponse.setGmail(userdetail.getGmail());
//       userRepository.save(userdetail);
//       return userDetailResponse;
//    }
//
//    public void adduser(User user) {
//    }
}