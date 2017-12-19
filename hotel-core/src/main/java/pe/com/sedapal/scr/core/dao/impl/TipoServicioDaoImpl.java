package pe.com.sedapal.scr.core.dao.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import pe.com.sedapal.common.core.beans.Paginacion;
import pe.com.sedapal.common.core.beans.Result;
import pe.com.sedapal.scr.core.beans.Parametro;
import pe.com.sedapal.scr.core.dao.ITipoServicioDao;
import pe.com.sedapal.scr.core.util.ExecuteProcedure;

@Repository
public class TipoServicioDaoImpl implements ITipoServicioDao {

	@Autowired
	private Environment environment;
	
	private JdbcTemplate template;
	private ExecuteProcedure execSp;
	
	@Autowired
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}
	
	
	@Override
	public Result obtenerTipoDeServicio(Parametro parametro, Paginacion paginacion) throws Exception {
		ArrayList ret = null;
		
		return null;
	}

	@Override
	public Parametro obtenerTipoDeServicio(Integer nid) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void grabarTipoDeServicio(Parametro parametro) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void actualizarPuntoDistribucion(Parametro parametroEditBean) throws Exception {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void inactivarTipoDeServicio(Parametro parametro) throws Exception {
		// TODO Auto-generated method stub

	}

}
