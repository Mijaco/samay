package pe.com.sedapal.scr.web.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import pe.com.sedapal.common.core.utils.ConstantsCommon;
import pe.com.sedapal.scr.core.beans.ActividadReporte;
import pe.com.sedapal.scr.core.beans.ParametroReporte;
import pe.com.sedapal.scr.core.beans.PlanOperativo;
import pe.com.sedapal.scr.core.beans.ReportePlanOperativo;
import pe.com.sedapal.scr.core.beans.SubactividadReporte;
import pe.com.sedapal.scr.core.beans.TotalesForm20;
import pe.com.sedapal.scr.core.common.ConstantsLaboratorio;
import pe.com.sedapal.scr.core.services.IPlanOperativoService;
import pe.com.sedapal.scr.web.common.Constants;

@Controller
@PropertySources(value = { @PropertySource(name = "props", value = {
		"classpath:application.properties" }, ignoreResourceNotFound = true) })
public class ReportePlanOperativoController {
	private static final Logger LOG = LoggerFactory.getLogger(ReportePlanOperativoController.class);

	@Autowired
	Environment env;

	@Autowired
	MessageSource messageSource;

	@Autowired
	IPlanOperativoService planOperativoService;
	
	@RequestMapping(value = "/reportePlanOperativoSave", method = RequestMethod.POST)
	public String reportePlanOperativoSave(HttpServletRequest request, HttpSession session,
			@ModelAttribute("wrappper") ReportePlanOperativo wrappper,
			Model model){
		
	String	strMensajeTipo = ConstantsCommon.GRABADO_OK;
	String	strMensajeError = "";
	
	LOG.info("wrappper " + wrappper);
		
	model.addAttribute(Constants.MENSAJE_MOSTRAR,obtenerMensaje("reporte.plan.operativo.msg.guardado"));
	
	model.addAttribute(Constants.MENSAJE_TIPO, strMensajeTipo);
	model.addAttribute(Constants.MENSAJE_ERROR, strMensajeError);
	
	model.addAttribute("wrappper", wrappper);
		
		return "generic/genericSave :: genericSave";
	}
	
	@RequestMapping(value = "/reportePlanOperativo", method = RequestMethod.GET)
	public String planOperativoGet(HttpServletRequest request, HttpSession session,
			@ModelAttribute("planOperativoSearchBean") PlanOperativo planOperativoSearchBean,
			@ModelAttribute("reportePlanEditBean") ReportePlanOperativo reportePlanEditBean,
			Model model,@RequestParam Map<String,String> allRequestParams){
			
			return "reportePlanOperativo/reportePlanOperativo";
	}
	
	@RequestMapping(value = "/refrescarTablaFiltradaXArea", method = RequestMethod.GET)
	public String refrescarTablaFiltradaXArea(HttpServletRequest request, HttpSession session,
			Model model,@RequestParam Map<String,String> allRequestParams){
			return "reportePlanOperativo/reportePlanBandeja :: resultsList";
	}
	
	
	
