package com.wileyedge.restfulservice;


import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

@Repository(value = "inmemory")
//@Profile(value = "dev")
public class StudentInMemoryRepository implements IDao {
	private static List<Student> students = new ArrayList<Student>();
	private static int studentCount = 3;
	static {
		students.add(new Student(10, "Nitish", 22, "8888888888", "Hong Kong"));
		students.add(new Student(15, "Jeff", 22, "999999999999", "America"));
		students.add(new Student(20, "Marty", 22, "7777777777", "Hong Kong"));
	}
	
	public StudentInMemoryRepository() {
		System.out.println("Inside default constuctor of UserInMemoryRepository");
	}
	
	
	
	@Override
	public Student deleteById(int id) {
		System.out.println("Inside deleteById of UserInMemoryRepository");
		Iterator<Student> iter = students.iterator();
		while(iter.hasNext()) {
			Student u = iter.next();
			if(u.getId() == id) {
				iter.remove();
				return u;
			}
		}
		return null;
	}

	@Override
	public List<Student> findAll() {
		System.out.println("Inside findAll of UserInMemoryRepository");
		return students;
	}

	@Override
	public Student save(Student student) {
		System.out.println("Inside save of UserInMemoryRepository");
		students.add(student);
		studentCount++;
		return student;
	}

	@Override
	public Optional<Student> findById(int id) {
		System.out.println("Inside findById of UserInMemoryRepository");

		Student student=students.stream().filter(a -> a.getId() == id).findAny().orElse(null);
	    Optional<Student> opt = Optional.ofNullable(student);
	        return opt;
	}



	@Override
	public List<Student> findByName(String name) {
		System.out.println("Inside findByName of UserInMemoryRepository");
		
		return null;
	}

}
