package com.application;

import javax.swing.JPanel;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class index extends JPanel {

	/**
	 * Create the panel.
	 */
	public index() {
		setLayout(null);
		
		Button button = new Button("New button");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		button.setBounds(10, 22, 70, 22);
		add(button);

	}

}
