package co.edu.usa.adf.tomates;

import java.util.Date;
import co.edu.usa.adf.Framework_Ancho_Fijo_Anotaciones.FixedWidthField;

public class Evento {
	
	private @FixedWidthField(posicion=0, width=30) String nombre;
	private @FixedWidthField(posicion=1, width=10) Date fecha;
	private @FixedWidthField(posicion=2, width=30) String descripcion;
	
	public Evento() {
	
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Override
	public String toString() {
		return "Eventos [nombre=" + nombre + ", fecha=" + fecha + ", descripcion=" + descripcion + "]";
	}
}
