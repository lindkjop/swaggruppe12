package gui;

import javax.swing.DefaultListCellRenderer;
import javax.swing.JLabel;
import javax.swing.JList;

import model.Person;


public class PersonRenderer extends DefaultListCellRenderer {
	public PersonRenderer() {
	}
	@Override
	public java.awt.Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus){
		JLabel label = (JLabel) super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
		
		if (value.getClass() == Person.class){
			Person p =(Person)value;
			label.setText(p.getName());
			
		}
		return label;
	}
}

