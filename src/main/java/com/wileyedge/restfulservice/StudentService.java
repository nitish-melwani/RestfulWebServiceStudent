package com.wileyedge.restfulservice;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
	@Autowired
	@Qualifier(value = "datajpa")
	private IDao dao;
	
	public StudentService() {
		System.out.println("Inside default constructor of UserService");
	}
	
	public List<Student> getAllStudents(){
		System.out.println("Inside getAllUsers of UserService");
		return dao.findAll();
	}
	
	public Student getStudent(int id) {
		System.out.println("Inside getUser of UserService");
		Optional<Student> student = dao.findById(id);
		if(student.isPresent()) {
			return student.get();
		}else {
			return null;
		}
	}
	
	public Student saveStudent(Student student) {
		System.out.println("Inside saveStudent of StudentService");
		System.out.println(student);
		System.out.println("After Hibernate call");
		Student x = dao.save(student);
		System.out.println(x);
		return x;
	}
	
	public void removeStudent(int id) {
		System.out.println("Inside removeUser of UserService");
		dao.deleteById(id);
	}
	
	public List<Student> findByName(String name) {
		return dao.findByName(name);
	}
	
	
}
