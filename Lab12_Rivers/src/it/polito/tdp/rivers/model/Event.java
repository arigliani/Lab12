package it.polito.tdp.rivers.model;

public class Event implements Comparable<Event> {
       public enum EventType { RIEMPI } ;
	
       private int giorni;//dopo aver impostato k ho il numero di giorni totali per cui ripetere la simulazione
       private EventType type;
       
	public Event(int giorni, EventType type) {
		super();
		this.giorni = giorni;
		this.type = type;
	}

	public int getGiorni() {
		return giorni;
	}

	public void setGiorni(int giorni) {
		this.giorni = giorni;
	}

	public EventType getType() {
		return type;
	}

	public void setType(EventType type) {
		this.type = type;
	}

	@Override
	public int compareTo(Event other) {
		
		return this.giorni-other.giorni;
	}
       
       
       

}
