package edu.umb.cs680.hw04;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class StudentTest {

	@Test
	public void InstateStudentInstance() {
		Student str = Student.createOutStateStudent("Test1", "Address", 5);
		assertNotNull(str);
	}
	
	@Test
	public void InstateStudentFactoryInstance() {
		Student str = StudentFactory.createOutStateStudent("Test1", "Address", 5);
		assertNotNull(str);
	}
	
	@Test
	public void InstateStudentValidData() {
		Student str = Student.createOutStateStudent("Test1", "Address", 5);
		assertEquals("Test1", str.getName());
		assertEquals("Address", str.getUsAddr());
		assertEquals(5, str.getYrsInState());
	}
	
	@Test
	public void InstateStudentFactoryValidData() {
		Student str = StudentFactory.createOutStateStudent("Test1", "Address", 5);
		assertEquals("Test1", str.getName());
		assertEquals("Address", str.getUsAddr());
		assertEquals(5, str.getYrsInState());
	}
	
	@Test
	public void OutStateStudentInstance() {
		Student str = Student.createInStateStudent("Test2", "Address1");
		assertNotNull(str);
	}
	
	@Test
	public void OutStateStudentFactoryInstance() {
		Student str = StudentFactory.createInStateStudent("Test2", "Address1");
		assertNotNull(str);
	}
	
	@Test
	public void OutStateStudentValidData() {
		Student str = Student.createInStateStudent("Test2", "Address1");
		assertEquals("Test2", str.getName());
		assertEquals("Address1", str.getUsAddr());
	}
	
	@Test
	public void OutStateStudentFactoryValidData() {
		Student str = Student.createInStateStudent("Test2", "Address1");
		assertEquals("Test2", str.getName());
		assertEquals("Address1", str.getUsAddr());
	}
	
	@Test
	public void IntlStateStudentInstance()  {
		Student str = Student.createIntlStudent("Test3", "Address2", 123, "Address3");
		assertNotNull(str);
	}
	
	
	@Test
	public void IntlStateStudentFactoryInstance()  {
		Student str = Student.createIntlStudent("Test3", "Address2", 123, "Address3");
		assertNotNull(str);
	}
	
	
	@Test
	public void IntlStateStudentValidData() {
		Student str = Student.createIntlStudent("Test3", "Address2", 123, "Address3");
		assertEquals("Test3", str.getName());
		assertEquals("Address2", str.getUsAddr());
		assertEquals("Address3", str.getForeignAddr());
		assertEquals(123, str.getI20num());
	}
	
	@Test
	public void IntlStateStudentFactoryValidData() {
		Student str = Student.createIntlStudent("Test3", "Address2", 123, "Address3");
		assertEquals("Test3", str.getName());
		assertEquals("Address2", str.getUsAddr());
		assertEquals("Address3", str.getForeignAddr());
		assertEquals(123, str.getI20num());
	}

}
