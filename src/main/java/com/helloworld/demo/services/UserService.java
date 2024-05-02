package com.helloworld.demo.services;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.helloworld.demo.BobyData.BodyData;
import com.helloworld.demo.repository.UserRepository;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@Service
public class UserService {

    private final String UPLOAD_DIR = "src/main/java/com/helloworld/demo/services/uploads/";

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

    public String deleteUserByrollNumber(int rollNumber){
        userRepository.deleteByRollNumber(rollNumber);
        return rollNumber+" task deleted from dashboard ";
    }
    
    public ResponseEntity<String>  fileUploadSer(MultipartFile file) throws IOException{
        byte[] bytes = file.getBytes();
        Path path = Paths.get(UPLOAD_DIR + file.getOriginalFilename());
        Files.write(path, bytes);
        return ResponseEntity.status(HttpStatus.OK).body("File uploaded successfully");
    }
    
}
