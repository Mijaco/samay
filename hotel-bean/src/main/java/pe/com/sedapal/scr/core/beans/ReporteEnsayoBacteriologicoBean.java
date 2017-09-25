package pe.com.sedapal.scr.core.beans;

import java.io.Serializable;

public class ReporteEnsayoBacteriologicoBean extends BaseBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private String strUsuarioCreacion;
	private String strFechaCreacion;
	private String strUsuarioModificacion;
	private String strFechaModificacion;
	private String strNomPrograma;
	
	private int intIdCabecera;
	private int intIdDetalle;
	private String strDescripcion;
	private String strBocatoma;
	private String strEntrada;
	private String strDecantada;
	private String strPlantaConvencional;
	private String strFiltrada;
	private String strColiforTotal;
	private String strColiforTermo;
	private String strBacterioHerterotro;
	private int intTipo;
	
	public String getStrUsuarioCreacion() {
		return strUsuarioCreacion;
	}
	public void setStrUsuarioCreacion(String strUsuarioCreacion) {
		this.strUsuarioCreacion = strUsuarioCreacion;
	}
	public String getStrFechaCreacion() {
		return strFechaCreacion;
	}
	public void setStrFechaCreacion(String strFechaCreacion) {
		this.strFechaCreacion = strFechaCreacion;
	}
	public String getStrUsuarioModificacion() {
		return strUsuarioModificacion;
	}
	public void setStrUsuarioModificacion(String strUsuarioModificacion) {
		this.strUsuarioModificacion = strUsuarioModificacion;
	}
	public String getStrFechaModificacion() {
		return strFechaModificacion;
	}
	public void setStrFechaModificacion(String strFechaModificacion) {
		this.strFechaModificacion = strFechaModificacion;
	}
	public String getStrNomPrograma() {
		return strNomPrograma;
	}
	public void setStrNomPrograma(String strNomPrograma) {
		this.strNomPrograma = strNomPrograma;
	}
	public int getIntIdCabecera() {
		return intIdCabecera;
	}
	public void setIntIdCabecera(int intIdCabecera) {
		this.intIdCabecera = intIdCabecera;
	}
	public String getStrDescripcion() {
		return strDescripcion;
	}
	public void setStrDescripcion(String strDescripcion) {
		this.strDescripcion = strDescripcion;
	}
	public String getStrBocatoma() {
		return strBocatoma;
	}
	public void setStrBocatoma(String strBocatoma) {
		this.strBocatoma = strBocatoma;
	}
	public String getStrEntrada() {
		return strEntrada;
	}
	public void setStrEntrada(String strEntrada) {
		this.strEntrada = strEntrada;
	}
	public String getStrDecantada() {
		return strDecantada;
	}
	public void setStrDecantada(String strDecantada) {
		this.strDecantada = strDecantada;
	}
	public String getStrPlantaConvencional() {
		return strPlantaConvencional;
	}
	public void setStrPlantaConvencional(String strPlantaConvencional) {
		this.strPlantaConvencional = strPlantaConvencional;
	}
	public String getStrFiltrada() {
		return strFiltrada;
	}
	public void setStrFiltrada(String strFiltrada) {
		this.strFiltrada = strFiltrada;
	}
	public String getStrColiforTotal() {
		return strColiforTotal;
	}
	public void setStrColiforTotal(String strColiforTotal) {
		this.strColiforTotal = strColiforTotal;
	}
	public String getStrColiforTermo() {
		return strColiforTermo;
	}
	public void setStrColiforTermo(String strColiforTermo) {
		this.strColiforTermo = strColiforTermo;
	}
	public String getStrBacterioHerterotro() {
		return strBacterioHerterotro;
	}
	public void setStrBacterioHerterotro(String strBacterioHerterotro) {
		this.strBacterioHerterotro = strBacterioHerterotro;
	}
	public int getIntIdDetalle() {
		return intIdDetalle;
	}
	public void setIntIdDetalle(int intIdDetalle) {
		this.intIdDetalle = intIdDetalle;
	}
	public int getIntTipo() {
		return intTipo;
	}
	public void setIntTipo(int intTipo) {
		this.intTipo = intTipo;
	}
	

}
