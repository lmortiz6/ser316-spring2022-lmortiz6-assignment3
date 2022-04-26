package main.java.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import main.java.object.Player;
import main.java.object.Weapon;
import main.java.system.Game;

public class ControlPanel extends JPanel{
	
	JTabbedPane tabbedPanel = new JTabbedPane();
	
	JPanel moveTab = new JPanel();
	JLabel nameL = new JLabel("Name: ");
	JLabel hpL = new JLabel("HP: ");
	JLabel mpL = new JLabel("MP: ");
	JLabel enL = new JLabel("EN: ");
	JLabel spL = new JLabel("SP: ");
	JLabel vigL = new JLabel("Vig: ");
	JLabel mndL = new JLabel("Mnd: ");
	JLabel endL = new JLabel("End: ");
	JLabel strL = new JLabel("Str: ");
	JLabel lckL = new JLabel("Lck: ");
	
	JPanel attackTab = new JPanel();
	JLabel weaponL = new JLabel("Weapon: ");
	JLabel damageL = new JLabel("Base Damage: ");
	JLabel rangeL = new JLabel("Range: ");
	JLabel enCostL = new JLabel("Energy Cost: ");
	
	JPanel statPanel = new JPanel();
	
	JPanel endTurnPanel = new JPanel(new BorderLayout());
	JButton endTurnB = new JButton("End Turn");
	
	JPanel buttonPanel = new JPanel();
	JButton northB = new JButton("∧");
	JButton southB = new JButton("v");
	JButton westB = new JButton("<");
	JButton eastB = new JButton(">");
	JButton pickUpB = new JButton("Pick Up");
	
	public ControlPanel() {
		setPreferredSize(new Dimension(250, 550));
		setBackground(Color.DARK_GRAY);
		tabbedPanel.setPreferredSize(new Dimension(250, 330));
		tabbedPanel.setBackground(Color.DARK_GRAY);
		statPanel.setPreferredSize(new Dimension(250, 70));
		endTurnPanel.setPreferredSize(new Dimension(250, 50));
		buttonPanel.setPreferredSize(new Dimension(250, 100));
		init();
	}
	
	private void init() {
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		moveTab.setLayout(new BoxLayout(moveTab, BoxLayout.Y_AXIS));
		
		Player player = Game.player;
		if (player != null) {
			nameL.setText(nameL.getText() + player.getName());
			hpL.setText(hpL.getText() + player.getHP() + "/" + player.getMaxHP());
			mpL.setText(mpL.getText() + player.getMP() + "/" + player.getMaxMP());
			enL.setText(enL.getText() + player.getEnergy() + "/" + player.getMaxEnergy());
			spL.setText(spL.getText() + player.getSP());
			vigL.setText(vigL.getText() + player.getVigor());
			mndL.setText(mndL.getText() + player.getMind());
			endL.setText(endL.getText() + player.getEndurance());
			strL.setText(strL.getText() + player.getStrength());
			lckL.setText(lckL.getText() + player.getLuck());
		}
		moveTab.add(leftAlligned(nameL));
		moveTab.add(leftAlligned(hpL));
		moveTab.add(leftAlligned(mpL));
		moveTab.add(leftAlligned(enL));
		moveTab.add(leftAlligned(spL));
		moveTab.add(leftAlligned(vigL));
		moveTab.add(leftAlligned(mndL));
		moveTab.add(leftAlligned(endL));
		moveTab.add(leftAlligned(strL));
		moveTab.add(leftAlligned(lckL));
		
		Weapon weapon = Game.player.getWeapon();
		
		if (weapon != null) {
			weaponL.setText(weaponL.getText() + weapon.getName());
			damageL.setText(damageL.getText() + weapon.getDamage());
			rangeL.setText(rangeL.getText() + weapon.getWidth() + "x" + weapon.getLength());
			enCostL.setText(enCostL.getText() + weapon.getEnergyCost());
		}
		attackTab.add(weaponL);
		attackTab.add(damageL);
		attackTab.add(rangeL);
		attackTab.add(enCostL);
		
		tabbedPanel.add(moveTab, "Move");
		tabbedPanel.add(attackTab, "Attack");
		
		statPanel.setLayout(new BoxLayout(statPanel, BoxLayout.Y_AXIS));
		statPanel.add(leftAlligned(hpL));
		statPanel.add(leftAlligned(mpL));
		statPanel.add(leftAlligned(enL));
		statPanel.add(leftAlligned(spL));
		
		endTurnB.addActionListener(new ActionListener( ) {
			@Override
			public void actionPerformed(ActionEvent e) {
				endTurnAction();
			}});
		endTurnPanel.add(endTurnB, BorderLayout.CENTER);
		
		buttonPanel.setLayout(new BorderLayout());
		
		northB.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				actionRequested("NORTH");
			}});
		buttonPanel.add(northB, BorderLayout.NORTH);
		
		southB.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				actionRequested("SOUTH");
			}});
		buttonPanel.add(southB, BorderLayout.SOUTH);
		
		westB.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				actionRequested("WEST");
			}});
		buttonPanel.add(westB, BorderLayout.WEST);
		
		eastB.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				actionRequested("EAST");
			}});
		buttonPanel.add(eastB, BorderLayout.EAST);
		
		pickUpB.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				pickUp();
			}});
		buttonPanel.add(pickUpB, BorderLayout.CENTER);
		
		add(tabbedPanel);
		add(statPanel);
		add(endTurnPanel);
		add(buttonPanel);
	}
	
	public void refresh() {
		Player player = Game.player;
		if (player != null) {
			nameL.setText("Name: " + player.getName());
			hpL.setText("HP: " + player.getHP() + "/" + player.getMaxHP());
			mpL.setText("MP: " + player.getMP() + "/" + player.getMaxMP());
			enL.setText("EN: " + player.getEnergy() + "/" + player.getMaxEnergy());
			spL.setText("SP: " + player.getSP());
			vigL.setText("Vig: " + player.getVigor());
			mndL.setText("Mnd: " + player.getMind());
			endL.setText("End: " + player.getEndurance());
			strL.setText("Str: " + player.getStrength());
			lckL.setText("Lck: " + player.getLuck());
		}
	}
	
	private void endTurnAction() {
		if (Game.playerTurn) {
			Game.player.endTurn();
		}
	}
	
	private void actionRequested(String direction) {
		if (Game.playerTurn && tabbedPanel.getSelectedIndex() != -1) {
			switch (tabbedPanel.getSelectedIndex()) {
			case 0:
				Game.player.move(direction);
				break;
			case 1:
				Game.player.attack(direction);
				break;
			}
		}
	}
	
	private void pickUp() {
		if (Game.playerTurn) {
			Game.player.pickUp();
		}
	}
	
	private Component leftAlligned(Component comp) {
		Box b = Box.createHorizontalBox();
		b.add(comp);
		b.add(Box.createHorizontalGlue());
		return b;
	}
	
	
}
