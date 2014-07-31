package ca.bcit.comp2613.a00833780.transcript.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import ca.bcit.comp2613.a00833780.transcript.model.Course;


@Entity
public class Students {
	@Id
	Long id;
	String studentNumber;
	String firstName;
	String lastName;
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "student_course",
	joinColumns = { @JoinColumn(name = "student_id") }, inverseJoinColumns = { @JoinColumn(name = "course_id") })
	private List<Course> courses;
	
	public Students(String studentNumber, String firstName, String lastName) {
		super();
		this.studentNumber = studentNumber;
		this.firstName = firstName;
		this.lastName = lastName;
	}
	public Students() {
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
	public List<Course> getCourses() {
		return courses;
	}
	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}
	
	@Override
	public String toString() {
		return "Students [studentNumber=" + studentNumber
				+ ", firstName=" + firstName + ", lastName=" + lastName + "]";
	}

}
