package ui;

import java.awt.Panel;
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DatabasePanel extends Panel {

	private static final long serialVersionUID = 1L;
	private JLabel theTitle;
	protected JButton returnCalButton;
	protected JButton getInfo;
	protected JTextArea theInfo;
	
	public DatabasePanel(String date, CalendarModel calendarModel, CalendarController calendarController) 
	{
		
		theTitle = new JLabel("Database Events");
		theTitle.setFont(new Font("Kalinga", Font.PLAIN, 30));
		theTitle.setHorizontalAlignment(SwingConstants.CENTER);
		theTitle.setForeground(Color.WHITE);
		theTitle.setBounds(60, 20, 527, 175);
		
		getInfo = new JButton("Request info");
		getInfo.setBounds(230,150, 200, 50);
		getInfo.addActionListener(new RequestInfo());
		
		returnCalButton = new JButton("Go back");
		returnCalButton.setBounds(234,433,204,64);
		returnCalButton.addActionListener(new ClearInfo());
		
		
		
		createPanel();
	}
	
	class RequestInfo implements ActionListener {
		public void actionPerformed(ActionEvent ae) {
			
			theInfo = new JTextArea("We need to put database info from query here");
			theInfo.append("\n and here and here etc etc etc");
			theInfo.setFont(new Font("Kalinga", Font.PLAIN, 20));
			theInfo.setBackground(Color.WHITE);
			theInfo.setBounds(100, 210, 450, 210);
			
			/*
			 * For example:
			 * 
			 * string = functionToConnectToDb and return info();
			 * 
			 */
			
			add(theInfo);
			repaint();
		}
	}
	
	class ClearInfo implements ActionListener {
		public void actionPerformed(ActionEvent ae) {
			remove(theInfo);
			repaint();
		}
	}

	private void createPanel()
	{
		this.setBackground(new Color(255, 204, 255));
		setLayout(null);
		this.setBounds(0, 0, 650, 550);
		add(theTitle);
		add(returnCalButton);
		add(getInfo);
		
		
	}
	
	
}
