package com.ipartek.formacion.modelo.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.ipartek.formacion.modelo.ConnectionManager;
import com.ipartek.formacion.modelo.dao.DepartamentoDAO;
import com.ipartek.formacion.modelo.pojo.Departamento;


public class DepartamentoDAOImpl implements DepartamentoDAO{
	
	private static final Logger LOG = Logger.getLogger(DepartamentoDAOImpl.class);
	private static DepartamentoDAOImpl INSTANCE = null;
	
	private DepartamentoDAOImpl() {
		super();
	}
	
	public static synchronized DepartamentoDAOImpl getInstance() {
		
		if (INSTANCE == null) {
			INSTANCE = new DepartamentoDAOImpl();
		}
		
		return INSTANCE;
	}
	
	private final String SQL_GET_ALL = "SELECT id, nombre FROM fabricantes ORDER BY nombre ASC LIMIT 500; ";
	
	@Override
	public ArrayList<Departamento> getAll() {
		
		ArrayList<Departamento> departamentos = new ArrayList<Departamento>();

		try(
			Connection con = ConnectionManager.getConnection();
			PreparedStatement pst = con.prepareStatement(SQL_GET_ALL);
			ResultSet rs = pst.executeQuery();
			){
			
			LOG.debug(pst);
			while( rs.next() ) {
				
				departamentos.add(mapper(rs));					
			}
				
		} catch (Exception e) {
			
			LOG.error(e);
		}
		
		return departamentos;
	}	
	
	private Departamento mapper(ResultSet rs) throws SQLException {
		
		Departamento d = new Departamento();
		
		d.setId(rs.getInt("id"));
		d.setNombre(rs.getString("nombre"));
		d.setPresupuesto(rs.getFloat("presupuesto"));
		d.setGastos(rs.getFloat("gastos"));
		
		return d;
	}
}
