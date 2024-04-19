package com.helloworld.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.helloworld.demo.BobyData.BodyData;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @RestController
    public static class HelloWorldController {

        @GetMapping("/hello")
        public String hello() {
            return "Hello, World!";
        }

        @GetMapping("/greet")
        public String greet() {
            return "Greetings from Spring Boot!";
        }
         
        @PostMapping("/createUser")
    public String createUser(@RequestBody BodyData requestData) {
        String firstName = requestData.getFirstName();
        return "Resource created successfully! Data received: " + firstName;
    }

        
    @PostMapping("/getUser")
    public String getUser(@RequestBody BodyData requestData) {
        String firstName = requestData.getFirstName();
        return "hResource created successfully! Data received: " + firstName;
    }

    @PutMapping("/updateUser")
    public String updateUser() {
        return "Resource updated successfully!";
    }

    @DeleteMapping("/deleteUser")
    public String deleteUser() {
        return "Resource deleted successfully!";
    }
        
    }
}
