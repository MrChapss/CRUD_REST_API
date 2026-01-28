package com.example.demo.entity;

public class TDL {
	private int id;
	private String title;
	private String description;
	private boolean is_completed;
	
	public TDL(int id, String title, String description, boolean is_completed) {
		this.id = id;
		this.title = title;
		this.description = description;
		this.is_completed = is_completed;
	}
	
	
	public void setId(int id) {this.id = id;}
	public int getId() {return id;}
	
	public void setTitle(String title) {this.title = title;}
	public String getTitle() {return title;}
	
	public String getDescription() {return description;}
	public boolean getIs_completed() {return is_completed;}
	
	
}
