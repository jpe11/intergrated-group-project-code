package ui;


import javax.swing.*;

import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar; //Used instead of Date as it is deprecated
import java.util.HashMap;
import java.awt.Color;


public class CalendarView extends JPanel {
	
	  private static final long serialVersionUID = 1L;

	  private JButton monthPrevButton = new JButton( "<" );
	  private JLabel monthLabel = new JLabel("monthLabel");
	  private JButton monthNextButton = new JButton( ">" );
	  protected JButton returnButton = new JButton("Return");
	  private JLabel theTitle = new JLabel("Calendar");
	  
	  private SimpleDateFormat sdf = new SimpleDateFormat("MMM yyyy");

	  //Store the days as buttons when cycling through the months
	  private HashMap<String, JButton> dynamicDayButtons = new HashMap<String, JButton>();
	  
	  /**
	   * CalendarView Constructor
	   */
	  public CalendarView(MainFrame mainFrame) {
	  	setBackground(Color.GRAY);	
		  monthLabel.setForeground(Color.WHITE);
		  monthLabel.setBounds(90, 20, 100, 50);
		  monthPrevButton.setBounds(10, 20, 50, 50);
		  monthNextButton.setBounds(170, 20, 50, 50);

		  Calendar now = Calendar.getInstance(); 
		 
		  setDateLabel(now); //Get time now
		  theTitle.setForeground(Color.WHITE);
		  theTitle.getPreferredSize();
		  this.add(theTitle);
		  
		  this.add(monthPrevButton);
		  this.add(monthLabel);
		  this.add(monthNextButton);
		  this.setLayout(getLayout());
		  listDaysOfMonth(now);
		  
		  
		  
	  }
	  
	  /**
	   * setDateLabel
	   * @param c (Calendar containing the current month)
	   */
	  public void setDateLabel(final Calendar c) {
		  monthLabel.setText(sdf.format(c.getTime()));
	  }
	  
	  /**
	   * listDaysOfMonth
	   * @param c (Calendar containing the current month) 
	   */
	  public void listDaysOfMonth(final Calendar c) { 
		  JButton b;
		  String dayKey;
		  int day, numDays;
		  
		  day = 0;	  
		  numDays = c.getActualMaximum(Calendar.DAY_OF_MONTH);
		
		  //Remove the last buttons when changing months
		  if (!dynamicDayButtons.isEmpty()) {
			  day = 31;
			  while (day > numDays - 1) {
				  dayKey = String.format("%d", day + 1);
				  
				  if (dynamicDayButtons.containsKey(dayKey))
					  this.remove(dynamicDayButtons.remove(dayKey));
				  
				  day--;
			  }
		  }
		  
	
		  
		  day = dynamicDayButtons.size(); //Start of the last day of the month if the month has more days

		  //Add the buttons
		  while (day < numDays) {
			  dayKey = String.format("%d", day + 1);
			  b = new JButton(dayKey);
			  dynamicDayButtons.put(dayKey, b);
			  b.setPreferredSize(new Dimension (80,70));
			  this.add(dynamicDayButtons.get(dayKey));
			  day++;

		  }
		 
		  
		  returnButton.setPreferredSize(new Dimension(450,50));
		  this.add(returnButton);
	  }
	  
	  /**
	   * displayError
	   * @param str (The error message)
	   */
	  public void displayError(final String msg) {
		  JOptionPane.showMessageDialog(this, msg);
	  }
	  
	  /**
	   * addMonthNextListener
	   * @param al (Action Listener)
	   */
	  public void addMonthNextListener(ActionListener al) {
		  monthNextButton.addActionListener(al);
	  }
	  
	  /**
	   * addMonthPrevListener
	   * @param al (Action Listener)
	   */	  
	  public void addMonthPrevListener(ActionListener al) {
		  monthPrevButton.addActionListener(al);
	  }
	  
	  /**
	   * addDayOfMonthListener
	   * @param al (Action Listener)
	   */	  
	  public void addDayOfMonthListener(ActionListener al) {
		  JButton b;
		  int i, size;
		   		  
		  size = dynamicDayButtons.size();
		  
		  for (i = 0; i < size; i++) {
			  b = dynamicDayButtons.get(String.format("%d", i + 1));
			  
			  //Make sure the buttons do not assign more than one ActionListener
			  if (b != null && b.getActionListeners().length < 1) { 
				  b.addActionListener(al);
			  }
		  }
		  
		  
	  }
}
