package pe.com.sedapal.scr.core.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.com.sedapal.common.core.beans.Paginacion;
import pe.com.sedapal.common.core.beans.Result;
import pe.com.sedapal.scr.core.beans.ParametroPlan;
import pe.com.sedapal.scr.core.beans.ParametroReporte;
import pe.com.sedapal.scr.core.beans.PlanOperativo;
import pe.com.sedapal.scr.core.beans.TotalesForm20;
import pe.com.sedapal.scr.core.dao.IPlanOperativoDao;
import pe.com.sedapal.scr.core.services.IPlanOperativoService;

@Service
public class PlanOperativoServiceImpl implements IPlanOperativoService{

	@Autowired
	IPlanOperativoDao planOperativoDao;

	@Override
	public Result obtenerDatosParametrosPlan(ParametroPlan parametroPlan, Paginacion paginacion) {
		return planOperativoDao.obtenerDatosParametrosPlan(parametroPlan, paginacion);
	}
	
	public ParametroPlan obtenerParametroPlan(Integer codsxp, Integer codplan){
		
		return planOperativoDao.obtenerParametroPlan(codsxp, codplan);
	}
	
	public void insertarParametroPlan(ParametroPlan parametroPlan) {
		planOperativoDao.insertarParametroPlan(parametroPlan);
	}
	
	public boolean existeParametroPlan(Integer codsxp, Integer codplan){
		return planOperativoDao.existeParametroPlan(codsxp,codplan);
	}
	
	public void actualizarParametroPlan(ParametroPlan parametroPlan){
		planOperativoDao.actualizarParametroPlan(parametroPlan);
	}
	
	public void actualizarPlanOperativo(PlanOperativo planOperativo){
		planOperativoDao.actualizarPlanOperativo(planOperativo);
	}
	
	public PlanOperativo obtenerPlanOperativo(Integer codplan) {
		return planOperativoDao.obtenerPlanOperativo(codplan);
	}
	
	public Result obtenerDatosPlanOperativo(PlanOperativo planOperativo, Paginacion paginacion){
		return planOperativoDao.obtenerDatosPlanOperativo(planOperativo, paginacion);
	}
	
	public int grabarPlanOperativo(PlanOperativo planOperativo) {
		return planOperativoDao.grabarPlanOperativo(planOperativo);
	}
	
	public void inactivarParametroPlan(ParametroPlan parametroPlan){
		planOperativoDao.inactivarParametroPlan(parametroPlan);
	}

	@Override
	public List<ParametroReporte> obtenerReportePlanOperativo(Integer codplan,Integer idGrupo, String mes) {
		return planOperativoDao.obtenerReportePlanOperativo(codplan,idGrupo, mes);
	}

	@Override
	public void guardarParametroReporte(ParametroReporte parametroReporte , Integer codplan, String mes){
		planOperativoDao.guardarParametroReporte(parametroReporte, codplan, mes);
	}
	
	@Override
	public TotalesForm20 obtenerTotalesForm20(String mes,Integer tipoResult) {
		return  planOperativoDao.obtenerTotalesForm20(mes,tipoResult);
	}
}
