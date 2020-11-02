package edu.umb.cs680.hw04;
public class Student {

	private float tuition;
	private String name;
	private int i20num;
	private String usAddr;
	private int yrsInState;
	private String foreignAddr;
	private StudentStatus status;

	protected Student(String name, int i20num, String usAddr, int yrsInState, String foreignAddr,
			StudentStatus status) {
		super();
		this.name = name; // name: String
		this.i20num = i20num; // i20num: int
		this.usAddr = usAddr; // usAddr: String
		this.yrsInState = yrsInState; // yrsInState: int
		this.foreignAddr = foreignAddr; // foreignAddr: String,
		this.status = status; // status: StudentStatus
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

	public String getName() {
		return name;
	}

	public int getI20num() {
		return i20num;
	}

	public String getUsAddr() {
		return usAddr;
	}

	public int getYrsInState() {
		return yrsInState;
	}

	public String getForeignAddr() {
		return foreignAddr;
	}

	public StudentStatus getStatus() {
		return status;
	}

	public float getTuition() {
		return tuition;
	}
	
	public static void main(String[] args) {
		System.out.println("Student Class Successfully Run!!");
	}

}