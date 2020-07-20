package com.ipartek.formacion.modelo.pojo;

public class FormularioBusqueda {
	private String nombre;
	private String ape1;
	private String ape2;
	private String cif;
	
	
	public FormularioBusqueda() {
		super();
		this.nombre = "";
		this.ape1 = "";
		this.ape2 = "";
		this.cif = "";
	}

	public FormularioBusqueda(String nombre, String ape1, String ape2, String cif) {
		super();
		this.setNombre(nombre);
		this.setApe1(ape1);
		this.setApe2(ape2);
		this.setCif(cif);
	}


	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		if(nombre == null) {
			this.nombre = "";
		} else {
			this.nombre = nombre.trim();
		}
	}

	public String getApe1() {
		return ape1;
	}

	public void setApe1(String ape1) {
		if(ape1 == null) {
			this.ape1 = "";
		} else {
			this.ape1 = ape1.trim();
		}
	}
	
	
	public String getApe2() {
		return ape2;
	}

	public void setApe2(String ape2) {
		if(ape2 == null) {
			this.ape2 = "";
		} else {
			this.ape2 = ape2.trim();
		}
	}
	
	
	public String getCif() {
		return cif;
	}

	public void setCif(String cif) {
		if(ape1 == null) {
			this.cif = "";
		} else {
			this.cif = cif.trim();
		}
	}
	
	
	@Override
	public String toString() {
		return "FormularioBusqueda [nombre=" + nombre + ", ape1=" + ape1 + ", ape2=" + ape2 + ", cif=" + cif + "]";
	}
}
