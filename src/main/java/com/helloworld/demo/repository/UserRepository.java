package com.helloworld.demo.repository;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import com.helloworld.demo.BobyData.BodyData;

public interface UserRepository extends MongoRepository<BodyData, ObjectId> {
	// Need to add all the required methods here
	BodyData findByRollNumber(Number rollNumber);
}
