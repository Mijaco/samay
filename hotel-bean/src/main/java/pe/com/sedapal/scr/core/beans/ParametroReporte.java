package pe.com.sedapal.scr.core.beans;

import java.io.Serializable;

public class ParametroReporte extends BaseBean implements Serializable{

	/**
	 * MIJAIL AYMARA
	 */
	private Integer codact;
	private Integer codsubact;
	private Integer codpar;
	private Integer codparam;//codigo codsxp
	
	private String actividad;
	private String subactividad;
	private String parametro;
	
	
	private static final long serialVersionUID = 1L;
	private Integer codigo;
	private String descripcion;
	private Integer programado;
	private Integer ejecutado;
	
	private Integer porcentaje;
	public ParametroReporte() {
	}
	
	/**
	 * @return the codpar
	 */
	public Integer getCodpar() {
		return codpar;
	}



	/**
	 * @param codpar the codpar to set
	 */
	public void setCodpar(Integer codpar) {
		this.codpar = codpar;
	}



	public ParametroReporte(String descripcion,String parametro, Integer programado) {
	
		this.descripcion = descripcion;
		this.programado = programado;
		this.parametro = parametro;
	}
	
	public Integer getCodigo() {
		return codigo;
	}
	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}
	public Integer getCodact() {
		return codact;
	}
	public void setCodact(Integer codact) {
		this.codact = codact;
	}
	public Integer getCodsubact() {
		return codsubact;
	}
	public void setCodsubact(Integer codsubact) {
		this.codsubact = codsubact;
	}
	public Integer getCodparam() {
		return codparam;
	}
	public void setCodparam(Integer codparam) {
		this.codparam = codparam;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public Integer getProgramado() {
		return programado;
	}
	public void setProgramado(Integer programado) {
		this.programado = programado;
	}
	public Integer getEjecutado() {
		return ejecutado;
	}
	public void setEjecutado(Integer ejecutado) {
		this.ejecutado = ejecutado;
	}
	public Integer getPorcentaje() {
		return porcentaje;
	}
	public void setPorcentaje(Integer porcentaje) {
		this.porcentaje = porcentaje;
	}
	
	
	public String getActividad() {
		return actividad;
	}
	public void setActividad(String actividad) {
		this.actividad = actividad;
	}
	public String getSubactividad() {
		return subactividad;
	}
	public void setSubactividad(String subactividad) {
		this.subactividad = subactividad;
	}
	public String getParametro() {
		return parametro;
	}
	public void setParametro(String parametro) {
		this.parametro = parametro;
	}
	@Override
	public String toString() {
		return "ParametroReporte [codact=" + codact + ", codsubact=" + codsubact + ", codparam=" + codparam
				+ ", actividad=" + actividad + ", subactividad=" + subactividad + ", parametro=" + parametro
				+ ", codigo=" + codigo + ", descripcion=" + descripcion + ", programado=" + programado + ", ejecutado="
				+ ejecutado + ", porcentaje=" + porcentaje + "]";
	}
	
}
