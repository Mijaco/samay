package pe.com.sedapal.scr.core.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.com.sedapal.common.core.beans.Paginacion;
import pe.com.sedapal.common.core.beans.Result;
import pe.com.sedapal.scr.core.beans.AnalisisHidroBiologico;
import pe.com.sedapal.scr.core.beans.ReporteAnalisisHidroDetalle;
import pe.com.sedapal.scr.core.dao.IAnalisisHibroBiologicoDao;
import pe.com.sedapal.scr.core.services.IAnalisisHibroBiologicoService;

@Service
public class AnalisisHibroBiologicoImpl implements IAnalisisHibroBiologicoService {

	@Autowired
	private IAnalisisHibroBiologicoDao analisisHibroBiologicoDao;

	@Override
	public void insertarAnalisisHidroBiologico(AnalisisHidroBiologico analisisHidroBiologico) {
		analisisHibroBiologicoDao.insertarAnalisisHidroBiologico(analisisHidroBiologico);
	}

	@Override
	public Result datosReporteAnalisisHidroBiologico(String fechaReporte, Paginacion paginacion){
		return analisisHibroBiologicoDao.datosReporteAnalisisHidroBiologico(fechaReporte, paginacion);
	}
	
	@Override
	public ReporteAnalisisHidroDetalle datosDetalleReporteHidroBiologico(String fechaAnalisis,Integer puntoMuestreo){
		return analisisHibroBiologicoDao.datosDetalleReporteHidroBiologico(fechaAnalisis, puntoMuestreo);
	}
	
	@Override
	public void insertarReporteHidroBiologico(ReporteAnalisisHidroDetalle reporteAnalisisHidroDetalle){
		 analisisHibroBiologicoDao.insertarReporteHidroBiologico(reporteAnalisisHidroDetalle);
	}
	
	@Override
	public Integer obtenerCorrelativoDetalleReporte() {
		return analisisHibroBiologicoDao.obtenerCorrelativoDetalleReporte();
	}
	@Override
	public ArrayList<ReporteAnalisisHidroDetalle> obtenerDetallePorCorrelativo(Integer idCorrelativo){
		return analisisHibroBiologicoDao.obtenerDetallePorCorrelativo(idCorrelativo);
	}
	
	@Override
	public boolean eliminarReporteHidroPorCorrelativo(Integer idCorrelativo){
		return analisisHibroBiologicoDao.eliminarReporteHidroPorCorrelativo(idCorrelativo);
	}
	
	@Override
	public List<AnalisisHidroBiologico> obtenerAnalisisPorParametros(String fechaMuestra,Integer puntoMuestra, String tipoOrganismo){
		return analisisHibroBiologicoDao.obtenerAnalisisPorParametros(fechaMuestra, puntoMuestra, tipoOrganismo);
	}
	
}
