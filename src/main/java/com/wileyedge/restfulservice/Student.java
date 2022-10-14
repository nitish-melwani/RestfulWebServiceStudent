package com.wileyedge.restfulservice;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.springframework.stereotype.Component;

@Entity
@Table(name = "students")
public class Student {
	@Id
	private Integer id;
	
	@Size(min=3,message="Name must have atleast 3 chars")
	@NotBlank(message = "Name is mandatory")
	@Column(name = "sname")
	private String name;
	
	@Column(name = "age")
	private int age;
	
	@Size(min=8,message="Number must have atleast 8 digits")
	@NotBlank(message = "Number is mandatory")
	@Column(name = "num")
	private String num;
	
	@Size(min=3,message="Address must have atleast 3 chars")
	@NotBlank(message = "Address is mandatory")
	@Column(name = "addr")
	private String addr;
	
	public Student() {
		// TODO Auto-generated constructor stub
	}

//	public Student(String name, int age, String num, String addr) {
//		super();
//		this.name = name;
//		this.age = age;
//		this.num = num;
//		this.addr = addr;
//	}
	public Student(int id, String name, int age, String num, String addr) {
		super();
		this.name = name;
		this.age = age;
		this.num = num;
		this.addr = addr;
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getNum() {
		return num;
	}

	public void setNum(String num) {
		this.num = num;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}



	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", age=" + age + ", num=" + num + ", addr=" + addr + "]";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
}
