
$(document).ready(function() {
	
	//MANEJO DEL FORMULARIO DE BUSQUEDA
	$('#idBtnBuscarConductimetroDigital').click(function () {		 
		 $('#myTableConductimetroDigital').DataTable().ajax.reload();
	});
	
});

function modificarConductimetroDigital(id) {
	
	MYAPPL.blockPageLoad();
	$.ajax({
		type: 'GET',
		url: 'conductimetroDigitalGet/'+id, 
		success: function(result) {
			$('#id-modal-content').replaceWith(result);
			$("#intCodigo").val(id);			
			
			cargarCombo("listEspecialistas","#strEspecialista");
			cargarCombo("listComboUbicacion","#intArea");
			
			if(id != -1){
				$("#strCodEquipo").attr('disabled', 'disabled');
				$('#idModalTitle').html($('#idValEditModalTitle').html());
			}else{
				$('#idModalTitle').html($('#idValCrearModalTitle').html());
			}
			enableValidationRules();
		},complete: function() {
			$('#modal-registra-conductimetroDigital').modal('show');
			
			if(id != -1){		
				setTimeout(function(){

					$('#intArea').val($('#intAreaHide').val());
					$('#strEspecialista').val($('#strEspecialistaHide').val());
				}, 500);
			}
			
			$.unblockUI();
			
		}
	});
}

