package main.java.ui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class LevelUpDialog extends JDialog{
	
	JPanel panel = new JPanel();
	JLabel selectL = new JLabel("Select stat to level: ");
	public JComboBox<String> stats = new JComboBox<String>(new String[] {
			"Vigor",
			"Mind",
			"Endurance",
			"Strength",
			"Luck"
	});
	
	JButton exitB = new JButton("Level Up");
	
	public LevelUpDialog() {
		super(App.getFrame(), true);
		setPreferredSize(new Dimension(400, 150));
		panel.setPreferredSize(new Dimension(400, 150));
		toFront();
		init();
		pack();
	}
	
	private void init() {
		
		this.setResizable(false);
		this.setLayout(new BorderLayout());
		
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		
		panel.add(selectL);
		
		panel.add(stats);
		
		exitB.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				exitAction();
			}});
		
		panel.add(exitB);
		
		this.getContentPane().add(panel, BorderLayout.CENTER);
		
	}
	
	private void exitAction() {
		this.dispose();
	}
}
