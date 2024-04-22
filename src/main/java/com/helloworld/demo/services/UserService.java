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

    public BodyData findUserByRollNumber(int rollNumber) {
        System.out.println("===========");
        System.out.println(rollNumber);
        BodyData userData = userRepository.findByRollNumber(rollNumber);
        System.out.println(userData);
        return userData;
    }

    public BodyData updateUser(BodyData requestData){
        System.out.println("************");
        System.out.println(requestData.getFirstName());
        //get the existing document from DB
        // populate new value from request to existing object/entity/document
        BodyData existingUser = userRepository.findByRollNumber(requestData.getRollNumber());

        System.out.println("====================");
        System.out.println(existingUser.getFirstName());
        
        existingUser.setFirstName(requestData.getFirstName());
        existingUser.setLastName(requestData.getLastName());
        existingUser.setRollNumber(requestData.getRollNumber());
        return userRepository.save(existingUser);
    }

    
 
    
}
