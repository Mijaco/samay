package pe.com.sedapal.scr.web.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

public class Util {
	public static String getPageCall(){
		String strProgram = "";
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
		strProgram = request.getHeader("Referer");
		strProgram = strProgram.substring(strProgram.lastIndexOf("/")+1);
		return strProgram;
	}
	
	public static String getUserLoged(){
		String strUser = "";
		//TODO implemetar la logica para obtener el usuario logeado
		return strUser;
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
	
	public static String StringToUPPER(String campo){
		String cadena = "";
		if(campo!=null && !campo.trim().equals("")){
			cadena = campo.toUpperCase();
		}
		
		return cadena;
	}
	
/*	public static void main(String[] args) {
		Util.StringToUPPER(null);
		
	}*/

}
