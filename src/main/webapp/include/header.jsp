<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   


<!doctype html>
<html lang="es">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">

	<!-- Datatables -->
    <link rel="stylesheet" href="https://cdn.datatables.net/1.10.21/css/jquery.dataTables.min.css">


    <title>Gestor de empleados</title>
  </head>
  <body>
   
   <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
	  <a class="navbar-brand" href="#">Gestor Empleados</a>
	  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
	    <span class="navbar-toggler-icon"></span>
	  </button>
	
	  <div class="collapse navbar-collapse" id="navbarSupportedContent">
	    <form class="form-inline my-2 my-lg-0">
	      <input class="form-control mr-sm-2" type="search" value="${busquedaEmpl.nombre} ${busquedaEmpl.nombre} ${busquedaEmpl.apellido1} ${busquedaEmpl.apellido2} ${busquedaEmpl.cif}" placeholder="nombre, apellido o NIF" aria-label="Search">
	      <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Buscar</button>
	    </form>
	  </div>
	</nav>
   
   
  <main class="container"> 