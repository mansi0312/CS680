package edu.umb.cs680.hw04;

public class StudentFactory extends Student{

	protected StudentFactory(String name, int i20num, String usAddr, int yrsInState,
			String foreignAddr, StudentStatus status) {
		super(name, i20num, usAddr, yrsInState, foreignAddr, status);
		// TODO Auto-generated constructor stub
	}

	public static Student createOutStateStudent(String name, String usAddr, int yrsInState) {
		return new Student(name, 123, usAddr, yrsInState, "Address", StudentStatus.OUTSTATE);
	}

	public static Student createInStateStudent(String name, String usAddr) {
		return new Student(name, 123, usAddr, 2, "Address", StudentStatus.INSTATE);
	}

	public static Student createIntlStudent(String name, String usAddr, int i20num, String foreignAddr) {
		return new Student(name, 123, usAddr, i20num, foreignAddr, StudentStatus.INTL);
	}
}
