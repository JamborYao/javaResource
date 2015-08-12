package com.application;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;

import java.awt.BorderLayout;

import javax.swing.JButton;

import org.fife.ui.rsyntaxtextarea.RSyntaxTextArea;
import org.fife.ui.rsyntaxtextarea.SyntaxConstants;
import org.fife.ui.rsyntaxtextarea.modes.WindowsBatchTokenMaker;
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
import java.awt.Window;

import javax.swing.JPanel;

public class window {



	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					window window = new window();			
					
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
		frameControl framesLoad=new frameControl();
		//frame=framesLoad.getFrames()[0];
		//initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	
	
}
