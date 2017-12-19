package pe.com.sedapal.scr.core.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.com.sedapal.common.core.beans.Paginacion;
import pe.com.sedapal.common.core.beans.Result;
import pe.com.sedapal.scr.core.beans.AnalisisBacteriologicoBean;
import pe.com.sedapal.scr.core.beans.ReporteEnsayoBacteriologicoBean;
import pe.com.sedapal.scr.core.dao.IreporteEnsayoBacteriologicoDao;
import pe.com.sedapal.scr.core.services.IreporteEnsayoBacteriologicoService;

@Service
public class reporteEnsayoBacteriologicoServiceImpl implements IreporteEnsayoBacteriologicoService {

	@Autowired
	private IreporteEnsayoBacteriologicoDao reporteEnsayoBacteriologicoDao;
	
	@Override
	public Result obtenerDatosEnsayoBacteriologico(ReporteEnsayoBacteriologicoBean reporteEnsayoBacteriologicoBean,	Paginacion paginacion) throws Exception {
		// TODO Auto-generated method stub
		return reporteEnsayoBacteriologicoDao.obtenerDatosEnsayoBacteriologico(reporteEnsayoBacteriologicoBean, paginacion);
	}

	@Override
	public Result obtenerDatosEficiencia(ReporteEnsayoBacteriologicoBean reporteEnsayoBacteriologicoBean, Paginacion paginacion) throws Exception {
		// TODO Auto-generated method stub
		return reporteEnsayoBacteriologicoDao.obtenerDatosEficiencia(reporteEnsayoBacteriologicoBean, paginacion);
	}

	@Override
	public void actualizarAnalisisBacteriologicoResul(AnalisisBacteriologicoBean analisisBacteriologicoBean) throws Exception {
		// TODO Auto-generated method stub
		reporteEnsayoBacteriologicoDao.actualizarAnalisisBacteriologicoResul(analisisBacteriologicoBean);
	}

	

}
