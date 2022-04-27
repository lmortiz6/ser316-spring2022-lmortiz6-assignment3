package main.java.ui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GameOverDialog extends JDialog{
	
	JPanel panel = new JPanel();
	JLabel gameOverL = new JLabel("Game Over");
	JButton restartB = new JButton("Restart");
	
	public GameOverDialog() {
		super(App.getFrame(), true);
		setPreferredSize(new Dimension(400, 150));
		//panel.setPreferredSize(new Dimension(400, 150));
		toFront();
		init();
		pack();
	}
	
	private void init() {
		
		this.setResizable(false);
		this.setLayout(new BorderLayout());
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		
		panel.add(gameOverL);
		
		restartB.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				restartAction();
			}});
		
		panel.add(restartB);
		
		this.getContentPane().add(panel, BorderLayout.CENTER);
	}
	
	private void restartAction() {
		this.dispose();
	}
}
