package pe.com.sedapal.scr.core.common;

public class MessagesHtml {

	public static final String NEWLINE = "<br />";
	
	public static final String PARAMETRO_1 = "{param_1}";
	public static final String PARAMETRO_2 = "{param_2}";

	/////////////////////// REPORTE DE GERENCIA
	public static final String REPORTE_GERENCIA_TABLE_INIT = "<table border='0' cellspacing='0' cellpadding='0' width='700' style='width:524.75pt;border-collapse:collapse'>";
	public static final String REPORTE_GERENCIA_TABLE_END = "</table>";
	public static final String REPORTE_GERENCIA_TABLE_BODY_INIT = "<tbody>";
	public static final String REPORTE_GERENCIA_TABLE_BODY_END = "</tbody>";
	public static final String REPORTE_GERENCIA_HEADER = "<tr style='height:18.0pt'>                                                                                                                                                                             "
			+ "   <td width='143' style='width:107.0pt;border:solid windowtext 1.0pt;background:#dbe5f1;padding:0cm 3.5pt 0cm 3.5pt;height:18.0pt'>                                                                   "
			+ "      <p style='text-align:center'><b><span style='font-size:10.0pt;font-family:&quot;Tahoma&quot;,&quot;sans-serif&quot;;color:navy'>Embalse</span></b><u></u><u></u></p>                             "
			+ "   </td>                                                                                                                                                                                               "
			+ "   <td width='127' style='width:95.0pt;border:solid windowtext 1.0pt;border-left:none;background:#dbe5f1;padding:0cm 3.5pt 0cm 3.5pt;height:18.0pt'>                                                   "
			+ "      <p style='text-align:center'><b><span style='font-size:10.0pt;font-family:&quot;Tahoma&quot;,&quot;sans-serif&quot;;color:navy'>Volumen Estimado al "
			+ PARAMETRO_1 + "                              "
			+ "         (MMC)</span></b><u></u><u></u>                                                                                                                                                                "
			+ "      </p>                                                                                                                                                                                             "
			+ "   </td>                                                                                                                                                                                               "
			+ "   <td width='128' valign='top' style='width:95.95pt;border:solid windowtext 1.0pt;border-left:none;background:#dbe5f1;padding:0cm 0cm 0cm 0cm;height:18.0pt'>                                         "
			+ "      <p style='text-align:center'><b><span style='font-size:10.0pt;font-family:&quot;Tahoma&quot;,&quot;sans-serif&quot;;color:navy'>Capacidad de Almacenamiento (MMC)</span></b><u></u><u></u></p>   "
			+ "   </td>                                                                                                                                                                                               "
			+ "   <td width='302' style='width:8.0cm;border:solid windowtext 1.0pt;border-left:none;background:#dbe5f1;padding:0cm 3.5pt 0cm 3.5pt;height:18.0pt'>                                                    "
			+ "      <p style='text-align:center'><b><span style='font-size:10.0pt;font-family:&quot;Tahoma&quot;,&quot;sans-serif&quot;;color:navy'>Comentarios</span></b><u></u><u></u></p>                         "
			+ "   </td>                                                                                                                                                                                               "
			+ "</tr>   ";
	public static final String REPORTE_GERENCIA_TABLE_ROW_INIT = "<tr>";
	public static final String REPORTE_GERENCIA_TABLE_ROW_END = "</tr>";

