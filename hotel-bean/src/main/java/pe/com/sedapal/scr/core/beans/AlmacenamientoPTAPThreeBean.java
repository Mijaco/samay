package pe.com.sedapal.scr.core.beans;

import java.io.Serializable;

public class AlmacenamientoPTAPThreeBean extends BaseBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private String strUsuarioCreacion;
	private String strFechaCreacion;
	private String strUsuarioModificacion;
	private String strFechaModificacion;
	private String strNomPrograma;
	
	private int intIdCabecera;
	private int intIdDetalle;
	private String strDescMuest;
	private String strColoni;
	private String strAglech;
	private String strPseae;

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

	public int getIntIdCabecera() {
		return intIdCabecera;
	}

	public void setIntIdCabecera(int intIdCabecera) {
		this.intIdCabecera = intIdCabecera;
	}

	public int getIntIdDetalle() {
		return intIdDetalle;
	}

	public void setIntIdDetalle(int intIdDetalle) {
		this.intIdDetalle = intIdDetalle;
	}

	

	public String getStrDescMuest() {
		return strDescMuest;
	}

	public void setStrDescMuest(String strDescMuest) {
		this.strDescMuest = strDescMuest;
	}

	public String getStrColoni() {
		return strColoni;
	}

	public void setStrColoni(String strColoni) {
		this.strColoni = strColoni;
	}

	public String getStrAglech() {
		return strAglech;
	}

	public void setStrAglech(String strAglech) {
		this.strAglech = strAglech;
	}

	public String getStrPseae() {
		return strPseae;
	}

	public void setStrPseae(String strPseae) {
		this.strPseae = strPseae;
	}

	public int getIntEstado() {
		return intEstado;
	}

	public void setIntEstado(int intEstado) {
		this.intEstado = intEstado;
	}
	
	
	
}
