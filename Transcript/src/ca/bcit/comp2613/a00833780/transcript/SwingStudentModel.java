package ca.bcit.comp2613.a00833780.transcript;

import javax.swing.table.DefaultTableModel;

public class SwingStudentModel extends DefaultTableModel {
	
	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	    public boolean isCellEditable(int row, int column) {
	       //all cells false
	       return false;
	    }
	
}
