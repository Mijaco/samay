package pe.com.sedapal.scr.core.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.com.sedapal.common.core.beans.Paginacion;
import pe.com.sedapal.common.core.beans.Result;
import pe.com.sedapal.scr.core.beans.AlmacenamientoPTAPBean;
import pe.com.sedapal.scr.core.beans.AlmacenamientoPTAPFirstBean;
import pe.com.sedapal.scr.core.beans.AlmacenamientoPTAPSecondBean;
import pe.com.sedapal.scr.core.beans.AlmacenamientoPTAPThreeBean;
import pe.com.sedapal.scr.core.dao.IAlmacenamientoPTAPDao;
import pe.com.sedapal.scr.core.services.IAlmacenamientoPTAPService;

@Service
public class AlmacenamientoPTAPServiceImpl implements IAlmacenamientoPTAPService{

	@Autowired
	private IAlmacenamientoPTAPDao almacenamientoPTAPDao;
	
	@Override
	public Result obtenerDatosAlmacenamientoPTAP(AlmacenamientoPTAPBean almacenamientoPTAPBean, Paginacion paginacion) throws Exception {
		
		return almacenamientoPTAPDao.obtenerDatosAlmacenamientoPTAP(almacenamientoPTAPBean, paginacion);
	}

	@Override
	public Result obtenerDatosTableFirst(AlmacenamientoPTAPFirstBean almacenamientoPTAPFirstBean, Paginacion paginacion) throws Exception {
		// TODO Auto-generated method stub
		return almacenamientoPTAPDao.obtenerDatosTableFirst(almacenamientoPTAPFirstBean, paginacion);
	}

	@Override
	public AlmacenamientoPTAPFirstBean obtenerTableFirst(AlmacenamientoPTAPFirstBean almacenamientoPTAPFirstBean) throws Exception {
		// TODO Auto-generated method stub
		return almacenamientoPTAPDao.obtenerTableFirst(almacenamientoPTAPFirstBean);
	}

	@Override
	public int updateMuestraForm21(AlmacenamientoPTAPFirstBean almacenamientoPTAPFirstBean) throws Exception {
		// TODO Auto-generated method stub
		return almacenamientoPTAPDao.updateMuestraForm21(almacenamientoPTAPFirstBean);
	}

	@Override
	public Result obtenerDatosTableSecond(AlmacenamientoPTAPSecondBean almacenamientoPTAPSecondBean, Paginacion paginacion) throws Exception {
		// TODO Auto-generated method stub
		return almacenamientoPTAPDao.obtenerDatosTableSecond(almacenamientoPTAPSecondBean, paginacion);
	}

	@Override
	public Result obtenerDatosTableThree(AlmacenamientoPTAPThreeBean almacenamientoPTAPThreeBean, Paginacion paginacion) throws Exception {
		// TODO Auto-generated method stub
		return almacenamientoPTAPDao.obtenerDatosTableThree(almacenamientoPTAPThreeBean, paginacion);
	}

	@Override
	public int grabarTableSecond(AlmacenamientoPTAPSecondBean almacenamientoPTAPSecondBean) throws Exception {
		// TODO Auto-generated method stub
		return almacenamientoPTAPDao.grabarTableSecond(almacenamientoPTAPSecondBean);
	}

	@Override
	public void inactivarTableSecond(AlmacenamientoPTAPSecondBean almacenamientoPTAPSecondBean) throws Exception {
		// TODO Auto-generated method stub
		almacenamientoPTAPDao.inactivarTableSecond(almacenamientoPTAPSecondBean);
	}

	@Override
	public int grabarTableThree(AlmacenamientoPTAPThreeBean almacenamientoPTAPThreeBean) throws Exception {
		// TODO Auto-generated method stub
		return almacenamientoPTAPDao.grabarTableThree(almacenamientoPTAPThreeBean);
	}

	@Override
	public void inactivarTableThree(AlmacenamientoPTAPThreeBean almacenamientoPTAPThreeBean) throws Exception {
		// TODO Auto-generated method stub
		almacenamientoPTAPDao.inactivarTableThree(almacenamientoPTAPThreeBean);
	}

	@Override
	public void calcularTablaFirst(AlmacenamientoPTAPFirstBean almacenamientoPTAPFirstBean) throws Exception {
		// TODO Auto-generated method stub
		almacenamientoPTAPDao.calcularTablaFirst(almacenamientoPTAPFirstBean);
	}

}
