package ca.bcit.comp2613.a00833780.transcript.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import ca.bcit.comp2613.a00833780.transcript.model.Students;

@Entity
public class Course {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Long id;
	Long courseId;
	String courseName;
	String courseNumber;
	double credit;
	double gpa;
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name = "student_course",
	joinColumns = { @JoinColumn(name = "course_id") }, inverseJoinColumns = { @JoinColumn(name = "student_id") })
	private List<Students> students;

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Course(Long courseId,String courseName, String courseNumber, double credit,
			double gpa) {
		super();
		this.courseId = courseId;
		this.courseName = courseName;
		this.courseNumber = courseNumber;
		this.credit = credit;
		this.gpa = gpa;
	}
	public Long getCourseId() {
		return courseId;
	}
	public void setCourseId(Long courseId) {
		this.courseId = courseId;
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
