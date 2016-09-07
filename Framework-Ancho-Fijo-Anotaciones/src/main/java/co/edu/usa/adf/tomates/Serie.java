package co.edu.usa.adf.tomates;

import co.edu.usa.adf.Framework_Ancho_Fijo_Anotaciones.FixedWidthField;

public class Serie {
	
	@FixedWidthField(posicion=0, width=31) private String nombre;
	@FixedWidthField(posicion=1, width=20) private String nombreAutor;
	@FixedWidthField(posicion=2, width=20) private String apellidoAutor;
	@FixedWidthField(posicion=3, width=10) private int year;
	@FixedWidthField(posicion=4, width=3) private double puntaje;
	
	public Serie(){
		
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getNombreAutor() {
		return nombreAutor;
	}

	public void setNombreAutor(String nombreAutor) {
		this.nombreAutor = nombreAutor;
	}

	public String getApellidoAutor() {
		return apellidoAutor;
	}

	public void setApellidoAutor(String apellidoAutor) {
		this.apellidoAutor = apellidoAutor;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public double getPuntaje() {
		return puntaje;
	}

	public void setPuntaje(double puntaje) {
		this.puntaje = puntaje;
	}

	@Override
	public String toString() {
		return "Serie [nombre=" + nombre + ", nombreAutor=" + nombreAutor + ", apellidoAutor=" + apellidoAutor
				+ ", year=" + year + ", puntaje=" + puntaje + "]";
	}

}
