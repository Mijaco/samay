package pe.com.sedapal.scr.core.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.com.sedapal.common.core.beans.Paginacion;
import pe.com.sedapal.common.core.beans.Result;
import pe.com.sedapal.scr.core.beans.AnalisisBacteriologicoBean;
import pe.com.sedapal.scr.core.beans.ReporteAlmacenamientoPTAPBean;
import pe.com.sedapal.scr.core.dao.IReporteAlmacenamientoPTAPDao;
import pe.com.sedapal.scr.core.services.IReporteAlmacenamientoPTAPService;

@Service
public class ReporteAlmacenamientoPTAPServiceImpl implements IReporteAlmacenamientoPTAPService{
	
	@Autowired
	private IReporteAlmacenamientoPTAPDao reporteAlmacenamientoPTAPDao;
	
	@Override
	public void actualizarReporteAlmacenamientoPTAPResul(AnalisisBacteriologicoBean analisisBacteriologicoBean)	throws Exception {
		// TODO Auto-generated method stub
		reporteAlmacenamientoPTAPDao.actualizarReporteAlmacenamientoPTAPResul(analisisBacteriologicoBean);
	}

	@Override
	public Result obtenerDatosPTAPResult(ReporteAlmacenamientoPTAPBean reporteAlmacenamientoPTAPBean, Paginacion paginacion) throws Exception {
		return reporteAlmacenamientoPTAPDao.obtenerDatosPTAPResult(reporteAlmacenamientoPTAPBean, paginacion);

	}

	@Override
	public ReporteAlmacenamientoPTAPBean obtenerDatosPTAPResultTable(ReporteAlmacenamientoPTAPBean reporteAlmacenamientoPTAPBean) throws Exception {
		// TODO Auto-generated method stub
		return reporteAlmacenamientoPTAPDao.obtenerDatosPTAPResultTable(reporteAlmacenamientoPTAPBean);
	}

	@Override
	public void actualizarPTAPResultTable(ReporteAlmacenamientoPTAPBean reporteAlmacenamientoPTAPBean) throws Exception {
		// TODO Auto-generated method stub
		reporteAlmacenamientoPTAPDao.actualizarPTAPResultTable(reporteAlmacenamientoPTAPBean);
	}

}
