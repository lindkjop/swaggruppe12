package gui;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;
import model.Event;

/*
 * This is only responsible for showing the eventTitle currently, instead of the eventID
 */

public class EventRenderer extends JLabel implements ListCellRenderer {
	
	public Component getListCellRendererComponent(
	JList list,
	Object ASSvalue,         // value to display
	int index,               // cell index
	boolean isSelected,      // is the cell selected
	boolean cellHasFocus )   // the list and the cell have the focus
	{
		//Casts the ASSvalue as the Event class
		Event event = (Event)ASSvalue;
		//makes it stand a little out
		this.setBackground(Color.LIGHT_GRAY);
		//Displays the given eventName
		this.setText(event.getTitle());

		return this;
	}

}
