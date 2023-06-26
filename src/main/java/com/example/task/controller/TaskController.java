package com.example.task.controller;

import java.util.List;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.task.entity.Tasks;
import com.example.task.service.TaskService;
@CrossOrigin("*")
@RestController
public class TaskController {
	@Autowired
	private TaskService taskService;
	
	TaskController(){
		System.out.println("task controller");
	}
	
	@GetMapping("/getAll")
	public ResponseEntity<List<Tasks>> getAllTasks(){
		List<Tasks> list = taskService.getAll();
		return ResponseEntity.ok(list);
	}
	
	@PostMapping("/addTask")
	public ResponseEntity<Tasks> addTask(@RequestBody Tasks task){
		
		return ResponseEntity.ok(taskService.addTask(task));
	}
	
	@GetMapping("/getTask/{id}")
	public ResponseEntity<Tasks> getTask(@PathVariable int id){
		return ResponseEntity.ok(taskService.getTask(id));
	}

	@PutMapping("/updateTask/{id}")
	public ResponseEntity<Tasks> updateTask(@RequestBody Tasks task,@PathVariable int id){
		return ResponseEntity.ok(taskService.updateTask(id, task));
	}
	
	@DeleteMapping("/deleteTask/{id}")
	public ResponseEntity<String> deleteTask(@PathVariable int id){
		taskService.deleteTask(id);
		return ResponseEntity.ok("deleted");
		
	}

}
