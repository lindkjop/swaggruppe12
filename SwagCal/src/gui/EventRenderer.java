package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ListCellRenderer;
import javax.swing.Box.Filler;
import javax.swing.SpringLayout.Constraints;

import org.junit.runners.ParentRunner;
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
		
		this.setLayout(new GridBagLayout());	
		this.setSize(this.getParent().getWidth(),eventName.getHeight()*3);
		this.setBackground(Color.LIGHT_GRAY);
		
		
		eventName.setText(event.getTitle());
		eventRoom.setText(event.getRoom().getRoomName());
		eventTime.setText(event.getFrom() + " " + event.getTo());
		
		
		
		this.add(eventName,GridBagConstraints.NORTH);
		this.add(eventRoom,GridBagConstraints.CENTER);
		this.add(eventTime,GridBagConstraints.SOUTH);
		
		
		
		
		
		return this;
	}

}
