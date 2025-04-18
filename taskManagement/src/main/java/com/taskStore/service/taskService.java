package com.taskStore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taskStore.entity.taskList;
import com.taskStore.repository.taskRepository;

@Service
public class taskService {
	
	@Autowired
	private taskRepository bRepo;
	
	public void save(taskList b) {
		bRepo.save(b);
	}
	
	public List<taskList> getAllTask(){
		return bRepo.findAll();
	}
	
	public taskList getTaskById(int id) {
		return bRepo.findById(id).get();
	}
	public void deleteById(int id) {
		bRepo.deleteById(id);
	}
}
