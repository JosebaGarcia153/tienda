package com.ipartek.formacion.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.ipartek.formacion.modelo.dao.impl.FabricanteDAOImpl;
import com.ipartek.formacion.modelo.dao.impl.ProductoDAOImpl;
import com.ipartek.formacion.modelo.pojo.FormularioBusqueda;
import com.ipartek.formacion.modelo.pojo.Producto;



/**
 * Servlet implementation class InicioController
 */
@WebServlet("/buscar")
public class InicioController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private final static Logger LOG = Logger.getLogger(InicioController.class);
	private final static ProductoDAOImpl dao = ProductoDAOImpl.getInstance();
	private final static FabricanteDAOImpl daof = FabricanteDAOImpl.getInstance();

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String nombre = request.getParameter("nombre");
		String pmin = request.getParameter("pmin");
		String pmax = request.getParameter("pmax");
		String fabricante = request.getParameter("fabricante");

		ArrayList<Producto> productos = new ArrayList<Producto>();
		FormularioBusqueda form = new FormularioBusqueda();

		try {

			LOG.trace("Entramos al controlador /inicio ");

			form = new FormularioBusqueda(nombre, pmin, pmax, fabricante);

			LOG.debug(String.format("filtro busqueda nombre=%s precioMinimo=%s precioMAximo=%s fabricante=%s", nombre,
					pmin, pmax, fabricante));

			productos = dao.buscar(form.getNombre(), form.getPrecioMin(), form.getPrecioMax(), form.getIdFabricante());

		} catch (Exception e) {

			LOG.error(e);

		} finally {
			request.setAttribute("fabricantes", daof.getAll());
			request.setAttribute("formulario", form);
			request.setAttribute("productos", productos);

			gestionBotonPrecio(request, form);

			request.getRequestDispatcher("index.jsp").forward(request, response);
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	/**
	 * Guarda 3 atributos en la request para usarlos en la vista y gestionar el boton de Precio:
	 * 
	 * <dl>
	 *  <dt>claseBtnPrecio:</dt> <dd>btn-primary o btn-outline-primary, si esta activado el filtro o no</dd>
	 *  <dt>textoBtnPrecio:</dt> <dd>texto a mostrar dentro del boton</dd>
	 *  <dt>btnPrecioShow:</dt>  <dd>true para mostrar boton de reset, false en caso contrario</dd>
	 * </dl> 
	 * 
	 * @param request FormularioBusqueda
	 * @param form    FormularioBusqueda
	 */
	private void gestionBotonPrecio(HttpServletRequest request, FormularioBusqueda form) {
		
		String claseBtnPrecio = "btn-primary";
		String textoBtnPrecio = "Precio desde " + form.getPrecioMin() + " hasta " + form.getPrecioMax();
		boolean btnPrecioShow = true;
		
		
		if ( form.getPrecioMin() == 0 && form.getPrecioMax() == 0 ) {
			
			claseBtnPrecio = "btn-outline-primary";
			textoBtnPrecio = "Precio";
			btnPrecioShow = false;
		}
		
		request.setAttribute("claseBtnPrecio", claseBtnPrecio);
		request.setAttribute("textoBtnPrecio", textoBtnPrecio);
		request.setAttribute("btnPrecioShow", btnPrecioShow);

	}

}