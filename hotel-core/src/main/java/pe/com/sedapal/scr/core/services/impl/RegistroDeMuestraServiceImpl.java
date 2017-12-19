package pe.com.sedapal.scr.core.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.com.sedapal.common.core.beans.Paginacion;
import pe.com.sedapal.common.core.beans.Result;
import pe.com.sedapal.scr.core.beans.BeanComodin;
import pe.com.sedapal.scr.core.beans.ClimaBean;
import pe.com.sedapal.scr.core.beans.Formulario153;
import pe.com.sedapal.scr.core.beans.ReporteMuestraPdf;
import pe.com.sedapal.scr.core.dao.IRegistroDeMuestraDao;
import pe.com.sedapal.scr.core.services.IRegistroDeMuestraService;

@Service
public class RegistroDeMuestraServiceImpl implements IRegistroDeMuestraService{
	
	@Autowired
	private IRegistroDeMuestraDao iRegistroDeMuestraDao;

	@Override
	public Result obtenerRegistros(Formulario153 formulario153, Paginacion paginacion) throws Exception {
		
		return iRegistroDeMuestraDao.obtenerRegistros(formulario153, paginacion);

	}
	
	@Override
	public Formulario153 obtenerFormulario153(Integer nid) {
		
		return iRegistroDeMuestraDao.obtenerFormulario153(nid);
	}

	@Override
	public void grabarMuestra(Formulario153 formulario153)  {
		
		iRegistroDeMuestraDao.grabarMuestra(formulario153);
		
	}
	
	@Override
	public List<ReporteMuestraPdf> generarReporteMuestraPdf(String fecha) {
		
		return iRegistroDeMuestraDao.generarReporteMuestraPdf(fecha);
	}
	
	@Override
	public void eliminarFormulario(Formulario153 formulario153) {
		
		iRegistroDeMuestraDao.eliminarFormulario(formulario153);
		
	}
	
	@Override
	public void actualizarFormulario(Formulario153 formulario153) {
		
		iRegistroDeMuestraDao.actualizarFormulario(formulario153);
		
	}

	@Override
	public List<BeanComodin> obtenerPuntoMuestreoCbo() {
		
		return iRegistroDeMuestraDao.obtenerPuntoMuestreoCbo();
	}

	@Override
	public List<BeanComodin> obtenerMatrizCbo() {
		
		return iRegistroDeMuestraDao.obtenerMatrizCbo();
	}

	@Override
	public List<BeanComodin> obtenerTipoAnalisisCbo() {
		
		return iRegistroDeMuestraDao.obtenerTipoAnalisisCbo();
	}

	@Override
	public List<BeanComodin> obtenerTipoFrascoCbo() {
		
		return iRegistroDeMuestraDao.obtenerTipoFrascoCbo();
	}

	@Override
	public List<BeanComodin> obtenerPersonaMuestreaCbo() {
		
		return iRegistroDeMuestraDao.obtenerPersonaMuestreaCbo();
	}

	@Override
	public List<BeanComodin> obtenerRecepAnalistaCbo() {
		
		return iRegistroDeMuestraDao.obtenerRecepAnalistaCbo();
	}

	
}
