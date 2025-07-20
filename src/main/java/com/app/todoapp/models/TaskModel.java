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

    }