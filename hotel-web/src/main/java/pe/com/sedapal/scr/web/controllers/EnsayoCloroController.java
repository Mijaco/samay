package pe.com.sedapal.scr.web.controllers;

import java.util.HashMap;
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
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import pe.com.sedapal.common.core.beans.Paginacion;
import pe.com.sedapal.common.core.beans.Result;
import pe.com.sedapal.common.core.utils.ConstantsCommon;
import pe.com.sedapal.scr.core.beans.EnsayoCloro;
import pe.com.sedapal.scr.core.beans.ReportePlanOperativo;
import pe.com.sedapal.scr.core.services.IEnsayoCloroService;
import pe.com.sedapal.scr.web.common.Constants;

@Controller
@PropertySources(value = { @PropertySource(name = "props", value = {
		"classpath:application.properties" }, ignoreResourceNotFound = true) })
public class EnsayoCloroController {

	private static final Logger LOG = LoggerFactory.getLogger(EnsayoCloroController.class);

	@Autowired
	Environment env;

	@Autowired
	MessageSource messageSource;

	@Autowired
	IEnsayoCloroService ensayoCloroService;
	
	@RequestMapping(value = "/ensayoCloroSave", method = RequestMethod.POST)
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
	
	@RequestMapping(value = "/ensayoCloroPlanta", method = RequestMethod.GET)
	public String planOperativoGet(HttpServletRequest request, HttpSession session,
			@ModelAttribute("ensayoCloroSearchBean") EnsayoCloro ensayoCloroSearchBean,
			@ModelAttribute("ensayoCloroEditBean") EnsayoCloro ensayoCloroEditBean,
			Model model,@RequestParam Map<String,String> allRequestParams){
			
			return "ensayoCloro/ensayoCloro";
	}
//	
//	@RequestMapping(value = "/refrescarTablaFiltradaXArea", method = RequestMethod.GET)
//	public String refrescarTablaFiltradaXArea(HttpServletRequest request, HttpSession session,
//			Model model,@RequestParam Map<String,String> allRequestParams){
//			return "reportePlanOperativo/reportePlanBandeja :: resultsList";
//	}
	
	
	
	@RequestMapping(value = "/buscarEnsayoCloroSearch", method = RequestMethod.POST)
	public String buscarReportePlan(HttpServletRequest request, HttpSession session,
			@ModelAttribute("ensayoCloroSearchBean") EnsayoCloro ensayoCloroSearchBean,
			@ModelAttribute("ensayoCloroEditBean") EnsayoCloro ensayoCloroEditBean,
			Model model,@RequestParam Map<String,String> allRequestParams){
		
			/// alterno
//			String mes = allRequestParams.get("idMes");
//			String codpla = allRequestParams.get("codplan");
//			String codare = allRequestParams.get("codare");
//			String codDesc = allRequestParams.get("codDesc");
//			String descPlan = allRequestParams.get("descPlan");
//			
//			LOG.info("mes : " + mes);
//			LOG.info("codpla : " + codpla);
//			LOG.info("codare : " + codare);
//			LOG.info("codplan : " + codpla);
//		
//			List<ParametroReporte> parametrosbd = planOperativoService.obtenerReportePlanOperativo(Integer.parseInt(codpla),Integer.parseInt(codare), mes);
//			reportePlanEditBean = obtenerReportePlanOperativo(parametrosbd, mes);
//			reportePlanEditBean.setCodDescPlan(codDesc);
//			reportePlanEditBean.setDescripcion(descPlan);
//			reportePlanEditBean.setCodplan(Integer.parseInt(codpla));
//		    reportePlanEditBean.setMes(mes);
//			reportePlanEditBean.setCodare(Integer.parseInt(codare));
//			
//			model.addAttribute("reportePlanEditBean",reportePlanEditBean);
//			
			return "ensayoCloro/ensayoCloroTable :: resultsList";
	}
	

	@RequestMapping(value = "/ensayoCloro/pagination/{fechaMuestreo}", method = RequestMethod.POST)
	public @ResponseBody ResponseEntity<Map<String,Object>> obtenerDatos(@RequestParam Map<String,String> allRequestParams,@PathVariable String fechaMuestreo)
			throws Exception {
		try {
			
			EnsayoCloro ensayoCloro = new EnsayoCloro();
			int estadoAprobado = Constants.ACTIVO;
			
			LOG.info("fechaMuestreo : " + fechaMuestreo);
			
			Paginacion paginacion = new Paginacion();
			paginacion.setCantidadpag(Integer.parseInt(allRequestParams.get("length")));
			paginacion.setPagdesde(Integer.parseInt(allRequestParams.get("start")));
			paginacion.setColorderby(Integer.parseInt(allRequestParams.get("order[0][column]"))==0?Integer.parseInt(allRequestParams.get("order[0][column]"))+1:Integer.parseInt(allRequestParams.get("order[0][column]")));
			paginacion.setColorderbydir(allRequestParams.get("order[0][dir]"));
			
			ensayoCloro.setFechaMuestreo(fechaMuestreo);

			Result result = ensayoCloroService.obtenerDatosEnsayoCloro(ensayoCloro, paginacion);
			LOG.info("DATA : " + result.getData());
			
			Map<String,Object> dtResponse = new HashMap<String, Object>();
			dtResponse.put("draw", allRequestParams.get("draw"));
			dtResponse.put("recordsTotal", result.getRecords());
			dtResponse.put("recordsFiltered", result.getRecords());
			dtResponse.put("data", result.getData());
					
			dtResponse.put("aprobado", estadoAprobado);
			
			return new ResponseEntity<Map<String,Object>>(dtResponse, HttpStatus.OK);
			
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	private String obtenerMensaje(String messageProp){
		
		return messageSource.getMessage(messageProp, new Object[] {}, Locale.US);
		
	}
	
	
}
