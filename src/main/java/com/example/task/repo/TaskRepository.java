package com.example.task.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.task.entity.Tasks;
@Repository
public interface TaskRepository extends JpaRepository<Tasks, Integer>{

}
