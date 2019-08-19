package com.school.book.entity;

import java.util.Date;
public class Book {

	private Integer id;
	private String name;
	private String title;
	private Integer inputId;
	private String inputTime;
	private Integer status;

	public void setId(Integer value) {
		this.id = value;
	}

	public Integer getId() {
		return this.id;
	}
	public void setName(String value) {
		this.name = value;
	}

	public String getName() {
		return this.name;
	}
	public void setTitle(String value) {
		this.title = value;
	}

	public String getTitle() {
		return this.title;
	}
	public void setInputId(Integer value) {
		this.inputId = value;
	}

	public Integer getInputId() {
		return this.inputId;
	}
	public void setInputTime(String value) {
		this.inputTime = value;
	}

	public String getInputTime() {
		return this.inputTime;
	}
	public void setStatus(Integer value) {
		this.status = value;
	}

	public Integer getStatus() {
		return this.status;
	}


	public Book (){

	}

	public Book (
 Integer id ,
 String name ,
 String title ,
 Integer inputId ,
 String inputTime ,
 Integer status 
		){
		this.id = id;
		this.name = name;
		this.title = title;
		this.inputId = inputId;
		this.inputTime = inputTime;
		this.status = status;
	}


}