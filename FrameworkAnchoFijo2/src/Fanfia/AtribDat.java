package Fanfia;

public class AtribDat {


	private String nombre;
	private String tipo;
	private int ancho;
	
	public AtribDat(String nombre, String tipo, int ancho) {
		this.nombre = nombre;
		this.tipo = tipo;
		this.ancho = ancho;
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTipo() {
		return tipo;
	}
	
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	public int getAncho() {
		return ancho;
	}
	
	public void setAncho(int ancho) {
		this.ancho = ancho;
	}

	@Override
	public String toString() {
		return "AtribDat [nombre=" + nombre + ", tipo=" + tipo + ", ancho=" + ancho + "]";
	}
}
