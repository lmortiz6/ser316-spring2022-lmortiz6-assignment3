package main.java.ui;

import java.awt.Dimension;
import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class StartDialog extends JDialog{
	
	public boolean starting = true;
	JPanel panel = new JPanel();
	JLabel selectL = new JLabel("Select Class: ");
	public JComboBox<String> classes = new JComboBox<String>(new String[] {
			"Warrior",
			"Thief",
			"Mage"
	});
	JLabel nameL = new JLabel("Enter Name: ");
	public JTextField nameField = new JTextField();
	
	JButton startB = new JButton("Start Game");
	
	public StartDialog() {
		super(App.getFrame(), true);
		setPreferredSize(new Dimension(400, 150));
		panel.setPreferredSize(new Dimension(500, 300));
		panel.setMinimumSize(new Dimension(400, 150));
		toFront();
		init();
		pack();
	}
	
	private void init() {
		
		this.setResizable(false);
		this.setLayout(new BorderLayout());
		
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

    	selectL.setMinimumSize(new Dimension(120, 24));
		panel.add(selectL);

    	classes.setMinimumSize(new Dimension(120, 24));
		panel.add(classes);

    	nameL.setMinimumSize(new Dimension(120, 24));
		panel.add(nameL);

    	nameField.setMinimumSize(new Dimension(120, 24));
		panel.add(nameField);

    	startB.setMinimumSize(new Dimension(120, 24));
		startB.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				startAction();
			}});
		
		panel.add(startB);
		
		this.getContentPane().add(panel, BorderLayout.CENTER);
		
	}
	
	private void startAction() {
		if (nameField.getText().isEmpty()) {
    		JOptionPane.showMessageDialog(null, "Please enter a name.");
			return;
		}else {
			starting = false;
			this.dispose();
		}
	}
}
