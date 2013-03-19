package gui.actions;

import java.util.ArrayList;

import gui.ClientGUI;
import model.Event;
import model.Model;
import model.Person;

public class FillWeekWithEvents {
	ArrayList<Person> persons;
	Model m;
	String week;
	ClientGUI c;

	public FillWeekWithEvents(ClientGUI c){
		this.m = c.getModel();
		this.week = (String)c.getComboBoxWeek().getSelectedItem();
		this.c = c;
		this.persons = m.getPersons();
		
		fill();
	}

	private void fill() {
		for (Person p: persons){
			if(p!= null && !p.getEvents().isEmpty()){
				for (Event e:p.getEvents()){
					switch(e.getFrom().getDayOfWeek()){
					case 1:
						c.getJLMandag().add(e);
						break;
					case 2:
						c.getJLTirsdag().add(e);
						break;
					case 3:
						c.getJLOnsdag().add(e);
						break;
					case 4:
						c.getJLTorsdag().add(e);
						break;
					case 5:
						c.getJLFredag().add(e);
						break;
					case 6:
						c.getJLLordag().add(e);
						break;
					case 7:
						c.getJLSondag().add(e);
						break;
					}

				}
			}
		}
		
	}

}
