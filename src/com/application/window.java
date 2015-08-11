package com.application;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;

import java.awt.BorderLayout;

import javax.swing.JButton;

import org.omg.CORBA.PRIVATE_MEMBER;

import com.azuredemo.listAutomation;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseListener;
import java.awt.CardLayout;
import java.awt.Panel;
import java.awt.Label;
import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.TextField;

public class window {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					window window = new window();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public window() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 850, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Panel panel = new Panel();
		frame.getContentPane().add(panel, BorderLayout.NORTH);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		Button button = new Button("first page");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cl.next(panel_1);
			}
		});
		panel.add(button);
	
		
		Button button_1 = new Button("Execute");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				listAutomation listauto=new listAutomation();
			label.setText(listauto.putAutomation());
		//listauto.getAutomation();
				
			}
		});
		panel.add(button_1);
		
		
		frame.getContentPane().add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(cl);
		
		TextField textField = new TextField();
		panel_1.add(textField, "name_375986190629600");
		
		Label label_1 = new Label("second page");
		panel_1.add(label_1, "name_375322862775700");
		
	    label = new Label("get Automation List");
		panel_1.add(label, "name_375299192512700");
		
	}
	private Panel panel_1 = new Panel(); 
	private CardLayout cl=new CardLayout();
	private Label label;
}
