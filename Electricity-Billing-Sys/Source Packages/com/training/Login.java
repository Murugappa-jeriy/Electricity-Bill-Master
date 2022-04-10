package com.training;

import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;

import javax.swing.*;

public class Login extends JFrame implements ActionListener {

	JLabel l1, l2, l3, l4;
	JTextField textf1;
	JPasswordField passf1;
	JButton b1, b2, b3;
	JPanel p1, p2, p3, p4;
	Choice ch1;
	Login()
	{
		super("Login Page");
		Container j = getContentPane();
		j.setBackground(Color.white);
		
		l1 = new JLabel("UserName");
		l1.setBounds(200, 20, 100, 20);
		add(l1);
		
		l2 = new JLabel("Password");
		l2.setBounds(200, 60, 100, 20);
		add(l2);
		
		textf1 = new JTextField(15);
		textf1.setBounds(300, 20, 150, 20);
		add(textf1);
	
		passf1 = new JPasswordField(20);
		passf1.setBounds(300, 60, 150, 20);
		add(passf1);
		
		l4 = new JLabel("Logging in as");
		l4.setBounds(200, 100, 100, 20);
		add(l4);
		
		ch1 = new Choice();
		ch1.add("Admin");
		ch1.add("Customer");
		ch1.setBounds(300, 100, 150, 20);
		add(ch1);
		
		//ImageIcon ic1
		b1 =  new JButton("Login");
		b1.setBounds(230, 160, 100, 20);
		add(b1);
		b2 = new JButton("Cancel");
		b2.setBounds(350, 160, 100, 20);
		add(b2);
		b3 = new JButton("Sign-up");
		b3.setBounds(280, 200, 130, 20);
		add(b3);
		
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		
		setLayout(new BorderLayout());
		
		setSize(600, 300);
		setLocation(600, 300);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void actionPerformed(ActionEvent event)
	{
		if(event.getSource() == b1)
		{
			try {
				Connectivity c = new Connectivity();
				String a = textf1.getText();
				String b = passf1.getText();
				String choice1 = ch1.getSelectedItem();
				String qy = "select * from login_table where username = '" +a+ "' and password = '" +b+ "' and user = '" +choice1+ "'";
				 ResultSet rs = c.s.executeQuery(qy);
				if(rs.next())
				{
					String meter = rs.getString("meter_no");
					Project start = new Project(meter, choice1);
					start.setVisible(true);
					this.setVisible(false);
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Invalid Login");
					textf1.setText("");
					passf1.setText("");
				}
			}catch(Exception e) {
				e.printStackTrace();
				System.out.println("error: "+e);
			}
		}
		else if(event.getSource() == b2)
		{
			this.setVisible(false);
		}
		else if(event.getSource() == b3)
		{
			this.setVisible(false);
			Signup si = new Signup();
			si.setVisible(true);
		}
	}
public static void main(String args[])
	{
		Login first = new Login();
		first.setVisible(true);
	}
}
