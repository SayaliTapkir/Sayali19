package ksc.poc.spring.integration.tests.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ksc.poc.spring.integration.tests.entities.Student;
import ksc.poc.spring.integration.tests.repos.StudentRepository;

@Service
public class StudentService {
	@Autowired
	private StudentRepository studentRepository;

	public Student createStudent(Student student) {
		Student savedStudent = studentRepository.save(student);
		return savedStudent;
	}

	public Iterable<Student> getAllStudents() {
		return studentRepository.findAll();
	}

	public Optional<Student> getStudent(String id) {
		Long studentId = Long.parseLong(id);
		return studentRepository.findById(studentId);
	}

	public Student updateStudent(Student student) {
		return studentRepository.save(student);
	}

	public void deleteStudent(String id) {
		Long studentId = Long.parseLong(id);
		studentRepository.deleteById(studentId);;
	}
}
