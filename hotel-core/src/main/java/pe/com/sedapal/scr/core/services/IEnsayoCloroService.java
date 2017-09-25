package pe.com.sedapal.scr.core.services;

import java.util.List;

import pe.com.sedapal.common.core.beans.Paginacion;
import pe.com.sedapal.common.core.beans.Result;
import pe.com.sedapal.scr.core.beans.EnsayoCloro;
import pe.com.sedapal.scr.core.beans.EnsayoCloroDetalle;

public interface IEnsayoCloroService {
	public Result obtenerDatosEnsayoCloro(EnsayoCloro ensayoCloro, Paginacion paginacion);
	
	public List<EnsayoCloroDetalle> obtenerListEnsayoCloro(Integer fechaMuestreo, String hora);
	
	public void guardarEnsayoCloro(EnsayoCloro ensayoCloro);
	
	public void guardarEnsayoCloroDetalle(EnsayoCloroDetalle ensayoCloroDetalle);
	
	public void inactivarEnsayoCloro(Integer id);
	
	public void inactivarCloroDetalle(Integer id);
	
}
