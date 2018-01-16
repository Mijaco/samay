package pe.com.sedapal.scr.core.services;

import java.util.List;

import pe.com.sedapal.scr.core.beans.Producto;

public interface IProductoService {

	public List<Producto> listarProductosFrecuentes();
	
	public List<Producto> fitrarProductos(String nombre, String descripcion, String volumen);

}
