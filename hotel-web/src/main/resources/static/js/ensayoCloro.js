;/**
 * Hoja de scripts manejados en el mantenimiento de clima
 */
$(document).ready(function() {
	
	toastr.options = {
		"closeButton" : true,
		"debug" : false,
		"newestOnTop" : false,
		"progressBar" : false,
		"positionClass" : "toast-top-center",
		"preventDuplicates" : false,
		"showDuration" : "300",
		"hideDuration" : "1000",
		"timeOut" : "5000",
		"extendedTimeOut" : "1000",
		"showEasing" : "swing",
		"hideEasing" : "linear",
		"showMethod" : "fadeIn",
		"hideMethod" : "fadeOut"
	}
	
	cargarComboTodos("listAreas","#cboArea");

	function mergeCommonRows(table) {
	    var firstColumnBrakes = [];
	    // iterate through the columns instead of passing each column as function parameter:
	    for(var i=1; i<=table.find('th').length; i++){
	    if(i==1 || i== 2){
	    console.log("i th: " + i);
	        var previous = null, cellToExtend = null, rowspan = 1;
	        table.find("td:nth-child(" + i + ")").each(function(index, e){
	            var jthis = $(this), content = jthis.text();
	            // check if current row "break" exist in the array. If not, then extend rowspan:
	            if (previous == content && content !== "" && $.inArray(index, firstColumnBrakes) === -1) {
	                // hide the row instead of remove(), so the DOM index won't "move" inside loop.
	                jthis.addClass('hidden');
	                cellToExtend.attr("rowspan", (rowspan = rowspan+1));
	            }else{
	                // store row breaks only for the first column:
	                if(i === 1) firstColumnBrakes.push(index);
	                rowspan = 1;
	                previous = content;
	                cellToExtend = jthis;
	            }
	        });
	        }
	    }
	    // now remove hidden td's (or leave them hidden if you wish):
	    $('td.hidden').remove();
	}
	


});



function showToastReportePlan(mensajeTipo, mensaje, mensajeError) {
	console.log("entrando al toast")
	
	//Mensajes despues de grabar
	if(mensajeTipo==='grabadoOk'){
		 toastr["success"](mensajeError, mensaje);
	 }
	
	 if(mensajeTipo==='grabadoNoOk'){
		 toastr["error"](mensajeError, mensaje);
	 }
	 
	 //Mensajes despues de eliminar
	 if(mensajeTipo==='inactivadoOk'){
		 toastr["success"](mensajeError, mensaje);
	 }
	 
	 if(mensajeTipo==='inactivadoNoOk'){
		 toastr["error"](mensajeError, mensaje);
	 }
	 
	 if(mensajeTipo==='parametroPlanExistente'){
		 toastr["error"](mensajeError, mensaje);
		 console.log("gol inexistente")
		 setTimeout(function(){
			 $('#modal-registra-parametroplan').modal('hide');
		 },400)
	 }
}

function filtrarReportePorArea(){
	
	MYAPPL.blockPageLoad();
		$.ajax({
			type: 'GET',
			url: 'refrescarTablaFiltradaXArea',
			data: dataFiltrar(),
			success: function(result){
				console.log("result: " + result);
				$('#tablaBandeja').html(result);
			},
			complete: function() {
				$("#guardarButton").html('Guardar');
				$('#guardarButton').removeAttr("disabled");
				enableValidationRulesBandeja1();
				$.unblockUI();
			}
		});
}

// metodo por defecto sera' 1
function dataSearch(codplan,codDesc,descPlan, area ){
//	buscarReportePlan(1,plan01, ' p011'  , ' 1 ')
	
	var data = {};
	data.idMes = "01";
	
	data.codplan = codplan;
	data.codDesc = codDesc;
	data.descPlan = descPlan;
	data.codare = area;
	
	return data;
}

function dataSearchXFecha(codplan){
	var data = {};
	var mes = $('#cboMeses').find(":selected").val();
	if(mes<10){
		mes = '0'+mes;
	}
	data.idMes = mes;
	data.codplan = $("#reporteData").data("codplan");
	data.codDesc = $("#codigoDesc").val();
	data.descPlan = $("#descPlan").val();
	data.codare = $("#reporteData").data("codare");
	
	return data;
}

function dataModificar(){
	var data = {};
	var mes = $('#cboMeses').find(":selected").val();
	if(mes<10){
		mes = '0'+mes;
	}
	data.idMes = mes;
	return data;
}


