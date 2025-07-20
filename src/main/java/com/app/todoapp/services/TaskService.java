package com.app.todoapp.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.app.todoapp.models.TaskModel;
import com.app.todoapp.repositories.TaskRepo;

@Service
public class TaskService {
    private final TaskRepo taskRepo;

    public TaskService(TaskRepo taskRepo){
        this.taskRepo = taskRepo;
    }

    public List<TaskModel> getAllTasks(){
        return taskRepo.findAll();
    }

    public void createTask(String title){
        TaskModel task = new TaskModel();
        task.setTitle(title);
        task.setCompleted(false);
        taskRepo.save(task);
    }

    public void deleteTask(Long id){
        taskRepo.deleteById(id);
    }

    public void toggleTask(Long id){
        TaskModel task = taskRepo.findById(id).orElseThrow(() -> new IllegalArgumentException("invalid task id!"));
        task.setCompleted(!task.isCompleted());
        taskRepo.save(task);
    }
}
