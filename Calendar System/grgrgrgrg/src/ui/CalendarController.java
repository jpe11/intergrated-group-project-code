package ui;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

/**
 * The Calendar Controller
 * @author Matthew Donaldson <i>(University of Brighton)</i>
 * @version 1.0
 * @todo Add an array list containing the dates and the messages in an array list containing the description
 */
public class CalendarController {
	 
	  private CalendarView  calendarView  = null;
	  private CalendarModel calendarModel = null;
	  private MainFrame theFrame = null;
	  protected Calendar theCalendar = null;

	  /**
	   * CalendarController Constructor
	   * @param model (The model)
	   * @param view (The view from which the interaction came)
	   */
	  public CalendarController( CalendarModel model, CalendarView view, MainFrame mainFrame ) {
		  calendarView  = view;
		  calendarModel = model;
		  theFrame = mainFrame;
		  
		  
		  calendarView.addMonthNextListener(new CalendarMonthNextListener());
		  calendarView.addMonthPrevListener(new CalendarMonthPrevListener());
		  calendarView.addDayOfMonthListener(new CalendarDayOfMonthListener());
	  }
	  
	  /**
	   * The CalendarMonthNextListener class
	   */
	  class CalendarMonthNextListener implements ActionListener {
		  
		  /**
		   * The actionPerformed
		   * @param ae (Action event)
		   * @Override
		   */
		  @Override
		  public void actionPerformed(ActionEvent ae) {
			  
			  try {			
				  Calendar currentCalendar;
				  
				  calendarModel.setNextMonth();
				  currentCalendar = calendarModel.getCalendar();
				  
				  calendarView.setDateLabel(currentCalendar);  
				  calendarView.listDaysOfMonth(currentCalendar);
				  calendarView.addDayOfMonthListener(new CalendarDayOfMonthListener());
			  }
			  catch (Exception ex) {
				  calendarView.displayError("CalendarMonthNextListener: " + ex.toString() +  ": " + ex.getMessage() + "\n");
				  ex.printStackTrace();
			  }
			  
			  
		  }
		  
	  }
	  /**
	   * The CalendarMonthPrevListener class
	   */
	  class CalendarMonthPrevListener implements ActionListener {
		  
		  /**
		   * The actionPerformed
		   * @param ae (Action event)
		   * @Override
		   */
		  @Override
		  public void actionPerformed(ActionEvent ae) {

			  try {			
				  Calendar currentCalendar;
				  
				  calendarModel.setPrevMonth();
				  currentCalendar = calendarModel.getCalendar();
				  
				  calendarView.setDateLabel(currentCalendar);
				  calendarView.listDaysOfMonth(currentCalendar);
				  calendarView.addDayOfMonthListener(new CalendarDayOfMonthListener());
			  }
			  catch (Exception ex) {
				  calendarView.displayError("CalendarMonthPrevListener: " + ex.toString() +  ": " + ex.getMessage());
			  }
			  
			  
		  }
		  
	  }
	  /**
	   * The CalendarDayOfMonthListener class
	   */
	  class CalendarDayOfMonthListener implements ActionListener {
		  
		  /**
		   * The actionPerformed
		   * 
		   * @param ae (Action event)
		   * @Override
		   */
		  @Override
		  public void actionPerformed(ActionEvent ae) {
			  //TODO
			  //throw new UnsupportedOperationException(ae.getActionCommand());
			  theCalendar = calendarModel.getCalendar();
			  calendarModel.setDay(ae.getActionCommand());
			  theFrame.changeFrame("Database");
			  System.out.println(theCalendar.getTime());
			  
		  }
		  
	  }
}

