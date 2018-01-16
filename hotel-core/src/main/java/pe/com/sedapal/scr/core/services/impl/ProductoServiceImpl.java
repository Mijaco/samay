package pe.com.sedapal.scr.core.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.com.sedapal.scr.core.beans.Producto;
import pe.com.sedapal.scr.core.dao.IProductoDao;
import pe.com.sedapal.scr.core.services.IProductoService;

@Service
public class ProductoServiceImpl implements IProductoService{
	
	@Autowired
	private IProductoDao productoDao;

	@Override
	public List<Producto> listarProductosFrecuentes() {
		return productoDao.listarProductosFrecuentes();
	}

	@Override
	public List<Producto> fitrarProductos(String nombre, String descripcion, String marca) {
		return productoDao.fitrarProductos(nombre, descripcion, marca);
	}
	
}
