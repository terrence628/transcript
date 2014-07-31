package ca.bcit.comp2613.a00833780.transcript;

import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JFrame;

import ca.bcit.comp2613.a00833780.transcript.SwingApplication;
import ca.bcit.comp2613.a00833780.transcript.model.Students;
import ca.bcit.comp2613.a00833780.transcript.util.StudentUtil;


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
	}

}
