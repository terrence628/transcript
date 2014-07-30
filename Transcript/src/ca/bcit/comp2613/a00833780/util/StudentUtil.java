package ca.bcit.comp2613.a00833780.util;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;


import ca.bcit.comp2613.transcript.model.Course;
import ca.bcit.comp2613.transcript.model.Students;

public class StudentUtil {

	public static ArrayList<Students> createStudents() {
		ArrayList<Students> students = new ArrayList<>();
		Students student = new Students("1", "Henry", "Chan");
		students.add(student);
		// create loop
		for (int i = 2; i < 101; i++) {

			String firstName = UUID.randomUUID().toString();
			String lastName = UUID.randomUUID().toString();
			student = new Students("A" + i, firstName, lastName);
			students.add(student);
		}
		
		return students;
	}

	public static void save(List<Students> students, Students student) {
		boolean foundUpdate = false;
		for (Students studentLoop :students) {
			if (studentLoop.getStudentNumber().equals(student.getStudentNumber())) {
				studentLoop.setFirstName(student.getFirstName());
				studentLoop.setLastName(student.getLastName());
				foundUpdate = true;
				break;
			}
		}
		if (!foundUpdate) { // do an insert
			students.add(student);
		}
	}

	public static void delete(List<Students> students, Students student) {
		Iterator<Students> iter = students.iterator();
		while (iter.hasNext()) {
			Students studentLoop = iter.next();
			if (studentLoop.getStudentNumber().equals(student.getStudentNumber())) {
				iter.remove();
				break;
			}
		}
	}

	public static void printStudents(ArrayList<Students> students) {
		for (Students student : students) {
			System.out.println(student);
		}
	}

	public static ArrayList<Students> searchStudentsByFirstName(
			ArrayList<Students> students, String firstName) {
		ArrayList<Students> retval = new ArrayList<>();
		for (Students student : students) {
			if (student.getFirstName().equals(firstName)) {
				retval.add(student);
			}
		}
		return retval;
	}

	public static ArrayList<Students> searchStudentsByFirstNameRegex(
			ArrayList<Students> students, String regex) {
		ArrayList<Students> retval = new ArrayList<>();
		for (Students student : students) {
			if (student.getFirstName().matches(regex)) {
				// if (student.getFirstName().matches("(?i)Dum.*")) { // how
				// about this regex?
				// if (student.getFirstName().matches("(?)DUM")) { // how about
				// this regex?
				System.out.println(student);
			}
		}
		return retval;
	}
	public static void addToCourse(Students student, Course course, List<Course> courses) {
		if (student.getCourses() == null) {
			student.setCourses(new ArrayList<Course>());
		}
		for (Course courseLoop : student.getCourses()) {
			if (courseLoop.getId().equals(course.getId())) {
				return; // already in class
			}
		}
		
		course = CourseUtil.findById(course.getId(), courses);
		student.getCourses().add(course);
	}

	public static void removeFromCourse(Students student, Course course) {
		if (student.getCourses() != null) {
			Iterator<Course> iter = student.getCourses().iterator();
			while (iter.hasNext()) {
				Course courseLoop = iter.next();
				if (courseLoop.getId().equals(course.getId())) {
					iter.remove();
					break;
				}
			}
		}
		
	}
	
	public static Students findById(String id, List<Students> students) {
		for (Students studentLoop :students) {
			if (studentLoop.getStudentNumber().equals(id)) {
				return studentLoop;
			}
			
		}
		return null;
	}
}
