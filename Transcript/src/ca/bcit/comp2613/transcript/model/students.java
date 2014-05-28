package ca.bcit.comp2613.transcript.model;
public class students {
	Long id;
	String studentNumber;
	String firstName;
	String lastName;
	
	public students(String studentNumber, String firstName, String lastName) {
		super();
		this.studentNumber = studentNumber;
		this.firstName = firstName;
		this.lastName = lastName;
	}
	public students() {
		// TODO Auto-generated constructor stub
	}
	public String getStudentNumber() {
		return studentNumber;
	}
	public void setStudentNumber(String studentNumber) {
		this.studentNumber = studentNumber;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	@Override
	public String toString() {
		return "students [studentNumber=" + studentNumber + ", firstName="
				+ firstName + ", lastName=" + lastName
				+ ", getStudentNumber()=" + getStudentNumber()
				+ ", getFirstName()=" + getFirstName() + ", getLastName()="
				+ getLastName() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}

}
