package it.polito.tdp.rivers.db;

import java.util.HashMap;

import java.util.Map;

import it.polito.tdp.rivers.model.Completamento;
import it.polito.tdp.rivers.model.River;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RiversDAO {

	public Map<Integer, River> getAllRivers() {
		
		final String sql = "SELECT id, name FROM river";

		Map<Integer, River> result = new HashMap<>();

		try {
			Connection conn = DBConnect.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			ResultSet res = st.executeQuery();

			while (res.next()) {
				
				River rTemp =new River(res.getInt("id"), res.getString("name"));
				result.put(rTemp.getId(), rTemp);
			}

			conn.close();
			
		} catch (SQLException e) {
			//e.printStackTrace();
			throw new RuntimeException("SQL Error");
		}

		return result;
	}
	
	public Completamento getCompletamento (String fiume) {
		
		String sql = "SELECT MIN(DAY) AS dataPicc, MAX(DAY) AS dataGrande, AVG(flow) AS mediaFlusso, COUNT(*) AS totMisurazioni, r.id "
				+ "FROM  flow f, river r "
				+ "WHERE f.river = r.id AND r.name = ?";
			
		Completamento result = null;
		
		try {
			
			Connection conn = DBConnect.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1, fiume);
			ResultSet rs = st.executeQuery();

			if(rs.next()) {
				
				result = new Completamento (rs.getDate("dataPicc").toLocalDate(), rs.getDate("dataGrande").toLocalDate(), rs.getFloat("mediaFlusso"), rs.getInt("totMisurazioni"), rs.getInt("id"));
			}
			
			conn.close();
			return result;
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("Errore connessione al database");
				throw new RuntimeException("Error Connection Database");
			}

		
		
	}
}
