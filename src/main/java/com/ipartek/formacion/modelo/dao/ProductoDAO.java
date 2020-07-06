package com.ipartek.formacion.modelo.dao;

import java.util.ArrayList;

import com.ipartek.formacion.modelo.pojo.Producto;

public interface ProductoDAO {
	
	ArrayList<Producto> buscar(String nombreProducto, float precioMin, float precioMax, int idFabricante);
	
	
}
