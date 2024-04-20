package com.helloworld.demo.BobyData;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Users")
public class BodyData {
    @Id
    private ObjectId _id;
    private String firstName;
    private String lastName;
    private String password;
    private Number rollNumber;


// Getters Function
public ObjectId getUserId() { 
    return _id;
}

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

// setter function

public void setFirstName(String firstName) {
    this.firstName = firstName;
}

public void setLastName(String lastName) {
    this.lastName = lastName;
}

public void setPassword(String password) {
    this.password = password;
}

public void setRollNumber(Number rollNumber) {
    this.rollNumber = rollNumber;
}

}
