package main.java.ui;

import java.awt.Component;

import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;

import main.java.system.Game;

public class SkillTable extends JTable{
	
	public SkillTable() {
		super();
		setModel(new SkillTableModel());
        getColumnModel().getColumn(0).setPreferredWidth(80);
        getColumnModel().getColumn(0).setMaxWidth(80);
        getColumnModel().getColumn(1).setPreferredWidth(32);
        getColumnModel().getColumn(1).setMaxWidth(32);
        getColumnModel().getColumn(2).setPreferredWidth(32);
        getColumnModel().getColumn(2).setMaxWidth(32);
        getColumnModel().getColumn(3).setPreferredWidth(32);
        getColumnModel().getColumn(3).setMaxWidth(32);
        getColumnModel().getColumn(4).setPreferredWidth(32);
        getColumnModel().getColumn(4).setMaxWidth(32);
        clearSelection();
        updateUI();
	}
	
	public TableCellRenderer getCellRenderer(int row, int collumn) {
		return new DefaultTableCellRenderer() {
			
			public Component getTableCellRendererComponent(
                JTable table,
                Object value,
                boolean isSelected,
                boolean hasFocus,
                int row,
                int column) {
                Component comp;
                comp = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                comp.setForeground(java.awt.Color.BLACK);
                return comp;
	            }
		};
	}

	class SkillTableModel extends AbstractTableModel {

		String[] columnNames = {
	            "Skill",
	            "HP",
	            "MP",
	            "EN",
	            "SP"
	    };
		
        SkillTableModel() {
            super();
        }
		
		@Override
		public int getRowCount() {
			int i;
			try {
				i = Game.player.getSkills().size();
			}catch (NullPointerException e) {
				i = 1;
			}
			return i;
		}

		@Override
		public int getColumnCount() {
			return 5;
		}

		@Override
		public Object getValueAt(int rowIndex, int columnIndex) {
			String str = "";
			if (columnIndex == 0) {
				str = Game.player.getSkills().get(rowIndex).getName();
			}
			else if (columnIndex == 1) {
				str += Game.player.getSkills().get(rowIndex).getHpCost();
			}
			else if (columnIndex == 2) {
				str += Game.player.getSkills().get(rowIndex).getMpCost();
			}
			else if (columnIndex == 3) {
				str += Game.player.getSkills().get(rowIndex).getEnCost();
			}
			else if (columnIndex == 4) {
				str += Game.player.getSkills().get(rowIndex).getSpCost();
			}
			return str;
		} 

        public String getColumnName(int col) {
            return columnNames[col];
        }
	}
	
}
