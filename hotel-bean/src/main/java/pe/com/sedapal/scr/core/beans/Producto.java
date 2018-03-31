package pe.com.sedapal.scr.core.beans;

public class Producto {

	private String codigo;
	private String nombre;
	private double precio;
	private String descripcion;
	private double volumen;
	private String medida;//kg, L, Onzas, etc
	
	public Producto(){}
	
	public Producto(String codigo, String nombre, double precio, String descripcion, double volumen, String medida) {
		this.codigo = codigo;
		this.nombre = nombre;
		this.precio = precio;
		this.descripcion = descripcion;
		this.volumen = volumen;
		this.medida = medida;
	}

	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public double getVolumen() {
		return volumen;
	}
	public void setVolumen(double volumen) {
		this.volumen = volumen;
	}

	public String getMedida() {
		return medida;
	}

	public void setMedida(String medida) {
		this.medida = medida;
	}

	@Override
	public String toString() {
		return "Producto [codigo=" + codigo + ", nombre=" + nombre + ", precio=" + precio + ", descripcion="
				+ descripcion + ", volumen=" + volumen + ", medida=" + medida + "]";
	}
	
	
	
	
	
}
