package ui;

import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;



public class MainView {

	public static void main(String[] args) {
		try{
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			}
		
		catch (UnsupportedLookAndFeelException e) {
		       
		    }
		    catch (ClassNotFoundException e) {
		    
		    }
		    catch (InstantiationException e) {
		      
		    }
		    catch (IllegalAccessException e) {
		       
		    }
	
		
		
		
		
		MainFrame mainFrame = new MainFrame();
		mainFrame.setSize(650, 550);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.setVisible(true);
	}
	

}