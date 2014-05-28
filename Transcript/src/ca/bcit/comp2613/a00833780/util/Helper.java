package ca.bcit.comp2613.a00833780.util;

import java.util.ArrayList;

import ca.bcit.comp2613.transcript.model.students;

public class Helper {

	public static String LOREM_IPSUM = "In publishing and graphic design, lorem ipsum is a placeholder text commonly used to "
			+ "demonstrate the graphic elements of a document or visual presentation. By replacing the distraction of meaningful "
			+ "content with filler text of scrambled Latin it allows viewers to focus on graphical elements such as font, typography, and layout"
			+ "The lorem ipsum text is typically a mangled section of De finibus bonorum et malorum, a 1st-century BC Latin text by Cicero, with words "
			+ "altered, added, and removed that make it nonsensical, improper Latin"
			+ "A variation of the common lorem ipsum text has been used during typesetting since the 1960s or "
			+ "earlier, when it was popularized by advertisements for Letraset transfer sheets. It was introduced "
			+ "to the Digital Age by Aldus Corporation in the mid-1980s, which employed it in graphics and word processing templates "
			+ "for its breakthrough desktop publishing program, PageMaker for the Apple Macintosh";

	public static ArrayList<students> createStudents() {
		ArrayList<students> retval = new ArrayList<>();
		String[] strs = LOREM_IPSUM.split("\\s");
		// create loop
		for (int i = 0; i < strs.length; i++) {
			students student = new students();
			student.setStudentNumber("A" + Integer.toString(i));
			student.setFirstName(strs[i].toUpperCase());
			student.setLastName(new StringBuilder(strs[i]).reverse().toString());
			retval.add(student);
		}
		return retval;
	}

	public static void printTeachers(ArrayList<students> students) {
		for (students student : students) {
			System.out.println(student);
		}
	}

	public static ArrayList<students> searchStudentsByFirstName(
			ArrayList<students> students, String firstName) {
		ArrayList<students> retval = new ArrayList<>();
		for (students student : students) {
			if (student.getFirstName().equals(firstName)) {
				retval.add(student);
			}
		}
		return retval;
	}

	public static ArrayList<students> searchStudentsByFirstNameRegex(
			ArrayList<students> students, String regex) {
		ArrayList<students> retval = new ArrayList<>();
		for (students student : students) {
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
}
