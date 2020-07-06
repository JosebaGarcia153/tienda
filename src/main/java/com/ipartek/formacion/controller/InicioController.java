package com.ipartek.formacion.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.ipartek.formacion.modelo.dao.impl.ProductoDAOImpl;
import com.ipartek.formacion.modelo.pojo.FormularioBusqueda;
import com.ipartek.formacion.modelo.pojo.Producto;


/**
 * Servlet implementation class InicioController
 */
@WebServlet("/buscar")
public class InicioController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private static final Logger LOG = Logger.getLogger(InicioController.class);
	private static final ProductoDAOImpl dao = ProductoDAOImpl.getInstance();
	
    	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String nombre 		= request.getParameter("nombre");
		String pmin 		= request.getParameter("pmin");
		String pmax			= request.getParameter("pmax");
		String fabricante 	= request.getParameter("fabricante");
		
		ArrayList<Producto> productos = new ArrayList<Producto>(); 
		FormularioBusqueda form = new FormularioBusqueda();

		try {

			LOG.trace("Entramos al controlador /inicio ");
			
			form = new FormularioBusqueda(nombre, pmin, pmax, fabricante);
			
			LOG.debug(String.format("filtro busqueda nombre=%s precioMinimo=%s precioMaximo=%s fabricante=%s", nombre, pmin, pmax, fabricante));
			
			productos = dao.buscar(form.getNombre(), form.getPrecioMin(), form.getPrecioMax(), form.getIdFabricante());
			
		}catch (Exception e) {
			
			LOG.error(e);
			
			
		}finally {
		request.setAttribute("formulario", form);
			request.setAttribute("productos", productos);
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		
		doGet(request, response);
	}
}