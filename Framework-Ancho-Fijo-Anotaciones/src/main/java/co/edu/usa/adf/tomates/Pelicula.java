package co.edu.usa.adf.tomates;

import java.util.Date;
import co.edu.usa.adf.Framework_Ancho_Fijo_Anotaciones.FixedWidthField;

public class Pelicula {
	
	@FixedWidthField(posicion=0, width=30)String nombre;
	@FixedWidthField(posicion=1, width=10)Date fechaEstreno;
	@FixedWidthField(posicion=2, width=4)double puntaje;
	@FixedWidthField(posicion=3, width=6)boolean ganoOscar;
	
	public Pelicula(){
		
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Date getFechaEstreno() {
		return fechaEstreno;
	}

	public void setFechaEstreno(Date fechaEstreno) {
		this.fechaEstreno = fechaEstreno;
	}

	public double getPuntaje() {
		return puntaje;
	}

	public void setPuntaje(double puntaje) {
		this.puntaje = puntaje;
	}

	public boolean getGanoOscar() {
		return ganoOscar;
	}

	public void setGanoOscar(boolean ganoOscar) {
		this.ganoOscar = ganoOscar;
	}

	@Override
	public String toString() {
		return "Pelicula [nombre=" + nombre + ", fechaEstreno=" + fechaEstreno
				+ ", puntaje=" + puntaje + ", ganoOscar=" + ganoOscar + "]";
	}
	
	
	

}
