package com.training;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class samplei extends JFrame implements ActionListener{
	
	JPanel p2;
	JButton b1;
	JLabel l1, l2;
	samplei()
	{
		setBounds(600, 250, 700, 400);//using setbounds on jframe will make the layout manager to adjust-
		// the layout automatically for jframe based on this statment.
		
		p2 = new JPanel();
		p2.setLayout(null);// using this method, separates the layout automatic organizing control-
		//from layout manager and with this we can use 'setBounds methods' for accurate depiction of GUI.
		p2.setBounds(600, 300, 150, 290);
		p2.setBackground(Color.blue);
		add(p2);
		
		b1 = new JButton("Click to greet the System");
		b1.setBounds(200, 50, 300, 20);
		p2.add(b1);
		
		
		l1 = new JLabel("Hello World");
		l1.setBounds(200, 70, 100, 20 );
		p2.add(l1);
		
		b1.addActionListener(this);
		l1.setVisible(false);
		
		 setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 
		 
	}
	
	public void actionPerformed(ActionEvent ee)
	{
		l1.setVisible(true);
	}
	

	public static void main(String[] args) {
		samplei c = new samplei();
		c.setVisible(true);
	}

}
