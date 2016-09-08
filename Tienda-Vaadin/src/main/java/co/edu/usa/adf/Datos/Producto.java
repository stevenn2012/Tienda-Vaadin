package co.edu.usa.adf.Datos;

public class Producto {

	private String productoId;
	private String nombre;
	private String descripcion;
	private double precioUnitario;
	private String rutaImagen;
	private int cantidadStock;
	
	public Producto() {
	
	}

	public Producto(String productoId, String nombre, String descripcion, double precioUnitario, String rutaImagen,
			int cantidadStock) {
		super();
		this.productoId = productoId;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.precioUnitario = precioUnitario;
		this.rutaImagen = rutaImagen;
		this.cantidadStock = cantidadStock;
	}

	public String getProductoId() {
		return productoId;
	}

	public void setProductoId(String productoId) {
		this.productoId = productoId;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public double getPrecioUnitario() {
		return precioUnitario;
	}

	public void setPrecioUnitario(double precioUnitario) {
		this.precioUnitario = precioUnitario;
	}

	public String getRutaImagen() {
		return rutaImagen;
	}

	public void setRutaImagen(String rutaImagen) {
		this.rutaImagen = rutaImagen;
	}

	public int getCantidadStock() {
		return cantidadStock;
	}

	public void setCantidadStock(int cantidadStock) {
		this.cantidadStock = cantidadStock;
	}

	@Override
	public String toString() {
		return "Producto [productoId=" + productoId + ", nombre=" + nombre + ", descripcion=" + descripcion
				+ ", precioUnitario=" + precioUnitario + ", rutaImagen=" + rutaImagen + ", cantidadStock="
				+ cantidadStock + "]";
	}
}
