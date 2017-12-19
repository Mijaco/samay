package pe.com.sedapal.scr.core.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class SubactividadReporte extends BaseBean implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private Integer codigo;
	private String descripcion;
	private Integer estado;
	private ArrayList<ParametroReporte> parametros;
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
	public ArrayList<ParametroReporte> getParametros() {
		return parametros;
	}
	public void setParametros(ArrayList<ParametroReporte> parametros) {
		this.parametros = parametros;
	}
	@Override
	public String toString() {
		return "SubactividadReporte [codigo=" + codigo + ", descripcion=" + descripcion + ", estado=" + estado
				+ ", parametros=" + parametros + "]";
	}
		
}
