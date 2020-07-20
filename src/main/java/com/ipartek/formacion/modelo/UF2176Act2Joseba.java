package com.ipartek.formacion.modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UF2176Act2Joseba {
	
	private final static String URL = "jdbc:mysql://localhost/uf2176_act2_joseba";
	private final static String USUARIO = "debian-sys-maint";
	private final static String PASS = "o8lAkaNtX91xMUcV";
	
	public static void main(String[] args) throws SQLException {
		
		Connection con = DriverManager.getConnection(URL, USUARIO, PASS);
		
		
		System.out.println("Lista el primer apellido de todos los empleados.");
		System.out.println("-----------------------------------------");
		
		String sql = "SELECT ape1 FROM empleados ORDER BY ape1 ASC LIMIT 500;";
		PreparedStatement pst = con.prepareStatement(sql);
		ResultSet rs = pst.executeQuery();
		
		while (rs.next()) {
			System.out.println("Apellido Empleado:" +rs.getString("ape1"));
		}
		
		System.out.println("-----------------------------------------");
		System.out.println("Lista el código de los departamentos de los empleados que aparecen en la tabla empleado.");
		System.out.println("-----------------------------------------");
		
		sql = "SELECT DISTINCT (id_departamento) FROM empleados ORDER BY id_departamento ASC LIMIT 500;";
		pst = con.prepareStatement(sql);
		rs = pst.executeQuery();
		
		while (rs.next()) {
			System.out.println("ID Departamento:" +rs.getInt("id_departamento"));
		}
		
		System.out.println("-----------------------------------------");
		System.out.println("Lista el nombre y apellidos de los empleados en una única columna.");
		System.out.println("-----------------------------------------");
		
		sql = "SELECT nombre, ape1, ape2 FROM empleados ORDER BY nombre ASC LIMIT 500;";
		pst = con.prepareStatement(sql);
		rs = pst.executeQuery();
		
		while (rs.next()) {
			System.out.println("Nombre Empleado:" + rs.getString("nombre") + " " + rs.getString("ape1") + " " + rs.getString("ape2"));
		}
		
		System.out.println("-----------------------------------------");
		System.out.println("Lista el nombre de los departamentos y el valor del presupuesto actual ordenado de forma ascendente.");
		System.out.println("-----------------------------------------");
		
		sql = "SELECT nombre, presupuesto FROM departamentos ORDER BY presupuesto ASC LIMIT 500;";
		pst = con.prepareStatement(sql);
		rs = pst.executeQuery();
		
		while (rs.next()) {
			System.out.println("Nombre Departamento:" + rs.getString("nombre") + " | Presupuesto:" + rs.getFloat("presupuesto"));
		}
		
		System.out.println("-----------------------------------------");
		System.out.println("Lista el nombre de todos los departamentos ordenados de forma ascendente.");
		System.out.println("-----------------------------------------");
		
		sql = "SELECT nombre FROM departamentos ORDER BY nombre ASC LIMIT 500;";
		pst = con.prepareStatement(sql);
		rs = pst.executeQuery();
		
		while (rs.next()) {
			System.out.println("Nombre Departamento:" + rs.getString("nombre"));
		}
		
		System.out.println("-----------------------------------------");
		System.out.println("Devuelve  una  lista  con  el  nombre  de  los  departamentos  y  el  presupuesto,  de  aquellos  que tienen un presupuesto mayor o igual a 150000 euros.");
		System.out.println("-----------------------------------------");
		
		sql = "SELECT nombre, presupuesto FROM departamentos WHERE presupuesto >= 150000 ORDER BY presupuesto ASC LIMIT 500;";
		pst = con.prepareStatement(sql);
		rs = pst.executeQuery();
		
		while (rs.next()) {
			System.out.println("Nombre Departamento:" + rs.getString("nombre") + " | Presupuesto:" + rs.getFloat("presupuesto"));
		}
		
		System.out.println("-----------------------------------------");
		System.out.println("Devuelve  una  lista  con  el  nombre  de  los  departamentos  y  el presupuesto,  de  aquellos  que tienen un presupuesto entre 100000 y 200000 euros. Sin utilizar el operador BETWEEN");
		System.out.println("(Esta QUERY no devuelve resultados porque no hay departamentos con presupuestos dentro de este rango)");
		System.out.println("-----------------------------------------");
		
		sql = "SELECT nombre, presupuesto FROM departamentos WHERE presupuesto >= 100000 AND presupuesto <= 200000 ORDER BY presupuesto ASC LIMIT 500;";
		pst = con.prepareStatement(sql);
		rs = pst.executeQuery();
		
		while (rs.next()) {
			System.out.println("Nombre Departamento:" + rs.getString("nombre") + " | Presupuesto:" + rs.getFloat("presupuesto"));
		}
		
		System.out.println("-----------------------------------------");
		System.out.println("Devuelve una  lista  con  el nombre  de  los departamentos,  gastos  y  presupuesto, de  aquellos departamentos donde los gastos sean menores que el presupuesto del que disponen.");
		System.out.println("-----------------------------------------");
		
		sql = "SELECT nombre, gastos, presupuesto FROM departamentos WHERE gastos < presupuesto ORDER BY nombre ASC LIMIT 500;";
		pst = con.prepareStatement(sql);
		rs = pst.executeQuery();
		
		while (rs.next()) {
			System.out.println("Nombre Departamento:" + rs.getString("nombre") + " | Gastos:" + rs.getFloat("gastos") + " | Presupuesto:" + rs.getFloat("presupuesto"));
		}
		
		System.out.println("-----------------------------------------");
		System.out.println("Lista los nombres, apellidos y nif de los empleados que trabajan en el departamento 3.");
		System.out.println("(Esta QUERY no devuelve resultados porque no hay empleados trabajando en el departamento 3)");
		System.out.println("-----------------------------------------");
		
		sql = "SELECT nombre, ape1, ape2, cif FROM empleados WHERE id_departamento = 3 ORDER BY nombre ASC LIMIT 500;";
		pst = con.prepareStatement(sql);
		rs = pst.executeQuery();
		
		while (rs.next()) {
			System.out.println("Nombre Empleado:" + rs.getString("nombre") + " | Apellidos:" + rs.getString("ape1") + " " + rs.getString("ape2") + " | DNI:" + rs.getString("cif"));
		}
		
		System.out.println("-----------------------------------------");
		System.out.println("Devuelve un listado con los empleados y los datos de los departamentos donde trabaja cada uno");
		System.out.println("-----------------------------------------");
		
		sql = "SELECT e.id AS 'empleado_id', cif, e.nombre 'empleado_nombre',"
				+ "ape1, ape2, d.id AS 'departamento_id', d.nombre AS 'departamento_nombre'," 
				+ "d.presupuesto 'presupuesto', d.gastos AS 'gastos'"
				+ " FROM empleados AS e LEFT JOIN departamentos AS d ON e.id_departamento = d.id"
				+ " ORDER BY e.id ASC LIMIT 500;";
		pst = con.prepareStatement(sql);
		rs = pst.executeQuery();
		
		while (rs.next()) {
			System.out.println("ID Empleado:" + rs.getInt("empleado_id") + " | Nombre Empleado:" + rs.getString("empleado_nombre") + " "
								+ rs.getString("ape1") + " " + rs.getString("ape2") + " | DNI:" + rs.getString("cif")
								+ " | ID Departamento:" + rs.getInt("departamento_id") + " | Nombre Departamento:" + rs.getString("departamento_nombre")
								+ " | Presupuesto:" + rs.getFloat("presupuesto") + " | Gastos:" + rs.getInt("gastos"));
		}
	}
}
