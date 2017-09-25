package pe.com.sedapal.scr.core.beans;

import java.io.Serializable;

public class ParametroPlan extends BaseBean implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Integer codvxp;
	private Integer codsxp;
	private Integer codplan;
	
	private Integer codarea;
	private Integer codact;
	private Integer codsubact;
	
	private String codDesc;
	private String tipo;
	private String parametro;
	private String medida;
	private String propuesta;
	private Integer mes1;
	private Integer mes2;
	private Integer mes3;
	private Integer mes4;
	private Integer mes5;
	private Integer mes6;
	private Integer mes7;
	private Integer mes8;
	private Integer mes9;
	private Integer mes10;
	private Integer mes11;
	private Integer mes12;
	
	private Integer estado;
	
	public Integer getEstado() {
		return estado;
	}
	public void setEstado(Integer estado) {
		this.estado = estado;
	}
	public Integer getCodvxp() {
		return codvxp;
	}
	public void setCodvxp(Integer codvxp) {
		this.codvxp = codvxp;
	}
	public Integer getCodsxp() {
		return codsxp;
	}
	public void setCodsxp(Integer codsxp) {
		this.codsxp = codsxp;
	}
	public Integer getCodplan() {
		return codplan;
	}
	public void setCodplan(Integer codplan) {
		this.codplan = codplan;
	}
	
	public String getCodDesc() {
		return codDesc;
	}
	public void setCodDesc(String codDesc) {
		this.codDesc = codDesc;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getParametro() {
		return parametro;
	}
	public void setParametro(String parametro) {
		this.parametro = parametro;
	}
	public String getMedida() {
		return medida;
	}
	public void setMedida(String medida) {
		this.medida = medida;
	}
	public String getPropuesta() {
		return propuesta;
	}
	public void setPropuesta(String propuesta) {
		this.propuesta = propuesta;
	}
	public Integer getMes1() {
		return mes1;
	}
	public void setMes1(Integer mes1) {
		this.mes1 = mes1;
	}
	public Integer getMes2() {
		return mes2;
	}
	public void setMes2(Integer mes2) {
		this.mes2 = mes2;
	}
	public Integer getMes3() {
		return mes3;
	}
	public void setMes3(Integer mes3) {
		this.mes3 = mes3;
	}
	public Integer getMes4() {
		return mes4;
	}
	public void setMes4(Integer mes4) {
		this.mes4 = mes4;
	}
	public Integer getMes5() {
		return mes5;
	}
	public void setMes5(Integer mes5) {
		this.mes5 = mes5;
	}
	public Integer getMes6() {
		return mes6;
	}
	public void setMes6(Integer mes6) {
		this.mes6 = mes6;
	}
	public Integer getMes7() {
		return mes7;
	}
	public void setMes7(Integer mes7) {
		this.mes7 = mes7;
	}
	public Integer getMes8() {
		return mes8;
	}
	public void setMes8(Integer mes8) {
		this.mes8 = mes8;
	}
	public Integer getMes9() {
		return mes9;
	}
	public void setMes9(Integer mes9) {
		this.mes9 = mes9;
	}
	public Integer getMes10() {
		return mes10;
	}
	public void setMes10(Integer mes10) {
		this.mes10 = mes10;
	}
	public Integer getMes11() {
		return mes11;
	}
	public void setMes11(Integer mes11) {
		this.mes11 = mes11;
	}
	public Integer getMes12() {
		return mes12;
	}
	public void setMes12(Integer mes12) {
		this.mes12 = mes12;
	}
	
	public Integer getCodarea() {
		return codarea;
	}
	public void setCodarea(Integer codarea) {
		this.codarea = codarea;
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
	@Override
	public String toString() {
		return "ParametroPlan [codvxp=" + codvxp + ", codsxp=" + codsxp + ", codplan=" + codplan + ", codDesc="
				+ codDesc + ", tipo=" + tipo + ", parametro=" + parametro + ", medida=" + medida + ", propuesta="
				+ propuesta + ", mes1=" + mes1 + ", mes2=" + mes2 + ", mes3=" + mes3 + ", mes4=" + mes4 + ", mes5="
				+ mes5 + ", mes6=" + mes6 + ", mes7=" + mes7 + ", mes8=" + mes8 + ", mes9=" + mes9 + ", mes10=" + mes10
				+ ", mes11=" + mes11 + ", mes12=" + mes12 + "]";
	}
}
