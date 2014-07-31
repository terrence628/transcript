package ca.bcit.comp2613.transcript;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
import javax.swing.JSeparator;

import ca.bcit.comp2613.transcript.model.Students;
import ca.bcit.comp2613.transcript.model.Course;
import ca.bcit.comp2613.a00833780.util.CourseUtil;
import ca.bcit.comp2613.a00833780.util.StudentUtil;
import ca.bcit.comp2613.transcript.SwingApplication;

public class ViewCourseFrame extends JFrame {

	private JTable table;
	private JTextField idTextField;
	private JTextField courseNumberTextField;
	private JTextField courseNameTextField;
	private JTextField creditTextField;
	private JTextField gpaTextField;
	private JLabel lblCredit;
	private JLabel lblCourseName;
	private JLabel lblCourseNumber;
	private JLabel lblId;
	private JLabel lblGpa;
	private NonEditableDefaultTableModel swingStudentModel;
	public String[] columnNames = new String[] { "id", "Course Name",
			"Course Number", "Credit", "GPA" };

	private Students student;
	private JButton btnClose;
	private JTextField addTextField;
	private JLabel lblCourseId;

	public ViewCourseFrame(Students student) {
		this.student = student;
		this.setTitle(student.getFirstName() + " " + student.getLastName()
				+ "' s Class");
		initialize();
		initTable();
	}

	private void initTable() {

		// table = new JTable(swingStudentModel);
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
			courseNameTextField.setText(table.getModel()
					.getValueAt(table.getSelectedRow(), 1).toString());
			courseNumberTextField.setText(table.getModel()
					.getValueAt(table.getSelectedRow(), 2).toString());
			creditTextField.setText(table.getModel()
					.getValueAt(table.getSelectedRow(), 3).toString());
			gpaTextField.setText(table.getModel()
					.getValueAt(table.getSelectedRow(), 4).toString());
		} catch (Exception e) {
		}
	}

	public void removeFromCourse() {
		String id = idTextField.getText();
		Course course = new Course(Long.parseLong(id), null, null, 0, 0);
		StudentUtil.removeFromCourse(student, course);
		refreshTable();
	}

	public void doAdd() {
		try {
			String id = addTextField.getText();
			Course course = new Course(Long.parseLong(id), null, null, 0, 0);
			StudentUtil.addToCourse(student, course, SwingApplication.courses);
		} catch (Exception e) {
		}
		refreshTable();
	}

	private void refreshTable() {
		// swingStudentModel = new SwingStudentModel();
		Object[][] data = null;
		if (student.getCourses() != null) {
			data = new Object[student.getCourses().size()][5];
			int i = 0;
			for (Course course : student.getCourses()) {
				data[i][0] = course.getId();
				data[i][1] = course.getCourseName();
				data[i][2] = course.getCourseNumber();
				data[i][3] = course.getCredit();
				data[i][4] = course.getGpa();
				i++;
			}
			swingStudentModel.setDataVector(data, columnNames);
			table.repaint();
		}
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		this.setBounds(100, 100, 601, 704);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setLayout(null);

		// table = new JTable();
		swingStudentModel = new NonEditableDefaultTableModel();

		table = new JTable(swingStudentModel);

		// table.setPreferredScrollableViewportSize(new Dimension(500, 70));
		// table.setBounds(0, 11, 585, 247);
		table.setFillsViewportHeight(true);
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(0, 11, 585, 247);
		this.getContentPane().add(scrollPane);
		// scrollPane.add(table);
		// frame.getContentPane().add(table);



		lblId = new JLabel("ID");
		lblId.setBounds(44, 288, 46, 14);
		this.getContentPane().add(lblId);
		
		lblCourseName = new JLabel("Course Name");
		lblCourseName.setBounds(44, 310, 103, 14);
		this.getContentPane().add(lblCourseName);
		
		lblCredit = new JLabel("Credit");
		lblCredit.setBounds(44, 374, 77, 14);
		this.getContentPane().add(lblCredit);

		lblCourseNumber = new JLabel("Course Number");
		lblCourseNumber.setBounds(44, 330, 103, 14);
		this.getContentPane().add(lblCourseNumber);
		
		lblGpa = new JLabel("GPA");
		lblGpa.setBounds(44, 354, 77, 14);
		this.getContentPane().add(lblGpa);



		idTextField = new JTextField();
		idTextField.setEditable(false);
		idTextField.setBounds(159, 285, 325, 20);
		this.getContentPane().add(idTextField);
		idTextField.setColumns(10);
		
		courseNameTextField = new JTextField();
		courseNameTextField.setBounds(159, 307, 325, 20);
		this.getContentPane().add(courseNameTextField);
		courseNameTextField.setColumns(10);

		courseNumberTextField = new JTextField();
		courseNumberTextField.setBounds(159, 327, 325, 20);
		this.getContentPane().add(courseNumberTextField);
		courseNumberTextField.setColumns(10);
		
		creditTextField = new JTextField();
		creditTextField.setBounds(159, 371, 325, 20);
		this.getContentPane().add(creditTextField);
		creditTextField.setColumns(10);

		gpaTextField = new JTextField();
		gpaTextField.setBounds(159, 351, 325, 20);
		this.getContentPane().add(gpaTextField);
		gpaTextField.setColumns(10);


		JButton btnRemove = new JButton("Remove From Transcript");
		btnRemove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				removeFromCourse();
			}
		});
		btnRemove.setBounds(32, 413, 252, 23);
		this.getContentPane().add(btnRemove);

		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				doAdd();
			}
		});
		btnAdd.setBounds(252, 594, 89, 23);
		this.getContentPane().add(btnAdd);


		btnClose = new JButton("Close");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewCourseFrame.this.dispose();
			}
		});
		btnClose.setBounds(496, 643, 89, 23);
		getContentPane().add(btnClose);

		addTextField = new JTextField();
		addTextField.setBounds(301, 556, 86, 20);
		getContentPane().add(addTextField);
		addTextField.setColumns(10);

		lblCourseId = new JLabel("Course ID to Add");
		lblCourseId.setBounds(159, 562, 125, 14);
		getContentPane().add(lblCourseId);

		JSeparator separator = new JSeparator();
		separator.setBounds(182, 413, 1, 2);
		getContentPane().add(separator);
	}
}
