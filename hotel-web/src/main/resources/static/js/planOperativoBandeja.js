
$(document).ready(function() {
	
	//MANEJO DEL FORMULARIO DE BUSQUEDA
	$('#idBtnBuscarTablaPoisson').click(function () {		 
		 $('#cboLambdasHidden').val($('#cboLambdas').val());
		 $('#myTableTablaPoisson').DataTable().ajax.reload();
	});
	
	//CARGA EL COMBO DE LAMBDAS
	cargarCombo("listAreas","#cboAreas");
	cargarComboTodos("listAreas","#cboAreasPlan");
	
	
});

function modificarPlanOperativo(id) {
	 
	$.ajax({
		type: 'GET',
		data: dataModificarPlan(id),
		url: 'planOperativoBandejaGet', 
		success: function(result) {
			console.log("id " + id)
//			if(id == 0){
//				$('#modal-registra-planoperativo-agregar').html(result);
//			}else{
//				$('#modal-registra-planoperativo-bandeja').html(result);
//			}
			$('#modal-registra-planoperativo-bandeja').html(result);
			if(id != 0){
				$('#idModalTitle').html($('#idValEditModalTitle').html());
				$("#intCodLambda").attr('disabled', 'disabled');
				$("#strCodIgx").attr('disabled', 'disabled');
			}else{
				$('#idModalTitle').html($('#idValCrearModalTitle').html());
			}
			enableValidationRulesBandeja();
		},complete: function() {
//			if(id == 0){
//				$('#modal-registra-planoperativo-agregar').modal('show');
//			}else{
//				$('#modal-registra-planoperativo-bandeja').modal('show');
//			}
			$('#modal-registra-planoperativo-bandeja').modal('show');
			
//			$('#modal-registra-planoperativo-bandeja').modal('show');
			cargarCombo('listAreas',"#cboAreas");
			
			setTimeout(function(){
				var codare = $("#cboAreas").attr("codare");
				console.log("codare: " + codare);
				
				if(codare!=null && codare != undefined){
					$("#cboAreas").val(codare);
				}
				
//				var idArea = $('#cboAreas').find(":selected").data("id");
				cambioArea(codare);		
//				$("#cboAreas").val(idArea)
			},500)
			
			$.unblockUI();
			
		}
	  });
}

function dataModificarPlan(codplan) {
	var data = {};
	
	if(codplan==0){
		
		data.codplan = codplan; 
		
	} else {
		
		var atributes = codplan.split("#");
		data.codplan = atributes[0]; 
		data.codDescPlan = atributes[1]; 
		data.descripcion = atributes[3];
		data.codare = atributes[2];
	}
	
	return data;
}

//FUNCION PARA HABILITAR LAS VALIDACIONES EN EL FORMULARIO DE CREACION O EDICION
function enableValidationRulesBandeja() {

	var validator = $("#form-edit-plan-operativo").bootstrapValidator({
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
		$.ajax({
			type: 'POST',
			url: 'planOperativoSave',
			data: $('#form-edit-plan-operativo').serialize(),
			success: function(result){
				$nuevoTablaPoissonForm.bootstrapValidator('resetForm', true);
				$nuevoTablaPoissonForm[0].reset();
				$('.container_save').html(result);
			},
			complete: function() {
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

			    			   $('#idTablaPlanOperativoBandeja').DataTable().ajax.reload();
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

function aprobarPlan(id) {
	$.confirm({
	    title: 'Confirmaci\u00f3n',
	    content: '\u00BF Confirma aprobar Plan Operativo \u003F',
	    buttons: {
	    	Aceptar: { 
	        	btnClass: 'btn-blue',
	        	action: function () {
				    $.ajax({
			    	   type: 'POST',
			    	   url: 'aprobarPlan/'+id,
			    	   success: function(result){  		   
			    		   	$("#btnActualizarDescri").data("aprobado",0);
			    		   	$("#btnActualizarDescri").attr("disabled","disabled");
			    		   	
			    		   	
				    	   },
							complete: function() {
								$('#myPlanOperativoDetalle').DataTable().ajax.reload();
								$(".param").addClass("hidden")
							}
				    	}); 
		        	}
		        },
		      Cancelar: {
		        }
		    }
		});	   
};



function showToastPlanOperativoBandeja(mensajeTipo, mensaje, mensajeError) {
	console.log("entrando al toast")
	
	//Mensajes despues de grabar
	if(mensajeTipo==='grabadoOk'){
		 toastr["success"](mensajeError, mensaje);
		 console.log("existente param")
		 setTimeout(function(){
			 
			 $('#idTablaPlanOperativoBandeja').DataTable().ajax.reload();
			 $('#modal-registra-planoperativo-bandeja').modal('hide');
			 $('#id-modal-parametroplan').addClass('hidden');
			 $('#myPlanOperativoDetalle').DataTable().ajax.reload();
			 
		 },1000)
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
