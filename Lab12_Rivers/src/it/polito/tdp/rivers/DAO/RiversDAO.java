package it.polito.tdp.rivers.DAO;

import java.util.*;

import it.polito.tdp.rivers.model.CoppiaDate;
import it.polito.tdp.rivers.model.Flow;
import it.polito.tdp.rivers.model.River;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class RiversDAO {
	
	public List<River> ListaRivers(){
		
		final String sql = "SELECT * FROM river ";
		List<River> lista= new ArrayList<>();
		

		try {
			Connection conn = DBConnetion.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			

			ResultSet rs = st.executeQuery();

			while (rs.next()) {
				River temp= new River(rs.getInt("id"), rs.getString("name"));
				lista.add(temp);

				
			}

			return lista;

		} catch (SQLException e) {
			// e.printStackTrace();
			throw new RuntimeException("Errore Db");
		}
	}
	
public CoppiaDate Primo(River r){
		
		final String sql = "SELECT * FROM `rivers`.`flow` WHERE `river` =? ORDER BY `day`";
		
		

		try {
			Connection conn = DBConnetion.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			st.setInt(1, r.getId());

			ResultSet rs = st.executeQuery();
			int flowTot=0;


			while (rs.next()) {
				Flow f= new Flow(rs.getInt("id"), rs.getDate("day").toLocalDate(),rs.getFloat("flow"),r);
				r.aggiungiElemneto(f);
				flowTot+=f.getFlow();

				
			}
			LocalDate prima=r.getlistaFlow().get(0).getDate();
			LocalDate ultima=r.getlistaFlow().get(r.getlistaFlow().size()-1).getDate();
			int misurazioni=r.getlistaFlow().size();
			float media= (flowTot/misurazioni);
			System.out.println("++++++++"+flowTot/misurazioni);

			CoppiaDate coppia= new CoppiaDate(prima,ultima,r, misurazioni,media);
			
			return coppia;

		} catch (SQLException e) {
			// e.printStackTrace();
			throw new RuntimeException("Errore Db");
		}
	}
		
		
		
}

