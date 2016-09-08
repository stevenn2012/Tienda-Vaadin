package co.edu.usa.adf.tomates;

import java.util.Date;

import co.edu.usa.adf.Framework_Ancho_Fijo_Anotaciones.FixedWidthField;

public class Venta {

	private @FixedWidthField(posicion=0, width=10) String facturaId;
	private @FixedWidthField(posicion=1, width=23) Date fecha;
	private @FixedWidthField(posicion=2, width=10) String productoId;
	private @FixedWidthField(posicion=3, width=4) int cantidadVendida;
	private @FixedWidthField(posicion=4, width=20) double precioUnitario;
	
	public Venta() {
		
	}

	public Venta(String facturaId, Date fecha, String productoId, int cantidadVendida, double precioUnitario) {
		super();
		this.facturaId = facturaId;
		this.fecha = fecha;
		this.productoId = productoId;
		this.cantidadVendida = cantidadVendida;
		this.precioUnitario = precioUnitario;
	}

	public String getFacturaId() {
		return facturaId;
	}

	public void setFacturaId(String facturaId) {
		this.facturaId = facturaId;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getProductoId() {
		return productoId;
	}

	public void setProductoId(String productoId) {
		this.productoId = productoId;
	}

	public int getCantidadVendida() {
		return cantidadVendida;
	}

	public void setCantidadVendida(int cantidadVendida) {
		this.cantidadVendida = cantidadVendida;
	}

	public double getPrecioUnitario() {
		return precioUnitario;
	}

	public void setPrecioUnitario(double precioUnitario) {
		this.precioUnitario = precioUnitario;
	}

	@Override
	public String toString() {
		return "Venta [facturaId=" + facturaId + ", fecha=" + fecha + ", productoId=" + productoId
				+ ", cantidadVendida=" + cantidadVendida + ", precioUnitario=" + precioUnitario + "]";
	}
}
