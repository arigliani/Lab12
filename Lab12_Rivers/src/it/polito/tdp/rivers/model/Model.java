package it.polito.tdp.rivers.model;

import java.util.List;

import it.polito.tdp.rivers.DAO.RiversDAO;

public class Model {
	public RiversDAO dao= new RiversDAO();
	
	public List<River> ListaRivers(){
		
		List<River> r=dao.ListaRivers();
		return r;
	}
	
	public CoppiaDate inizioFine(River r){
		return dao.Primo(r);
	}
	
	

}
