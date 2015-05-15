package ui;


import java.util.Calendar;
/**
 * The Model of the Calendar
 * @author Matthew Donaldson <i>(University of Brighton)</i>
 * @version 1.0
 */
public class CalendarModel {
		
	private Calendar currentCalendar = Calendar.getInstance();
	
	/**
	 * setNextMonth
	 * (Sets the calendar forward by one month)
	 */
	public void setNextMonth() {	
		currentCalendar.add(Calendar.MONTH, 1);
	}
	
	/**
	 * setPrevMonth
	 * (Sets the calendar backwards by one month)
	 */
	public void setPrevMonth() {	
		currentCalendar.add(Calendar.MONTH, -1);
	}
	
	/**
	 * setDay
	 * (Sets the calendar backwards by one month)
	 * @param day (String of day number)
	 */
	public void setDay(String day) {	
		currentCalendar.set(Calendar.DAY_OF_MONTH, Integer.parseInt(day));
	}
	
	/**
	 * getCalendar
	 * (Get the current calendar)
	 */
	public Calendar getCalendar() {
		return currentCalendar;
	}
		
}

