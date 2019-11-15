package ksc.poc.spring.integration.tests.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ksc.poc.spring.integration.tests.entities.Student;
import ksc.poc.spring.integration.tests.services.StudentService;

@RestController
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	@PostMapping
	public ResponseEntity<Student> createStudent(@RequestBody Student student){
		Student savedStudent = studentService.createStudent(student);
		return ResponseEntity
				.status(HttpStatus.CREATED)
				.body(savedStudent);
	}
	
	@GetMapping
	public Iterable<Student> getAllStudents(){ 
		return studentService.getAllStudents(); 
	}

	@GetMapping("/{id}") 
	public Optional<Student> getStudent(@PathVariable String id){ 
		return studentService.getStudent(id); 
	}

	@PutMapping("/{id}") 
	public ResponseEntity<Student> updateStudent(@RequestBody Student student, @PathVariable String id){
		Student updatedStudent = studentService.updateStudent(student);
		return ResponseEntity
				.status(HttpStatus.OK)
				.body(updatedStudent);
	}
	
	@DeleteMapping("/{id}")
	public void deleteStudent(@PathVariable String id){
		studentService.deleteStudent(id);
	}
	
	
}
