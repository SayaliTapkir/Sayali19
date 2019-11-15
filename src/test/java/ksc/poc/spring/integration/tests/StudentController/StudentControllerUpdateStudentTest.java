package ksc.poc.spring.integration.tests.StudentController;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.context.annotation.Description;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import ksc.poc.spring.integration.tests.SpringBootIntTestsApplication;
import ksc.poc.spring.integration.tests.entities.Student;

@SpringBootTest(classes = SpringBootIntTestsApplication.class, webEnvironment = WebEnvironment.RANDOM_PORT)
public class StudentControllerUpdateStudentTest extends StudentControllerTest{
	
	@Test
	@Description("Given valid inputs, returns 200 and updated student response")
	@DisplayName("Given valid inputs, returns 200 and updated student response")
	public void testUpdate() {
		
		// given / arrange
		Student savedStudent = saveStudent();				
		Student request = Student.builder().id(savedStudent.getId()).firstName("Sayali").lastName("Tapkir").build();
		
		// when /act
		HttpEntity<Student> requestEntity = new HttpEntity<Student>(request);
		ResponseEntity<Student> responseEntity = restTemplate.exchange("http://localhost:" + port + "/"+savedStudent.getId(), 
				HttpMethod.PUT,
				requestEntity,
				Student.class);
		
		// then / assert
		assertNotNull(responseEntity, "Expected testUpdate response not null");
		assertEquals(HttpStatus.OK.value(), responseEntity.getStatusCodeValue());
		Student response = responseEntity.getBody();
		assertNotNull(response);
		assertEquals(response.getFirstName(), request.getFirstName(), "First name mismatched");
		assertEquals(response.getLastName(), request.getLastName(), "Last name mismatched");
		assertEquals(response.getId(), request.getId(), "Last name mismatched");
	}

}
