package ca.bcit.comp2613.a00833780.transcript.util;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.UUID;

import ca.bcit.comp2613.a00833780.transcript.model.Course;
import ca.bcit.comp2613.a00833780.transcript.model.Students;

public class CourseUtil {
	public static ArrayList<Course> create1000RandomCourses() {
		ArrayList<Course> courses = new ArrayList<>();

		for (int i = 0; i < 1000; i++) {
			String courseName = UUID.randomUUID().toString();
			Course course = new Course((long) i, courseName, "COMP" + i,
					(int) ((Math.random() * 10)+1),(int)( Math.random() * 100));
			courses.add(course);
		}
		return courses;
	}

	public static void randomlyAssignCoursesToStudents(List<Students> students,
			List<Course> courses) {
		int courseArraySize = courses.size();
		for (Students student : students) {
			Random rand = new Random();

			for (int i = 0; i < 10; i++) {
				int randCourseIndex = rand.nextInt(courseArraySize);
				Course randomCourse = courses.get(randCourseIndex);
				if (student.getCourses() == null) {
					student.setCourses(new ArrayList<Course>());
				}
				StudentUtil.addToCourse(student, randomCourse, courses);
			}
		}
	}

	public static void save(List<Course> courses, Course course) {
		boolean foundUpdate = false;
		for (Course courseLoop : courses) {
			if (courseLoop.getCourseId().equals(course.getCourseId())) {
				courseLoop.setCourseName(course.getCourseName());
				courseLoop.setCourseNumber(course.getCourseNumber());
				courseLoop.setCredit(course.getCredit());
				courseLoop.setGpa(course.getGpa());
				foundUpdate = true;
				break;
			}
		}
		if (!foundUpdate) { // do an insert
			courses.add(course);
		}
	}

	public static void delete(List<Course> courses, Course course) {
		Iterator<Course> iter = courses.iterator();
		while (iter.hasNext()) {
			Course courseLoop = iter.next();
			if (courseLoop.getCourseId().equals(course.getCourseId())) {
				iter.remove();
				break;
			}
		}
	}
	public static Course findById(Long courseId, List<Course> courses) {
		for (Course courseLoop :courses) {
			if (courseLoop.getCourseId().equals(courseId)) {
				return courseLoop;
			}
			
		}
		return null;
	}
}