	public static final String REPORTE_GERENCA_TABLE_BODY_COL1 = "<td style='width:107.0pt;border:solid windowtext 1.0pt;border-top:none;padding:0cm 3.5pt 0cm 3.5pt;height:12.75pt'> "
			+ "<p><span style='font-size:8.0pt;font-family:&quot;Tahoma&quot;,&quot;sans-serif&quot;;color:navy'>"
			+ PARAMETRO_1 + "</span><u></u><u></u></p>" + "</td>";
	public static final String REPORTE_GERENCA_TABLE_BODY_COL2 = "<td style='width:95.0pt;border-top:none;border-left:none;border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;padding:0cm 3.5pt 0cm 3.5pt;height:12.75pt'> "
			+ "<p style='text-align:center'><span style='font-size:8.0pt;font-family:&quot;Tahoma&quot;,&quot;sans-serif&quot;;color:navy'>"
			+ PARAMETRO_1 + "</span><u></u><u></u></p>" + "</td>";
	public static final String REPORTE_GERENCA_TABLE_BODY_COL3 = "<td style='width:95.95pt;border-top:none;border-left:none;border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;padding:0cm 0cm 0cm 0cm;height:12.75pt'>"
			+ "<p style='text-align:center'><span style='font-size:8.0pt;font-family:&quot;Tahoma&quot;,&quot;sans-serif&quot;;color:navy'>"
			+ PARAMETRO_1 + "</span><u></u><u></u></p>" + "</td>";
	public static final String REPORTE_GERENCA_TABLE_BODY_COL4 = "<td style='width:8.0cm;border-top:none;border-left:none;border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;padding:0cm 3.5pt 0cm 3.5pt;height:12.75pt'> "
			+ "<p ><span style='font-size:8.0pt;font-family:&quot;Tahoma&quot;,&quot;sans-serif&quot;;color:navy'>"+PARAMETRO_1+"</span><u></u><u></u></p>"
			+ "</td>";
	
	public static final String REPORTE_GERENCA_TABLE_BODY_COL1_SIN = "<td style='width:107.0pt;border:solid windowtext 1.0pt;border-top:none;padding:0cm 3.5pt 0cm 3.5pt;height:29.25pt'>"
			+ "<p><b><span style='font-size:8.0pt;font-family:&quot;Tahoma&quot;,&quot;sans-serif&quot;;color:#e46c0a'>"
			+ PARAMETRO_1 + "</span></b><u></u><u></u></p>" + "</td>";
	public static final String REPORTE_GERENCA_TABLE_BODY_COL2_SIN = "<td style='width:95.0pt;border-top:none;border-left:none;border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;padding:0cm 3.5pt 0cm 3.5pt;height:29.25pt'>"
			+ "<p style='text-align:center'><b><span style='font-size:8.0pt;font-family:&quot;Tahoma&quot;,&quot;sans-serif&quot;;color:#e46c0a'>"
			+ PARAMETRO_1 + "</span></b><u></u><u></u></p>" + "</td>";
	public static final String REPORTE_GERENCA_TABLE_BODY_COL3_SIN = "<td style='width:95.95pt;border-top:none;border-left:none;border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;padding:0cm 0cm 0cm 0cm;height:29.25pt'>"
			+ "<p style='text-align:center'><b><span style='font-size:8.0pt;font-family:&quot;Tahoma&quot;,&quot;sans-serif&quot;;color:#e46c0a'>"
			+ PARAMETRO_1 + "</span></b><u></u><u></u></p>" + "</td>";
	public static final String REPORTE_GERENCA_TABLE_BODY_COL4_SIN = "<td style='width:8.0cm;border-top:none;border-left:none;border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;padding:0cm 3.5pt 0cm 3.5pt;height:29.25pt'>"
			+ PARAMETRO_1 + "</td>";
	
