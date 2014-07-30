package ca.bcit.comp2613.transcript.model;

import java.util.List;

import ca.bcit.comp2613.transcript.model.Students;

public class Course {
	Long id;
	String courseName;
	String courseNumber;
	double credit;
	double gpa;
	private List<Students> students;

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Course(Long id,String courseName, String courseNumber, double credit,
			double gpa) {
		super();
		this.id = id;
		this.courseName = courseName;
		this.courseNumber = courseNumber;
		this.credit = credit;
		this.gpa = gpa;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public String getCourseNumber() {
		return courseNumber;
	}
	public void setCourseNumber(String courseNumber) {
		this.courseNumber = courseNumber;
	}
	public double getCredit() {
		return credit;
	}
	public void setCredit(double credit) {
		this.credit = credit;
	}
	public double getGpa() {
		return gpa;
	}
	public void setGpa(double gpa) {
		this.gpa = gpa;
	}
	
	public List<Students> getStudents() {
		return students;
	}
	public void setStudents(List<Students> students) {
		this.students = students;
	}
	@Override
	public String toString() {
		return "Course [id=" + id + ", courseName=" + courseName
				+ ", courseNumber=" + courseNumber + ", credit=" + credit
				+ ", gpa=" + gpa + ", students=" + students + "]";
	}
	
	


}
