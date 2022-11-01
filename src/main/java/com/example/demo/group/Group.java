package com.example.demo.group;

import java.util.Collection;

import com.example.demo.group.student.Student;

import lombok.Data;

@Data
public class Group {
	private final Integer id;
	private final String groupName;
	//private final Collection<Student> group;
}
