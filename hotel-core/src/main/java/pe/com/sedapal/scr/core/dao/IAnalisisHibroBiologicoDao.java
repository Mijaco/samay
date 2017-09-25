package pe.com.sedapal.scr.core.dao;

import java.util.ArrayList;
import java.util.List;

import pe.com.sedapal.common.core.beans.Paginacion;
import pe.com.sedapal.common.core.beans.Result;
import pe.com.sedapal.scr.core.beans.AnalisisHidroBiologico;
import pe.com.sedapal.scr.core.beans.ReporteAnalisisHidroDetalle;

public interface IAnalisisHibroBiologicoDao{

	public Result obtenerDatosAnalisisHidroBiologico(String fecha, Integer codsubac);
	
	public void insertarAnalisisHidroBiologico(AnalisisHidroBiologico analisisHidroBiologico);
	
	public Result datosReporteAnalisisHidroBiologico(String fechaReporte, Paginacion paginacion);
	
	public ReporteAnalisisHidroDetalle datosDetalleReporteHidroBiologico(String fechaAnalisis,Integer puntoMuestreo);
	
	public void insertarReporteHidroBiologico(ReporteAnalisisHidroDetalle reporteAnalisisHidroDetalle);
	
	public Integer obtenerCorrelativoDetalleReporte();
	
	public ArrayList<ReporteAnalisisHidroDetalle> obtenerDetallePorCorrelativo(Integer idCorrelativo);
	
	public boolean eliminarReporteHidroPorCorrelativo(Integer idCorrelativo);
	
	public List<AnalisisHidroBiologico> obtenerAnalisisPorParametros(String fechaMuestra,Integer puntoMuestra, String tipoOrganismo);
}
