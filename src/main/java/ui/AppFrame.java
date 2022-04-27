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
	LogPanel logPane;
	public boolean consoleLog;
	
	private static String name;
	private static int character;
	
	public AppFrame(boolean consoleLog) {
		
		this.consoleLog = consoleLog;
		
		openStartMenu();
    	
		this.setPreferredSize(new Dimension(1200, 700));
		contentPane = (JPanel)this.getContentPane();
		contentPane.setLayout(new BorderLayout());
		this.setResizable(false);
		
		asciiPane = new AsciiPanel();
		
		controlPane = new ControlPanel();
		
		logPane = new LogPanel();
		
		contentPane.add(asciiPane, BorderLayout.CENTER);
		contentPane.add(controlPane, BorderLayout.EAST);
		contentPane.add(logPane, BorderLayout.SOUTH);
		
		asciiPane.repaint();
	}
	
	public static void openStartMenu() {
		
		StartDialog dlg = new StartDialog();
        dlg.setVisible(true);
        
		character = dlg.classes.getSelectedIndex();
		name = dlg.nameField.getText();
		
		Date date = new Date();
    	Game.start(date.getTime(), character, name);
	}
	
	public void gameOver() {
		
		GameOverDialog dlg = new GameOverDialog();
		dlg.setVisible(true);
		
		openStartMenu();
	}
	
	public void log(String string) {
		if (consoleLog) {
			System.out.println(string);
		}
		logPane.log(string);
	}
	
	public void levelUp() {
		
		LevelUpDialog dlg = new LevelUpDialog();
		dlg.setVisible(true);
		
		switch (dlg.stats.getSelectedIndex()) {
		case 0:
			Game.player.levelVigor(1);
		case 1:
			Game.player.levelMind(1);
		case 2:
			Game.player.levelEndurance(1);
		case 3:
			Game.player.levelStrength(1);
		case 4:
			Game.player.levelLuck(1);
		}
	}
}
