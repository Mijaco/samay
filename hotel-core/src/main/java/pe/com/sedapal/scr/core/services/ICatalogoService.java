package pe.com.sedapal.scr.core.services;

import java.util.List;

import pe.com.sedapal.scr.core.beans.SelectItemBean;

public interface ICatalogoService {

	public List<SelectItemBean> obtenerCatalogo(Integer idTabla);
	public List<SelectItemBean> obtenerCatalogoTodosNinguno(Integer idTabla, Integer flag);
	
	public List<SelectItemBean> obtenerCatalogoSeleccionar(Integer idTabla, Integer flag);
	
}
