package ca.bcit.comp2613.a00833780.transcript;

import java.awt.EventQueue;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ImportResource;
import ca.bcit.comp2613.a00833780.transcript.SwingApplication;
import ca.bcit.comp2613.a00833780.transcript.model.Course;
import ca.bcit.comp2613.a00833780.transcript.repository.CourseRepository;
import ca.bcit.comp2613.a00833780.transcript.repository.CustomQueryHelper;
import ca.bcit.comp2613.a00833780.transcript.repository.StudentRepository;

@EnableAutoConfiguration
@ImportResource("applicationContext.xml")
public class TestDriver {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SwingApplication window = new SwingApplication();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		ConfigurableApplicationContext context = SpringApplication
				.run(TestDriver.class);

		StudentRepository studentRepository = context.getBean(StudentRepository.class);
		CourseRepository courseRepository = context.getBean(CourseRepository.class);
		EntityManagerFactory emf = (EntityManagerFactory) context.getBean("entityManagerFactory");
		CustomQueryHelper customQueryHelper = new CustomQueryHelper(emf);

		// Teacher teacher = teacherRepository.findOne("2");

		List<Course> coursesOfStudent = customQueryHelper
				.getCoursesofStudent("2");
		for (Course course : coursesOfStudent) {
			System.out.println(course);
		}

		customQueryHelper.addCourseToStudent("2", 1L);
		coursesOfStudent = customQueryHelper.getCoursesofStudent("2");
		for (Course course : coursesOfStudent) {
			System.out.println(course);
		}

		customQueryHelper.removeCourseFromStudent("2", 1L);
		coursesOfStudent = customQueryHelper.getCoursesofStudent("2");
		for (Course course : coursesOfStudent) {
			System.out.println(course);
		}
		context.close();

	}

}