//FUNCION PARA HABILITAR LAS VALIDACIONES EN EL FORMULARIO DE CREACION O EDICION
function enableValidationRules() {
		
	var validator = $("#form-edit-conductimetroDigital-id").bootstrapValidator({
		message: 'El valor no es v\u00e1lido',
		feedbackIcons : {
			valid : "glyphicon glyphicon-ok",
			invalid : "glyphicon glyphico-remove",
			validating : "glyphicon glyphicon-refresh"
		},
		fields : {			
			strCodEquipo: {
				validators : {
							
					stringLength : {
						max : 20,
						message : "El valor ha de ser como m\u00e1ximo 20 caracteres"
					},
					notEmpty: {
                        message: 'Ingrese Código de equipo'
                    }
				}
			},
			strkmax: {
				validators : {					
                    regexp: {

                    	 regexp: /^[0-9]+([.][0-9]+)?$/, 
                   	 
						 message: 'Valor incorrecto'
	 
					}
				}
			},
			strkmin: {
				validators : {					
                    regexp: {
						 
						 regexp: /^[0-9]+([.][0-9]+)?$/, 
	 
						 message: 'Valor incorrecto'
	 
					}
				}
			},
			strValor1: {
				validators : {					
                    regexp: {
						 
						 regexp: /^[0-9]+([.][0-9]+)?$/, 
	 
						 message: 'Valor incorrecto'
	 
					}
				}
			},
			strValor2: {
				validators : {					
                    regexp: {
						 
						 regexp: /^[0-9]+([.][0-9]+)?$/, 
	 
						 message: 'Valor incorrecto'
	 
					}
				}
			}	
		}
	})	
	.on('success.form.bv', function(e, data) {
		$("#guardarButton").html('Guardando...');
		$("#guardarButton").attr('disabled', 'disabled');
		e.preventDefault();
		var $nuevoConductimetroDigitalForm = $(e.target);
		$.ajax({
			type: 'POST',
			url: $('#form-edit-conductimetroDigital-id').attr('action'),
			data: $('#form-edit-conductimetroDigital-id').serialize(),
			success: function(result){
				$nuevoConductimetroDigitalForm.bootstrapValidator('resetForm', true);
				$nuevoConductimetroDigitalForm[0].reset();
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
function inactivarConductimetroDigital(id) {
	$.confirm({
	    title: 'Confirmaci\u00f3n',
	    content: 'Confirma inactivar Registro ?',
	    buttons: {
	    	Aceptar: { 
	        	btnClass: 'btn-blue',
	        	action: function () {
		        	$('#inacId').val(id); 
				    $.ajax({
			    	   type: 'POST',
			    	   url: $('#form-inactiva-conductimetroDigital').attr('action'),
			    	   data: $('#form-inactiva-conductimetroDigital').serialize(),  
			    	   success: function(result){  		   
			    	       $('.container_save').html(result);		    	      
				    	   },
							complete: function() {
								$.unblockUI();
							}
				    	}); 
		        	}
		        },
		        Cancelar: {
		        }
		    }
		});	   
}



var idConductimetro;
function modificarConductimetroDigitalDetalle(id) {
	idConductimetro=id;
	MYAPPL.blockPageLoad();
	$.ajax({
		type: 'GET',
		url: 'conductimetroDigitalDetalleGet/'+id, 
		success: function(result) {
			$('#id-modal-content-detalle').replaceWith(result);
			
			cargarCombo("listEspecialistas","#strEspecialista2");
			cargarCombo("listComboUbicacion","#intArea2");
			$('#intIdConductimetro').val(id);
			
			$("#intArea2").attr('disabled', 'disabled');				
			$("#strCodEquipo2").attr('disabled', 'disabled');		
			$("#strEquipoMedicion2").attr('disabled', 'disabled');		
			$("#strNroSerie2").attr('disabled', 'disabled');		
			$("#strEspecialista2").attr('disabled', 'disabled');		
			
			$('#idModalTitle').html($('#idValEditModalTitle').html());
			
		},complete: function() {
			$('#modal-registra-conductimetroDigitalDetalle').modal('show');
			setTimeout(function(){

				$('#intArea2').val($('#intArea2Hide').val());
				$('#strEspecialista2').val($('#strEspecialista2Hide').val());
			}, 500);
			$.unblockUI();
			
		}
	});
}

function modificarConductimetroDigitalDetalleEdit() {
	//alert(idPhMetro);
	MYAPPL.blockPageLoad();
	$.ajax({
		type: 'GET',
		url: 'conductimetroDigitalDetalleEditGet/'+idConductimetro, 
		success: function(result) {
			$('#id-modal-content-detalle-edit').replaceWith(result);
			
			$('#intIdConductimetroEdit').val(idConductimetro);
			
			
			$('#strFecha').datetimepicker({
			      //  format: 'DD/MM/YYYY HH:mm:SS',
					format: 'DD/MM/YYYY',
			        ignoreReadonly: false,
			        date: new Date(),
			        locale: "es"
			    });
									
			$('#idModalTitle').html($('#idValCrearModalTitle').html());
			enableValidationRulesDetalle();
		},complete: function() {
			$('#modal-registra-conductimetroDigital-detalle-edit').modal('show');		
			
			$.unblockUI();
			
		}
	});
}

function enableValidationRulesDetalle() {

	var validator = $("#form-edit-conductimetroDigitalDetalleEdit-id").bootstrapValidator({
		message: 'El valor no es v\u00e1lido',
		feedbackIcons : {
			valid : "glyphicon glyphicon-ok",
			invalid : "glyphicon glyphico-remove",
			validating : "glyphicon glyphicon-refresh"
		},
		fields : {
			
			strFecha: {
				validators : {
							
					notEmpty: {
                        message: 'Ingrese Fecha'
                    }		
					
				}
			},
			strCodEquipo: {
				validators : {
							
					notEmpty: {
                        message: 'Ingrese Código'
                    }		
					
				}
			},
			strResult1: {
				validators : {
							
					stringLength : {
						max : 20,
						message : "El valor ha de ser como m\u00e1ximo 20 caracteres"
					},			
					regexp: {
						 
						 regexp: /^[0-9]+([.][0-9]+)?$/, 
	 
						 message: 'Valor incorrecto'
	 
					}
				}
			},
			strKCelda: {
				validators : {
							
					stringLength : {
						max : 20,
						message : "El valor ha de ser como m\u00e1ximo 20 caracteres"
					},			
					regexp: {
						 
						 regexp: /^[0-9]+([.][0-9]+)?$/, 
	 
						 message: 'Valor incorrecto'
	 
					}
				}
			},
			strResult2: {
				validators : {
							
					stringLength : {
						max : 20,
						message : "El valor ha de ser como m\u00e1ximo 20 caracteres"
					},			
					regexp: {
						 
						 regexp: /^[0-9]+([.][0-9]+)?$/, 
	 
						 message: 'Valor incorrecto'
	 
					}
				}
			}
			
		}
	})	
	.on('success.form.bv', function(e, data) {
		$("#guardarButton").html('Guardando...');
		$("#guardarButton").attr('disabled', 'disabled');
		e.preventDefault();
		var $nuevoConductimetroDigitalDetalleEditForm = $(e.target);
		$.ajax({
			type: 'POST',
			url: $('#form-edit-conductimetroDigitalDetalleEdit-id').attr('action'),
			data: $('#form-edit-conductimetroDigitalDetalleEdit-id').serialize(),
			success: function(result){
				$nuevoConductimetroDigitalDetalleEditForm.bootstrapValidator('resetForm', true);
				$nuevoConductimetroDigitalDetalleEditForm[0].reset();
				$('.container_save').html(result);
			},
			complete: function() {
				
				$("#guardarButton").html('Guardar');
				$('#guardarButton').removeAttr("disabled");
			}
		});
	});	
}

function inactivarConductimetroDigitalDetalle(id) {

	$.confirm({
	    title: 'Confirmaci\u00f3n',
	    content: 'Confirma inactivar Registro ?',
	    buttons: {
	    	Aceptar: { 
	        	btnClass: 'btn-blue',
	        	action: function () {
		        	$('#inacIdDetalle').val(id); 
				    $.ajax({
			    	   type: 'POST',
			    	   url: $('#form-inactiva-conductimetroDigitalDetalle').attr('action'),
			    	   data: $('#form-inactiva-conductimetroDigitalDetalle').serialize(),  
			    	   success: function(result){  		   
			    	       $('.container_save').html(result);		    	      
				    	   },
							complete: function() {
								$.unblockUI();
							}
				    	}); 
		        	}
		        },
		        Cancelar: {
		        }
		    }
		});	   
}

function showToastConductimetroDigital(mensajeTipo, mensajeError) {
	//Mensajes despues de grabar
	if(mensajeTipo==='grabadoOk'){
		 toastr["success"](mensajeError, "Registro correctamente guardado");
		 $('#modal-registra-conductimetroDigital').modal('hide');
		 $('#idBtnBuscarConductimetroDigital').click();
	 }
	 if(mensajeTipo==='grabadoNoOk'){
		 toastr["error"](mensajeError, "Hubo un error en el servidor, el registro no fue guardado");
	 }
	 //Mensajes despues de eliminar
	 if(mensajeTipo==='inactivadoOk'){
		 toastr["success"](mensajeError, "Registro correctamente inactivado");
		 $('#modal-registra-conductimetroDigital').modal('hide');
		 $('#idBtnBuscarConductimetroDigital').click();
	 }
	 if(mensajeTipo==='inactivadoNoOk'){
		 toastr["error"](mensajeError, "Hubo un error en el servidor, el registro no fue inactivado");
	 }
	 if(mensajeTipo==='RegDuplicado'){
		 toastr["error"](mensajeError, "Registro ya existe en la Tabla");
		 //$('#modal-registra-conductimetroDigital').modal('hide');
		 //$('#idBtnBuscarConductimetroDigital').click();
	 }
	 if(mensajeTipo==='grabadoOkSubForm'){
		 toastr["success"](mensajeError, "Registro agregado correctamente");
		 $('#modal-registra-conductimetroDigital-detalle-edit').modal('hide');
		 $('#myTableConductimetroDigitalDetalle').DataTable().ajax.reload();
	 }
	 if(mensajeTipo==='inactivadoSubFormOk'){
		 toastr["success"](mensajeError, "Registro agregado correctamente");
		 $('#myTableConductimetroDigitalDetalle').DataTable().ajax.reload();
	 }
}
	 
