$(document).ready(function() {
	
	// Inicializamos multiselect
//	loadMultiSelectRio();
	
	// INICALIZAMOS PARA MANEJO DE PERIODOS
	$('#periodo').datetimepicker({
        format: 'YYYYMM',
        ignoreReadonly: false,
        date: new Date(),
        maxDate: new Date(),
        locale: "es"
    });
	
	cargarCombo("listTipoEnsayo","#cboTipoEnsayo");
	
});



formatDias = function(val, axis){
	return ("0" + val).slice(-2);
}

formatPromedios = function(val, axis) {
	return parseFloat(Math.round(val * 100) / 100).toFixed(2);
}

var dataset = [];
var numCuadriculasVertical = 8;

llenarDatos = function () {
	MYAPPL.blockPageLoad();
	$.ajax({
 	   type: 'GET',
 	   url: "reportesGrafico312/obtenerData",
 	   data: $('#frmReporteGrafico').serialize(),  
 	   success: function(result){
 		   console.log(result);
 		   dataset = [];
 		   var listData = result.lstDataReporte;
 		   var len = listData.length;
 		   if(len === 0){
 			   dataset = [[]];
 		   }
 		   else{
 			  for ( var i = 0; i < len; i++) {
 				   if(i === 0){
 					   dataset.push({label:listData[i].label,data: listData[i].data, points: { symbol: "triangle"} });
 				   }else{
 					   dataset.push({label:listData[i].label,data: listData[i].data, yaxis:1});
 				   }
 			   }
 		   }
 		   
 		  console.log(dataset);
// 		 dataset = [[]];
// 		 var lstData = [['01', 12], ['02', 2],['03', 30],['04', 1],['05', 0],['06', 21],['07', 3]];
// 		 dataset.push({label:"TURBIEDAD",data: lstData, points: { symbol: "triangle"} });
	   },
	   complete: function(result) {
		  var metaReporte = result.responseJSON;
		  $.plot( $("#wrap_chart_plot_02 #chart_plot_02"), 
					dataset,
					{
					   xaxis: {
						      axisLabel: metaReporte.strEjexTitulo,
					          min: 1,
					          max: metaReporte.intDiasPeriodo, // Leer dias del periodo
					          tickSize: 1,
					          tickFormatter: formatDias
					        },
					   yaxis: {
						   	  axisLabel: metaReporte.strEjeyTitulo,
					          min:0,
					          tickFormatter: formatPromedios
					        },
						    
						legend: { 
//							      show: true,
//								  position : "se"
								  container:$("#legendContainer"),            
							      noColumns: 3
							},
					    grid: {
				            hoverable: true,
				            borderWidth: 2,
				            borderColor: "#633200",
				            backgroundColor: { colors: ["#ffffff", "#EDF5FF"] }
				        },
//				        colors: ["#FF0000", "#0022FF"]
					}
				);
		  
//		  var myCanvas = plot.getCanvas();
//		  var image = myCanvas.toDataURL();
//		  image = image.replace("image/png","image/octet-stream");
//		  document.location.href=image;
		  
		   $("#chart_plot_02").UseTooltip();
		   $.unblockUI();
	   }
	}); 
};

var previousPoint = null, previousLabel = null;

$.fn.UseTooltip = function () {
    $(this).bind("plothover", function (event, pos, item) {
        if (item) {
            if ((previousLabel != item.series.label) || (previousPoint != item.dataIndex)) {
                previousPoint = item.dataIndex;
                previousLabel = item.series.label;
                $("#tooltip").remove();

                var x = item.datapoint[0];
                var y = item.datapoint[1];

                var color = item.series.color;
                var dayNumber = ("0" + x).slice(-2);

                if (item.seriesIndex >= 0) { // Tomara todos
                    showTooltip(item.pageX,
                    item.pageY,
                    color,
                    "<strong>" + item.series.label + "</strong><br>DIA " + dayNumber + " : <strong>" + y + "</strong>(%rsd");
                }
                
            }
        } else {
            $("#tooltip").remove();
            previousPoint = null;
        }
    });
};

function showTooltip(x, y, color, contents) {
    $('<div id="tooltip">' + contents + '</div>').css({
        position: 'absolute',
        display: 'none',
        top: y - 40,
        left: x - 120,
        border: '2px solid ' + color,
        padding: '3px',
        'font-size': '9px',
        'border-radius': '5px',
        'background-color': '#fff',
        'font-family': 'Verdana, Arial, Helvetica, Tahoma, sans-serif',
        opacity: 0.9
    }).appendTo("body").fadeIn(200);
}

generarReporteVisual = function () {
	llenarDatos();
};