package pe.com.sedapal.scr.core.beans;

import java.io.Serializable;
import java.math.BigDecimal;

public class TablaPoissonBean extends BaseBean implements Serializable {
	
	private String strUsuarioCreacion;
	private String strFechaCreacion;
	private String strUsuarioModificacion;
	private String strFechaModificacion;
	private String strNomPrograma;
	private int intCodPoisson;

	private String intCodLambda;
	private String intCodLambdaHide;
	private String strCodIgx;
	private String strCodIgxHide;
	private String strValorPoisson;
	
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
	public int getIntCodPoisson() {
		return intCodPoisson;
	}
	public void setIntCodPoisson(int intCodPoisson) {
		this.intCodPoisson = intCodPoisson;
	}
	
	
	public String getIntCodLambda() {
		return intCodLambda;
	}
	public void setIntCodLambda(String intCodLambda) {
		this.intCodLambda = intCodLambda;
	}
	public String getIntCodLambdaHide() {
		return intCodLambdaHide;
	}
	public void setIntCodLambdaHide(String intCodLambdaHide) {
		this.intCodLambdaHide = intCodLambdaHide;
	}
	
	public String getStrCodIgx() {
		return strCodIgx;
	}
	public void setStrCodIgx(String strCodIgx) {
		this.strCodIgx = strCodIgx;
	}
	public String getStrCodIgxHide() {
		return strCodIgxHide;
	}
	public void setStrCodIgxHide(String strCodIgxHide) {
		this.strCodIgxHide = strCodIgxHide;
	}
	public String getStrValorPoisson() {
		return strValorPoisson;
	}
	public void setStrValorPoisson(String strValorPoisson) {
		this.strValorPoisson = strValorPoisson;
	}

	

	
}
