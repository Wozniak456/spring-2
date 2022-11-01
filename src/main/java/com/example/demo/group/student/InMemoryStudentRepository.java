package com.example.demo.group.student;

import java.util.Collection;
import java.util.Map;
import java.util.TreeMap;
import org.springframework.stereotype.Repository;

@Repository
public class InMemoryStudentRepository implements StudentRepository {

	public InMemoryStudentRepository() {
		students = new TreeMap<>();
		students.put(1, new Student(1, "Anna", "Sperkach", "is"));
		students.put(2, new Student(2, "Sofiia", "Vozniak", "is-01"));
		students.put(3, new Student(3, "Karina", "Dudukchian", "is-01"));
		students.put(4, new Student(4, "Anna", "Mikhnenko", "is-01"));
		students.put(5, new Student(5, "Denys", "Neklass", "is-02"));
		students.put(6, new Student(6, "Bohdan", "Servetnik", "is-01"));
	}

	public TreeMap<Integer, Student> students;
	TreeMap<Integer, Student> groupList;
	
	public TreeMap<Integer, Student> getStudentList(){
		return this.students;
	}
	
	
	@Override
	public Student findById(Integer id) {
		return students.get(id);
	}

	@Override
	public Collection<Student> findAll() {
		return students.values();
	}

	@Override
	public boolean deleteById(Integer id) {
		return students.remove(id) != null;
	}
	
	@Override
	public Collection<Student> findByGroup(String group){
		groupList = new TreeMap<>();
		for(Map.Entry<Integer,Student> entry : students.entrySet()) {
			Integer key = entry.getKey();
			Student value = entry.getValue();
			
			if (value.getGroupName().equals(group))
				groupList.put(key, value);
		}
		return groupList.values();
	}

	@Override
	public Student save(Student student) { 
		if(student.getId() != null) {
			students.put(student.getId(), student);
			return student;
		} else {
			Integer id = students.lastKey() + 1;
			Student newStudent = new Student(id, student.getFirstName(), student.getLastName(), student.getGroupName());
			students.put(id, newStudent);
			return newStudent;
		}
	}
	
	

}
