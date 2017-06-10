package it.polito.tdp.rivers.model;

import java.util.*;

import it.polito.tdp.rivers.DAO.RiversDAO;

public class River {
	private int id;
	private String name;
	private List<Flow> listaFlow;
	private Map<Integer,Flow> mappaFlow;
	
	public River(int id, String name) {
		super();
		this.id = id;
		this.name = name;
		this.listaFlow=new ArrayList<>();
		this.mappaFlow=new HashMap<>();
	}

	public List<Flow> getlistaFlow() {
		if(listaFlow==null){
			RiversDAO dao= new RiversDAO();
			dao.Primo(this);
			
		}
		return listaFlow;
	}

	public void setlistaFlow(List<Flow> listaFlow) {
		this.listaFlow = listaFlow;
	}
	
	public void aggiungiElemneto(Flow f){
		if(!mappaFlow.containsKey(f.getId())){
			mappaFlow.put(f.getId(), f);
			
			
			//System.out.println(f.getId());
			//System.out.println(mappaFlow.get(f.getId()));
			
			
			listaFlow.add(f);
		}
		
	}
	
	public float getFlow(int i){
		
		
		return this.listaFlow.get(i).getFlow();
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		River other = (River) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "River [id=" + id + ", name=" + name + "]";
	}
	
	
	
	
	

}
