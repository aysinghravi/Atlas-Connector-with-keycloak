package com.springboot.mongo.atlas.repository;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;

import com.springboot.mongo.atlas.model.Task;

@DataMongoTest
class TaskRepositoryTest {

	@Autowired
	private TaskRepository repository;
	
	
	@BeforeEach
	void setup() {
		Task task = new Task("121","Test2",5,"Ronny",7);
		repository.save(task);
	}
	
	@Test
	public void testFindByTaskId() {
		Task task = repository.findById("121").get();
		assertEquals("Ronny",task.getAssignee() );
	}

}
