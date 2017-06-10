package it.polito.tdp.rivers.model;
import java.util.List;
import java.util.PriorityQueue;

import it.polito.tdp.rivers.model.Event.EventType;

public class Simulator {
	private int GIORNITOTALI;	
	
	private float FMED;
	private float Q;
	
	private float c;//lovello della capienza
    private float fin;
	     private float fout;
	 private List<Flow> listaFin;
	
	private int GiorniGarantita;
    	private float cmed;
    	
	private Model m= new Model();
	CoppiaDate fiume;
	River r;
	
	PriorityQueue<Event> queue ;
	
	public Simulator(int k, River r) {
		super();
		this.r=r;
		fiume= m.inizioFine(r);
		listaFin=r.getlistaFlow();
		this.FMED=fiume.getfMedInt();
		this.GIORNITOTALI = k*30;
		this.Q=FMED*GIORNITOTALI;
		System.out.println(fiume);
		this.c=Q/2;
		this.GiorniGarantita=0;
		cmed=0;
		this.fin=0;
		this.fout=0;
		this.queue = new PriorityQueue<>() ;
		
	}
	
	
	public void addFlow(){
		System.out.println("giornate "+this.GIORNITOTALI);
		for(int i=1; i<=this.GIORNITOTALI;i++){
		//	System.out.println(+i);
			queue.add(new Event(i, EventType.RIEMPI));
		}
		
	}
	
	
	
	
	public void run(){
		
		int nMisurazioni=this.listaFin.size();
		this.addFlow();
		
		while(!queue.isEmpty()){
			Event e=queue.poll();
			int n=0;
			while(n==0)
			 n= (int)(Math.random()*nMisurazioni);
			
			//System.out.println(nMisurazioni);
			//System.out.println(n);
			this.setFin(n);// impostato fin
			
			this.setFout(this.getFout());
			float temp= this.c+(this.fin-this.fout);
			if(temp>0){
				//controllo se la differenza posso aggiungerla o devo tracimare
				System.out.println(" temp maggiore"+ temp+" "+this.Q);
				
				if(temp>this.Q){
					System.out.println("         temp maggiore di q");
					this.c=this.Q;
					this.cmed+=this.c;
				}else
				{     System.out.println("         temp maggiore ma minore di q");
					this.c=temp;
					this.cmed+=this.c;
					
				}
			}
			else{
				System.out.println(" temp minore");
				//aumento giorni che non si è potuto garantire l' acqua
				this.GiorniGarantita++;
				//aumento pongo c=0;
				this.c=0;
			}
			
		}
		
		this.cmed=this.cmed/nMisurazioni;
	}


	public float getC() {
		return c;
	}


	public void setC(float c) {
		this.c = c;
	}


	public float getFin() {
		return fin;
	}


	public void setFin(int fin) {
		this.fin = r.getFlow(fin);
	}


	public float getFout() {
		return fout;
	}


	private void setFout(float fout) {
		Double d= (double) Math.random();
		if(d<=0.05){
			this.fout = (float) (10*(0.8*this.FMED));
		}
		else{
			this.fout = (float) (0.8*this.FMED);
		}
		
		
	}


	public int getGiorniGarantita() {
		return GiorniGarantita;
	}


	public void setGiorniGarantita(int giorniGarantita) {
		GiorniGarantita = giorniGarantita;
	}


	public float getCmed() {
		return cmed;
	}


	public void setCmed(int cmed) {
		this.cmed = cmed;
	}


	public int getGIORNITOTALI() {
		return GIORNITOTALI;
	}


	public float getFMED() {
		return FMED;
	}


	public float getQ() {
		return Q;
	}


	public List<Flow> getListaFin() {
		return listaFin;
	}
	
	
	
	
	
	
	
	

}
