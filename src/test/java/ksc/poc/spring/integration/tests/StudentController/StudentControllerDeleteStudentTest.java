package ksc.poc.spring.integration.tests.StudentController;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

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
public class StudentControllerDeleteStudentTest extends StudentControllerTest{

	@Test
	@Description("Given valid inputs, returns 201 and saved student response")
    @DisplayName("Given valid inputs, returns 201 and saved student response")
	public void testDelete() 
    {
		// given / arrange
		Student savedStudent = saveStudent();
		
		// when /act
		restTemplate.delete("http://localhost:" + port + "/"+savedStudent.getId());
		
		ResponseEntity<Student> responseEntity = this.restTemplate.getForEntity(
				"http://localhost:" + port + "/"+savedStudent.getId(), 
				Student.class);
		
		// then / assert
		assertNotNull(responseEntity, "Expected testDelete response not null");
		assertEquals(HttpStatus.OK.value(), responseEntity.getStatusCodeValue());
		assertNull(responseEntity.getBody());
    }

}
