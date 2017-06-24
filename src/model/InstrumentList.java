package model;

import java.util.ArrayList;


/*
 * class model InstrumentList
 * marwilc
 */

public class InstrumentList extends ArrayList<Instrument>{

	private InstrumentList instance;

	public InstrumentList() {
	}

	// getters and setters
	public InstrumentList getInstance() {
		return instance;
	}

	public void setInstance(InstrumentList instance) {
		this.instance = instance;
	}

	public Instrument next(int index)
	{
		Instrument instrument = null;
		
		if(index < this.size()-1){
			instrument = this.get(index+1);
		}
		return instrument;
	}

	// print the list
	public void printInstruments(){
		String print="";
		for (Instrument instrument : this) {
			print += instrument.toString() +"\n";
		}
		System.out.println(print);
	}

	public Instrument previous(int index) {
		// TODO Auto-generated method stub
		Instrument instrument = null;
		
		if(index > 0){
			instrument = this.get(index-1);
		}
		return instrument;
	}
	
	
}
