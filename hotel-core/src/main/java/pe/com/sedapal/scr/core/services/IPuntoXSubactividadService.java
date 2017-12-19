package pe.com.sedapal.scr.core.services;

import java.util.List;

import pe.com.sedapal.scr.core.beans.ActividadArea;
import pe.com.sedapal.scr.core.beans.PuntoXSubactividad;
import pe.com.sedapal.scr.core.beans.SelectItemBean;

public interface IPuntoXSubactividadService {

	public void actualizarPuntoXSubactividad(PuntoXSubactividad puntoXSubactividad);
	
	public void insertarPuntoXSubactividad(PuntoXSubactividad puntoXSubactividad);
	
	public boolean existePuntoXSubactividad(Integer idSubactividad,Integer idPunto);
	
	public List<SelectItemBean> listarPuntos(Integer idSubactividad);
}
