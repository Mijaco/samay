package pe.com.sedapal.scr.core.services;

import pe.com.sedapal.common.core.beans.Paginacion;
import pe.com.sedapal.common.core.beans.Result;
import pe.com.sedapal.scr.core.beans.AnalisisBacteriologicoBean;
import pe.com.sedapal.scr.core.beans.ReporteAlmacenamientoPTAPBean;

public interface IReporteAlmacenamientoPTAPService {

	void actualizarReporteAlmacenamientoPTAPResul(AnalisisBacteriologicoBean analisisBacteriologicoBean)	throws Exception;
	Result obtenerDatosPTAPResult(ReporteAlmacenamientoPTAPBean reporteAlmacenamientoPTAPBean, Paginacion paginacion) throws Exception;
	ReporteAlmacenamientoPTAPBean obtenerDatosPTAPResultTable(ReporteAlmacenamientoPTAPBean reporteAlmacenamientoPTAPBean) throws Exception;
	void actualizarPTAPResultTable(ReporteAlmacenamientoPTAPBean reporteAlmacenamientoPTAPBean) throws Exception;
}
