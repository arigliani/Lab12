package it.polito.tdp.rivers.DAO;

public abstract class TestDAO {

	public static void main(String[] args) {
		RiversDAO dao= new RiversDAO();
		
		System.out.println(dao.ListaRivers());
		System.out.println("-----");
		System.out.println(dao.Primo(dao.ListaRivers().get(0)));
	}

}
