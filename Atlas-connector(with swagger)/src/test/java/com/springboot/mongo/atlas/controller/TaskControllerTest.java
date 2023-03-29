package com.springboot.mongo.atlas.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.springboot.mongo.atlas.model.Task;
import com.springboot.mongo.atlas.service.TaskService;

@WebMvcTest(TaskController.class)
class TaskControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private TaskService taskService;
	
	private Task task;
	
	@Autowired
	private ObjectMapper objectMapper;
	
	@BeforeEach
	void setup() {
		task = new Task("133", "Test3", 5, "Shivam", 7);
	}

	@Test
	public void testSaveTask() throws Exception {
		task = new Task("133", "Test3", 5, "Shivam", 7);
		Mockito.when(taskService.saveTask(task)).thenReturn(task);
		mockMvc.perform(MockMvcRequestBuilders.post("/tasks/create")
				.contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(task))).andExpect(status().isCreated()).andDo(print());
	}
}
