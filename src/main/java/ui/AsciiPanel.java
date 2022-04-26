package main.java.ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

import main.java.system.Game;
import main.java.system.Room;
import main.java.object.GameObject;
import main.java.object.Enemy;

public class AsciiPanel extends JPanel{
	public final static int CAM_WIDTH = Room.ROOM_WIDTH * 6;
	public final static int CAM_HEIGHT = (int)(Room.ROOM_WIDTH * 3.5);
	
	public AsciiPanel() {
		this.setPreferredSize(new Dimension(950, 550));
		this.setBackground(Color.BLACK);
	}
	
	public void paint(Graphics g) {
		if (Game.player == null || Game.currentFloor == null) {
			return;
		}
		Dimension size = getSize();
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, size.width, size.height);
		int leftX = Game.player.getPosition().x - (CAM_WIDTH / 2);
		int rightX = leftX + CAM_WIDTH;
		int topY = Game.player.getPosition().y - (CAM_HEIGHT / 2);
		int bottomY = topY + CAM_HEIGHT;
		double relativeX = 0;
		double relativeY = 0;
		int drawX = 0;
		int drawY = 0;
		
		g.setColor(Color.WHITE);
		for (GameObject obj : Game.currentFloor.getWalls()) {
			if (obj.getPosition().x > leftX && obj.getPosition().x < rightX 
						&& obj.getPosition().y > topY && obj.getPosition().y < bottomY) {
				relativeX = (double)(obj.getPosition().x - leftX) / (double)CAM_WIDTH;
				relativeY = (double)(obj.getPosition().y - topY) / (double)CAM_HEIGHT;
				drawX = (int)(relativeX*size.width) + 1;
				drawY = (int)(relativeY*size.height) + 1;
				g.drawString(String.valueOf(obj.getAscii()), drawX, drawY);
			}
		}
		
		Room room = Game.player.getRoom();
		
		if (room != null) {
			for (GameObject obj : Game.currentFloor.getFurnitureList()) {
				if (room.isWithin(obj.getPosition().x, obj.getPosition().y) && obj.getPosition().x > leftX && obj.getPosition().x < rightX 
							&& obj.getPosition().y > topY && obj.getPosition().y < bottomY) {
					relativeX = (double)(obj.getPosition().x - leftX) / (double)CAM_WIDTH;
					relativeY = (double)(obj.getPosition().y - topY) / (double)CAM_HEIGHT;
					drawX = (int)(relativeX*size.width) + 1;
					drawY = (int)(relativeY*size.height) + 1;
					g.drawString(String.valueOf(obj.getAscii()), drawX, drawY);
				}
			}
			g.setColor(Color.YELLOW);
			for (GameObject obj : Game.currentFloor.getItems()) {
				if (room.isWithin(obj.getPosition().x, obj.getPosition().y) && obj.getPosition().x > leftX && obj.getPosition().x < rightX 
							&& obj.getPosition().y > topY && obj.getPosition().y < bottomY) {
					relativeX = (double)(obj.getPosition().x - leftX) / (double)CAM_WIDTH;
					relativeY = (double)(obj.getPosition().y - topY) / (double)CAM_HEIGHT;
					drawX = (int)(relativeX*size.width) + 1;
					drawY = (int)(relativeY*size.height) + 1;
					g.drawString(String.valueOf(obj.getAscii()), drawX, drawY);
				}
			}
			g.setColor(Color.RED);
			for (GameObject obj : Game.currentFloor.getEntities()) {
				if (obj instanceof Enemy && room.isWithin(obj.getPosition().x, obj.getPosition().y) && obj.getPosition().x > leftX
						&& obj.getPosition().x < rightX && obj.getPosition().y > topY && obj.getPosition().y < bottomY) {
					relativeX = (double)(obj.getPosition().x - leftX) / (double)CAM_WIDTH;
					relativeY = (double)(obj.getPosition().y - topY) / (double)CAM_HEIGHT;
					drawX = (int)(relativeX*size.width) + 1;
					drawY = (int)(relativeY*size.height) + 1;
					g.drawString(String.valueOf(obj.getAscii()), drawX, drawY);
				}
			}
		}
		g.setColor(Color.WHITE);
		relativeX = (double)(Game.player.getPosition().x - leftX) / (double)CAM_WIDTH;
		relativeY = (double)(Game.player.getPosition().y - topY) / (double)CAM_HEIGHT;
		drawX = (int)(relativeX*size.width) + 1;
		drawY = (int)(relativeY*size.height) + 1;
		g.drawString(String.valueOf(Game.player.getAscii()), drawX, drawY);
	}
}
