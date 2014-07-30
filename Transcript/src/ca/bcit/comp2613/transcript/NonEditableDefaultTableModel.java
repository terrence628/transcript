package ca.bcit.comp2613.transcript;

import javax.swing.table.DefaultTableModel;

public class NonEditableDefaultTableModel extends DefaultTableModel {
	
	 @Override
	    public boolean isCellEditable(int row, int column) {
	       //all cells false
	       return false;
	    }
	
}
