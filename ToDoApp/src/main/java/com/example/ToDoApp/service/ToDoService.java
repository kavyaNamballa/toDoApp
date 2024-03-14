package com.example.ToDoApp.service;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ToDoApp.model.ToDoItem;
import com.example.ToDoApp.repos.ToDoRepo;

@Service
public class ToDoService {
	@Autowired
    private ToDoRepo toDoRepo;
	
	public List<ToDoItem> getAllToDoItems() {
		ArrayList<ToDoItem> todoList = new ArrayList<>();
		toDoRepo.findAll().forEach(todo -> todoList.add(todo));
		
		return todoList;
	}
	
	public ToDoItem getToDoItemById(Long id) {
		return toDoRepo.findById(id).get();
	}
	
	public boolean updateStatus(Long id) {
		ToDoItem todo = getToDoItemById(id);
		todo.setStatus("Completed");
		return saveOrUpdateToDoItem(todo);
	}
	
	public boolean saveOrUpdateToDoItem(ToDoItem todo) {
		ToDoItem obj = toDoRepo.save(todo);
		if(getToDoItemById(obj.getId()) != null) {
			return true;
		}
		return false;
		
	}
	
	public boolean deleteToDoItem(Long id) {
		try {
	        toDoRepo.deleteById(id);
	        return true;
	    } catch (NoSuchElementException e) {
	        return false;
	    }
	}
}
