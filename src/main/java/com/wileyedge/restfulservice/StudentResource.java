package com.wileyedge.restfulservice;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController //@RestController = @Controller + @ResponseBody
@CrossOrigin
public class StudentResource {
	
	@Autowired
	private StudentService service;
	
	public StudentResource() {
		System.out.println("Inside default constructor of StudentResource");
	}
	
	
	
	
	@GetMapping(path = "/student")
	public List<Student> retrieveAllStudents(){
		System.out.println("Inside retrieve all");
		System.out.println("Inside retrieveAllstudents of StudentResource");
		List<Student> students = service.getAllStudents();
		System.out.println(students);
		return students;
	}
	
	@GetMapping(path = "/student/{id}")
	public List<Student> retrievesStudent(@PathVariable int id){
		List<Student> students = new ArrayList<Student>();
		System.out.println("Inside retrieveStudent of StudentResource" + id);
		Student student = service.getStudent(id);
		if(student == null) {
			System.out.println("Custom exception is being thrown");
			throw new StudentNotFoundException(id + " not found");
		}
		students.add(student);
		System.out.println(student);
		return students;
	}
	
	@PostMapping(path = "/student")
	public Student createStudent(@RequestBody Student student, BindingResult result, Model model) {
		System.out.println(student.getId());
		System.out.println("Inside createStudent of StudentResource");
		System.out.println(student);
		return service.saveStudent(student);
	}
	
	@DeleteMapping(path= "/student/{id}")
	public void deleteStudent(@PathVariable int id) {
		System.out.println("Inside deleteStudent of StudentResource");
		System.out.println(id);
		
		service.removeStudent(id);
	}
	
	@GetMapping(path="/student/name/{name}")
	public List<Student> getStudentsByName(@PathVariable String name){
		System.out.println("Inside getStudentsByName of StudentResource");
		List <Student> student = service.findByName(name);
		return student;
	}
	
	
	@PutMapping(path="/student/{id}")
	public Student updateStudentById(@PathVariable int id, @RequestBody Student s) {
		
		System.out.println("Inside put mapping");
		System.out.println(s);
		Student cstudent = service.getStudent(id);
		if(cstudent == null) {
			throw new StudentNotFoundException("Student ID invalid");
		} else {
			cstudent.setName(s.getName());
			cstudent.setAge(s.getAge());
			cstudent.setNum(s.getNum());
			cstudent.setAddr(s.getAddr());
			return service.saveStudent(cstudent);
		}
	}

}
