package pe.com.sedapal.scr.core.beans;

import java.io.Serializable;

public class FormulaMuestraBean extends BaseBean implements Serializable {

	private String strUsuarioCreacion;
	private String strFechaCreacion;
	private String strUsuarioModificacion;
	private String strFechaModificacion;
	private String strNomPrograma;
	
	private int intCodFormula;
	private String strNomFormula;
	private String strNomFuncion;
	private int intCodGrupo;
	private int intCodGrupoHide;
	private String strCodFormulario;
	private String strCodFormularioHide;
	
	
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
	public int getIntCodFormula() {
		return intCodFormula;
	}
	public void setIntCodFormula(int intCodFormula) {
		this.intCodFormula = intCodFormula;
	}
	public String getStrNomFormula() {
		return strNomFormula;
	}
	public void setStrNomFormula(String strNomFormula) {
		this.strNomFormula = strNomFormula;
	}
	public String getStrNomFuncion() {
		return strNomFuncion;
	}
	public void setStrNomFuncion(String strNomFuncion) {
		this.strNomFuncion = strNomFuncion;
	}
	public String getStrCodFormulario() {
		return strCodFormulario;
	}
	public void setStrCodFormulario(String strCodFormulario) {
		this.strCodFormulario = strCodFormulario;
	}
	public int getIntCodGrupo() {
		return intCodGrupo;
	}
	public void setIntCodGrupo(int intCodGrupo) {
		this.intCodGrupo = intCodGrupo;
	}
	public int getIntCodGrupoHide() {
		return intCodGrupoHide;
	}
	public void setIntCodGrupoHide(int intCodGrupoHide) {
		this.intCodGrupoHide = intCodGrupoHide;
	}
	public String getStrCodFormularioHide() {
		return strCodFormularioHide;
	}
	public void setStrCodFormularioHide(String strCodFormularioHide) {
		this.strCodFormularioHide = strCodFormularioHide;
	}
	
	
}