	@RequestMapping(value = "/buscarReportePlanSearch", method = RequestMethod.POST)
	public String buscarReportePlan(HttpServletRequest request, HttpSession session,
			@ModelAttribute("planOperativoSearchBean") PlanOperativo planOperativoSearchBean,
			@ModelAttribute("reportePlanEditBean") ReportePlanOperativo reportePlanEditBean,
			Model model,@RequestParam Map<String,String> allRequestParams){
		
			/// alterno
			String mes = allRequestParams.get("idMes");
			String codpla = allRequestParams.get("codplan");
			String codare = allRequestParams.get("codare");
			String codDesc = allRequestParams.get("codDesc");
			String descPlan = allRequestParams.get("descPlan");
			
			LOG.info("mes : " + mes);
			LOG.info("codpla : " + codpla);
			LOG.info("codare : " + codare);
			LOG.info("codplan : " + codpla);
		
			List<ParametroReporte> parametrosbd = planOperativoService.obtenerReportePlanOperativo(Integer.parseInt(codpla),Integer.parseInt(codare), mes);
			reportePlanEditBean = obtenerReportePlanOperativo(parametrosbd, mes);
			reportePlanEditBean.setCodDescPlan(codDesc);
			reportePlanEditBean.setDescripcion(descPlan);
			reportePlanEditBean.setCodplan(Integer.parseInt(codpla));
		    reportePlanEditBean.setMes(mes);
			reportePlanEditBean.setCodare(Integer.parseInt(codare));
			
			model.addAttribute("reportePlanEditBean",reportePlanEditBean);
			
			return "reportePlanOperativo/reportePlanOperativoTable :: resultsList";
	}
	
	
	private ReportePlanOperativo obtenerReportePlanOperativo(List<ParametroReporte> parametrosbd, String mes){
		Map<Integer,Map<Integer,Map<Integer,Integer>>>  totalesForm20;
		
		Map<Integer, Map<Integer, Map<Integer,ParametroReporte>>> mapActividad = new LinkedHashMap<>();
		ReportePlanOperativo reportePlanOperativo = new ReportePlanOperativo();
		try {
		 totalesForm20 = obtenerMapTotales(mes);
		 
		 LOG.info("> totalesForm20 " + totalesForm20);
			
		 Map<Integer, Map<Integer,ParametroReporte>> subactividadesMap;
		 Map<Integer,ParametroReporte> parametroMap;
		 
		 
		 for (ParametroReporte parametroReporte : parametrosbd) {
		
			if(mapActividad.containsKey(parametroReporte.getCodact())){
				
				 Map<Integer, Map<Integer,ParametroReporte>> subactividadesReg = mapActividad.get(parametroReporte.getCodact());
				
				 Map<Integer,ParametroReporte> parametroReg;
				 if(subactividadesReg.containsKey(parametroReporte.getCodsubact())){
					 parametroReg = subactividadesReg.get(parametroReporte.getCodsubact());
					 
				 } else {
					 
					 parametroReg = new HashMap<>();
				 }
				 
				 LOG.info("parametroReg: " + parametroReg);
				 
				 parametroReg.put(parametroReporte.getCodparam(), parametroReporte);
				 subactividadesReg.put(parametroReporte.getCodsubact(), parametroReg);
				 
			} else {
				
				subactividadesMap = new HashMap<>();
				parametroMap = new HashMap<>();
				parametroMap.put(parametroReporte.getCodparam(), parametroReporte);
				
				subactividadesMap.put(parametroReporte.getCodsubact(), parametroMap);
				mapActividad.put(parametroReporte.getCodact(), subactividadesMap);
				
			}
			
		}
		
		LOG.info(" mapActividad: " + mapActividad);
		
		ArrayList<ActividadReporte> actividades = new ArrayList<ActividadReporte>();
		ArrayList<SubactividadReporte> subactividades = new ArrayList<SubactividadReporte>();
		ArrayList<ParametroReporte> parametros = new ArrayList<ParametroReporte>();
		
		//SE ITERA PARA DAR FORMA  LISTADO DE OBJETOSr
		for (Map.Entry<Integer, Map<Integer, Map<Integer,ParametroReporte>>> actividadRep : mapActividad.entrySet())
		{
			ActividadReporte actividadReporte = new ActividadReporte();
			actividadReporte.setCodigo(actividadRep.getKey());
		    
			Map<Integer, Map<Integer,ParametroReporte>> subactividadesRepo = actividadRep.getValue();
		    
			subactividades = new ArrayList<SubactividadReporte>();
		    for (Map.Entry<Integer, Map<Integer,ParametroReporte>> subactividadesEntry : subactividadesRepo.entrySet()){
		    	
		    	Map<Integer,ParametroReporte> parametrosRepo = subactividadesEntry.getValue();
		    	
		    	SubactividadReporte subactividadReporte = new SubactividadReporte();	
		    	subactividadReporte.setCodigo(subactividadesEntry.getKey());
		    	
		    	 parametros = new ArrayList<ParametroReporte>();
		    	 int totalProgramados = 0;
		    	 for (Map.Entry<Integer,ParametroReporte> parametrosEntry : parametrosRepo.entrySet()){
		    		 ParametroReporte paramRepo = parametrosEntry.getValue();
		    		 actividadReporte.setDescripcion(paramRepo.getActividad());
		    		 subactividadReporte.setDescripcion(paramRepo.getSubactividad());
		    		 totalProgramados+=paramRepo.getProgramado();
		    		 
		    		 if(paramRepo.getEjecutado()<=0){
		    			 
		    			 int ejecutados = obtenerMensajesActividad(totalesForm20, paramRepo.getCodact(), paramRepo.getCodsubact(), paramRepo.getCodpar());
		    			 LOG.info("ejecutados para " + "[ "+ paramRepo.getCodact() + " ] ; [ " + paramRepo.getCodsubact() + " ] ; [ " + paramRepo.getCodpar() + " ] : " + ejecutados + "; antes: " + paramRepo.getEjecutado());
		    			 paramRepo.setEjecutado(ejecutados);
		    		 }
		    		 
//		    		 paramRepo.setEjecutado(ejecutados);
		    		 parametros.add(paramRepo);
		    	 }
		    	 parametros.add(new ParametroReporte(ConstantsLaboratorio.TOTALES_PROGRAMADOS,ConstantsLaboratorio.TOTALES_PROGRAMADOS, totalProgramados));
		    	 subactividadReporte.setParametros(parametros);
		    	 subactividades.add(subactividadReporte);
		    	
		    }
		    actividadReporte.setSubactividades(subactividades);
		    actividades.add(actividadReporte);
		}
		
		reportePlanOperativo.setActividades(actividades);
		
		} catch (Exception e) {
			
			e.printStackTrace();
			return null;
		}
		
		LOG.info(" reportePlanOperativo: " + reportePlanOperativo);
		return reportePlanOperativo;
	}
	
