package com.ipartek.formacion.modelo.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.ipartek.formacion.modelo.ConnectionManager;
import com.ipartek.formacion.modelo.dao.FabricanteDAO;
import com.ipartek.formacion.modelo.pojo.Fabricante;


public class FabricanteDAOImpl implements FabricanteDAO{
	
	private static final Logger LOG = Logger.getLogger(FabricanteDAOImpl.class);
	private static FabricanteDAOImpl INSTANCE = null;
	
	private FabricanteDAOImpl() {
		super();
	}
	
	public static synchronized FabricanteDAOImpl getInstance() {
		
		if (INSTANCE == null) {
			INSTANCE = new FabricanteDAOImpl();
		}
		
		return INSTANCE;
	}
	
	private final String SQL_GET_ALL = "SELECT id, nombre FROM fabricantes ORDER BY nombre ASC LIMIT 500; ";
	
	@Override
	public ArrayList<Fabricante> getAll() {
		
		ArrayList<Fabricante> fabricantes = new ArrayList<Fabricante>();

		try(
			Connection con = ConnectionManager.getConnection();
			PreparedStatement pst = con.prepareStatement(SQL_GET_ALL);
			ResultSet rs = pst.executeQuery();
			){
			
			LOG.debug(pst);
			while( rs.next() ) {
				
				fabricantes.add(mapper(rs));					
			}
				
		} catch (Exception e) {
			
			LOG.error(e);
		}
		
		return fabricantes;
	}	
	
	private Fabricante mapper(ResultSet rs) throws SQLException {
		
		Fabricante f = new Fabricante();
		
		f.setId(rs.getInt("id"));
		f.setNombre(rs.getString("nombre"));
		
		return f;
	}
}
