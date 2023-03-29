package com.springboot.mongo.atlas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.mongo.atlas.model.Task;
import com.springboot.mongo.atlas.service.TaskService;



@RestController
@RequestMapping("/tasks")
public class TaskController {
	
	@Autowired
	private TaskService service;
	
	@PostMapping("/create")
	public ResponseEntity<Task> createTask(@RequestBody Task task) {
		return new ResponseEntity<Task>(service.saveTask(task), HttpStatus.CREATED);	}
	
	@GetMapping("/all")
	public List<Task> getAllTask(){
		return service.getAllTask();
	}
	
	@GetMapping("/{taskId}")
	public ResponseEntity<Task> getTaskById(@PathVariable("taskId") String taskId){
		return new ResponseEntity<Task>(service.getTaskByTaskId(taskId),HttpStatus.OK);
	}
	
	@PutMapping("/task/{taskId}")
	public ResponseEntity<Task> updateEmployee(@RequestBody Task task,@PathVariable("taskId") String taskId){
		return new ResponseEntity<Task>(service.updateTask(task, taskId),HttpStatus.OK);
	}
	
	@DeleteMapping("/task/{taskId}")
	public ResponseEntity<String> deleteEmployee(@PathVariable("taskId") String taskId){
		service.deleteTask(taskId);
		return new ResponseEntity<String>("Task deleted successfully",HttpStatus.OK);
	}

}