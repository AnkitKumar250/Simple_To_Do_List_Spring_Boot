package com.app.todoapp.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.app.todoapp.exception.TaskNotFoundException;
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
        TaskModel task = taskRepo.findById(id).orElseThrow(() -> new TaskNotFoundException("This task does not exist!"));
        task.setCompleted(!task.isCompleted());
        taskRepo.save(task);
    }

 
    public TaskModel getTask(Long id) {
        return taskRepo.findById(id).orElseThrow(() -> new TaskNotFoundException("This task does not exist!"));
    }

    public void updateTask(Long id, TaskModel updatedTask){
        TaskModel existingTask = taskRepo.findById(id).orElseThrow(() -> new TaskNotFoundException("This task does not exist"));
        existingTask.setTitle(updatedTask.getTitle());
        existingTask.setCompleted(updatedTask.isCompleted());

        taskRepo.save(existingTask);
    }

    
}
