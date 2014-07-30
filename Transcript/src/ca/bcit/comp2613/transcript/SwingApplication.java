package ca.bcit.comp2613.transcript;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.UUID;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import ca.bcit.comp2613.transcript.model.Students;
import ca.bcit.comp2613.transcript.model.Course;
import ca.bcit.comp2613.a00833780.util.CourseUtil;
import ca.bcit.comp2613.a00833780.util.StudentUtil;

import ca.bcit.comp2613.transcript.CourseFrame;
import ca.bcit.comp2613.transcript.SwingStudentModel;

public class SwingApplication {

	JFrame frame;
	private JTable table;
	private JTextField firstNameTextField;
	private JTextField lastNameTextField;
	private JLabel lblLastName;
	private JLabel lblId;
	private Students student;
	public String[] columnNames = new String[] { "Student #", "First Name",
			"Last Name" };
	private JTextField idTextField;
	public static List<Students> students;
	public static List<Course> courses;
	SwingStudentModel swingStudentModel;
	private JButton btnViewAllCourses;
	private JButton btnViewCourse;

	/**
	 * Create the application.
	 */
	public SwingApplication() {
		students = StudentUtil.createStudents();
		courses = CourseUtil.create1000RandomCourses();
		CourseUtil.randomlyAssignCoursesToStudents(students, courses);
		initialize();
		initTable();
	}

	private void initTable() {

		// table = new JTable(swingTeacherModel);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.getSelectionModel().addListSelectionListener(
				new ListSelectionListener() {

					@Override
					public void valueChanged(ListSelectionEvent e) {
						if (e.getValueIsAdjusting()) {
							populateFields();
						}
					}
				});
		refreshTable();

	}

	private void populateFields() {
		try {
			idTextField.setText(table.getModel()
					.getValueAt(table.getSelectedRow(), 0).toString());
			firstNameTextField.setText(table.getModel()
					.getValueAt(table.getSelectedRow(), 1).toString());
			lastNameTextField.setText(table.getModel()
					.getValueAt(table.getSelectedRow(), 2).toString());
		} catch (Exception e) {
		}
	}

	public void doSave() {
		String id = idTextField.getText();
		String firstName = firstNameTextField.getText();
		String lastName = lastNameTextField.getText();
		Students student = new Students(id, firstName, lastName);
		StudentUtil.save(students, student);
		// table.clearSelection();
		refreshTable();
	}

	public void doDelete() {
		String id = idTextField.getText();
		Students student = new Students(id, null, null);
		StudentUtil.delete(students, student);
		refreshTable();
	}

	public void doNew() {
		String id = "";
		for (Students student : students) {
			id = student.getStudentNumber();
		}
		int index = Integer.parseInt(id.substring(1));
		String newId = "A" + (index + 1);
		idTextField.setText(newId);
		firstNameTextField.setText("");
		lastNameTextField.setText("");
	}

	public void viewAllCourses() {
		CourseFrame courseFrame = new CourseFrame();
		courseFrame.setVisible(true);
	}

	public void viewCourse() {
		String id = idTextField.getText();
		Students student = null;
		student = StudentUtil.findById(id, students);
		if (student != null) {
			ViewCourseFrame viewCourseFrame = new ViewCourseFrame(student);
			viewCourseFrame.setVisible(true);
		}	
	}

	private void refreshTable() {
		// swingStudentModel = new SwingStudentModel();
		Object[][] data = null;

		data = new Object[students.size()][3];
		int i = 0;
		for (Students student : students) {
			data[i][0] = student.getStudentNumber();
			data[i][1] = student.getFirstName();
			data[i][2] = student.getLastName();
			i++;
		}
		swingStudentModel.setDataVector(data, columnNames);
		table.repaint();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 601, 499);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		// table = new JTable();
		swingStudentModel = new SwingStudentModel();

		table = new JTable(swingStudentModel);

		// table.setPreferredScrollableViewportSize(new Dimension(500, 70));
		// table.setBounds(0, 11, 585, 247);
		table.setFillsViewportHeight(true);
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(0, 11, 585, 247);
		frame.getContentPane().add(scrollPane);
		// scrollPane.add(table);
		// frame.getContentPane().add(table);

		JLabel lblFirstName = new JLabel("First Name");
		lblFirstName.setBounds(44, 330, 103, 14);
		frame.getContentPane().add(lblFirstName);

		firstNameTextField = new JTextField();
		firstNameTextField.setBounds(159, 327, 325, 20);
		frame.getContentPane().add(firstNameTextField);
		firstNameTextField.setColumns(10);

		lastNameTextField = new JTextField();
		lastNameTextField.setBounds(159, 371, 325, 20);
		frame.getContentPane().add(lastNameTextField);
		lastNameTextField.setColumns(10);

		lblLastName = new JLabel("Last Name");
		lblLastName.setBounds(44, 374, 77, 14);
		frame.getContentPane().add(lblLastName);

		lblId = new JLabel("id");
		lblId.setBounds(44, 288, 46, 14);
		frame.getContentPane().add(lblId);

		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				doSave();
			}
		});
		btnSave.setBounds(44, 412, 89, 23);
		frame.getContentPane().add(btnSave);

		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				doDelete();
			}
		});
		btnDelete.setBounds(169, 412, 89, 23);
		frame.getContentPane().add(btnDelete);

		JButton btnNewButton = new JButton("New");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				doNew();
			}
		});
		btnNewButton.setBounds(496, 260, 89, 23);
		frame.getContentPane().add(btnNewButton);

		idTextField = new JTextField();
		idTextField.setEditable(false);
		idTextField.setBounds(159, 285, 325, 20);
		frame.getContentPane().add(idTextField);
		idTextField.setColumns(10);

		btnViewAllCourses = new JButton("View all course");
		btnViewAllCourses.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				viewAllCourses();
			}
		});
		btnViewAllCourses.setBounds(0, 260, 121, 23);
		frame.getContentPane().add(btnViewAllCourses);
		
		btnViewCourse = new JButton("View Course");
		btnViewCourse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				viewCourse();
			}
		});
		btnViewCourse.setBounds(300, 412, 144, 23);
		frame.getContentPane().add(btnViewCourse);

	}
}
