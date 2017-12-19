package pe.com.sedapal.scr.core.services.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.sedapal.scr.core.beans.PuntoXSubactividad;
import pe.com.sedapal.scr.core.beans.SelectItemBean;
import pe.com.sedapal.scr.core.dao.PuntoXSubactividadDao;
import pe.com.sedapal.scr.core.services.IPuntoXSubactividadService;

@Service
public class PuntoXSubactividadServiceImpl implements IPuntoXSubactividadService {

	@Autowired
	private PuntoXSubactividadDao puntoXSubactividadDao;

	@Override
	public void actualizarPuntoXSubactividad(PuntoXSubactividad puntoXSubactividad) {
		puntoXSubactividadDao.actualizarPuntoXSubactividad(puntoXSubactividad);
	}

	@Override
	public void insertarPuntoXSubactividad(PuntoXSubactividad puntoXSubactividad) {
		puntoXSubactividadDao.insertarPuntoXSubactividad(puntoXSubactividad);
	}

	@Override
	public boolean existePuntoXSubactividad(Integer idSubactividad, Integer idPunto) {
		return puntoXSubactividadDao.existePuntoXSubactividad(idSubactividad, idPunto);
	}

	@Override
	public List<SelectItemBean> listarPuntos(Integer idSubactividad) {
		return puntoXSubactividadDao.listarPuntos(idSubactividad);
	}
	
}
