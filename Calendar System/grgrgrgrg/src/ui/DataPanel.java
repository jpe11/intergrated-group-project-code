package ui;

import java.awt.Panel;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;


public class DataPanel extends Panel {

	private static final long serialVersionUID = 1L;
	private JLabel theTitle;
	JButton returnCalButton;
	
	public DataPanel() 
	{
		theTitle = new JLabel("Data for ");
		theTitle.setFont(new Font("Kalinga", Font.PLAIN, 30));
		theTitle.setHorizontalAlignment(SwingConstants.CENTER);
		theTitle.setForeground(Color.WHITE);
		theTitle.setBounds(60, 47, 527, 175);
		
		returnCalButton = new JButton("Go back");
		returnCalButton.setBounds(234,433,204,64);
				
		createPanel();
	}

	private void createPanel()
	{
		this.setBackground(new Color(255, 204, 255));
		setLayout(null);
		this.setBounds(0, 0, 650, 550);
		add(theTitle);
		add(returnCalButton);
		
	}
}
