package com.example.demo.group.student;

import java.util.Collection;

public interface StudentRepository {
	
	Student findById(Integer id);
	
	Collection<Student> findAll();
	
	boolean deleteById(Integer id);
	
	Student save(Student student);
	
	Collection<Student> findByGroup(String group);
}
