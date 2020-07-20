package com.ipartek.formacion.modelo.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.ipartek.formacion.modelo.ConnectionManager;

import com.ipartek.formacion.modelo.dao.EmpleadoDAO;
import com.ipartek.formacion.modelo.pojo.Departamento;
import com.ipartek.formacion.modelo.pojo.Empleado;


public class EmpleadoDAOImpl implements EmpleadoDAO {
	
	private static final Logger LOG = Logger.getLogger(EmpleadoDAOImpl.class);
	
	private static EmpleadoDAOImpl INSTANCE = null;
	
	private EmpleadoDAOImpl() {
		super();
	}
	
	public static synchronized EmpleadoDAOImpl getInstance() {
		
		if (INSTANCE == null) {
			INSTANCE = new EmpleadoDAOImpl();
		}
		
		return INSTANCE;
	}
	
	private final String SQL_GET_ALL = "SELECT e.id AS 'empleado_id', cif, e.nombre 'empleado_nombre',"
			+ "ape1, ape2, d.id AS 'departamento_id', d.nombre AS 'departamento_nombre'," 
			+ "d.presupuesto 'presupuesto', d.gastos AS 'gastos'"
			+ " FROM empleados AS e LEFT JOIN departamentos AS d ON e.id_departamento = d.id"
			+ " ORDER BY e.id ASC LIMIT 500;";
	
	private final String SQL_SEARCH = "SELECT e.id AS 'empleado_id', cif, e.nombre 'empleado_nombre',"
			+ "ape1, ape2, d.id AS 'departamento_id', d.nombre AS 'departamento_nombre'," 
			+ "d.presupuesto 'presupuesto', d.gastos AS 'gastos'"
			+ " FROM empleados AS e LEFT JOIN departamentos AS d ON e.id_departamento = d.id";

	@Override
	public ArrayList<Empleado> getAll() {
		
		ArrayList<Empleado> resultado = new ArrayList<Empleado>();
		
		
		
		try(
			Connection con = ConnectionManager.getConnection();
			PreparedStatement pst = con.prepareStatement(SQL_GET_ALL);
			) {
			
			LOG.debug(pst);
			try ( ResultSet rs = pst.executeQuery() ) {
				
				Empleado e;
				
				while( rs.next() ) {
					
					 e = new Empleado();
					 e.setId( rs.getInt("empleado_id"));
					 e.setCif(rs.getString("cif"));
					 e.setNombre( rs.getString("empleado_nombre"));
					 e.setApe1( rs.getString("ape1"));
					 e.setApe2( rs.getString("ape2"));
					 
					 Departamento d = new Departamento();
					 d.setId( rs.getInt("departamento_id"));
					 d.setNombre(rs.getString("departamento_nombre"));
					 d.setPresupuesto(rs.getFloat("presupuesto"));
					 d.setGastos(rs.getFloat("gastos"));
					 
					 e.setDepartamento(d);
					 
					 resultado.add(e);			
				}
			} 
		} catch (Exception e) {
			
			LOG.error(e);
		}
		
		return resultado;
	}

	@Override
	public ArrayList<Empleado> buscar(String nombre, String ape1, String ape2, String cif) {
		
		ArrayList<Empleado> resultado = new ArrayList<Empleado>();
		
		String where = " WHERE ";
		
		if (!"".equals(nombre)) {
			where += " e.nombre LIKE " + "'%"+nombre+"%'" + " ";
		} else {
			where += " e.nombre LIKE " + "'%'" + " ";
		}
		
		if (!"".equals(ape1)) {
			where += " AND ape1 LIKE " + "'%"+ape1+"%'" + " ";
		}
		
		if (!"".equals(ape2)) {
			where += " AND ape2 LIKE " + "'%"+ape2+"%'" + " ";
		}
		
		if (!"".equals(cif)) {
			where += " AND cif LIKE " + "'%"+cif+"%'" + " ";
		}
		
		String order = " ORDER BY e.id ASC LIMIT 500;";
		
		String sql = SQL_SEARCH + where + order;
		
		try(
			Connection con = ConnectionManager.getConnection();
			PreparedStatement pst = con.prepareStatement(sql);
			) {
			
			LOG.debug(pst);
			try ( ResultSet rs = pst.executeQuery() ) {
				
				Empleado e;
				
				while( rs.next() ) {
					
					e = new Empleado();
					e.setId( rs.getInt("empleado_id"));
					e.setCif(rs.getString("cif"));
					e.setNombre( rs.getString("empleado_nombre"));
					e.setApe1( rs.getString("ape1"));
					e.setApe2( rs.getString("ape2"));
					
					Departamento d = new Departamento();
					d.setId( rs.getInt("departamento_id"));
					d.setNombre(rs.getString("departamento_nombre"));
					d.setPresupuesto(rs.getFloat("presupuesto"));
					d.setGastos(rs.getFloat("gastos"));
					
					e.setDepartamento(d);
					 
					 resultado.add(e);
				}
			} 
		} catch (Exception e) {
			
			LOG.error(e);
		}
		
		return resultado;
	}
}
