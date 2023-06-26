package com.example.task.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.task.entity.Tasks;


@Service
public class TaskService {
	@Autowired
	private com.example.task.repo.TaskRepository taskRepo;
	
	TaskService(){
		System.out.println("task service");
	}
	
	public List<Tasks> getAll(){
		List<Tasks> list = taskRepo.findAll(); 
		return list;
	}
	
	public Tasks addTask(Tasks task) {
		return taskRepo.save(task);
	}
	
	public Tasks getTask(int id) {
		return taskRepo.findById(id).orElseThrow(null);
	}
	
	public Tasks updateTask(int id, Tasks task) {
		Tasks t=taskRepo.findById(id).orElseThrow(null);
		t.setName(task.getName());
		t.setTitle(task.getTitle());
		t.setDescription(task.getDescription());
		t.setStartDate(task.getStartDate());
		t.setEndDate(task.getEndDate());
		t.setStatus(task.getStatus());
		return taskRepo.save(t);
	}
	
	public void deleteTask(int id) {
		Tasks task=taskRepo.findById(id).orElseThrow(null);
		taskRepo.delete(task);
	}
	
}
