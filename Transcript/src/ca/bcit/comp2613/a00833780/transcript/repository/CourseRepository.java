package ca.bcit.comp2613.a00833780.transcript.repository;


import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import ca.bcit.comp2613.a00833780.transcript.model.Course;



public interface CourseRepository extends CrudRepository<Course, Long> {

	
	@Query("select s from Course s where s.courseName = :courseName or s.courseNumber = :courseNumber")
	Course findByLastnameOrFirstname(@Param("courseName") String courseName,
	                                 @Param("courseNumber") String courseNumber);
	
	/*
	 List<Student> findByFirstNameAndLastName(String firstName, String lastName);
	
	
	@Modifying
	@Query("update Student s set s.firstName = ?1 where u.lastName = ?2")
	int setFixedFirstnameFor(String firstName, String lastName);
	*/
}