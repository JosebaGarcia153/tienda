package com.ipartek.formacion.modelo.dao;

import java.util.ArrayList;

import com.ipartek.formacion.modelo.pojo.Empleado;


public interface EmpleadoDAO {

	ArrayList<Empleado> getAll();
	ArrayList<Empleado> buscar(String nombre, String ape1, String ape2, String cif);
}
