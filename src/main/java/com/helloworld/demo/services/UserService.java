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
        List<BodyData> smpData =  userRepository.findAll();
        System.out.println(smpData);
        return smpData;
    }

    
    public BodyData saveUser(BodyData requestData){
        BodyData smpData =  userRepository.save(requestData);
        System.out.println(smpData);
        return smpData;
    }

    // Getting a specific user by category from collection
    // public BodyData getBookByCategory(Number rollNumber){
    //     BodyData user = userRepository.findByUserId(rollNumber);
    //     return user;
    // }
 
    
}
