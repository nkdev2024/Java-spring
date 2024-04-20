package com.helloworld.demo;

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
        String firstName = requestData.getFirstName();
        String lastName = requestData.getLastName();
        String password = requestData.getPassword();
        Number rollNumber = requestData.getRollNumber();
         
        // return "Hello, World!";
        BodyData data = userService.saveUser(requestData);
    
        return data + " => Resource created successfully! Data received: " + firstName 
        + lastName + password + rollNumber;
    }

        
    @GetMapping("/getUser")
    public BodyData getUser(@RequestParam("rollNumber") Number rollNumber) {
        BodyData userData = userService.findUserByRollNumber(rollNumber);
        System.out.println(userData);
        return userData;
    }

    @PutMapping("/updateUser")
    public String updateUser(@RequestBody BodyData requestData) {
        Number rollNumber = requestData.getRollNumber();
        return "Resource updated successfully!" + rollNumber;
    }

    @DeleteMapping("/deleteUser")
    public String deleteUser(@RequestBody BodyData requestData) {
        Number rollNumber = requestData.getRollNumber();
        return "Resource deleted successfully!"+ rollNumber;
    }
        
    }
}
