package ksc.poc.spring.integration.tests.StudentController;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import ksc.poc.spring.integration.tests.entities.Student;


public class StudentControllerTest {

	@LocalServerPort
	protected int port;

	@Autowired
	protected TestRestTemplate restTemplate;
	
	protected Student saveStudent() {
		
		// given / arrange
		Student request = Student.builder().firstName("Kaushlendra").lastName("Singh").build();
		
		// when /act
		ResponseEntity<Student> responseEntity = this.restTemplate.postForEntity("http://localhost:" + port, 
				request,
				Student.class);
		
		// then / assert
		assertNotNull(responseEntity, "Expected testSave response not null");
		assertEquals(HttpStatus.CREATED.value(), responseEntity.getStatusCodeValue());
		Student response = responseEntity.getBody();
		assertNotNull(response);
		
		assertEquals(response.getFirstName(), request.getFirstName(), "First name mismatched");
		assertEquals(response.getLastName(), request.getLastName(), "Last name mismatched");
		
		return response;
	}
}