	private Map<Integer,Map<Integer,Map<Integer,Integer>>> obtenerMapTotales(String mes) {
		
		 TotalesForm20 totalesActividad01 = planOperativoService.obtenerTotalesForm20(mes,1);
		 TotalesForm20 totalesActividad02 = planOperativoService.obtenerTotalesForm20(mes,2);
		 
		 LOG.info("totalesActividad01: " + totalesActividad01);
		 LOG.info("totalesActividad02: " + totalesActividad02);
		
		Map<Integer,Map<Integer,Map<Integer,Integer>>> mapaTotales = new HashMap<>();
		
		Map<Integer,Map<Integer,Integer>> mapaTotalSubactividadFirst =  new HashMap<>();
		Map<Integer,Map<Integer,Integer>> mapaTotalSubactividadSecond =  new HashMap<>();
		
		Map<Integer,Integer> mapaTotalParametroResultFirst =  new HashMap<>();
		Map<Integer,Integer> mapaTotalParametroResultSecond=  new HashMap<>();
		
		String actividades[] = obtenerMensaje("actividad.formulario20.mapeo").split("#");
		String subactividades[]= obtenerMensaje("subactividad.formulario20.mapeo").split("#");
		String parametros[] = obtenerMensaje("parametros.formulario20.mapeo").split("#");

		
		mapaTotalParametroResultFirst.put(Integer.parseInt(parametros[0]), totalesActividad01.getColiTotales());
		mapaTotalParametroResultFirst.put(Integer.parseInt(parametros[1]), totalesActividad01.getColiTermoTolerantes());
		mapaTotalParametroResultFirst.put(Integer.parseInt(parametros[2]), totalesActividad01.getHeterotroficas());
		
		mapaTotalParametroResultSecond.put(Integer.parseInt(parametros[0]), totalesActividad02.getColiTotales());
		mapaTotalParametroResultSecond.put(Integer.parseInt(parametros[1]), totalesActividad02.getColiTermoTolerantes());
		mapaTotalParametroResultSecond.put(Integer.parseInt(parametros[2]), totalesActividad02.getHeterotroficas());
		
		// Las subactividades pueden ser igual o o diferentes (configurar 2 en messages.properties)
		mapaTotalSubactividadFirst.put(Integer.parseInt(subactividades[0]), mapaTotalParametroResultFirst);
		mapaTotalSubactividadSecond.put(Integer.parseInt(subactividades[1]), mapaTotalParametroResultSecond);
				
		mapaTotales.put(Integer.parseInt(actividades[0]), mapaTotalSubactividadFirst);
		mapaTotales.put(Integer.parseInt(actividades[1]), mapaTotalSubactividadSecond);
		
		return mapaTotales;
	}
	
