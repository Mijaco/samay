package pe.com.sedapal.scr.core.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import pe.com.sedapal.common.core.beans.Paginacion;
import pe.com.sedapal.common.core.beans.Result;
import pe.com.sedapal.scr.core.beans.BeanComodin;
import pe.com.sedapal.scr.core.beans.ClimaBean;
import pe.com.sedapal.scr.core.beans.Formulario153;
import pe.com.sedapal.scr.core.beans.ReporteMuestraPdf;
import pe.com.sedapal.scr.core.beans.RioBean;

@Repository
public interface IRegistroDeMuestraDao {
	
	Result obtenerRegistros(Formulario153 formulario153, Paginacion paginacion) throws Exception;
	
	Formulario153 obtenerFormulario153(Integer nid);
	
	void grabarMuestra(Formulario153 formulario153);
	
	void eliminarFormulario(Formulario153 formulario153);
	
	void actualizarFormulario(Formulario153 formulario153);
	
	List<ReporteMuestraPdf> generarReporteMuestraPdf(String fecha);
	
	List<BeanComodin> obtenerPuntoMuestreoCbo();
	
	List<BeanComodin> obtenerMatrizCbo();
	
	List<BeanComodin> obtenerTipoAnalisisCbo();
	
	List<BeanComodin> obtenerTipoFrascoCbo();
	
	List<BeanComodin> obtenerPersonaMuestreaCbo();
	
	List<BeanComodin> obtenerRecepAnalistaCbo();

}
