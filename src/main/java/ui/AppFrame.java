package main.java.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JPanel;

import main.java.system.Game;

public class AppFrame extends JFrame{
	JPanel contentPane;
	public AsciiPanel asciiPane;
	public ControlPanel controlPane;
	JPanel logPane;
	
	public AppFrame() {
		//testing
		Date date = new Date();
    	Game.start(date.getTime(), "");
    	
		this.setPreferredSize(new Dimension(1200, 700));
		contentPane = (JPanel)this.getContentPane();
		contentPane.setLayout(new BorderLayout());
		this.setResizable(false);
		
		asciiPane = new AsciiPanel();
		
		controlPane = new ControlPanel();
		
		logPane = new JPanel();
		logPane.setPreferredSize(new Dimension(800, 150));
		logPane.setBackground(new Color(2, 30, 2));
		
		contentPane.add(asciiPane, BorderLayout.CENTER);
		contentPane.add(controlPane, BorderLayout.EAST);
		contentPane.add(logPane, BorderLayout.SOUTH);
		
		asciiPane.repaint();
	}
}