	private static int  obtenerMensajesActividad(Map<Integer,Map<Integer,Map<Integer,Integer>>> dataForm20,Integer codact,Integer codsubact, Integer codparam){
		int result = 0;
		Map<Integer,Map<Integer,Integer>> subactividades = dataForm20.get(codact);
		if(subactividades != null){
			Map<Integer,Integer> parametros = subactividades.get(codsubact);
			if(parametros!=null && codparam!=null){
				result = parametros.get(codparam) != null? parametros.get(codparam) : 0;
			}
		}
		return result;
	}
	
	@RequestMapping(value = "/reportePlanOperativoSave1", method = RequestMethod.POST)
	public String planOperativoSave(ModelMap model, HttpServletRequest request, HttpSession session,
			@ModelAttribute("reportePlanEditBean") ReportePlanOperativo reportePlanEditBean){

		String strMensajeTipo = "";
		String strMensajeError = "";
		try {
			   ReportePlanOperativo repo = new ReportePlanOperativo(reportePlanEditBean);
				
				LOG.info("descrip: "+reportePlanEditBean.getDescripcion());
				LOG.info("reportePlanEditBean: "+reportePlanEditBean);
				LOG.info("codplan: " + reportePlanEditBean.getCodplan());
				LOG.info("descripcion: " + reportePlanEditBean.getDescripcion());
				LOG.info("mes: " + reportePlanEditBean.getMes());
				
				strMensajeTipo = ConstantsCommon.GRABADO_OK;
				
				List<ActividadReporte> actividades = reportePlanEditBean.getActividades();
				if(actividades!=null){
				for (ActividadReporte actividadReporte : actividades) {
					List<SubactividadReporte> subactividades = actividadReporte.getSubactividades();
					
					for (SubactividadReporte subactividadReporte : subactividades) {
						List<ParametroReporte> parametros = subactividadReporte.getParametros();
						
						for (ParametroReporte parametroReporte : parametros) {
							if(!ConstantsLaboratorio.TOTALES_PROGRAMADOS.equals(parametroReporte.getDescripcion())){
								planOperativoService.guardarParametroReporte(parametroReporte, reportePlanEditBean.getCodplan(), reportePlanEditBean.getMes());	
							}
						}
					}
				 }
				
				}
				
				model.addAttribute(Constants.MENSAJE_MOSTRAR,obtenerMensaje("plan.operativo.msg.guardado"));
				model.addAttribute("reportePlanEditBean",repo);
				
		} catch (Exception e) {
			
			strMensajeTipo = ConstantsCommon.GRABADO_NO_OK;
			strMensajeError = e.getMessage();
			e.printStackTrace();
		}
		
		model.addAttribute("mensajeTipo", strMensajeTipo);
		model.addAttribute("mensajeError", strMensajeError);
		return "generic/genericSave :: genericSave";
		
	}

		
	private String obtenerMensaje(String messageProp){
		
		return messageSource.getMessage(messageProp, new Object[] {}, Locale.US);
		
	}
	
}
