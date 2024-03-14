package com.example.ToDoApp.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.ToDoApp.model.ToDoItem;

@Repository
public interface ToDoRepo extends JpaRepository<ToDoItem,Long> {

}
