package pe.com.sedapal.scr.core.beans;

import java.io.Serializable;

public class AnalisisHidroBiologico extends BaseBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer codigo;
	private Integer codsub;
	
	private String fechaAnalisis;
	private Integer tipoOrganismo;
	private Integer codorg;
	private String descripcion;
	
	private Integer cantidad;
	
	/**
	 * @return the tipoOrganismo
	 */
	public Integer getTipoOrganismo() {
		return tipoOrganismo;
	}
	/**
	 * @param tipoOrganismo the tipoOrganismo to set
	 */
	public void setTipoOrganismo(Integer tipoOrganismo) {
		this.tipoOrganismo = tipoOrganismo;
	}
	/**
	 * @return the cantidad
	 */
	public Integer getCantidad() {
		return cantidad;
	}
	/**
	 * @param cantidad the cantidad to set
	 */
	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}
	/**
	 * @return the codigo
	 */
	public Integer getCodigo() {
		return codigo;
	}
	/**
	 * @param codigo the codigo to set
	 */
	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}
	/**
	 * @return the codorg
	 */
	public Integer getCodorg() {
		return codorg;
	}
	/**
	 * @param codorg the codorg to set
	 */
	public void setCodorg(Integer codorg) {
		this.codorg = codorg;
	}
	
	/**
	 * @return the codsub
	 */
	public Integer getCodsub() {
		return codsub;
	}
	/**
	 * @param codsub the codsub to set
	 */
	public void setCodsub(Integer codsub) {
		this.codsub = codsub;
	}
	/**
	 * @return the fechaAnalisis
	 */
	public String getFechaAnalisis() {
		return fechaAnalisis;
	}
	/**
	 * @param fechaAnalisis the fechaAnalisis to set
	 */
	public void setFechaAnalisis(String fechaAnalisis) {
		this.fechaAnalisis = fechaAnalisis;
	}
	
	/**
	 * @return the descripcion
	 */
	public String getDescripcion() {
		return descripcion;
	}
	/**
	 * @param descripcion the descripcion to set
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	@Override
	public String toString() {
		return "AnalisisHidroBiologico [codigo=" + codigo + ", codsub=" + codsub + ", fechaAnalisis=" + fechaAnalisis
				+ ", tipoOrganismo=" + tipoOrganismo + ", codorg=" + codorg + ", descripcion=" + descripcion + "]";
	}
	
}
