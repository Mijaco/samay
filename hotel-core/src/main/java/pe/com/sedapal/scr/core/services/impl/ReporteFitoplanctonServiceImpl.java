package pe.com.sedapal.scr.core.services.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.com.sedapal.common.core.beans.Paginacion;
import pe.com.sedapal.common.core.beans.Result;
import pe.com.sedapal.scr.core.beans.ReporteFitoplanctonDetalle;
import pe.com.sedapal.scr.core.dao.IReporteFitoplanctonDao;
import pe.com.sedapal.scr.core.services.IReporteFitoplanctonService;

@Service
public class ReporteFitoplanctonServiceImpl implements IReporteFitoplanctonService{

	@Autowired
	private IReporteFitoplanctonDao reporteFitoplanctonDao;

	@Override
	public Result datosReporteFitoplancton(String fechaReporte, Paginacion paginacion) {
		return reporteFitoplanctonDao.datosReporteFitoplancton(fechaReporte, paginacion);
	}

	@Override
	public ReporteFitoplanctonDetalle datosDetalleReporteFitoplancton(String fechaAnalisis, Integer puntoMuestreo) {
		return reporteFitoplanctonDao.datosDetalleReporteFitoplancton(fechaAnalisis, puntoMuestreo);
	}

	@Override
	public void insertarReporteFitoplancton(ReporteFitoplanctonDetalle reporteFitoplanctonDetalle) {
		reporteFitoplanctonDao.insertarReporteFitoplancton(reporteFitoplanctonDetalle);
		
	}

	@Override
	public Integer obtenerCorrelativoDetalleReporte() {
		return  reporteFitoplanctonDao.obtenerCorrelativoDetalleReporte();
	}

	@Override
	public ArrayList<ReporteFitoplanctonDetalle> obtenerDetallePorCorrelativo(Integer idCorrelativo) {
		return reporteFitoplanctonDao.obtenerDetallePorCorrelativo(idCorrelativo);
	}
	
	@Override
	public boolean eliminarReportePorCorrelativo(Integer idCorrelativo) {
		return reporteFitoplanctonDao.eliminarReportePorCorrelativo(idCorrelativo);
	}
	

}
