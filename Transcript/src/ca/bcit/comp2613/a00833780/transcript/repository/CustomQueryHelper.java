package ca.bcit.comp2613.a00833780.transcript.repository;

import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import ca.bcit.comp2613.a00833780.transcript.model.Course;
import ca.bcit.comp2613.a00833780.transcript.model.Students;


public class CustomQueryHelper {
	private EntityManagerFactory emf;

	public EntityManagerFactory getEmf() {
		return emf;
	}

	public void setEmf(EntityManagerFactory emf) {
		this.emf = emf;
	}

	public CustomQueryHelper(EntityManagerFactory emf) {
		this.emf = emf;
	}

	public List<Course> getStudentsOfTeacherWithNativeQuery(String student_id) {
		List<Course> retval = null;
		EntityManager em = null;
		try {
			em = emf.createEntityManager();
			Query query = em
					.createNativeQuery(
							" select "
									+ "       Course.* "
									+ "    from "
									+ "        student_course "
									+ "    left join "
									+ "        course "
									+ "            on student_course.course_id = course.id where student_course.student_id = :student_id",
							Course.class);
			query.setParameter("student_id", student_id);
			retval = query.getResultList();
		} catch (Exception e) {

		} finally {
			try {
				em.close();
			} catch (Exception e) {
			}
		}
		return retval;
	}
	
	
	public List<Course> getCoursesofStudent(String studentId) {
		List<Course> retval = null;
		EntityManager em = null;
		try {
			em = emf.createEntityManager();
			Students student = em.find(Students.class, studentId);
			student.getCourses().size(); // make a db call
			return student.getCourses();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				em.close();
			} catch (Exception e) {
			}
		}
		return retval;
	}
	
	public void addCourseToStudent(String studentId, Long courseId) {
		EntityManager em = null;
		try {
			em = emf.createEntityManager();
			Students student = em.find(Students.class, studentId);
			Course course = em.find(Course.class, courseId);
			System.out.println(student.getCourses().size()); // make a db call
			student.getCourses().add(course);
			em.getTransaction().begin();
			em.persist(student);
			em.getTransaction().commit();
			System.out.println(student.getCourses().size()); // make a db call
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				em.close();
			} catch (Exception e) {
			}
		}
		
	}
	
	
	public void removeCourseFromStudent(String studentId, Long courseId) {
		EntityManager em = null;
		try {
			em = emf.createEntityManager();
			Students student = em.find(Students.class, studentId);
			student.getCourses().size(); // make a db call
			Iterator<Course> iter = student.getCourses().iterator();
			while (iter.hasNext()) {
				if (iter.next().getId().equals(courseId)) {
					iter.remove();
				}
			}		
			em.getTransaction().begin();
			em.persist(student);
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				em.close();
			} catch (Exception e) {
			}
		}
		
	}
	
}