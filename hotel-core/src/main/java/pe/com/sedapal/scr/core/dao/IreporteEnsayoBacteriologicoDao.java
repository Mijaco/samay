package pe.com.sedapal.scr.core.dao;


import pe.com.sedapal.common.core.beans.Result;

import pe.com.sedapal.common.core.beans.Paginacion;
import pe.com.sedapal.scr.core.beans.AnalisisBacteriologicoBean;
import pe.com.sedapal.scr.core.beans.ReporteEnsayoBacteriologicoBean;

public interface IreporteEnsayoBacteriologicoDao {
	
	Result obtenerDatosEnsayoBacteriologico(ReporteEnsayoBacteriologicoBean reporteEnsayoBacteriologicoBean,  Paginacion paginacion) throws Exception;
	
	Result obtenerDatosEficiencia(ReporteEnsayoBacteriologicoBean reporteEnsayoBacteriologicoBean, Paginacion paginacion) throws Exception;
	
	void actualizarAnalisisBacteriologicoResul(AnalisisBacteriologicoBean analisisBacteriologicoBean)	throws Exception;

}
