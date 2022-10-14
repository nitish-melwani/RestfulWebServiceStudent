package com.wileyedge.restfulservice;

import java.util.List;
import java.util.Optional;

public interface IDao {
	public Student deleteById(int id);
	public List<Student> findAll();
	//public User findById(int id);
	public Student save(Student student);
	Optional<Student> findById(int id);
	List<Student> findByName(String name);

}
