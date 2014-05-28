package ca.bcit.comp2613.transcript.model;

public class course {
	Long id;
	String courseName;
	String courseNumber;
	double credit;
	double gpa;

	public course(String courseName, String courseNumber, double credit,
			double gpa) {
		super();
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
	@Override
	public String toString() {
		return "course [courseName=" + courseName + ", courseNumber="
				+ courseNumber + ", credit=" + credit + ", gpa=" + gpa
				+ ", getCourseName()=" + getCourseName()
				+ ", getCourseNumber()=" + getCourseNumber() + ", getCredit()="
				+ getCredit() + ", getGpa()=" + getGpa() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}

}
