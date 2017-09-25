package pe.com.sedapal.scr.web.controllers;

import java.util.ArrayList;
import java.util.List;
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
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import pe.com.sedapal.scr.core.beans.PlanOperativo;
import pe.com.sedapal.scr.core.beans.ReporteEnsayoCloro;
import pe.com.sedapal.scr.core.beans.ReporteEnsayoCloroResult;
import pe.com.sedapal.scr.core.services.IParametroXSubactividadService;
import pe.com.sedapal.scr.core.services.IPlanOperativoService;

@Controller
@PropertySources(value = { @PropertySource(name = "props", value = {
		"classpath:application.properties" }, ignoreResourceNotFound = true) })
public class ReporteEnsayoCloroController {
	private static final Logger LOG = LoggerFactory.getLogger(PlanOperativoController.class);

	@Autowired
	Environment env;

	@Autowired
	MessageSource messageSource;

	@Autowired
	IParametroXSubactividadService parametroXSubactividadService;

	@Autowired
	IPlanOperativoService planOperativoService;
	
	@RequestMapping(value = "/reporteEnsayoCloro", method = RequestMethod.GET)
	public String planOperativoBandeja(HttpServletRequest request, HttpSession session,
			@ModelAttribute("planOperativoSearchBean") PlanOperativo planOperativoSearchBean,
			@ModelAttribute("planOperativoEditBean") PlanOperativo planOperativoEditBean,
			Model model){
		
		return "reporteEnsayoCloro/reporteEnsayoCloro";
	}
	

	@RequestMapping(value = "/reporteEnsayoCloroSearch", method = RequestMethod.POST)
	public String reporteEnsayoCloroSearch(HttpServletRequest request, HttpSession session,
			@ModelAttribute("reporteEnsayoCloroBean") ReporteEnsayoCloro reporteEnsayoCloroBean,
			Model model,@RequestParam Map<String,String> allRequestParams){
		
			/// alterno
			String fechaMuestreo = allRequestParams.get("fechaMuestreo");
			String horaMuestreo = allRequestParams.get("horaMuestreo");
	
			
			LOG.info("fechaMuestreo : " + fechaMuestreo);
			LOG.info("horaMuestreo : " + horaMuestreo);
			
			List<ReporteEnsayoCloroResult> parametrosbd = new ArrayList<>();
			
			ReporteEnsayoCloroResult bean = new ReporteEnsayoCloroResult();
			bean.setCloroResidualLibre(4D);
			bean.setCloroResidualTotal(10D);
			bean.setCodigoArea(1);
			bean.setCorrelativo(1);
			bean.setPuntoMuestra(1);
			bean.setDosisClor(20D);
			bean.setPh(9D);
			parametrosbd.add(bean);
			ReporteEnsayoCloro reporteEnsayoCloroBeanBD = new ReporteEnsayoCloro();
			reporteEnsayoCloroBeanBD.setDetalles(parametrosbd);
			
			reporteEnsayoCloroBean = reporteEnsayoCloroBeanBD;
			model.addAttribute("reporteEnsayoCloroBean", reporteEnsayoCloroBean);
			
			return "reporteEnsayoCloro/reporteEnsayoCloroTable :: resultsList";
	}
	

}
