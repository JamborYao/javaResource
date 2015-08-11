package com.application;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;

import java.awt.BorderLayout;

import javax.swing.JButton;

import org.fife.ui.rsyntaxtextarea.RSyntaxTextArea;
import org.fife.ui.rsyntaxtextarea.SyntaxConstants;
import org.fife.ui.rtextarea.RTextScrollPane;
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
import java.awt.Color;

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
		//frame.getContentPane().add(panel, BorderLayout.NORTH);
		azureRestAPI panelApi=new azureRestAPI();
		
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		Button button = new Button("azure Rest API");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.getContentPane().removeAll();
				
				frame.getContentPane().invalidate();

				frame.getContentPane().add(panelApi,BorderLayout.CENTER);
				frame.getContentPane().revalidate();
				
				/*frame.getContentPane().add(indexPanelIndex,BorderLayout.CENTER);
				System.out.println("new panel created");//for debugging purposes
		          
				indexPanelIndex.setVisible(true);*/
			}
		});
		button.setBackground(Color.MAGENTA);
		button.setBounds(10, 47, 95, 30);
		panel.add(button);
		
		

	  
		
	}
	
}
