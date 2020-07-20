package com.ipartek.formacion.modelo.pojo;

public class Empleado {
	

	private int id;
	private String cif;
	private String nombre;
	private String ape1;
	private String ape2;
	private Departamento departamento;
	
	
	public Empleado() {
		super();
		this.id = 0;
		this.cif = "";
		this.nombre = "";
		this.ape1 = "";
		this.ape2 = "";
		this.departamento = new Departamento();
	}
	
	public Empleado(int id, String cif, String nombre, String ape1, String ape2) {
		this();
		this.id = id;
		this.cif = cif;
		this.nombre = nombre;
		this.ape1 = ape1;
		this.ape2 = ape2;

	}

	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	
	public String getCif() {
		return cif;
	}

	public void setCif(String cif) {
		this.cif = cif;
	}

	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	
	public String getApe1() {
		return ape1;
	}

	public void setApe1(String ape1) {
		this.ape1 = ape1;
	}

	
	public String getApe2() {
		return ape2;
	}

	public void setApe2(String ape2) {
		this.ape2 = ape2;
	}

	
	public Departamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}

	
	@Override
	public String toString() {
		return "Empleado [id=" + id + ", cif=" + cif + ", nombre=" + nombre + ", ape1=" + ape1 + ", ape2=" + ape2
				+ ", departamento=" + departamento + "]";
	}
}
