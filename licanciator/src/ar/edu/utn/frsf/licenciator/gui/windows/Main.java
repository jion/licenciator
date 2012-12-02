package ar.edu.utn.frsf.licenciator.gui.windows;

import javax.swing.UIManager;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		 try {
	            // Set System L&F
	        UIManager.setLookAndFeel(
	            UIManager.getSystemLookAndFeelClassName());
	    } 
		catch (Exception e) {
		}
		 
		LoginGUI.runLogin();
	}

}
