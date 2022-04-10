package com.training;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class Signup extends JFrame implements ItemListener, ActionListener{
	JPanel p1;
	JTextField t1, t2, t3, t4;
	Choice c1;
	JButton b1, b2;
	JLabel l5;
	Signup()
	{
		setBounds(600, 250, 700, 400);
		
		p1 = new JPanel();
		//p1.setBounds(30, 30, 650, 300);
		p1.setLayout(null);
		p1.setBackground(Color.blue);
		add(p1);
		
		JLabel l1 = new JLabel("Username");
		l1.setBounds(100, 50, 100, 20);
		p1.add(l1);
		
		t1 = new JTextField();
		t1.setBounds(260, 50, 150, 20);
		p1.add(t1);
		
		JLabel l2 = new JLabel("Name");
		l2.setBounds(100, 90, 100, 20 );
		p1.add(l2);
		
		t2 = new JTextField();
		t2.setBounds(260, 90, 150, 20);
		p1.add(t2);
		
		JLabel l3 = new JLabel("Password");
		l3.setBounds(100, 130, 100, 20);
		p1.add(l3);
		
		t3 = new JTextField();
		t3.setBounds(260, 130, 150, 20);
		p1.add(t3);
		
		JLabel l4 = new JLabel("Create Account As");
		l4.setBounds(100, 170, 140, 20);
		p1.add(l4);
		
		c1 = new Choice();
		c1.add("--Select User Type--");
		c1.add("Admin");
		c1.add("Customer");
		c1.setBounds(260, 170, 150, 20);
		p1.add(c1);
		
		c1.addItemListener(this);
		
		l5 = new JLabel("Meter Number");
		l5.setBounds(100, 210, 100, 20);
		p1.add(l5);
		
		t4 = new JTextField();
		t4.setBounds(260, 210, 150, 20);
		p1.add(t4);
		
		b1 = new JButton("Create");
		b1.setBounds(140, 290, 120, 30);
		p1.add(b1);
		b1.addActionListener(this);
		
		b2 = new JButton("Back");
		b2.setBounds(300, 290, 120, 30);
		p1.add(b2);
		b2.addActionListener(this);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	}
	public void itemStateChanged(ItemEvent eve)
	{
		String user = c1.getSelectedItem();
		if(user.equals("Customer"))
		{
			l5.setVisible(true);
			t4.setVisible(true);
		}
		else if(user.equals("Admin") || user.equals("--Select User Type--"))
		{
			l5.setVisible(false);
			t4.setVisible(false);
		}
	}
	
	public void actionPerformed(ActionEvent event)
	{
		if(event.getSource() == b1)
		{
			String username = t1.getText();
			String name = t2.getText();
			String password = t3.getText();
			String user = c1.getSelectedItem();
			String meter = t4.getText();
			try {
				Connectivity conn = new Connectivity();
				String str = null;
				if(user.equals("Admin"))
				{
					str = "Insert into login_table (username, name, password, user) values('"+username+"','"+name+"','"+password+"','"+user+"');";
					conn.s.executeUpdate(str);
					JOptionPane.showMessageDialog(null, "Account created Successfully");
					this.setVisible(false);
					Login lg = new Login();
					lg.setVisible(true);
				}
				else if(user.equals("Customer"))
				{
					str = "Insert into login_table (meter_no, username, name, password, user) values('"+meter+"','"+username+"','"+name+"','"+password+"','"+user+"');";
					conn.s.executeUpdate(str);
					JOptionPane.showMessageDialog(null, "Account created Successfully");
					this.setVisible(false);
					Login lg = new Login();
					lg.setVisible(true);
				}
				else if(user.equals("--Select User Type--"))
				{
					JOptionPane.showMessageDialog(null, "Please select a user type");
				}
				
			}catch(Exception e) {
				e.printStackTrace();
				System.out.println("error: "+e);
			}
		}
	}
	
	public static void main(String args[])
	{
		Signup sec = new Signup();
		sec.setVisible(true);
	}
}
