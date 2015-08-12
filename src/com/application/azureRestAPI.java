package com.application;

import javax.swing.JPanel;

import org.fife.ui.rsyntaxtextarea.RSyntaxTextArea;
import org.fife.ui.rsyntaxtextarea.SyntaxConstants;
import org.fife.ui.rtextarea.RTextScrollPane;

import com.azuredemo.listAutomation;
import com.azuredemo.uploadToStorage;

import java.awt.Button;
import java.awt.Label;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.TextArea;

import javax.swing.JButton;

public class azureRestAPI extends JPanel {
	public azureRestAPI() {
		setBackground(Color.GRAY);
		setLayout(null);
		
		Button button = new Button("list Automation");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listAutomation listauto=new listAutomation();
				textArea.setText(listauto.getAutomation());
			
			}
		});
		RSyntaxTextArea rtextArea = new RSyntaxTextArea(120, 60);
	      rtextArea.setSyntaxEditingStyle(SyntaxConstants.SYNTAX_STYLE_JAVA);
	      //rtextArea.setCodeFoldingEnabled(true);
	      RTextScrollPane sp = new RTextScrollPane(rtextArea);
	      add(sp);
	      rtextArea.setText("test application");
	    rtextArea.setVisible(true);
	      
		button.setBackground(Color.GREEN);
		button.setBounds(316, 246, 124, 44);
		add(button);
		
		JButton btnUploadFile = new JButton("Upload File");
		btnUploadFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				uploadToStorage fileUpload=new uploadToStorage();
				fileUpload.upload();
			}
		});
		btnUploadFile.setBounds(0, 254, 89, 23);
		add(btnUploadFile);
		
	 /*   textArea = new TextArea();
		textArea.setBounds(30, 21, 380, 160);
		add(textArea);*/

	}
	private TextArea textArea;
}
