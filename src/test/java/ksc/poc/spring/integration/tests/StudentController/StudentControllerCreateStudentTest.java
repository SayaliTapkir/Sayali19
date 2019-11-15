package ksc.poc.spring.integration.tests.StudentController;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.context.annotation.Description;

import ksc.poc.spring.integration.tests.SpringBootIntTestsApplication;

@SpringBootTest(classes = SpringBootIntTestsApplication.class, webEnvironment = WebEnvironment.RANDOM_PORT)
public class StudentControllerCreateStudentTest extends StudentControllerTest{

	@Test
	@Description("Given valid inputs, returns 201 and saved student response")
	@DisplayName("Given valid inputs, returns 201 and saved student response")
	public void testSave() {
		saveStudent();
	}

}
