package pe.com.sedapal.scr.core.beans;

import java.io.Serializable;

public class TurbidimetroDigitalBean extends BaseBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String strUsuarioCreacion;
	private String strFechaCreacion;
	private String strUsuarioModificacion;
	private String strFechaModificacion;
	private String strNomPrograma;
	
	private int intCodigo;
	private String strUbicacionDesc;
	private String intUbicacion;
	private String strNomEquipo;
	private String strMarca;
	private String strModelo;
	private String strCodEquipo;
	private String strCodEquipoHide;
	private int intProxMesCalibracion;
	private int intMesCalibracion;
	
	private String strRangoNTU1;
	private String strMaxNTU1;
	private String strMinNTU1;
	
	private String strRangoNTU2;
	private String strMaxNTU2;
	private String strMinNTU2;
	
	private String strRangoNTU3;
	private String strMaxNTU3;
	private String strMinNTU3;
	
	private String strRangoNTU4;
	private String strMaxNTU4;
	private String strMinNTU4;
	
	private String strRangoNTU5;
	private String strMaxNTU5;
	private String strMinNTU5;
	private int intEstado;
	
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

	public int getIntCodigo() {
		return intCodigo;
	}
	public void setIntCodigo(int intCodigo) {
		this.intCodigo = intCodigo;
	}

	public String getStrUbicacionDesc() {
		return strUbicacionDesc;
	}
	public void setStrUbicacionDesc(String strUbicacionDesc) {
		this.strUbicacionDesc = strUbicacionDesc;
	}
	public String getIntUbicacion() {
		return intUbicacion;
	}
	public void setIntUbicacion(String intUbicacion) {
		this.intUbicacion = intUbicacion;
	}
	public String getStrNomEquipo() {
		return strNomEquipo;
	}
	public void setStrNomEquipo(String strNomEquipo) {
		this.strNomEquipo = strNomEquipo;
	}
	public String getStrMarca() {
		return strMarca;
	}
	public void setStrMarca(String strMarca) {
		this.strMarca = strMarca;
	}
	public String getStrModelo() {
		return strModelo;
	}
	public void setStrModelo(String strModelo) {
		this.strModelo = strModelo;
	}
	
	public int getIntProxMesCalibracion() {
		return intProxMesCalibracion;
	}
	public void setIntProxMesCalibracion(int intProxMesCalibracion) {
		this.intProxMesCalibracion = intProxMesCalibracion;
	}
	public int getIntMesCalibracion() {
		return intMesCalibracion;
	}
	public void setIntMesCalibracion(int intMesCalibracion) {
		this.intMesCalibracion = intMesCalibracion;
	}
	public String getStrCodEquipo() {
		return strCodEquipo;
	}
	public void setStrCodEquipo(String strCodEquipo) {
		this.strCodEquipo = strCodEquipo;
	}
	public String getStrRangoNTU1() {
		return strRangoNTU1;
	}
	public void setStrRangoNTU1(String strRangoNTU1) {
		this.strRangoNTU1 = strRangoNTU1;
	}
	public String getStrMaxNTU1() {
		return strMaxNTU1;
	}
	public void setStrMaxNTU1(String strMaxNTU1) {
		this.strMaxNTU1 = strMaxNTU1;
	}
	public String getStrMinNTU1() {
		return strMinNTU1;
	}
	public void setStrMinNTU1(String strMinNTU1) {
		this.strMinNTU1 = strMinNTU1;
	}
	public String getStrRangoNTU2() {
		return strRangoNTU2;
	}
	public void setStrRangoNTU2(String strRangoNTU2) {
		this.strRangoNTU2 = strRangoNTU2;
	}
	public String getStrMaxNTU2() {
		return strMaxNTU2;
	}
	public void setStrMaxNTU2(String strMaxNTU2) {
		this.strMaxNTU2 = strMaxNTU2;
	}
	public String getStrMinNTU2() {
		return strMinNTU2;
	}
	public void setStrMinNTU2(String strMinNTU2) {
		this.strMinNTU2 = strMinNTU2;
	}
	public String getStrRangoNTU3() {
		return strRangoNTU3;
	}
	public void setStrRangoNTU3(String strRangoNTU3) {
		this.strRangoNTU3 = strRangoNTU3;
	}
	public String getStrMaxNTU3() {
		return strMaxNTU3;
	}
	public void setStrMaxNTU3(String strMaxNTU3) {
		this.strMaxNTU3 = strMaxNTU3;
	}
	public String getStrMinNTU3() {
		return strMinNTU3;
	}
	public void setStrMinNTU3(String strMinNTU3) {
		this.strMinNTU3 = strMinNTU3;
	}
	public String getStrRangoNTU4() {
		return strRangoNTU4;
	}
	public void setStrRangoNTU4(String strRangoNTU4) {
		this.strRangoNTU4 = strRangoNTU4;
	}
	public String getStrMaxNTU4() {
		return strMaxNTU4;
	}
	public void setStrMaxNTU4(String strMaxNTU4) {
		this.strMaxNTU4 = strMaxNTU4;
	}
	public String getStrMinNTU4() {
		return strMinNTU4;
	}
	public void setStrMinNTU4(String strMinNTU4) {
		this.strMinNTU4 = strMinNTU4;
	}
	public String getStrRangoNTU5() {
		return strRangoNTU5;
	}
	public void setStrRangoNTU5(String strRangoNTU5) {
		this.strRangoNTU5 = strRangoNTU5;
	}
	public String getStrMaxNTU5() {
		return strMaxNTU5;
	}
	public void setStrMaxNTU5(String strMaxNTU5) {
		this.strMaxNTU5 = strMaxNTU5;
	}
	public String getStrMinNTU5() {
		return strMinNTU5;
	}
	public void setStrMinNTU5(String strMinNTU5) {
		this.strMinNTU5 = strMinNTU5;
	}
	public int getIntEstado() {
		return intEstado;
	}
	public void setIntEstado(int intEstado) {
		this.intEstado = intEstado;
	}
	public String getStrCodEquipoHide() {
		return strCodEquipoHide;
	}
	public void setStrCodEquipoHide(String strCodEquipoHide) {
		this.strCodEquipoHide = strCodEquipoHide;
	}
	
	
}
