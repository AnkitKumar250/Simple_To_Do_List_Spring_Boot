package com.app.todoapp.models;
import jakarta.persistence.*;
import lombok.Data;


@Entity
@Data 
public class TaskModel {

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private Long task_id;

        private String title;

        private boolean completed;


        public TaskModel(Long task_id, String title, boolean completed){
            this.task_id = task_id;
            this.title = title;
            this.completed = completed;
        }

        public TaskModel(){

        }

    }