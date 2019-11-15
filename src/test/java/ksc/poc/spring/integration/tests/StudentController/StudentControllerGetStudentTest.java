package ksc.poc.spring.integration.tests.StudentController;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.context.annotation.Description;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import ksc.poc.spring.integration.tests.SpringBootIntTestsApplication;
import ksc.poc.spring.integration.tests.entities.Student;

@SpringBootTest(classes = SpringBootIntTestsApplication.class, webEnvironment = WebEnvironment.RANDOM_PORT)	
class StudentControllerGetStudentTest extends StudentControllerTest{

	@Test
	@Description("Given valid inputs, returns 200 and get student response")
	@DisplayName("Given valid inputs, returns 200 and get student response")
	public void testGet() {
		
		// given / arrange
		Student savedStudent = saveStudent();
		
		// when /act
		ResponseEntity<Student> responseEntity = this.restTemplate.getForEntity(
				"http://localhost:" + port + "/"+savedStudent.getId(), 
				Student.class);
		
		// then / assert
		assertNotNull(responseEntity, "Expected testGet response not null");
		assertEquals(HttpStatus.OK.value(), responseEntity.getStatusCodeValue());
		Student response = responseEntity.getBody();
		assertNotNull(response);
		
		assertEquals(response.getFirstName(), savedStudent.getFirstName(), "First name mismatched");
		assertEquals(response.getLastName(), savedStudent.getLastName(), "Last name mismatched");
		assertEquals(response.getId(), savedStudent.getId(), "Id mismatched");
	}

}