function dataFiltrar(){
	var data = {};
	var area = $("#cboArea").val();
	
	
	data.codare = area;
	return data;
}

function dataRefrescarDatos(){
	var area = $("#reporteData").data("codare");
	if(area == 1){
		area = "BIOQUIMICA";
	}else{
		area = "FISICOQUIMICA";
	}
	
	var mes = Number($("#reporteData").data("mes"));
	console.log("mes: " + mes)
	setTimeout(function(){
	  $("#textArea").val(area);
	  $("#cboMeses").val(mes)
	},200)
}


function buscarReportePlanXFecha(){
	$.ajax({
		type: 'POST',
		url: 'buscarReportePlanSearch',
		data: dataSearchXFecha(),
		success: function(result){
			$('#id-modal-plan-bandeja').html(result);
			$('#modal-registra-parametroplan').modal('show');
			
				cargarCombo("listComboMeses","#cboMeses");
				calcularTotales();
				dataRefrescarDatos();
		},
		complete: function() {
			$("#guardarButton").html('Guardar');
			$('#guardarButton').removeAttr("disabled");
			enableValidationRulesBandeja1();
		}
	});
}

function buscarReportePlan(codplan,codDesc,descPlan, area){
	console.log("codplan: " + codplan);
	$.ajax({
		type: 'POST',
		url: 'buscarReportePlanSearch',
		data: dataSearch(codplan,codDesc,descPlan, area),
		success: function(result){
			console.log("result: " + result);
			$('#id-modal-plan-bandeja').html(result);
			$('#modal-registra-parametroplan').modal('show');
			
			setTimeout(function(){
				cargarCombo("listComboMeses","#cboMeses");
				calcularTotales();
				dataRefrescarDatos();
			},200)
		},
		complete: function() {
			$("#guardarButton").html('Guardar');
			$('#guardarButton').removeAttr("disabled");
			enableValidationRulesBandeja1();
		}
	});
}

function modificarReportePlan(){
	var idMes = $('#cboMeses').find(":selected").val();
	if(idMes<10){
		idMes = '0'+idMes;
	}
	console.log("idMes: " + idMes);
	
	$.ajax({
		type: 'POST',
		url: 'modificarReportePlanSearch',
		data: dataModificar(),
		success: function(result){
			$('.container_save').html(result);
		},
		complete: function() {
			$("#guardarButton").html('Guardar');
			$('#guardarButton').removeAttr("disabled");
		}
	});
}

function calcularTotales(){
	$(".subactcalcular").each(function(index){
		console.log("index: " + index);
		
		var total = Number(0) ;
		$(this).find(".no-total").each(function(stat){
			console.log("no-total : " + $(this).children().prop("value"));
			total += Number($(this).children().prop("value"));
			
			var progr = Number($(this).parent().find(".programado").text());
			console.log("progr: " + progr)
			
			var porcentaje = (Number($(this).children().prop("value"))/progr)*100;
			porcentaje =  porcentaje.toFixed(2);
			
			$(this).parent().find(".porcentaje").text(porcentaje);
		});
		
		$(this).find(".total").children().val(total);
		
		var prograTotal = Number($(this).find(".programado-total").text());
		
		var porTotal = (total/prograTotal)*100;
		
		$(this).find(".porcentaje-total").text(porTotal.toFixed(2));
	})
}

