package com.springboot.mongo.atlas.service;

import java.util.List;

import com.springboot.mongo.atlas.model.Task;



public interface TaskService {
	Task saveTask(Task task);
	List<Task> getAllTask();
	Task getTaskByTaskId(String taskId );
	Task updateTask(Task task,String taskId);
	String deleteTask(String taskId);

}
