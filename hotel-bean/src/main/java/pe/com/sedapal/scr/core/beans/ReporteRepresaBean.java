package pe.com.sedapal.scr.core.beans;

import java.io.Serializable;
import java.math.BigDecimal;

public class ReporteRepresaBean implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Long codMantRepresa;
	private String nombreRepresa;
	private String strAbreviatura;
	private String dia;
	private BigDecimal promVolumen;
	private BigDecimal promPrecitpitaciones;
	
	private String strNombreManiobra;
	private Integer tipoManiobra;
	private BigDecimal bdValorManiobra;
	
	public Long getCodMantRepresa() {
		return codMantRepresa;
	}
	public void setCodMantRepresa(Long codMantRepresa) {
		this.codMantRepresa = codMantRepresa;
	}
	public String getNombreRepresa() {
		return nombreRepresa;
	}
	public void setNombreRepresa(String nombreRepresa) {
		this.nombreRepresa = nombreRepresa;
	}
	public String getDia() {
		return dia;
	}
	public void setDia(String dia) {
		this.dia = dia;
	}
	public BigDecimal getPromVolumen() {
		return promVolumen;
	}
	public void setPromVolumen(BigDecimal promVolumen) {
		this.promVolumen = promVolumen;
	}
	public BigDecimal getPromPrecitpitaciones() {
		return promPrecitpitaciones;
	}
	public void setPromPrecitpitaciones(BigDecimal promPrecitpitaciones) {
		this.promPrecitpitaciones = promPrecitpitaciones;
	}
	public BigDecimal getBdValorManiobra() {
		return bdValorManiobra;
	}
	public void setBdValorManiobra(BigDecimal bdValorManiobra) {
		this.bdValorManiobra = bdValorManiobra;
	}
	public Integer getTipoManiobra() {
		return tipoManiobra;
	}
	public void setTipoManiobra(Integer tipoManiobra) {
		this.tipoManiobra = tipoManiobra;
	}
	public String getStrAbreviatura() {
		return strAbreviatura;
	}
	public void setStrAbreviatura(String strAbreviatura) {
		this.strAbreviatura = strAbreviatura;
	}
	public String getStrNombreManiobra() {
		return strNombreManiobra;
	}
	public void setStrNombreManiobra(String strNombreManiobra) {
		this.strNombreManiobra = strNombreManiobra;
	}
}
