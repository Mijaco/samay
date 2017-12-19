package pe.com.sedapal.scr.core.services.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.sedapal.scr.core.beans.Formulario312;
import pe.com.sedapal.scr.core.beans.Reporte312Bean;
import pe.com.sedapal.scr.core.beans.ReporteForm312Bean;
import pe.com.sedapal.scr.core.common.ConstantsLaboratorio;
import pe.com.sedapal.scr.core.dao.IFormulario312Dao;
import pe.com.sedapal.scr.core.services.IFormulario312Service;
import pe.com.sedapal.scr.core.util.Utils;

@Service
public class Formulario312ServiceImpl implements IFormulario312Service {
	
	@Autowired
	private IFormulario312Dao iFormulario312Dao;

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public ReporteForm312Bean generarReporteResumenGrafico(String periodo, String[] ensayo) throws Exception {
		
		boolean bolFiltraTipoEnsayo = (ensayo!=null && periodo!=null && !periodo.trim().equals(""));
		ReporteForm312Bean wrapper = new ReporteForm312Bean();
		Map<String, List> mapa = new HashMap <String, List>();
		List<Formulario312> lista = new ArrayList<>();
		List<Reporte312Bean> lstresult = new ArrayList<>();
		Reporte312Bean result = null;
		
//		if(bolFiltraTipoEnsayo){
			lista = iFormulario312Dao.generarReporte(periodo);
//		}
		
		for (Formulario312 rp : lista) {
			if(Utils.valueInCollection(ensayo, rp.getTipoEnsayo()+"")){
				Object obj = new Object[]{rp.getDia(), rp.getRsd()};
				if(!mapa.containsKey(rp.getStrTipoEnsayo())){
					mapa.put(rp.getStrTipoEnsayo(), new ArrayList());
				}
				mapa.get(rp.getStrTipoEnsayo()).add(obj);
			}
		}
		
		for (String strKey : mapa.keySet()) {
			result = new Reporte312Bean();
			result.setLabel(strKey);
			result.setData(mapa.get(strKey));
			lstresult.add(result);
		}
		
		// Obtenermos mes y anio y num de dias
		if(periodo!=null&&periodo.trim().length() == 6){
			String anio = periodo.substring(0, 4);
			String mes = periodo.substring(4, periodo.length());
			String mesTexto = Utils.getMonthName(mes);
			wrapper.setStrEjexTitulo(ConstantsLaboratorio.REP_GRAF1_X_TITULO.replace(ConstantsLaboratorio.PARAM1, mesTexto).
					replace(ConstantsLaboratorio.PARAM2, anio));
			wrapper.setIntDiasPeriodo(Utils.daysOfMonthFromPeriod(periodo.trim()));
		}
		else{
			wrapper.setStrEjexTitulo(ConstantsLaboratorio.REP_GRAF1_X_TITULO_UNDEFINED);
			wrapper.setIntDiasPeriodo(ConstantsLaboratorio.REP_GRAF1_DIAS_DEFAULT);
		}
		
		wrapper.setStrEjeyTitulo(ConstantsLaboratorio.REP_GRAF1_Y_TITULO);
		wrapper.setLstDataReporte(lstresult);
		
		return wrapper;
	}



}
