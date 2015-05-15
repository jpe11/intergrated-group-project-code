package ui;

import javax.swing.*;

import java.awt.Container;
import java.awt.CardLayout;
import java.awt.event.*;
import java.awt.Color;


public class MainFrame extends JFrame {

	//Simple panel setup - Panels loaded on events
	private static final long serialVersionUID = 1L;
	private DataPanel dataPanel = new DataPanel();
	private LoginPanel loginPanel = new LoginPanel();
	private MenuPanel menuPanel = new MenuPanel();
	private CardLayout theLayout;
	CalendarModel calModel = new CalendarModel();
	CalendarView calView = new CalendarView(this);
	CalendarController calConr = new CalendarController(calModel, calView, this);
	private DatabasePanel theDatabase = new DatabasePanel("", calModel, calConr);


	//Main panel swap method
	protected void changeFrame(String title) {
		theLayout.show(getContentPane(), title);
	}
	
	//Events
	class LoginButtonPress implements ActionListener {
		public void actionPerformed(ActionEvent ae) {
			changeFrame("Menu");
		}
	}

	class SelectButtonPress implements ActionListener {
		public void actionPerformed(ActionEvent ae) {
			changeFrame("Calendar");
		}
	}
	
	class ReturnButtonPress implements ActionListener {
		public void actionPerformed(ActionEvent ae) {
			changeFrame("Menu");
		}
	}
	
	class ViewButtonPress implements ActionListener {
		public void actionPerformed(ActionEvent ae) {
			changeFrame("Data");
		}
	}
	
	class ReturnCalButtonPress implements ActionListener {
		public void actionPerformed(ActionEvent ae) {
			changeFrame("Calendar");
		}
	}
	
	class DataButtonPress implements ActionListener {
		public void actionPerformed(ActionEvent ae) {
			changeFrame("Data");
		}
	}
	
	class ReturnToLogin implements ActionListener {
		public void actionPerformed(ActionEvent ae)
		{
			changeFrame("Login");
		}
	}
	
	class DayButtonPress implements ActionListener {
		public void actionPerformed(ActionEvent ae)
		{
			changeFrame("Database");
		}
	}
	
	class ReturnToCal implements ActionListener {
		public void actionPerformed(ActionEvent ae)
		{
			changeFrame("Calendar");
		}
	}
	
	class CreateButtonPress implements ActionListener {
		public void actionPerformed(ActionEvent ae) {
			changeFrame("Create");
		}
	}
	
	public MainFrame() {
		getContentPane().setBackground(Color.GRAY);
		setBackground(Color.GRAY);

		//Container with panels 
		Container mainPane = getContentPane();
		theLayout = new CardLayout();
		
		mainPane.setLayout(theLayout);
		loginPanel.userLogin.setForeground(Color.BLACK);
		loginPanel.userPassword.setForeground(Color.BLACK);
		loginPanel.loginButton.setForeground(Color.BLACK);
		loginPanel.setBackground(Color.GRAY);
		mainPane.add("Login", loginPanel);
		menuPanel.setBackground(Color.GRAY);
		mainPane.add("Menu", menuPanel);
		dataPanel.setBackground(Color.GRAY);
		mainPane.add("Data", dataPanel);
		calView.setBackground(Color.GRAY);
		mainPane.add("Calendar", calView);
		theDatabase.setBackground(Color.GRAY);
		mainPane.add("Database", theDatabase);
		
		calView.returnButton.setBounds(199, 305, 350, 50);

		
		loginPanel.loginButton.addActionListener(new LoginButtonPress());
		menuPanel.viewSelect.addActionListener(new SelectButtonPress());
		menuPanel.returnButton.addActionListener(new ReturnToLogin());
		dataPanel.returnCalButton.addActionListener(new ReturnCalButtonPress());
		calView.returnButton.addActionListener(new ReturnButtonPress());
		calView.addDayOfMonthListener(new DayButtonPress());
		theDatabase.returnCalButton.addActionListener(new ReturnToCal());
		
	}
}
