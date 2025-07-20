package com.app.todoapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.todoapp.models.TaskModel;

@Repository
public interface TaskRepo extends JpaRepository<TaskModel, Long>{

}
