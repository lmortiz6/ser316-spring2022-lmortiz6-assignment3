package main.java.ui;

import java.awt.Frame;

public class App {
	static AppFrame frame = null;
	
	public App(boolean consoleLog) {
		frame = new AppFrame(consoleLog);
		frame.pack();
		frame.setExtendedState(Frame.NORMAL);
		frame.setVisible(true);
	}
	
	public static AppFrame getFrame() {
		return frame;
	}
}
