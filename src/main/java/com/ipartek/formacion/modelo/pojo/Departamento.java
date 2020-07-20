package com.ipartek.formacion.modelo.pojo;

public class Departamento {
	
	private int id;
	private String nombre;
	private float presupuesto;
	private float gastos;
	
	
	public Departamento() {
		super();
		this.id = 0;
		this.nombre = "";
		this.presupuesto = 0;
		this.gastos = 0;
	}


	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public float getPresupuesto() {
		return presupuesto;
	}

	public void setPresupuesto(float presupuesto) {
		this.presupuesto = presupuesto;
	}


	public float getGastos() {
		return gastos;
	}

	public void setGastos(float gastos) {
		this.gastos = gastos;
	}


	@Override
	public String toString() {
		return "Departamento [id=" + id + ", nombre=" + nombre + ", presupuesto=" + presupuesto + ", gastos=" + gastos
				+ "]";
	}
}
