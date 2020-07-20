package com.ipartek.formacion.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

//import com.ipartek.formacion.modelo.dao.impl.DepartamentoDAOImpl;
import com.ipartek.formacion.modelo.dao.impl.EmpleadoDAOImpl;
import com.ipartek.formacion.modelo.pojo.Departamento;
import com.ipartek.formacion.modelo.pojo.Empleado;


/**
 * Servlet implementation class InicioController
 */
@WebServlet("/inicio")
public class InicioController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private final static Logger LOG = Logger.getLogger(InicioController.class);
	private final static EmpleadoDAOImpl dao = EmpleadoDAOImpl.getInstance();
	//private final static DepartamentoDAOImpl daod = DepartamentoDAOImpl.getInstance();

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String nombre = request.getParameter("nombre");
		String apellido1 = request.getParameter("ape1");
		String apellido2 = request.getParameter("ape2");
		String cif = request.getParameter("cif");
		
		ArrayList<Empleado> busquedaEmpl = new ArrayList<Empleado>();
		
		
		try {
			LOG.trace("Entramos al controlador /inicio ");
			
			LOG.debug(String.format("filtro busqueda nombre=%s apellido1=%s apellido2=%s cif=%s", nombre, apellido1, apellido2, cif));
			
			busquedaEmpl = dao.buscar(nombre, apellido1, apellido2, cif);

		} catch (Exception e) {

			LOG.error(e);

		} finally {
			
			if (busquedaEmpl.isEmpty()) {
				
				request.setAttribute("empleados", dao.getAll());
				request.getRequestDispatcher("index.jsp").forward(request, response);
				
			} else {
				
				request.setAttribute("busquedaEmpl", busquedaEmpl);
				response.sendRedirect("index.jsp");
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Empleado empleado = new Empleado();
		
		int id = 0;
		int idDept = 0;
		
		try {
			
			String idParam = request.getParameter("id");
			String nombreParam = request.getParameter("nombre");
			String ape1Param = request.getParameter("ape1");
			String ape2Param = request.getParameter("ape2");
			String cifParam = request.getParameter("cif");
			String idDeptParam = request.getParameter("id_departamento");
								
			id = Integer.parseInt(idParam);
			idDept = Integer.parseInt(idDeptParam);
			
			
			empleado.setId(id);
			empleado.setNombre(nombreParam);
			empleado.setApe1(ape1Param);			
			empleado.setApe2(ape2Param);
			empleado.setCif(cifParam);

			
			Departamento d = new Departamento();
			d.setId(idDept);
			empleado.setDepartamento(d);
			
			//dao.crear(empleado);
		} catch (Exception e) {

			request.getRequestDispatcher("index.jsp").forward(request, response);
			
		} finally {
			
			request.setAttribute("empleados", dao.getAll());
			response.sendRedirect("index.jsp");
		}
	}
}