package ui;

import java.awt.Panel;
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class MenuPanel extends Panel {


	private static final long serialVersionUID = 1L;
	public JButton viewSelect;
	private JLabel theTitle;
	protected JButton returnButton;
	private JButton addEvent;
	private JButton createEvent;
	private JDialog addEventDialog;
	JLabel dialogTitle;
	JTextField inputDay;
	JTextField inputMonth;
	JTextField inputYear;
	JTextField inputData;
	JLabel inputDayLabel;
	JLabel inputMonthLabel;
	JLabel inputYearLabel;
	JLabel inputEventData;
	
	public MenuPanel() 
	{
		
		viewSelect = new JButton("Monthly");
		viewSelect.setBounds(235, 243, 174, 63);
		
		theTitle = new JLabel("Select view desired");
		theTitle.setFont(new Font("Kalinga", Font.PLAIN, 30));
		theTitle.setHorizontalAlignment(SwingConstants.CENTER);
		theTitle.setBounds(60, 47, 527, 175);
		theTitle.setForeground(Color.WHITE);
				
		returnButton  = new JButton("Return");
		returnButton.setBounds(235, 343, 173, 63);
		
		addEvent = new JButton("Add event");
		addEvent.setBounds(268,47,89,32);
		addEvent.addActionListener(new AddEventWindow());
		
		createPanel();
	}
	
	class AddEventWindow implements ActionListener {
		public void actionPerformed(ActionEvent ae)
		{
			addEventDialog = new JDialog();
			addEventDialog.setBounds(200,200,400,400);
			addEventDialog.setLayout(null);
			
			dialogTitle = new JLabel("Add an event");
			dialogTitle.setBounds(160,10,80,40);
			
			inputDayLabel = new JLabel("Day");
			inputDayLabel.setBounds(10, 60, 30, 30);
			inputDay = new JTextField();
			inputDay.setBounds(80,60,120,30);
			
			inputMonthLabel = new JLabel("Month");
			inputMonthLabel.setBounds(10, 130, 50, 10);
			inputMonth = new JTextField();
			inputMonth.setBounds(80,120,120,30);
			
			inputYearLabel = new JLabel("Year");
			inputYearLabel.setBounds(10, 190, 50, 10);
			inputYear = new JTextField();
			inputYear.setBounds(80,180,120,30);
			
			
			inputEventData = new JLabel("Event data");
			inputEventData.setBounds(10, 230, 90, 10);
			inputData = new JTextField();
			inputData.setBounds(80,220,120,30);
			
			createEvent = new JButton("Create event");
			createEvent.setBounds(150,300,120,30);
			
			
			addEventDialog.add(dialogTitle);
			addEventDialog.add(inputDay);
			addEventDialog.add(inputMonth);
			addEventDialog.add(inputYear);
			addEventDialog.add(inputYearLabel);
			addEventDialog.add(inputDayLabel);
			addEventDialog.add(inputMonthLabel);
			addEventDialog.add(inputEventData);
			addEventDialog.add(inputData);
			addEventDialog.add(createEvent);
						
			addEventDialog.setVisible(true);
		}
	}

	private void createPanel()
	{
		this.setBackground(new Color(255, 204, 255));
		setLayout(null);
		this.setBounds(0, 0, 650, 550);
		add(viewSelect); 
		add(theTitle);
		add(returnButton);
		add(addEvent);
		
		
	}
}
