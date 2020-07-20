<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!--
No es necesario porque ya dice a donde ir en la web.xml en la web.xml
<%@ page errorPage="error.jsp" isErrorPage="false"%>
-->
<jsp:include page ="include/header.jsp">
	<jsp:param name="page" value="index" />
	<jsp:param name="title" value="Index" />
</jsp:include>	
	<a href="">TODO Formulario para crear Empleado</a>  	
 
	<table class="table" id="example">
	  <thead class="thead-dark">
	    <tr>
	      <th scope="col">ID</th>
	      <th scope="col">Empleado</th>
	      <th scope="col">NIF</th>
	      <th scope="col">Departamento</th>
	    </tr>
	  </thead>
	  <tbody>
	 <c:forEach items="${empleados}" var="empleado">
		    <tr>
		      <th scope="row">1</th>
		      <td>${empleado.nombre}, ${empleado.ape1} ${empleado.ape2}</td>
		      <td>${empleado.cif}</td>
		      <td>
		      	<button type="button" 
				           class="btn btn-link" 
				           data-toggle="popover" 
				           title="${empleado.departamento.nombre}" 
				           data-html="true"
				           data-placement="left"
				           data-content="Gastos: <b>${empleado.departamento.gastos} €</b> <br> Presupuesto: <b>${empleado.departamento.presupuesto}  € </b>">${empleado.departamento.nombre}</button>
		      </td>
		    </tr>
	    </c:forEach>
	    
	    <c:forEach items="${busquedaEmpl}" var="empleado">
		    <tr>
		      <th scope="row">1</th>
		      <td>${empleado.nombre}, ${empleado.ape1} ${empleado.ape2}</td>
		      <td>${empleado.cif}</td>
		      <td>
		      	<button type="button" 
				           class="btn btn-link" 
				           data-toggle="popover" 
				           title="${empleado.departamento.nombre}" 
				           data-html="true"
				           data-placement="left"
				           data-content="Gastos: <b>${empleado.departamento.gastos} €</b> <br> Presupuesto: <b>${empleado.departamento.presupuesto}  € </b>">${empleado.departamento.nombre}</button>
		      </td>
		    </tr>
	    </c:forEach>
	  </tbody>
	</table>
	
	<div class="row">
		<div class="col">
			<form action="game-form-control" method="post">
				<div class="form-group">
					<label for="id">ID:</label>
					<input type="text" name="id" id="id" value="${empleado.id}" readonly class="inicio">
				</div>
				
				<div class="form-group">
					<label for="name">Nombre:</label>
					<input type="text" name="nombre" value="${empleado.nombre}" class="inicio" placeholder="Nombre del empleado">
				</div>
				
				<div class="form-group">
					<label for="ape1">Primer apellido:</label>
					<input type="text" name="ape1" value="${empleado.ape1}" class="inicio" placeholder="Primer apellido">
				</div>
				
				<div class="form-group">
					<label for="ape1">Segundo apellido:</label>
					<input type="text" name="ape2" value="${empleado.ape2}" class="inicio" placeholder="Segundo apellido">
				</div>
				
				<div class="form-group">
					<label for="cif">DNI:</label>
					<input type="text" name="cif" value="${empleado.cif}" class="inicio" placeholder="DNI">
				</div>
				
				<div class="form-group">
					<label for="id_departamento">ID del departamento:</label>
					<input type="text" name="id_departamento" value="${empleado.id_departamento}" class="inicio" placeholder="ID del departamento">
				</div>
				<input type="submit" value="Save" class="btn btn-primary">
			</form>
		</div>
	</div>
<%@include file="include/footer.jsp" %>
	