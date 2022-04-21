package ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class AppFrame extends JFrame{
	JPanel contentPane;
	JPanel asciiPane;
	JPanel actionPane;
	JPanel logPane;
	
	public AppFrame() {
		this.setPreferredSize(new Dimension(1200, 700));
		contentPane = (JPanel)this.getContentPane();
		contentPane.setLayout(new BorderLayout());
		this.setResizable(false);
		
		asciiPane = new JPanel();
		asciiPane.setPreferredSize(new Dimension(950, 550));
		asciiPane.setBackground(Color.BLACK);
		
		actionPane = new JPanel();
		//actionPane.setMinimumSize(new Dimension(200, 500));
		actionPane.setPreferredSize(new Dimension(250, 550));
		actionPane.setBackground(Color.DARK_GRAY);
		
		logPane = new JPanel();
		logPane.setPreferredSize(new Dimension(800, 150));
		logPane.setBackground(new Color(2, 30, 2));
		
		contentPane.add(asciiPane, BorderLayout.CENTER);
		contentPane.add(actionPane, BorderLayout.EAST);
		contentPane.add(logPane, BorderLayout.SOUTH);
		
		//contentPane.setMinimumSize(new Dimension(800, 700));
		//this.setMinimumSize(new Dimension(800, 700));
	}
}
