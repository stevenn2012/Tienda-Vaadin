package co.edu.usa.adf.tomates;

import co.edu.usa.adf.Framework_Ancho_Fijo_Anotaciones.FixedWidthField;

public class Contacto2 {
	
	@FixedWidthField(posicion=0, width=21) private String nombre;
	@FixedWidthField(posicion=1, width=20) private String apellido;
	@FixedWidthField(posicion=2, width=10) private String celular;
	
	public Contacto2(){
		
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getCelular() {
		return celular;
	}
	public void setCelular(String celular) {
		this.celular = celular;
	}

	@Override
	public String toString() {
		return "Contacto [nombre=" + nombre + ", apellido=" + apellido + ", celular=" + celular + "]";
	}

}
