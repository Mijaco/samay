package pe.com.sedapal.scr.core.beans;

import java.io.Serializable;
import java.util.ArrayList;

public class ActividadReporte extends BaseBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer codigo;
	private String descripcion = "unknown";
	private Integer estado;
	
	private ArrayList<SubactividadReporte> subactividades;
	
	public Integer getCodigo() {
		return codigo;
	}
	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public Integer getEstado() {
		return estado;
	}
	public void setEstado(Integer estado) {
		this.estado = estado;
	}
	public ArrayList<SubactividadReporte> getSubactividades() {
		return subactividades;
	}
	public void setSubactividades(ArrayList<SubactividadReporte> subactividades) {
		this.subactividades = subactividades;
	}
	public ActividadReporte(){
		
	}
	public ActividadReporte(Integer codigo, String descripcion, Integer estado,
			ArrayList<SubactividadReporte> subactividades) {
		this.codigo = codigo;
		this.descripcion = descripcion;
		this.estado = estado;
		this.subactividades = subactividades;
	}
	public ActividadReporte(Integer codigo, String descripcion) {
		this.codigo = codigo;
		this.descripcion = descripcion;
	}
	@Override
	public String toString() {
		return "ActividadReporte [codigo=" + codigo + ", descripcion=" + descripcion + ", estado=" + estado
				+ ", subactividades=" + subactividades + "]";
	}

}
