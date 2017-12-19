package pe.com.sedapal.scr.core.services;

import pe.com.sedapal.common.core.beans.Paginacion;
import pe.com.sedapal.common.core.beans.Result;
import pe.com.sedapal.scr.core.beans.AlmacenamientoPTAPBean;
import pe.com.sedapal.scr.core.beans.AlmacenamientoPTAPFirstBean;
import pe.com.sedapal.scr.core.beans.AlmacenamientoPTAPSecondBean;
import pe.com.sedapal.scr.core.beans.AlmacenamientoPTAPThreeBean;
import pe.com.sedapal.scr.core.beans.ReporteAlmacenamientoPTAPBean;

public interface IAlmacenamientoPTAPService {

	Result obtenerDatosAlmacenamientoPTAP(AlmacenamientoPTAPBean almacenamientoPTAPBean, Paginacion paginacion)	throws Exception;
	Result obtenerDatosTableFirst(AlmacenamientoPTAPFirstBean almacenamientoPTAPFirstBean, Paginacion paginacion) throws Exception;
	AlmacenamientoPTAPFirstBean obtenerTableFirst(AlmacenamientoPTAPFirstBean almacenamientoPTAPFirstBean) throws Exception;
	int updateMuestraForm21(AlmacenamientoPTAPFirstBean almacenamientoPTAPFirstBean) throws Exception;
	Result obtenerDatosTableSecond(AlmacenamientoPTAPSecondBean almacenamientoPTAPSecondBean, Paginacion paginacion) throws Exception;
	Result obtenerDatosTableThree(AlmacenamientoPTAPThreeBean almacenamientoPTAPThreeBean, Paginacion paginacion) throws Exception;
	int grabarTableSecond(AlmacenamientoPTAPSecondBean almacenamientoPTAPSecondBean) throws Exception;
	void inactivarTableSecond(AlmacenamientoPTAPSecondBean almacenamientoPTAPSecondBean) throws Exception;
	int grabarTableThree(AlmacenamientoPTAPThreeBean almacenamientoPTAPThreeBean) throws Exception;	
	void inactivarTableThree(AlmacenamientoPTAPThreeBean almacenamientoPTAPThreeBean) throws Exception;
	void calcularTablaFirst(AlmacenamientoPTAPFirstBean almacenamientoPTAPFirstBean) throws Exception;
	
}
