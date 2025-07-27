package com.app.todoapp.controller;

//import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.http.ResponseEntity;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.todoapp.models.TaskModel;
import com.app.todoapp.response.ResponseHandler;
import com.app.todoapp.services.TaskService;

@RestController
@RequestMapping("/tasks/api")
public class TaskControllerAPI {
    
    //private TaskModel taskModel;
    private TaskService taskService;

    public TaskControllerAPI(TaskService taskService){
        this.taskService = taskService;
    }

    //Get All tasks
    @GetMapping
    //default response
    /* public List<TaskModel> getAllTasks(){
        return taskService.getAllTasks();
    }  */
    
    //custom response
    public ResponseEntity<Object> getAllTasks(){
        return ResponseHandler.responseBuilder("Custom response",
        HttpStatus.OK,
        taskService.getAllTasks());
    }

    //Get single task by id
    @GetMapping("/{id}")

    //Default response
   /*  public TaskModel getTaskDetails(@PathVariable("id") Long id){
        return taskService.getTask(id);
    }  */

    //Custom response
    public ResponseEntity<Object> getTaskDetails(@PathVariable("id") Long id) {
        return ResponseHandler.responseBuilder("Custom Response",
        HttpStatus.OK,
        taskService.getTask(id));
    }

    //Create a new task
    @PostMapping
    public String createTask(@RequestBody TaskModel taskModel){
        taskService.createTask(taskModel.getTitle());
        return "Task created successfully";
    }

    //update complete task details
    @PutMapping("/{id}/update")
    public String updateTask(@PathVariable("id") Long id, @RequestBody TaskModel updatedTask){
        taskService.updateTask(id, updatedTask);
        return "Task has been updated successfully";
    }

    //Update only status of task from completed to not completed and vice versa
    @PutMapping("/{id}/toggle")
    public String toggleTask(@PathVariable("id") Long id){
        taskService.toggleTask(id);
        return "Task status has been updated";
    }

    @DeleteMapping("/{id}/delete")
        public String deleteTask(@PathVariable("id") Long id){
            taskService.deleteTask(id);
            return "task has been deleted successfully";
        }


}