//FUNCION PARA HABILITAR LAS VALIDACIONES EN EL FORMULARIO DE CREACION O EDICION
function enableValidationRulesBandeja1() {

	var validator = $("#form-edit-reporte-plan").bootstrapValidator({
		message: 'El valor no es v\u00e1lido',
		excluded: [':disabled', ':hidden', '#strParaAdd', '#strCcAdd'],
		feedbackIcons : {
			valid : "glyphicon glyphicon-ok",
			invalid : "glyphicon glyphico-remove",
			validating : "glyphicon glyphicon-refresh"
		},
		fields : {
			codigoDescripcionPlan: {
					validators : {
						regexp: {
							 regexp:/^[a-z0-9\u00E1\u00E9\u00ED\u00F3\u00FA\u00FC\u00F1\s\.-]+$/i,
							 message: 'Ingrese valor alfanumerico'
						},
						stringLength : {
							max : 5,
							message : 'Campo incorrecto'
						},
						notEmpty: {
	                        message: 'Ingrese valor alfanumerico'
	                    } 
					}
	        },
	        descripcion: {
				validators : {
					regexp: {
						 regexp:/^[a-z0-9\u00E1\u00E9\u00ED\u00F3\u00FA\u00FC\u00F1\s\.-]+$/i,
						 message: 'Ingrese valor alfanumerico'
					},
					stringLength : {
						max : 5,
						message : 'Ingrese valor alfanumerico'
					},
					notEmpty: {
                        message: 'Ingrese valor alfanumerico'
                    }
				}
          },
         
        
           
		}
	})	
	.on('success.form.bv', function(e, data) {
		
		$("#guardarButton").html('Guardando...');
		$("#guardarButton").attr('disabled', 'disabled');
		e.preventDefault();
		
		var $nuevoTablaPoissonForm = $(e.target);
		console.log("guardando cambios para reporte");
		
		$.ajax({
			type: 'POST',
			url: 'reportePlanOperativoSave1',
			data: $('#form-edit-reporte-plan').serialize(),
			success: function(result){
				$nuevoTablaPoissonForm.bootstrapValidator('resetForm', true);
				$nuevoTablaPoissonForm[0].reset();
				
				$('.container_save_reporte').html(result);
			},
			complete: function() {
				
				
				$("#buttonCloseDetail").click();
				$("#guardarButton").html('Guardar');
				$('#guardarButton').removeAttr("disabled");
			}
		});
	});	
}

//FUNCION PARA INACTIVAR UN REGISTRO
function inactivarPlanOperativo(id) {
	console.log("inactivarPlanOperativo ....")
	$.confirm({
	    title: 'Confirmaci\u00f3n',
	    content: 'Confirma inactivar Registro ?',
	    buttons: {
	    	Aceptar: { 
	        	btnClass: 'btn-blue',
	        	action: function () {
				    $.ajax({
			    	   type: 'POST',
			    	   url: 'inactivarPlanOperativo/'+id,
			    	   success: function(result){		   
			    		   setTimeout(function(){
			    			   console.log("activando modal")

			    			   $('#ensayoCloroBandeja').DataTable().ajax.reload();
			    			   $('#id-modal-plan-bandeja-inactivar').html(result);   
			    		   },500);
				    	  },
				    	}); 
		        	}
		        },
		        Cancelar: {
		        	
		        }
		    }
		});	   
};


function cargarEnsayoCloro(url){
	var urldefault  = "ensayoCloro/pagination/";
	if(url == null || url == undefined){
		url = urldefault;
	}
	
	
	$('#ensayoCloroBandeja').DataTable({
		"bProcessing": true,
		"serverSide": true,
		"searching": false,
		"lengthChange":   false,
		"ajax":{
			url : url + '27/09/2017', // json datasource
            type: "post",  // type of method  ,GET/POST/DELETE
            error: function(){
              $("#myTableTablaPoisson_processing").css("display","none");
            },
            "data": function ( d ) {
            }
		},
		"order": [ 1, 'desc' ],
		"columnDefs": [ 
			{ targets: '_all', visible: true,  },
			{"width": "50px",
        		className: "dt-body-center",
        		sortable :true,
                "targets": 0                 
            },
            {"width": "40px",
        		className: "dt-body-center hidden",
                "targets": 1                
            },
            {"width": "40px",
    		  	className: "dt-body-center",
    		  	sortable :true,
              	"targets": 2
          	},
          	{"width": "40px",
        		className: "dt-body-center",
        		sortable :true,
                "targets": 3               
            },
            
            {"width": "40px",
        		className: "dt-body-center",
        		sortable :true,
                "targets": 4               
            },
            {"width": "40px",
        		className: "dt-body-center",
        		sortable :true,
                "targets": 4               
            },
            
            {"width": "40px",
        		className: "dt-body-center",
        		sortable :true,
                "targets": 4               
            },
          	{"width": "40px",
          		className: "dt-body-center",
          		sortable :true,
          		"orderable": false,
          		"targets": 0,
          		visible: true,
          		"data": 1,
          		"render": function ( data, type, row) {
          			 
          			 return '<button class="btn btn-info btn-modif-punto" title="Editar" onclick="buscarReportePlan('+row[1]+ ', \''+ row[2] +'\' , \''+ row[3] + '\' , \'' + row[4] +   '\')"><span class="glyphicon glyphicon-pencil"></span></button>'+
          			'<button class="btn btn-danger btn-delete-punto" title="Inactivar" onclick="inactivarPlanOperativo('+row[1]+')"><span class="glyphicon glyphicon-erase"></span></button>';
          		}
          	}
		]
	});
}

			
			
