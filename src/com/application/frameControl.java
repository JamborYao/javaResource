package com.application;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class frameControl {

	private JFrame[] frames;

	public frameControl() {
		frames=new JFrame[2];
		// TODO Auto-generated constructor stub
		frames[0]=addWindowsFrame("default");
		frames[1]=addAzureRestAPIFrame("azureRest");
	}
	
	public JFrame addWindowsFrame(String frameName)
	{
		JFrame frame = new JFrame();
		frame.setName(frameName);
		frame.setVisible(true);
		frame.setBounds(100, 100, 850, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Panel panel = new Panel();
		// frame.getContentPane().add(panel, BorderLayout.NORTH);
		azureRestAPI panelApi = new azureRestAPI();

		frame.getContentPane().add(panel, BorderLayout.NORTH);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JPanel panel_1 = new JPanel();
		panel.add(panel_1);
		Button button = new Button("azure Rest API");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				visibleThis("azureRest");
				//JOptionPane.showMessageDialog(null, "test");
				/*frame.getContentPane().add(indexPanelIndex,BorderLayout.CENTER);
				System.out.println("new panel created");//for debugging purposes
		          
				indexPanelIndex.setVisible(true);*/
			}
		});
		button.setBackground(Color.MAGENTA);
		panel.add(button);
		return frame;
	}

	public JFrame addAzureRestAPIFrame(String frameName)
	{
		JFrame frame=	new TextEditorDemo();
		frame.setName(frameName);
		frame.setVisible(false);
		TextEditorDemo textEditorDemo=(TextEditorDemo)frame;
		JButton button = new JButton("back to default");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				visibleThis("default");				
			}
		});
	    textEditorDemo.getPanel().add(button, 0);	    
	    textEditorDemo.getPanel().setBackground(Color.black);
		return frame;
	}
	public  void visibleThis(String frameName)
	{
		for (JFrame jFrame : getFrames()) {
			if (jFrame.getName()==frameName) {
				jFrame.setVisible(true);
			}
			else {
				jFrame.setVisible(false);
			}
		}
	}

	public JFrame[] getFrames() {
		return frames;
	}

	public void setFrames(JFrame[] frames) {
		this.frames = frames;
	}
}
