package com.springboot.mongo.atlas.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.springboot.mongo.atlas.model.Task;


public interface TaskRepository extends MongoRepository<Task, String> {

	List<Task> findBySeverity(int severity);
	
	@Query("{assignee: ?0 }")
	List<Task> getTasksByAssignee(String Assignee);
}
