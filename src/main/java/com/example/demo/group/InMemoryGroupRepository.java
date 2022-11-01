package com.example.demo.group;

import java.util.Collection;
import java.util.Map;
import java.util.TreeMap;
import org.springframework.stereotype.Repository;

import com.example.demo.group.student.InMemoryStudentRepository;
import com.example.demo.group.student.Student;


@Repository
public class InMemoryGroupRepository implements GroupRepository {

	public InMemoryGroupRepository() {
		groups = new TreeMap<>();
		groups.put(1, new Group(1, "is-01"));
		groups.put(2, new Group(2, "is-02"));
		groups.put(3, new Group(3, "is-03"));
		groups.put(4, new Group(4, "ia-01"));
		groups.put(5, new Group(5, "ia-02"));
	}

	TreeMap<Integer, Group> groups;
	TreeMap<Integer, Student> grouplist;
	
	@Override
	public Group findById(Integer id) {
		return groups.get(id);
	}

	@Override
	public Collection<Group> findAll() {
		return groups.values();
	}

	@Override
	public boolean deleteById(Integer id) {
		return groups.remove(id) != null;
	}

	@Override
	public Group save(Group group) { 
		if(group.getId() != null) {
			groups.put(group.getId(), group);
			return group;
		} else {
			Integer id = groups.lastKey() + 1;
			Group newGroup = new Group(id, group.getGroupName());
			groups.put(id, newGroup);
			return newGroup;
		}
	}

	@Override
	public Collection<Student> findByGroup(String group) {
		return null;
	}


}
