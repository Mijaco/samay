//package pe.com.sedapal.scr.web.controllers;
//
//import java.util.HashMap;
//import java.util.Locale;
//import java.util.Map;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpSession;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.MessageSource;
//import org.springframework.context.annotation.PropertySource;
//import org.springframework.context.annotation.PropertySources;
//import org.springframework.core.env.Environment;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.ui.ModelMap;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//import pe.com.sedapal.common.core.beans.Paginacion;
//import pe.com.sedapal.common.core.beans.Result;
//import pe.com.sedapal.common.core.utils.ConstantsCommon;
//import pe.com.sedapal.scr.core.beans.ParametroPlan;
//import pe.com.sedapal.scr.core.beans.PlanOperativo;
//import pe.com.sedapal.scr.core.common.ConstantsLaboratorio;
//import pe.com.sedapal.scr.core.services.IParametroXSubactividadService;
//import pe.com.sedapal.scr.core.services.IPlanOperativoService;
//import pe.com.sedapal.scr.web.common.Constants;
//import pe.com.sedapal.scr.web.common.Util;
//
//@Controller
//@PropertySources(value = { @PropertySource(name = "props", value = {
//		"classpath:application.properties" }, ignoreResourceNotFound = true) })
//public class PlanOperativoController {
//	private static final Logger LOG = LoggerFactory.getLogger(PlanOperativoController.class);
//
//	
//	@Autowired
//	Environment env;
//
//	@Autowired
//	MessageSource messageSource;
//
//	@Autowired
//	IParametroXSubactividadService parametroXSubactividadService;
//	
//	@Autowired
//	IPlanOperativoService planOperativoService;
//	
//	
//	@RequestMapping(value = "/planOperativoDetalle/pagination/{codplan}", method = RequestMethod.POST)
//	public @ResponseBody ResponseEntity<Map<String,Object>> obtenerDatos(@RequestParam Map<String,String> allRequestParams,@PathVariable int codplan)
//			throws Exception {
//		try {
//			
//			ParametroPlan parametroPlan = new ParametroPlan();
//			int estadoAprobado = Constants.ACTIVO;
//			
//			LOG.info("cod plan a consultar : " + codplan);
//			
//			Paginacion paginacion = new Paginacion();
//			paginacion.setCantidadpag(Integer.parseInt(allRequestParams.get("length")));
//			paginacion.setPagdesde(Integer.parseInt(allRequestParams.get("start")));
//			paginacion.setColorderby(Integer.parseInt(allRequestParams.get("order[0][column]"))==0?Integer.parseInt(allRequestParams.get("order[0][column]"))+1:Integer.parseInt(allRequestParams.get("order[0][column]")));
//			paginacion.setColorderbydir(allRequestParams.get("order[0][dir]"));
//			
//			parametroPlan.setCodplan(codplan);
//
//			Result result = planOperativoService.obtenerDatosParametrosPlan(parametroPlan, paginacion);
//			LOG.info("DATA : " + result.getData());
//			
//			Map<String,Object> dtResponse = new HashMap<String, Object>();
//			dtResponse.put("draw", allRequestParams.get("draw"));
//			dtResponse.put("recordsTotal", result.getRecords());
//			dtResponse.put("recordsFiltered", result.getRecords());
//			dtResponse.put("data", result.getData());
//			
//			if(codplan>0){
//				PlanOperativo planOperativo = planOperativoService.obtenerPlanOperativo(codplan);
//				estadoAprobado = planOperativo.getEstadoPlan();
//				
//				LOG.info("estadoAprobado : " + estadoAprobado + " ; codplan " + codplan);
//				LOG.info("estadoAprobado : " + estadoAprobado + " ; data: " + result.getData().size());
//			}
//			
//			
//			
//			dtResponse.put("aprobado", estadoAprobado);
//			
//			return new ResponseEntity<Map<String,Object>>(dtResponse, HttpStatus.OK);
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//		}
//	}
//	
//	@RequestMapping(value = "/planOperativoGet/{id}", method = RequestMethod.GET)
//	public String tablaPoissonGetPage(
//			@ModelAttribute("parametroPlanSearchBean") ParametroPlan parametroPlanSearchBean,
//			@ModelAttribute("parametroPlanEditBean") ParametroPlan parametroPlanEditBean, Model model,
//			@RequestParam Map<String,String> allRequestParams,
//			@PathVariable int id) throws Exception {
//		
//		try {
//
//			int codsxp = Integer.parseInt(allRequestParams.get("codsxp")!=null? allRequestParams.get("codsxp"):"0");
//			int codplan = Integer.parseInt(allRequestParams.get("codplan")!=null? allRequestParams.get("codplan"):"0");
//			
//			int codarea = Integer.parseInt(allRequestParams.get("codarea")!=null? allRequestParams.get("codarea"):"0");
//			int codact = Integer.parseInt(allRequestParams.get("codact")!=null? allRequestParams.get("codact"):"0");
//			int codsubact = Integer.parseInt(allRequestParams.get("codsubact")!=null? allRequestParams.get("codsubact"):"0");
//			
//			LOG.info("codsxp: " + codsxp);
//			LOG.info("codplan: " + codplan);
//			LOG.info("codarea: " + codarea);
//			LOG.info("codact: " + codact);
//			LOG.info("codsubact: " + codsubact);
//			LOG.info("id: " + id);
//			
//			
//			LOG.info("textparam: " + allRequestParams.get("textparam"));
//			
//			if(codsxp > 0) {
//				
//				parametroPlanEditBean = planOperativoService.obtenerParametroPlan(codsxp,codplan);
//				if(id==0){
//					
//					if(parametroPlanEditBean!=null && parametroPlanEditBean.getCodsxp()!= null && parametroPlanEditBean.getEstado()!=0 ){
//						
//							model.addAttribute(Constants.MENSAJE_TIPO, "parametroPlanExistente");
//							model.addAttribute(Constants.MENSAJE_MOSTRAR,"Atributo ya existente");
//							
//							LOG.info(">>> retornando genericSave <<<");
//							return "planOperativo/planOperativoDetalleSave :: genericSave";
//					}
//				}
//				
//			} else {
//				parametroPlanEditBean = new ParametroPlan();  
//				parametroPlanEditBean.setCodsxp(codsxp);
//				parametroPlanEditBean.setCodplan(codplan);
//			
//				parametroPlanEditBean.setCodarea(codarea);
//				parametroPlanEditBean.setCodact(codact);
//				parametroPlanEditBean.setCodsubact(codsubact);
//			}
//		
//			parametroPlanEditBean.setParametro(allRequestParams.get("textparam"));
//			parametroPlanEditBean.setCodsxp(codsxp);
//			parametroPlanEditBean.setCodplan(codplan);
//			
//			parametroPlanEditBean.setCodarea(codarea);
//			parametroPlanEditBean.setCodact(codact);
//			parametroPlanEditBean.setCodsubact(codsubact);
//			
//			parametroPlanEditBean.setPrograma(Util.getPageCall());
//			parametroPlanEditBean.setUsuarioCreacion(Util.getUserLoged());
//			parametroPlanEditBean.setUsuarioModificacion(Util.getUserLoged());
//			
//			LOG.info("parametroPlanEditBean: " + parametroPlanEditBean);
//			model.addAttribute("parametroPlanEditBean", parametroPlanEditBean);
//
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//			
//		}
//		
//		return "planOperativo/planOperativoDetalleTableEdit :: form-edit-tablaPoisson";
//	}
//	
//	/*
//	 * Método que permite registrar y/o actualizar un registro de tabla Poisson
//	 * ModelMap es una interfaz de Map que permite la abstracción completa de la tecnología de vista
//	 * @Return Objeto de tipo Result que contiene los resultados
//	 * */
//	@RequestMapping(value = "/aprobarPlan/{idPlan}", method = RequestMethod.POST)
//	public String insertParametroPlanSave(ModelMap model, HttpServletRequest request, HttpSession session,
//			@ModelAttribute("parametroPlanEditBean") ParametroPlan parametroPlanEditBean,@PathVariable int idPlan) {
//
//		String strMensajeTipo = "";
//		String strMensajeError = "";
//	
//		PlanOperativo planOperativo = new PlanOperativo();
//		try {
//			planOperativo.setPrograma(Util.getPageCall());
//			planOperativo.setUsuarioModificacion(Util.getUserLoged());
//			planOperativo.setCodigoPlan(idPlan);
//			
//						LOG.info("planOperativo MODIFICAR: " + planOperativo);
//						planOperativo.setActivo(1);
//						planOperativo.setEstadoPlan(0);
//						planOperativoService.actualizarPlanOperativo(planOperativo);
//					
//			
//			strMensajeTipo = ConstantsCommon.GRABADO_OK;
//			model.addAttribute(Constants.MENSAJE_MOSTRAR,obtenerMensaje("parametro.plan.msg.guardado"));
//			
//		} catch (Exception e) {
//			strMensajeTipo = ConstantsCommon.GRABADO_NO_OK;
//			strMensajeError = e.getMessage();
//			LOG.info("ERROR",e);
//			
//		}
//		
//		model.addAttribute(Constants.MENSAJE_TIPO, strMensajeTipo);
//		model.addAttribute(Constants.MENSAJE_ERROR, strMensajeError);
//		
//		return "generic/genericSave :: genericSave";
//	}
//	
//	@RequestMapping(value = "/parametroPlanSave", method = RequestMethod.POST)
//	public String planOperativoSave(ModelMap model, HttpServletRequest request, HttpSession session,
//			@ModelAttribute("parametroPlanEditBean") ParametroPlan parametroPlanEditBean){
//
//		String strMensajeTipo = "";
//		String strMensajeError = "";
//		
//		parametroPlanEditBean.setPrograma(Util.getPageCall());
//		parametroPlanEditBean.setUsuarioCreacion(Util.getUserLoged());
//		parametroPlanEditBean.setUsuarioModificacion(Util.getUserLoged());
//		
//		try {
//			
//			LOG.info("getCodsxp: " + parametroPlanEditBean.getCodsxp());
//			LOG.info("getCodplan: " + parametroPlanEditBean.getCodplan());
//			LOG.info("getParametro: " + parametroPlanEditBean.getParametro());
//			
//			LOG.info("getCodarea: " + parametroPlanEditBean.getCodarea());
//			LOG.info("getCodact: " + parametroPlanEditBean.getCodact());
//			LOG.info("getCodsubact: " + parametroPlanEditBean.getCodsubact());
//			
//			boolean exists = planOperativoService.existeParametroPlan(parametroPlanEditBean.getCodsxp(), parametroPlanEditBean.getCodplan());
//				
//				LOG.info("exists: " + exists);
//				
//					if(exists) {
//						
//						LOG.info("parametroPlanEditBean MODIFICAR: " + parametroPlanEditBean);
//						parametroPlanEditBean.setEstado(1);
//						planOperativoService.actualizarParametroPlan(parametroPlanEditBean);
//					
//					} else {
//						
//						LOG.info("parametroPlanEditBean INSERTAR: " + parametroPlanEditBean);
//						parametroPlanEditBean.setEstado(1);
//						planOperativoService.insertarParametroPlan(parametroPlanEditBean);
//
//					}
//			
//			strMensajeTipo = ConstantsCommon.GRABADO_OK;
//			model.addAttribute(Constants.MENSAJE_MOSTRAR,obtenerMensaje("parametro.plan.msg.guardado"));
//			
//		} catch (Exception e) {
//			
//			strMensajeTipo = ConstantsCommon.GRABADO_NO_OK;
//			strMensajeError = e.getMessage();
//			LOG.info("ERROR",e);
//			
//		}
//		
//		model.addAttribute(Constants.MENSAJE_TIPO, strMensajeTipo);
//		
//		model.addAttribute(Constants.MENSAJE_ERROR, strMensajeError);
//		
//		return "planOperativo/planOperativoDetalleSave :: genericSave";
//	}
//
//	@RequestMapping(value = "/planOperativoDetalle/{codplan}", method = RequestMethod.GET)
//	public String tablaPoisson(HttpServletRequest request, HttpSession session,
//			@ModelAttribute("parametroPlanSearchBean") ParametroPlan parametroPlanSearchBean,
//			@ModelAttribute("parametroPlanEditBean") ParametroPlan parametroPlanEditBean,
//			@PathVariable int codplan,@RequestParam Map<String,String> allRequestParams,
//			Model model){
//		
//		LOG.info("icodplan2 :: "+ request.getParameter("codplan"));
//		LOG.info("icodplan3 :: "+ request.getQueryString());
//		LOG.info("icodpla4 :: "+ request.getScheme());
//		
//		model.addAttribute("codplan",codplan);
//		model.addAttribute("codDescPlan",allRequestParams.get("codDescPlan"));
//		model.addAttribute("descripcion",allRequestParams.get("descripcion"));
//		
//		return "planOperativo/planOperativoDetalle";
//	}
//	
//	@RequestMapping(value = "/planOperativoBandejaGet", method = RequestMethod.GET)
//	public String planOperativoGet(HttpServletRequest request, HttpSession session,
//			@ModelAttribute("planOperativoSearchBean") PlanOperativo planOperativoSearchBean,
//			@ModelAttribute("planOperativoEditBean") PlanOperativo planOperativoEditBean,
//			Model model,@RequestParam Map<String,String> allRequestParams){
//		
//		String  codplan = allRequestParams.get("codplan");
//		   
//		   if(!codplan.equals("0")){
//			   LOG.info("id codplan: " + codplan);
//
//			   model.addAttribute("codplan",codplan);
//			   model.addAttribute("codDescPlan",allRequestParams.get("codDescPlan"));
//			   model.addAttribute("descripcion",allRequestParams.get("descripcion"));
//			   model.addAttribute("codare",allRequestParams.get("codare")!=null?allRequestParams.get("codare"):1);
//			   return "planOperativo/planOperativoDetalleTable :: resultsList";
//		   }
//		   
//			model.addAttribute("planOperativoEditBean", new PlanOperativo());
//		
//		return "planOperativo/planOperativoBandejaTableEdit :: form-edit-tablaPoisson";
//	}
//	
//	public String obtenerMensaje(String messageProp){
//		return messageSource.getMessage(messageProp, new Object[] {}, Locale.US);
//	}
//	
//	/**************************************************************************** 
//	 ******************* METODOS PARA BANDJEA DE PLAN OPERATIVO *****************
//	 ****************************************************************************/
//	
//	@RequestMapping(value = "/planOperativo", method = RequestMethod.GET)
//	public String planOperativoBandeja(HttpServletRequest request, HttpSession session,
//			@ModelAttribute("planOperativoSearchBean") PlanOperativo planOperativoSearchBean,
//			@ModelAttribute("planOperativoEditBean") PlanOperativo planOperativoEditBean,
//			Model model){
//		
//		return "planOperativo/planOperativoBandeja";
//	}
//	
//	@RequestMapping(value = "/planOperativo/pagination", method = RequestMethod.POST)
//	public @ResponseBody ResponseEntity<Map<String,Object>> obtenerDatos(@RequestParam Map<String,String> allRequestParams)
//			throws Exception {
//		try {
//			PlanOperativo planOperativo = new PlanOperativo();
//			planOperativo.setCodare(-1);
//			Paginacion paginacion = new Paginacion();
//			paginacion.setCantidadpag(Integer.parseInt(allRequestParams.get("length")));
//			paginacion.setPagdesde(Integer.parseInt(allRequestParams.get("start")));
//			paginacion.setColorderby( Integer.parseInt(allRequestParams.get("order[0][column]"))==0?Integer.parseInt(allRequestParams.get("order[0][column]"))+1:Integer.parseInt(allRequestParams.get("order[0][column]")));
//			paginacion.setColorderbydir(allRequestParams.get("order[0][dir]"));
//			
//			Result result = planOperativoService.obtenerDatosPlanOperativo(planOperativo, paginacion);
//			
//			Map<String,Object> dtResponse = new HashMap<String, Object>();
//			dtResponse.put("draw", allRequestParams.get("draw"));
//			dtResponse.put("recordsTotal", result.getRecords());
//			dtResponse.put("recordsFiltered", result.getRecords());
//			dtResponse.put("data", result.getData());
//			
//			return new ResponseEntity<Map<String,Object>>(dtResponse, HttpStatus.OK);
//		} catch (Exception e) {		
//			LOG.error(e.getMessage(), e);	
//			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//		}
//	}
//	
//	@RequestMapping(value = "/planOperativo/pagination/{id}", method = RequestMethod.POST)
//	public @ResponseBody ResponseEntity<Map<String,Object>> obtenerDatosFiltroArea(@RequestParam Map<String,String> allRequestParams,@PathVariable int id)
//			throws Exception {
//		try {
//			PlanOperativo planOperativo = new PlanOperativo();
//			planOperativo.setCodare(id);
//			Paginacion paginacion = new Paginacion();
//			paginacion.setCantidadpag(Integer.parseInt(allRequestParams.get("length")));
//			paginacion.setPagdesde(Integer.parseInt(allRequestParams.get("start")));
//			paginacion.setColorderby( Integer.parseInt(allRequestParams.get("order[0][column]"))==0?Integer.parseInt(allRequestParams.get("order[0][column]"))+1:Integer.parseInt(allRequestParams.get("order[0][column]")));
//			paginacion.setColorderbydir(allRequestParams.get("order[0][dir]"));
//			
//			Result result = planOperativoService.obtenerDatosPlanOperativo(planOperativo, paginacion);
//			
//			Map<String,Object> dtResponse = new HashMap<String, Object>();
//			dtResponse.put("draw", allRequestParams.get("draw"));
//			dtResponse.put("recordsTotal", result.getRecords());
//			dtResponse.put("recordsFiltered", result.getRecords());
//			dtResponse.put("data", result.getData());
//			
//			return new ResponseEntity<Map<String,Object>>(dtResponse, HttpStatus.OK);
//		} catch (Exception e) {		
//			LOG.error(e.getMessage(), e);	
//			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//		}
//	}
//	
//	@RequestMapping(value = "/planOperativoSave", method = RequestMethod.POST)
//	public String planOperativoSave(ModelMap model, HttpServletRequest request, HttpSession session,
//			@ModelAttribute("planOperativoEditBean") PlanOperativo planOperativoEditBean){
//
//		String strMensajeTipo = "";
//		String strMensajeError = "";
//		
//		planOperativoEditBean.setUsuarioCreacion(Util.getUserLoged());
//		planOperativoEditBean.setUsuarioModificacion(Util.getUserLoged());
//		
//		try {
//			
//				LOG.info("cod des: "+planOperativoEditBean.getCodigoDescripcionPlan());
//				LOG.info("desc: "+planOperativoEditBean.getDescripcion());
//				LOG.info("codarea: "+planOperativoEditBean.getCodare());
//				planOperativoEditBean.setPrograma(ConstantsLaboratorio.PRG_INSERT_PLAN);
//				planOperativoEditBean.setEstadoPlan(Constants.ACTIVO);
//				planOperativoEditBean.setActivo(Constants.INACTIVO);
//				planOperativoEditBean.setCodare(planOperativoEditBean.getCodare());
//				
//				planOperativoService.grabarPlanOperativo(planOperativoEditBean);
//				strMensajeTipo = ConstantsCommon.GRABADO_OK;
//				model.addAttribute(Constants.MENSAJE_MOSTRAR,obtenerMensaje("plan.operativo.msg.guardado"));
//				
//				
//		} catch (Exception e) {
//			
//			strMensajeTipo = ConstantsCommon.GRABADO_NO_OK;
//			strMensajeError = e.getMessage();
//			e.printStackTrace();
//			
//		}
//		
//		model.addAttribute("mensajeTipo", strMensajeTipo);
//		model.addAttribute("mensajeError", strMensajeError);
//		return "planOperativo/planOperativoBandejaSave :: planOperativoBandejaSave";
//	}
//	
//	@RequestMapping(value = "/inactivarPlanOperativo/{codplan}", method = RequestMethod.POST)
//	public String inactivarPlanOperativo(ModelMap model, HttpServletRequest request, HttpSession session,
//			@RequestParam Map<String,String> allRequestParams,@PathVariable int codplan) {
//
//		String strMensajeTipo = "";
//		String strMensajeError = "";
//		
//		PlanOperativo planOperativo = new PlanOperativo();
//		
//		try {
//			planOperativo.setPrograma(Util.getPageCall());
//			planOperativo.setUsuarioModificacion(Util.getUserLoged());
//			planOperativo.setCodigoPlan(codplan);
//
//			LOG.info("planOperativo MODIFICAR: " + planOperativo);
//			
//			planOperativo.setActivo(Constants.INACTIVO);
//			planOperativo.setEstadoPlan(Constants.ACTIVO);
//			planOperativoService.actualizarPlanOperativo(planOperativo);
//			
//			strMensajeTipo = ConstantsCommon.GRABADO_OK;
//			model.addAttribute(Constants.MENSAJE_MOSTRAR,obtenerMensaje("parametro.plan.msg.removido"));
//			
//		} catch (Exception e) {
//			
//			strMensajeTipo = ConstantsCommon.GRABADO_NO_OK;
//			strMensajeError = e.getMessage();
//			LOG.info("ERROR",e);
//			
//		}
//		
//		model.addAttribute(Constants.MENSAJE_TIPO, strMensajeTipo);
//		model.addAttribute(Constants.MENSAJE_ERROR, strMensajeError);
//		return "planOperativo/planOperativoBandejaSave :: planOperativoBandejaSave";
//	}
//	
//	@RequestMapping(value = "/inactivarParametroPlan", method = RequestMethod.POST)
//	public String inactivarParametroPlan(ModelMap model, HttpServletRequest request, HttpSession session,
//			@RequestParam Map<String,String> allRequestParams) {
//
//		String strMensajeTipo = "";
//		String strMensajeError = "";
//		
//		ParametroPlan parametroPlan = new ParametroPlan();
//		try {
//			
//			LOG.info("User logged: " + Util.getUserLoged());
//			LOG.info("parametroPlan MODIFICAR: " + parametroPlan);
//			LOG.info("codsxp: " + allRequestParams.get("codsxp"));
//			LOG.info("codplan: " + allRequestParams.get("codplan"));
//			
//			parametroPlan.setPrograma(Util.getPageCall());
//			parametroPlan.setUsuarioModificacion(Util.getUserLoged());
//			parametroPlan.setCodsxp(Integer.parseInt(allRequestParams.get("codsxp")));
//			parametroPlan.setCodplan(Integer.parseInt(allRequestParams.get("codplan")));
//			parametroPlan.setEstado(Constants.INACTIVO);
//			
//			planOperativoService.inactivarParametroPlan(parametroPlan);
//			strMensajeTipo = ConstantsCommon.GRABADO_OK;
//			model.addAttribute(Constants.MENSAJE_MOSTRAR,obtenerMensaje("parametro.plan.msg.removido"));
//			
//		} catch (Exception e) {
//			
//			strMensajeTipo = ConstantsCommon.GRABADO_NO_OK;
//			strMensajeError = e.getMessage();
//			LOG.info("ERROR",e);
//		}
//		
//		model.addAttribute(Constants.MENSAJE_TIPO, strMensajeTipo);
//		model.addAttribute(Constants.MENSAJE_ERROR, strMensajeError);
//		
//		return "planOperativo/planOperativoDetalleSave :: genericSave";
//	}
//	
//	@RequestMapping(value = "/pruebaSave", method = RequestMethod.POST)
//	public String planOperativoSave(ModelMap model, HttpServletRequest request, HttpSession session
//		 ){
//
//				model.addAttribute(Constants.MENSAJE_MOSTRAR,obtenerMensaje("plan.operativo.msg.guardado"));
//	
//		model.addAttribute("mensajeTipo", ConstantsCommon.GRABADO_OK);
//		model.addAttribute("mensajeError", "");
//		return "planOperativo/planOperativoBandejaSave :: planOperativoBandejaSave";
//	}
//	
//}
