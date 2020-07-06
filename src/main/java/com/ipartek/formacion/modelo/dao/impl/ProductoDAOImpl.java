package com.ipartek.formacion.modelo.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.ipartek.formacion.modelo.ConnectionManager;
import com.ipartek.formacion.modelo.dao.ProductoDAO;
import com.ipartek.formacion.modelo.pojo.Fabricante;
import com.ipartek.formacion.modelo.pojo.Producto;

public class ProductoDAOImpl implements ProductoDAO {
	
	private static final Logger LOG = Logger.getLogger(ProductoDAOImpl.class);
	private static ProductoDAOImpl INSTANCE = null;
	
	private ProductoDAOImpl() {
		super();
	}
	
	public static synchronized ProductoDAOImpl getInstance() {
		
		if (INSTANCE == null) {
			INSTANCE = new ProductoDAOImpl();
		}
		
		return INSTANCE;
	}
	
	/**
	 * Busca productos segun los parametros indicados
	 * @param nombreProducto String busca la palabra "nombreProducto" dentro del nombre del producto, si queremos todos pasar ""
	 * @param precioMin float, si no queremos filtrar pasar 0 o negativo
	 * @param precioMax float, si no queremos filtrar pasar 0 o negativo
	 * @param idFabricante int identificador del fabricante, si queremos todos pasar un 0
	 * @return listado de prodcutos, si no encuentra nada una lista vacia pero inicializada
	 */
	@Override
	public ArrayList<Producto> buscar(String nombreProducto, float precioMin, float precioMax, int idFabricante) {
		
		
		ArrayList<Producto> resultado = new ArrayList<Producto>();
		//String sql = "SELECT id, nombre, precio FROM productos ORDER BY id DESC LIMIT 500;";
		/*
		 * String sql = "SELECT p.id AS 'producto_id', p.nombre AS 'producto_nombre',"
						+ " precio, descripcion, f.id AS 'fabricante_id',"
						+ " f.nombre AS 'fabricante_nombre' FROM productos p"
						+ " INNER JOIN fabricantes f ON p.id_fabricante = f.id"
						+ " ORDER BY p.id ASC LIMIT 500;";
		*/
		
		String select = "SELECT p.id AS 'producto_id', p.nombre AS 'producto_nombre',"
					+ " precio, descripcion, f.id AS 'fabricante_id',"
					+ " f.nombre AS 'fabricante_nombre' FROM productos p"
					+ " INNER JOIN fabricantes f ON p.id_fabricante = f.id ";
		
		String where = " WHERE ";
		
		if (!"".equals(nombreProducto)) {
			where += " p.nombre LIKE " + "'%"+nombreProducto+"%'" + " ";
		} else {
			where += " p.nombre LIKE " + "'%'" + " ";
		}
		
		if (precioMin >= 0 && precioMax > 0 && precioMin <= precioMax) {
			where += " AND precio >= " + precioMin + " AND precio <= " + precioMax + " ";
		}
		
		if (idFabricante > 0) {
			where += " AND p.id_fabricante = " + idFabricante + " ";
		}
		
		String order = " ORDER BY p.id ASC LIMIT 500;";
		
		String sql = select + where + order;
		
		try(
			Connection con = ConnectionManager.getConnection();
			PreparedStatement pst = con.prepareStatement(sql);
			) {
			
			LOG.debug(pst);
			try ( ResultSet rs = pst.executeQuery() ) {
				
				Producto p;
				
				while( rs.next() ) {
					
					 p = new Producto();
					 p.setId( rs.getInt("producto_id"));
					 p.setNombre( rs.getString("producto_nombre"));
					 p.setPrecio(rs.getFloat("precio"));
					 p.setDescripcion("descripcion");
					 
					 Fabricante f = new Fabricante();
					 f.setId( rs.getInt("fabricante_id"));
					 f.setNombre( rs.getString("fabricante_nombre"));
					 
					 p.setFabricante(f);
					 
					 resultado.add(p);
					
				}
			} 
		} catch (Exception e) {
			
			LOG.error(e);
		}
		
		return resultado;
	}
}
