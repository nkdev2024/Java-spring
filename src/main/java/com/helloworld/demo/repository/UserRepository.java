package com.helloworld.demo.repository;
import org.springframework.data.mongodb.repository.MongoRepository;
import com.helloworld.demo.BobyData.BodyData;

public interface UserRepository extends MongoRepository<BodyData, String> {
	// Need to add all the required methods here
	BodyData findByRollNumber(int rollNumber);

	BodyData deleteByRollNumber(int rollNumber);
}
