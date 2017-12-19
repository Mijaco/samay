package pe.com.sedapal.scr.core.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.com.sedapal.scr.core.beans.SelectItemBean;
import pe.com.sedapal.scr.core.dao.ICatalogoDao;
import pe.com.sedapal.scr.core.services.ICatalogoService;

@Service
public class CatalogoServicesImpl implements ICatalogoService{
	
	@Autowired
	private ICatalogoDao catalogoDao;
	
	
	public ICatalogoDao getCatalogoDao() {
		return catalogoDao;
	}

	public void setCatalogoDao(ICatalogoDao catalogoDao) {
		this.catalogoDao = catalogoDao;
	}

	@Override
	public List<SelectItemBean> obtenerCatalogo(Integer idTabla) {
		List<SelectItemBean> cats=null;
		try {
			cats= catalogoDao.obtenerCatalogo(idTabla);
		} catch (Exception e) {
			
		}
		return cats;
	}

	@Override
	public List<SelectItemBean> obtenerCatalogoTodosNinguno(Integer idTabla, Integer flag) {
		List<SelectItemBean> cats=null;
		try {
			cats= catalogoDao.obtenerCatalogoTodosNinguno(idTabla, flag);
		} catch (Exception e) {
			
		}
		return cats;
	}

	@Override
	public List<SelectItemBean> obtenerCatalogoSeleccionar(Integer idTabla, Integer flag) {
		List<SelectItemBean> cats=null;
		try {
			cats= catalogoDao.obtenerCatalogoSeleccionar(idTabla, flag);
		} catch (Exception e) {
			
		}
		return cats;
	}
}
