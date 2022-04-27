package main.java.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
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
	JLabel xpL = new JLabel("XP: ");
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
	
	JPanel skillTab = new JPanel();
	SkillTable skillTable = new SkillTable();
	JScrollPane skillScroll = new JScrollPane();
	JPanel skillInfoPanel = new JPanel();
	JButton skillInfoB = new JButton("Get Info");
	
	JPanel itemTab = new JPanel();
	ItemTable itemTable = new ItemTable();
	JScrollPane itemScroll = new JScrollPane();
	JPanel itemInfoPanel = new JPanel();
	JButton itemInfoB = new JButton("Get Info");
	
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
			xpL.setText(xpL.getText() + player.getXP() + "/" + player.getLevelXP());
			vigL.setText(vigL.getText() + player.getVigor());
			mndL.setText(mndL.getText() + player.getMind());
			endL.setText(endL.getText() + player.getEndurance());
			strL.setText(strL.getText() + player.getStrength());
			lckL.setText(lckL.getText() + player.getLuck());
		}
		moveTab.add(leftAlligned(nameL));
		moveTab.add(leftAlligned(xpL));
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
		
		attackTab.setLayout(new BoxLayout(attackTab, BoxLayout.Y_AXIS));
		attackTab.add(leftAlligned(weaponL));
		attackTab.add(leftAlligned(damageL));
		attackTab.add(leftAlligned(rangeL));
		attackTab.add(leftAlligned(enCostL));
		
		skillInfoB.addActionListener(new ActionListener( ) {
			@Override
			public void actionPerformed(ActionEvent e) {
				skillInfoAction();
			}});
		
		skillInfoPanel.setLayout(new BorderLayout());
		skillInfoPanel.setPreferredSize(new Dimension(250, 50));
		skillInfoPanel.add(skillInfoB, BorderLayout.CENTER);
        skillTable.setRowHeight(24);
		skillScroll.getViewport().add(skillTable, null);
		
		skillTab.setLayout(new BorderLayout());
		skillTab.add(skillScroll, BorderLayout.CENTER);
		skillTab.add(skillInfoPanel, BorderLayout.SOUTH);
		
		itemInfoB.addActionListener(new ActionListener( ) {
			@Override
			public void actionPerformed(ActionEvent e) {
				itemInfoAction();
			}});
		
		itemInfoPanel.setLayout(new BorderLayout());
		itemInfoPanel.setPreferredSize(new Dimension(250, 50));
		itemInfoPanel.add(itemInfoB, BorderLayout.CENTER);
		itemTable.setRowHeight(24);
		itemScroll.getViewport().add(itemTable, null);
		
		itemTab.setLayout(new BorderLayout());
		itemTab.add(itemScroll, BorderLayout.CENTER);
		itemTab.add(itemInfoPanel, BorderLayout.SOUTH);
		
		
		tabbedPanel.setFont(tabbedPanel.getFont().deriveFont(12.5f));
		tabbedPanel.add(moveTab, "Move");
		tabbedPanel.add(attackTab, "Attack");
		tabbedPanel.add(skillTab, "Skills");
		tabbedPanel.add(itemTab, "Items");
		
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
			xpL.setText("XP: " + player.getXP() + "/" + player.getLevelXP());
			vigL.setText("Vig: " + player.getVigor());
			mndL.setText("Mnd: " + player.getMind());
			endL.setText("End: " + player.getEndurance());
			strL.setText("Str: " + player.getStrength());
			lckL.setText("Lck: " + player.getLuck());
		}
		skillTable.clearSelection();
		skillTable.updateUI();
		itemTable.clearSelection();
		itemTable.updateUI();
	}
	
	private void skillInfoAction() {
		int index = skillTable.getSelectedRow();
		if (index != -1) {
			String str = Game.player.getSkills().get(index).getDesc();
			//TODO log str
			App.getFrame().log(str);
			System.out.println(str);
		}
	}
	
	private void itemInfoAction() {
		int index = itemTable.getSelectedRow();
		if (index != -1) {
			String str = "";
			if (index < Game.player.getUseItems().size()) {
				str = Game.player.getUseItems().get(index).getDesc();
			} else {
				str = Game.player.getRelics().get(index - Game.player.getUseItems().size()).getDesc();
			}
			//TODO log str
			App.getFrame().log(str);
			System.out.println(str);
		}
	}
	
	private void endTurnAction() {
		if (Game.playerTurn) {
			Game.player.endTurn();
		}
	}
	
	private void actionRequested(String direction) {
		if (Game.playerTurn && tabbedPanel.getSelectedIndex() != -1) {
			int index;
			switch (tabbedPanel.getSelectedIndex()) {
			case 0:
				Game.player.move(direction);
				break;
			case 1:
				Game.player.attack(direction);
				break;
			case 2:
				index = skillTable.getSelectedRow();
				if (index != -1) {
					Game.player.getSkills().get(index).use(direction);
				}
				break;
			case 3:
				index = itemTable.getSelectedRow();
				if (index != -1) {
					if (index < Game.player.getUseItems().size()) {
						Game.player.getUseItems().get(index).use();
					}else {
						itemInfoAction();
					}
				}
				
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
