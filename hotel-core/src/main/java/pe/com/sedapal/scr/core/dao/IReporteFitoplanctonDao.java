package pe.com.sedapal.scr.core.dao;

import java.util.ArrayList;

import pe.com.sedapal.common.core.beans.Paginacion;
import pe.com.sedapal.common.core.beans.Result;
import pe.com.sedapal.scr.core.beans.ReporteFitoplanctonDetalle;

public interface IReporteFitoplanctonDao {

	public Result datosReporteFitoplancton(String fechaReporte, Paginacion paginacion);
	
	public ReporteFitoplanctonDetalle datosDetalleReporteFitoplancton(String fechaAnalisis,Integer puntoMuestreo);
	
	public void insertarReporteFitoplancton(ReporteFitoplanctonDetalle reporteFitoplanctonDetalle);
	
	public Integer obtenerCorrelativoDetalleReporte();
	
	public ArrayList<ReporteFitoplanctonDetalle> obtenerDetallePorCorrelativo(Integer idCorrelativo);
	
	public boolean eliminarReportePorCorrelativo(Integer idCorrelativo);
	
}
