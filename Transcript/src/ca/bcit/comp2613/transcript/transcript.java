package ca.bcit.comp2613.transcript;

import java.util.ArrayList;
import java.util.Arrays;

import ca.bcit.comp2613.transcript.model.students;
import ca.bcit.comp2613.a00833780.util.Helper;

public class transcript {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<students> students = Helper.createStudents();
		Helper.printTeachers(students);
		System.out.println("---------------");
		ArrayList<students> studentsByFirstName = Helper.searchStudentsByFirstName(students, "PUBLISHING");
		Helper.printTeachers(studentsByFirstName);

		System.out.println("---------------");
		ArrayList<students> studentsByFirstNameRegex = Helper.searchStudentsByFirstNameRegex(students, "WO.*");
		Helper.printTeachers(studentsByFirstNameRegex);
	}

}
