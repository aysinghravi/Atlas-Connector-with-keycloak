package com.springboot.mongo.atlas.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.mongo.atlas.model.Task;
import com.springboot.mongo.atlas.repository.TaskRepository;
import com.springboot.mongo.atlas.service.TaskService;



@Service
public class Serviceimpl implements TaskService {
	@Autowired
	private TaskRepository repository;
	
	@Override
	public Task saveTask(Task task) {
		return repository.save(task);
	}
	
	@Override
	public List<Task> getAllTask(){
		return repository.findAll();
	}
	
	@Override
	public Task getTaskByTaskId(String taskId ) {
		return repository.findById(taskId).get();
	}
	
	@Override
	public Task updateTask(Task task, String taskId) {
		//get existing doc from db
		//populate new value from request to existing object
		Task existingTask = repository.findById(task.getTaskId()).get();
		existingTask.setDescription(task.getDescription());
		existingTask.setSeverity(task.getSeverity());
		existingTask.setAssignee(task.getAssignee());
		existingTask.setStoryPoint(task.getStoryPoint());
		return repository.save(existingTask);
	}
	
	@Override
	public String deleteTask(String taskId) {
		repository.deleteById(taskId);
		return taskId+ "task deleted from dashboard";
	}
	
}