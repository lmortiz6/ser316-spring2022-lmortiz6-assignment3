package main.java.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class LogPanel extends JPanel{
	
	JTextArea log = new JTextArea();
	
	public LogPanel() {
		super();
		setPreferredSize(new Dimension(800, 150));
		setBackground(new Color(2, 30, 2));
		init();
	}
	
	private void init() {
		
		this.setLayout(new BorderLayout());
		
		log.setBackground(new Color(2, 30, 2));
		log.setForeground(new Color(50, 200, 15));
		
		add(new JScrollPane(log), BorderLayout.CENTER);
	}
	
	public void log(String string) {
		log.append("\n> " + string);
	}

}
