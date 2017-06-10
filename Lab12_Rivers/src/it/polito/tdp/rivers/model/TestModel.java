package it.polito.tdp.rivers.model;

import it.polito.tdp.rivers.DAO.RiversDAO;

public class TestModel {

	public static void main(String[] args) {
     
		RiversDAO dao= new RiversDAO();
		River r=dao.ListaRivers().get(2);
		  Simulator s=new Simulator(2,r);
		s.run();
		  //Integer i=3;
		 // System.out.println( r.getFlow(4));
		System.out.println("flow medio " +s.getFMED());
		System.out.println(("non garantita in "+s.getGiorniGarantita()));
	}

}
