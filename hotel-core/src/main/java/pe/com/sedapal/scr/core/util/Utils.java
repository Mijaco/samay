package pe.com.sedapal.scr.core.util;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

import pe.com.sedapal.common.core.utils.DateUtils;
import pe.com.sedapal.scr.core.common.Constants;
public class Utils {
	
	public static String evalMathExpression(String strMathExpression) throws ScriptException{
		ScriptEngineManager mgr = new ScriptEngineManager();
	    ScriptEngine engine = mgr.getEngineByName("JavaScript");
		return String.valueOf(engine.eval(strMathExpression));
	}
	

	
	public static String StringToUPPER(String campo){
		String cadena = "";
		if(campo!=null && !campo.trim().equals("")){
			cadena = campo.toUpperCase();
		}
		
		return cadena;
	}
	
	public static java.sql.Date getDateOracle(String campo){
		java.sql.Date f1sql = null;
		DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		try {
			if(!campo.trim().equals("")){
				java.util.Date f1 = formatter.parse(campo);				
				f1sql = new java.sql.Date(f1.getTime());
			}
		} catch (ParseException e) {
			f1sql=null;
		}
		return f1sql;
	}
	
	public static String convertirFechaString(Date fecha) {
		String resultado = "";
		try {
			SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
			if(fecha!=null){
				resultado = df.format(fecha);
			}
		} catch (Exception e) {
			resultado = "";


		}
		return resultado;
	}
	
	public static String formatFechaStringddMMYYY(java.sql.Date fecha){
		String resultado = "";
		try {
			SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
			if(fecha!=null){
				resultado = df.format(fecha);
			}
		} catch (Exception e) {
			resultado = "";
		}
		return resultado;
	}
	

	/**
	 * Método que permite validar la precisión de un texto numérico decimal
	 * @param strValue Es el valor que se quiere validar
	 * @param intDigEnt Es el número de dígitos permitidos en la parte entera del dato
	 * @param intDigDec Es el número de dígitos permitidos en la parte decimal del dato
	 * @Return boolean que informa si el decimal es o no válido
	 */
	public static boolean longValidInputDecimal(String strValue, int intDigEnt, int intDigDec){
		String strNum = strValue;
		if(strNum.contains(".")){
			String[] parts = strNum.split("\\.");
			return (parts[0].length() <= intDigEnt && parts[1].length() <= intDigDec);
		}
		else{
			return (strNum.length() <= intDigEnt);
		}
	}
	
