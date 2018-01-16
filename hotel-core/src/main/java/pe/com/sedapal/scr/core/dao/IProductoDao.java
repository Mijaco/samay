package pe.com.sedapal.scr.core.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import pe.com.sedapal.scr.core.beans.Producto;


@Repository
public interface IProductoDao {

		public List<Producto> listarProductosFrecuentes();
		
		public List<Producto> fitrarProductos(String nombre, String descripcion, String marca);

}
