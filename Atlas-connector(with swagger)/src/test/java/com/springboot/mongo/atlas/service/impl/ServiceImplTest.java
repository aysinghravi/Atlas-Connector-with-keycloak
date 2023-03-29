package com.springboot.mongo.atlas.service.impl;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.springboot.mongo.atlas.model.Task;
import com.springboot.mongo.atlas.repository.TaskRepository;
import com.springboot.mongo.atlas.service.TaskService;

@SpringBootTest
class ServiceImplTest {
	
	@Autowired
	private TaskService taskService;
	
	@MockBean
	private  TaskRepository repository ;
	
	@BeforeEach
	void setup() {
		Optional<Task> task = Optional.of(new Task("121", "Test", 6, "Rahul", 7));
		Mockito.when(repository.findById("121")).thenReturn(task);
	}
	
	@Test
	public void testGetTaskById_Success() {
		String assignee = "Rahul";
		Task taskById =  taskService.getTaskByTaskId("121");
		assertEquals(assignee, taskById.getAssignee());
	}

}
