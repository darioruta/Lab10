package it.polito.tdp.rivers.model;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import it.polito.tdp.rivers.db.RiversDAO;

public class Model {
	
	private Map<Integer, River> idMap;
	private RiversDAO dao;
	
	
	public Model() {
		
		dao = new RiversDAO();
		idMap = dao.getAllRivers();
		
	}
	
	
	public Completamento getCompletamento (String nomeFiume) {
			
		
		return dao.getCompletamento(nomeFiume);
	}

	public Collection <River> getTuttiFiumi(){
		
		return  this.idMap.values();
	}
}
