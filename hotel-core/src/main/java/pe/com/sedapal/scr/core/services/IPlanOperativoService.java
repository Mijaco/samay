package pe.com.sedapal.scr.core.services;

import java.util.List;

import pe.com.sedapal.common.core.beans.Paginacion;
import pe.com.sedapal.common.core.beans.Result;
import pe.com.sedapal.scr.core.beans.ParametroPlan;
import pe.com.sedapal.scr.core.beans.ParametroReporte;
import pe.com.sedapal.scr.core.beans.PlanOperativo;
import pe.com.sedapal.scr.core.beans.TotalesForm20;

public interface IPlanOperativoService {

	public Result obtenerDatosParametrosPlan(ParametroPlan parametroPlan, Paginacion paginacion);
	
	public ParametroPlan obtenerParametroPlan(Integer codsxp, Integer codplan);
	
	public void insertarParametroPlan(ParametroPlan parametroPlan);
	
	public boolean existeParametroPlan(Integer codsxp, Integer codplan);
	
	public void actualizarParametroPlan(ParametroPlan parametroPlan);
	
	public void actualizarPlanOperativo(PlanOperativo planOperativo);
	
	public PlanOperativo obtenerPlanOperativo(Integer codplan);
	
	public Result obtenerDatosPlanOperativo(PlanOperativo planOperativo, Paginacion paginacion);
	
	public int grabarPlanOperativo(PlanOperativo planOperativo);
	
	public void inactivarParametroPlan(ParametroPlan parametroPlan);
	
	public List<ParametroReporte> obtenerReportePlanOperativo(Integer codplan,Integer idGrupo, String mes);
	
	public void guardarParametroReporte(ParametroReporte parametroReporte , Integer codplan, String mes);
	
	public TotalesForm20 obtenerTotalesForm20(String codmes,Integer tipoResult);

}
