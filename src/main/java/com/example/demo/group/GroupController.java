package com.example.demo.group;
import java.util.Collection;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.group.student.Student;
import com.example.demo.group.student.StudentRepository;

import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/groups")
public class GroupController {
	
GroupRepository groupRepository;
	
	public GroupController(GroupRepository groupRepository) {
		this.groupRepository = groupRepository;
	}
	
	@GetMapping()
	Collection<Group> findAll(){
		return groupRepository.findAll();
	}
	
	//@GetMapping("/{id}")
	//ResponseEntity<Group> findById(@PathVariable Integer id) {
		//Group group = groupRepository.findById(id);
		//if(group == null) {
			//return ResponseEntity.notFound().build();
		//}
		//return ResponseEntity.ok(group);
	//}
	
	
	@DeleteMapping("/{id}")
	ResponseEntity<?> deleteById(@PathVariable Integer id) {
		if (groupRepository.deleteById(id)) {
			return ResponseEntity.ok().build();
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	
	
	@PutMapping("/{id}")
	ResponseEntity<?> save(@PathVariable Integer id, @RequestBody Group group) {
		if(id == null | !id.equals(group.getId())) {
			return ResponseEntity.badRequest().build();
		}
		groupRepository.save(group);
		return ResponseEntity.noContent().build();
	}
 
	
	@PostMapping()
	void create(@RequestBody Group group) {
		groupRepository.save(group);
	}
	
	@GetMapping("/{groupName}")
	ResponseEntity<Collection<Student>> findByGroup(@PathVariable String groupName) {
		Collection<Student> students = groupRepository.findByGroup(groupName);
		if(students.size() == 0) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(students);
	}
}
