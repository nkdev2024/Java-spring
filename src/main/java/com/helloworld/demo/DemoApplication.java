package com.helloworld.demo;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.helloworld.demo.BobyData.BodyData;
import com.helloworld.demo.services.UserService;

// mvn spring-boot:run

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @RestController
    public static class HelloWorldController {

        @Autowired
        UserService userService;

        @GetMapping("/hello")
        public List<BodyData> hello() {
            // return "Hello, World!";
            List<BodyData> data = userService.getAllUsers();
            System.out.println(data.toString());
            return data;
        }

        @GetMapping("/greet")
        public String greet() {
            return "Greetings from Spring Boot!";
        }
         
        @PostMapping("/createUser")
    public String createUser(@RequestBody BodyData requestData) {
        // String userId = requestData.getUserId();
        // String firstName = requestData.getFirstName();
        // String lastName = requestData.getLastName();
        // String password = requestData.getPassword();
        // Number rollNumber = requestData.getRollNumber();
         
        // return "Hello, World!";
         userService.saveUser(requestData);
    
        return " => Resource created successfully! Data received: " ;
    }
 

    // get all users
    @GetMapping("/getAllusers")
    public List<BodyData> getAllUserss() {
        // return "Hello, World!";
        List<BodyData> data = userService.getAllUsers();
        System.out.println(data.toString());
        return data;
    }

        
    @GetMapping("/getUserByrollNumber")
    public BodyData getUser(@RequestParam("rollNumber") int rollNumber) {
        System.out.println(rollNumber);
        BodyData userData = userService.findUserByRollNumber(rollNumber);
        System.out.println(userData);
        return userData;
    }

    @PutMapping("/updateUser")
    public BodyData updateUser(@RequestBody BodyData requestData) {
        // Number rollNumber = requestData.getRollNumber();
        return userService.updateUser(requestData);

        // return "Resource updated successfully!" + rollNumber;
    }

    @DeleteMapping("/deleteUser")
    public String deleteTask(@RequestParam("rollNumber") int rollNumber){
        return userService.deleteUserByrollNumber(rollNumber);
    }
        

    @PostMapping("/fileUpload")
    public  ResponseEntity<String>  fileUploadHandle(@RequestParam("file") MultipartFile file) throws IOException{
        return userService.fileUploadSer(file);
        // return ResponseEntity.status(HttpStatus.OK).body("File uploaded successfully");
    }

    }
}
