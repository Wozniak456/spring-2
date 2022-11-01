package com.example.demo.group;

import java.util.Collection;

import com.example.demo.group.student.Student;

public interface GroupRepository {
	
	Group findById(Integer id);
	
	Collection<Group> findAll();
	
	boolean deleteById(Integer id);
	
	Group save(Group student);
	
	Collection<Student> findByGroup(String group);
}
