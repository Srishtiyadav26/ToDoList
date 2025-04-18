package com.taskStore.entity;

//import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="empList")
public class empList {
	
	@Id
	private int id;
	private String task;
	private String taskDetail;
	private String status;
	public empList() {
		super();
		// TODO Auto-generated constructor stub
	}
	public empList(int id, String task, String taskDetail, String status) {
		super();
		this.id = id;
		this.task = task;
		this.taskDetail = taskDetail;
		this.status = status;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTask() {
		return task;
	}
	public void setTask(String task) {
		this.task = task;
	}
	public String getTaskDetail() {
		return taskDetail;
	}
	public void setTaskDetail(String taskDetail) {
		this.taskDetail = taskDetail;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
}
