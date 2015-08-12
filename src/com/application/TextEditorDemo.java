package com.application;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import org.fife.ui.rsyntaxtextarea.RSyntaxTextArea;
import org.fife.ui.rsyntaxtextarea.SyntaxConstants;
import org.fife.ui.rtextarea.RTextScrollPane;

import com.azuredemo.listAutomation;

import javax.swing.JButton;

import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.BoxLayout;
import javax.swing.SwingConstants;

import java.awt.Component;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TextEditorDemo extends JFrame  {

	 private JPanel panel;
	 public TextEditorDemo() {

		 panel=initPanel();
		 

	   }
	 
	 public JPanel initPanel()
	 {
		  JPanel  panel = new JPanel();

	      RSyntaxTextArea textArea = new RSyntaxTextArea(20, 60);
	      textArea.setSyntaxEditingStyle(SyntaxConstants.SYNTAX_STYLE_XML);
	      panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
	    
	      
	      JButton btnNewButton = new JButton("get Result");     
	  
	      
	      btnNewButton.addActionListener(new ActionListener() {
	      	public void actionPerformed(ActionEvent arg0) {
	      		listAutomation listAutomation=new listAutomation();	      		      		
	      		textArea.setText(listAutomation.getAutomation());
	      	}
	      });
	     
	      panel.add(btnNewButton);
	      
	     
	      
	     // textArea.setCodeFoldingEnabled(true);
	      RTextScrollPane sp = new RTextScrollPane(textArea);
	      panel.add(sp);

	      setContentPane(panel);
	    //  setTitle("Text Editor Demo");
	    //  setDefaultCloseOperation(EXIT_ON_CLOSE);
	      pack();
	      setLocationRelativeTo(null);
	      return panel;
	 }
	 
	 public String getName()
	 {
		 return super.getName();
	 }

	public JPanel getPanel() {
		return panel;
	}

	public void setPanel(JPanel panel) {
		this.panel = panel;
	}

	  /* public static void main(String[] args) {
	      // Start all Swing applications on the EDT.
	      SwingUtilities.invokeLater(new Runnable() {
	         public void run() {
	            new TextEditorDemo().setVisible(true);
	         }
	      });
	   }*/

	}