	/**
	 * Método que permite saber si un texto está en una lista de textos
	 * @param value Es el valor que se busca en la colección
	 * @param collection Es la colección donde se busca
	 * @Return boolean que informa si el texto se encuentra en la colección
	 */
	public static boolean valueInCollection(String[] collection, String value){
		for(String elemento : collection){
			if(elemento.equals(value)){
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Método que permite obtener el número literal del día actual
	 * @Return entero con el resultado
	 * @throws Exception Excepción que puede ser lanzada
	 */
	public static int getActualDate() throws Exception{
		Calendar cal = DateUtils.getCalendar();
		int day = cal.get(Calendar.DATE);
		return day;
	}
	
	/**
	 * Método que permite saber si un periodo es el periodo actual
	 * @param periodo Es el periodo del que se quiere saber si es el actual
	 * @Return booleano que indica si es o no el periodo actual
	 * @throws Exception Excepción que puede ser lanzada
	 */
	public static boolean isActualPeriod(String period) throws Exception{
		Calendar cal = DateUtils.getCalendar();
		String year = String.valueOf(cal.get(Calendar.YEAR));
		String month = String.format("%02d", cal.get(Calendar.MONTH) + 1);
		String periodoActual = year+month;
		return periodoActual.equals(period);
	}
	
	/**
	 * Método que permite saber la cantidad de días que tiene un periodo específico (período está a nivel de mes)
	 * @param period Es el periodo del que se quiere saber la cantidad de días
	 * @Return entero con la información de días
	 * @throws Exception Excepción que puede ser lanzada
	 */
	public static int daysOfMonthFromPeriod(String period) throws Exception{
		Date date = DateUtils.toYyyyMMddToDate(period+"01");
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		return cal.getActualMaximum(Calendar.DAY_OF_MONTH);
	}
	
	/**
	 * Método que permite saber si una fecha en un determinado formato es válido
	 * @param date es la fecha que se desea validar
	 * @param formatParse es el formato en el que está la fecha
	 * @Return booleano que indica si la fecha es o no válida
	 */
	public static boolean isValidDate(String date, String formatParse){
		String formatString = formatParse == null ? "dd/MM/yyyy" : formatParse;
        try {
            SimpleDateFormat format = new SimpleDateFormat(formatString);
            format.setLenient(false);
            format.parse(date);
        } catch (ParseException e) {
            return false;
        } catch (IllegalArgumentException e) {
            return false;
        }
        return true;
	}
	
	/**
	 * Método que permite validar la precisión de un texto numérico decimal
	 * @param num Es el valor que se quiere validar
	 * @param numInts Es el número de dígitos permitidos en la parte entera del dato
	 * @param numFloats Es el número de dígitos permitidos en la parte decimal del dato
	 * @Return boolean que informa si el decimal válido o no
	 */
	public static boolean isValidDecimal(String num, int numInts, int numFloats){
		return num.matches(Constants.REGEX_DECIMAL_NUMBERS.replace(Constants.PARAM1, numInts+"").replace(Constants.PARAM2, numFloats+""));
	}
	
	public static void main(String[] args) {
		System.out.println("-1.2".matches("^\\d{1,2}(\\.\\d{1,4})?$"));
	}
	
	/**
	 * Método que permite calcular el promedio de una lista de cadenas de texto numéricas
	 * @param row Es la lista de valores que se quieren promediar
	 * @Return Objeto de tipo String con el promedio de los datos
	 */
	public static String calculateRowAverage(List<String> row){
		List<String> data = row;
		boolean bolExisteAlMenosUnDatoFila = false;
		double dblCaudalPromedioDia = 0;
		int contadorDatos = 0;
		for(String cell : data){
			if(!cell.trim().equals("")){
				// Si encuentra alguna celda con dato
				bolExisteAlMenosUnDatoFila = true;
				try {
					dblCaudalPromedioDia = dblCaudalPromedioDia + Double.parseDouble(cell.toString());
					contadorDatos++;
				} catch (Exception e) {
				}
			}
		}
		dblCaudalPromedioDia = dblCaudalPromedioDia / contadorDatos;
		dblCaudalPromedioDia = Math.round(dblCaudalPromedioDia * 10000)/10000D;
		// Si es que existe dato, retornar el promedio, sino vacio para que no lo compare en las matrices
		if(bolExisteAlMenosUnDatoFila){
			// para evitar la notacion exponencial PE: 12.3434E4
			return new BigDecimal(dblCaudalPromedioDia + "").stripTrailingZeros().toPlainString();
		}else{
			return "";
		}
	}
	
	/**
	 * Método que permite comparar una fecha (en un determinado formato) con la actual
	 * @param date es la fecha que se desea comparar con la actual
	 * @param formatParse es el formato en el que está la fecha a comparar
	 * @Return entero con el resultado de la comparación
	 */
	public static int compareWithToday(String date, String formatParse){
		String formatString = formatParse == null ? "dd/MM/yyyy" : formatParse;
		try {
            SimpleDateFormat format = new SimpleDateFormat(formatString);
            Date input = format.parse(date);
            Date today = new Date();
            return input.compareTo(today);
        } catch (Exception e) {
        	e.printStackTrace();
        }
		return 0;
	}
	
	/**
	 * Método que permite obtener el literal del día y el periodo a raíz de una fecha en formato dd/MM/yyyy
	 * @param strDate es la fecha que se desea disgregar
	 * @Return mapa con info de día y periodo
	 */
	public static Map<String, String> getDayAndPeriodFromDate(String strDate){
		if(strDate.length() == 10){
			strDate = strDate.substring(0, 10);
		}
		else if(strDate.length() == 9){
			strDate = strDate.substring(0, 9);
		}
		Map<String, String> informacion = new HashMap<>();
		try {
			String[] valuesDate = strDate.split("/");
			informacion.put("dia", valuesDate[0]);
			informacion.put("periodo", valuesDate[2] + valuesDate[1]);
		} catch (Exception e) {
		}
		return informacion;
	}
	
	/**
	 * Método que permite obtener un mes en texto en base a su valor numérico
	 * @param monthNumber es el mes en formato numérico
	 * @Return Objeto de tipo String con el resultado
	 */
	public static String getMonthName(String monthNumber){
		switch (monthNumber) {
		case "01":
			return "ENERO";
		case "02":
			return "FEBRERO";
		case "03":
			return "MARZO";
		case "04":
			return "ABRIL";
		case "05":
			return "MAYO";
		case "06":
			return "JUNIO";
		case "07":
			return "JULIO";
		case "08":
			return "AGOSTO";
		case "09":
			return "SETIEMBRE";
		case "10":
			return "OCTUBRE";
		case "11":
			return "NOVIEMBRE";
		case "12":
			return "DICIEMBRE";
		default:
			return "";
		}
	}

}
