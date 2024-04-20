package com.helloworld.demo.services;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.helloworld.demo.BobyData.BodyData;
import com.helloworld.demo.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public List<BodyData> getAllUsers(){
        return userRepository.findAll();
    }

    // Getting a specific user by category from collection
    // public BodyData getBookByCategory(Number rollNumber){
    //     BodyData user = userRepository.findByUserId(rollNumber);
    //     return user;
    // }
 
    
}
