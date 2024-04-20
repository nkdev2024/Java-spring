package com.helloworld.demo.BobyData;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Users")
public class BodyData {
    @Id
    private String firstName;
    private String lastName;
    private String password;
    private Number rollNumber;
// Getters for firstName and rollNumber
public String getFirstName() { 
    return firstName;
}

public String getLastName() {
    return lastName;
}

public String getPassword() {
    return password;
}


public Number getRollNumber() {
    return rollNumber;
}

}
