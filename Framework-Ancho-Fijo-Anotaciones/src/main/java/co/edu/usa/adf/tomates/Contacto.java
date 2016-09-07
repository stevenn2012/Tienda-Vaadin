package co.edu.usa.adf.tomates;
import co.edu.usa.adf.Framework_Ancho_Fijo_Anotaciones.FixedWidthField;

public class Contacto{

	@FixedWidthField(posicion=0, width=30) String nombre;
	@FixedWidthField(posicion=1, width=20) String celular;
	@FixedWidthField(posicion=2, width=30) String email;
	@FixedWidthField(posicion=3, width=50) String direccion;
	@FixedWidthField(posicion=4, width= 3) Integer edad;
	@FixedWidthField(posicion=5, width=15) long cedula;
	
	public Contacto() {
		
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public Integer getEdad() {
		return edad;
	}

	public void setEdad(Integer edad) {
		this.edad = edad;
	}

	public long getCedula() {
		return cedula;
	}

	public void setCedula(long cedula) {
		this.cedula = cedula;
	}

	@Override
	public String toString() {
		return "Contacto [nombre=" + nombre + ", celular=" + celular
				+ ", email=" + email + ", direccion=" + direccion + ", edad="
				+ edad + ", cedula=" + cedula + "]";
	}
}
