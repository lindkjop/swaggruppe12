package gui;

import java.awt.BorderLayout;
import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ListCellRenderer;
import javax.swing.SpringLayout.Constraints;

import oving4.Person;

import model.Event;

public class EventRenderer extends JPanel implements ListCellRenderer {

	private JLabel eventName, eventRoom, eventTime;
	
	
	
	
	
	
	public Component getListCellRendererComponent(
	JList list,
	Object ASSvalue,         // value to display
	int index,               // cell index
	boolean isSelected,      // is the cell selected
	boolean cellHasFocus )   // the list and the cell have the focus
	{
		
		Event event = (Event)ASSvalue;
		
		this.setLayout(new BorderLayout());
		this.setSize(40, 50);
		
		
		
		eventName.setText(event.getTitle());
		eventRoom.setText(event.getRoom().getRoomName());
		eventTime.setText(event.getFrom() + " " + event.getTo());
		
		this.add(eventName,BorderLayout.NORTH);
		this.add(eventRoom,BorderLayout.AFTER_LAST_LINE);
		this.add(eventTime,BorderLayout.SOUTH);
		
		
		
		
		
		return this;
	}

}
