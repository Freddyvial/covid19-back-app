package com.poli.covid19;

import com.poli.covid19.controllers.PatientsController;
import com.poli.covid19.domain.*;
import com.poli.covid19.repositories.impl.AnswerPatientRepositoryImpl;
import com.poli.covid19.repositories.impl.PatientsRepositoryImpl;
import com.poli.covid19.repositories.impl.QuestionRepositoryImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.Assert.assertEquals;

@SpringBootTest
class Covid19ApplicationTests {

	@Autowired
	private QuestionRepositoryImpl questionRepositoryImpl;

	@Autowired
	private PatientsController patientsController;



	@Test
	void UnitTestResultPatient() throws Exception {
		TestPatient();

	}

	@Test
	void UnitTestNumberQuestion() {
		TestNumberQuestion();

	}

	private void TestPatient() throws Exception {
		Patient newPatient=new Patient();
		newPatient.setId("");
		newPatient.setDocumentNumber("1152209");
		newPatient.setFullName("AndresF");
		newPatient.setDirection("Calle 32c # 30a");
		newPatient.setPhone("3206796543");
		newPatient.setEmail("Andres.f@gmail.com");
		DocumentType documentType = new DocumentType();
		documentType.setId("3");
		documentType.setValue("Cédula de ciudadanía");
		newPatient.setDocumentType(documentType);
		Town town = new Town();
		town.setId("1");
		town.setIdDepartment("1");
		town.setName("MEDELLIN");
		newPatient.setTown(town);
		Department department = new Department();
		department.setId("1");
		department.setName("Antioquia");
		newPatient.setDepartment(department);
		State statePatient = new State();
		statePatient.setId("2");
		statePatient.setValue("Recuperado");
		newPatient.setState(statePatient);
		newPatient.setChangeDate("2020-07-09 10:52:32");
		newPatient.setBirthDate("1992-07-16T04:00:00.000Z");
		newPatient.setLatitude("7.1979636");
		newPatient.setLongitude("-75.60915829999999");
		newPatient.setResult("1");

		Patient expected = newPatient;
		Patient actual = patientsController.createPatients(expected);
		assertEquals(expected, actual);

	}

	private void TestNumberQuestion() {
		int expected = 24;

		int actual=  questionRepositoryImpl.getQuestion().size();


		assertEquals(expected, actual);
	}


}