	public static final String REPORTE_GERENCA_TABLE_BODY_COL1_TOT = "<td style='width:107.0pt;border:solid windowtext 1.0pt;border-top:none;padding:0cm 3.5pt 0cm 3.5pt;height:29.25pt'>"
			+ "<p><b><span style='font-size:8.0pt;font-family:&quot;Tahoma&quot;,&quot;sans-serif&quot;'>" + PARAMETRO_1
			+ "</span></b><u></u><u></u></p>" + "</td>";
	public static final String REPORTE_GERENCA_TABLE_BODY_COL2_TOT = "<td style='width:95.0pt;border-top:none;border-left:none;border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;padding:0cm 3.5pt 0cm 3.5pt;height:29.25pt'>"
			+ "<p style='text-align:center'><b><span style='font-size:8.0pt;font-family:&quot;Tahoma&quot;,&quot;sans-serif&quot;'>"
			+ PARAMETRO_1 + "</span></b><u></u><u></u></p>" + "</td>";
	public static final String REPORTE_GERENCA_TABLE_BODY_COL3_TOT = "<td style='width:95.95pt;border-top:none;border-left:none;border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;padding:0cm 0cm 0cm 0cm;height:29.25pt'>"
			+ "<p style='text-align:center'><b><span style='font-size:8.0pt;font-family:&quot;Tahoma&quot;,&quot;sans-serif&quot;'>"
			+ PARAMETRO_1 + "</span></b><u></u><u></u></p>" + "</td>";
	public static final String REPORTE_GERENCA_TABLE_BODY_COL4_TOT = "<td style='width:8.0cm;border-top:none;border-left:none;border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;padding:0cm 3.5pt 0cm 3.5pt;height:29.25pt'>"
			+ "<p>&nbsp;<u></u><u></u></p>" + "</td>";
	
	public static final String REPORTE_GERENCA_TABLE_BODY_COL1_CON = "<td style='width:107.0pt;border:solid windowtext 1.0pt;border-top:none;padding:0cm 3.5pt 0cm 3.5pt;height:29.25pt'>"
			+ "<p><b><span style='font-size:8.0pt;font-family:&quot;Tahoma&quot;,&quot;sans-serif&quot;;color:#c00000'>"
			+ PARAMETRO_1 + "</b><u></u><u></u></p>" + "</td>";
	public static final String REPORTE_GERENCA_TABLE_BODY_COL2_CON = "<td style='width:95.0pt;border-top:none;border-left:none;border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;padding:0cm 3.5pt 0cm 3.5pt;height:29.25pt'>"
			+ "<p style='text-align:center'><b><span style='font-size:8.0pt;font-family:&quot;Tahoma&quot;,&quot;sans-serif&quot;;color:#c00000'>"
			+ PARAMETRO_1 + "</span></b><u></u><u></u></p>" + "</td>";
	public static final String REPORTE_GERENCA_TABLE_BODY_COL3_CON = "<td style='width:95.95pt;border-top:none;border-left:none;border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;padding:0cm 0cm 0cm 0cm;height:29.25pt'>"
			+ "<p style='text-align:center'><b><span style='font-size:8.0pt;font-family:&quot;Tahoma&quot;,&quot;sans-serif&quot;;color:#c00000'>"
			+ PARAMETRO_1 + "</span></b><u></u><u></u></p>" + "</td>";
	public static final String REPORTE_GERENCA_TABLE_BODY_COL4_CON = "<td style='width:8.0cm;border-top:none;border-left:none;border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;padding:0cm 3.5pt 0cm 3.5pt;height:29.25pt'>"
			+ "<p>&nbsp;<u></u><u></u></p>" + "</td>";
	
	public static final String REPORTE_GERENCIA_TABLE_BODY_ROWCLIMA = "<td colspan='4' style='width:524.75pt;border:solid windowtext 1.0pt;border-top:none;padding:0cm 0cm 0cm 0cm;height:22.2pt'>" +
            "<p><span style='font-size:8.0pt;font-family:&quot;Tahoma&quot;,&quot;sans-serif&quot;;color:navy'>"+PARAMETRO_1+"</span><u></u><u></u></p>" +
         "</td>";
	
	public static final String COMENTARIO_VOLUMEN_TOTAL = "Volumen total "+PARAMETRO_1+" a la fecha = "+PARAMETRO_2+" MMC";
	public static final String COMENTARIO_APERTURA = "Abierto "+PARAMETRO_1+" m3/s";
	
	public static final String TEXTO_AGREGADO_SIN = "Total Almacenado Sin ";
	public static final String TEXTO_AGREGADO_TOT = "Total Almacenado Con Disponible Bombeo HUASCACOCHA";
	public static final String TEXTO_AGREGADO_CON = "Total Almacenado Con Real ";
	
	public static final String TEXTO_CLIMA = "Las condiciones del tiempo para las "+PARAMETRO_1+" horas en ";
}
