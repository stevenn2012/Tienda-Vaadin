package co.edu.usa.adf.Datos;

import java.util.Date;

public class Venta {

	private String facturaId;
	private Date fecha;
	private String productoId;
	private int cantidadVendida;
	private double precioUnitario;
	
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
