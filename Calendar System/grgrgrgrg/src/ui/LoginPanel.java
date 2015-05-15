package ui;

import java.awt.Panel;
import java.awt.Color;

import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import java.awt.Font;


public class LoginPanel extends Panel {
	
	private static final long serialVersionUID = 1L;
	protected JTextField userLogin;
	protected JPasswordField userPassword;
	private JLabel loginLabel;
	private JLabel passwordLabel;
	public JButton loginButton;
	private JLabel theTitle;
	
	public LoginPanel() 
	{
		userLogin = new JTextField();
		userLogin.setBounds(249, 303, 174, 20);
		
		userPassword = new JPasswordField();
		userPassword.setBounds(249, 334, 174, 20);
		
		loginButton = new JButton("Login");
		loginButton.setBounds(249, 386, 174, 63);
		
		loginLabel = new JLabel("Login");
		loginLabel.setBounds(167, 306, 72, 14);
		loginLabel.setForeground(Color.WHITE);
		
		passwordLabel = new JLabel("Password");
		passwordLabel.setBounds(167, 337, 72, 14);
		passwordLabel.setForeground(Color.WHITE);
		
		theTitle = new JLabel("BRIGHTON CALENDAR SYSTEM");
		theTitle.setFont(new Font("Kalinga", Font.PLAIN, 30));
		theTitle.setHorizontalAlignment(SwingConstants.CENTER);
		theTitle.setForeground(Color.WHITE);
		theTitle.setBounds(60, 47, 527, 175);
				
		createPanel();
	}

	private void createPanel()
	{
		this.setBackground(new Color(255, 204, 255));
		setLayout(null);
		this.setBounds(0, 0, 650, 550);
		add(userLogin);
		add(userPassword);
		add(loginLabel);
		add(passwordLabel);
		add(loginButton); 
		add(theTitle);
		
	}
}
