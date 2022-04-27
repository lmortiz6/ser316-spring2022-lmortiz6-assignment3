package main.java.ui;

import java.awt.Component;

import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;

import main.java.system.Game;

public class ItemTable extends JTable{

	public ItemTable() {
		super();
		setModel(new ItemTableModel());
		getColumnModel().getColumn(0).setPreferredWidth(130);
		getColumnModel().getColumn(0).setMaxWidth(130);
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
	
	class ItemTableModel extends AbstractTableModel {

		String[] columnNames = {
	            "Item"
	    };
		
		ItemTableModel() {
			super();
		}
		
		@Override
		public int getRowCount() {
			int i;
			try {
				i = Game.player.getUseItems().size() + Game.player.getRelics().size();
			}catch (NullPointerException e) {
				i = 1;
			}
			return i;
		}

		@Override
		public int getColumnCount() {
			return 1;
		}

		@Override
		public Object getValueAt(int rowIndex, int columnIndex) {
			String str = "";
			if (rowIndex < Game.player.getUseItems().size()) {
				str = Game.player.getUseItems().get(rowIndex).getName();
			}else {
				str = Game.player.getRelics().get(rowIndex - Game.player.getUseItems().size()).getName();
			}
			return str;
		} 

        public String getColumnName(int col) {
            return columnNames[col];
        }
	}
}
