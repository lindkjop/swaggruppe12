package gui.actions;

import tools.dateTime;
import gui.ClientGUI;
import model.Model;

public class SelectWeek {
	ClientGUI mainFrame;
	Model model;
	int selectedWeek;
	
	dateTime man;
	dateTime tir;
	dateTime ons;
	dateTime tor;
	dateTime fre;
	dateTime lor;
	dateTime son;
	
	public SelectWeek(ClientGUI clientGUI, Model m, int selectedWeek){
		this.mainFrame = clientGUI;
		this.model = m;
		this.selectedWeek = selectedWeek;
		
		man = new dateTime();
		this.man.setWeek(selectedWeek);
		this.man.setWeekDay(1);
		this.man.setYear(dateTime.now().getYear());
		
		tir = new dateTime();
		this.tir.setWeek(selectedWeek);
		this.tir.setWeekDay(2);
		this.tir.setYear(dateTime.now().getYear());
		
		ons = new dateTime();
		this.ons.setWeek(selectedWeek);
		this.ons.setWeekDay(3);
		this.ons.setYear(dateTime.now().getYear());
		
		tor = new dateTime();
		this.tor.setWeek(selectedWeek);
		this.tor.setWeekDay(4);
		this.tor.setYear(dateTime.now().getYear());
		
		fre = new dateTime();
		this.fre.setWeek(selectedWeek);
		this.fre.setWeekDay(5);
		this.fre.setYear(dateTime.now().getYear());
		
		lor = new dateTime();
		this.lor.setWeek(selectedWeek);
		this.lor.setWeekDay(6);
		this.lor.setYear(dateTime.now().getYear());
		
		son = new dateTime();
		this.son.setWeek(selectedWeek);
		this.son.setWeekDay(7);
		this.son.setYear(dateTime.now().getYear());
		
		updateWeekDayDates();
//		updateWeekDayEvents();
	}

	private void updateWeekDayEvents() {
		// TODO Auto-generated method stub
		
	}

	private void updateWeekDayDates() {		
		mainFrame.getLblMandagDato().setText(man.getDateFormatedForWeekView());
		mainFrame.getLblTirsdagDato().setText(tir.getDateFormatedForWeekView());
		mainFrame.getLblOnsdagDato().setText(ons.getDateFormatedForWeekView());
		mainFrame.getLblTorsdagDato().setText(tor.getDateFormatedForWeekView());
		mainFrame.getLblFredagDato().setText(fre.getDateFormatedForWeekView());
		mainFrame.getLblLordagDato().setText(lor.getDateFormatedForWeekView());
		mainFrame.getLblSondagDato().setText(son.getDateFormatedForWeekView());
	}
	
	
	

}
