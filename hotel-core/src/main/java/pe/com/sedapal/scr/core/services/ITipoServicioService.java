package pe.com.sedapal.scr.core.services;

import pe.com.sedapal.common.core.beans.Paginacion;
import pe.com.sedapal.common.core.beans.Result;
import pe.com.sedapal.scr.core.beans.Parametro;

public interface ITipoServicioService {

	Result obtenerTipoDeServicio(Parametro parametro, Paginacion paginacion) throws Exception;
	Parametro obtenerTipoDeServicio(Integer nid) throws Exception;
	void grabarTipoDeServicio(Parametro parametro) throws Exception;
	void actualizarPuntoDistribucion(Parametro parametroEditBean) throws Exception;
	void inactivarTipoDeServicio(Parametro parametro) throws Exception;
	
}
