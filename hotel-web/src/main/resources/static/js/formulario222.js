
$(document).ready(function() {
	
	//MANEJO DEL FORMULARIO DE BUSQUEDA
	$('#idBtnBuscarFormulario').click(function () {
		 $('#myTableFormulario222').DataTable().ajax.reload();  //PARA LLAMAR AL DATATABLE PRINCIPAL A TRAVES DEL ID
	});

	$('#inputFecha').datetimepicker({
	        format: 'DD/MM/YYYY',
			//format: 'YYYY-MM-DD HH:mm:ss',
	        ignoreReadonly: false,
//	        date: new Date(),
	        locale: "es"
	    });
	
	
});

$('#modal-registra-detalle').on('shown.bs.modal', function() {
	$($.fn.dataTable.tables(true)).DataTable().columns.adjust();
})


function modificarFormulario(id) {
//	id= -1 Boton Agregar
	MYAPPL.blockPageLoad();
//	$('#idcabeceraHidden').val(id); //input definido en la pagina principal
	$.ajax({
		type: 'GET',
		url: 'formulario222Get/'+id, //LLAMA AL CONTROLER Y DEVUELVE UNA PAGINA(PAGUNA HEADER)
		success: function(result) {
			$('#id-modal-content').replaceWith(result); //SE INYECTA EN LA PAGINA PRINCIPAL EL HEADER
			
			cargarCombo("listPersonaMuestrea","#cboMuestrea");
			cargarCombo("listPersonaMuestrea","#cboMuestrea2");
			cargarCombo("listPersonaRecepcion","#cboRecepcion");
			cargarCombo("listPersonaRecepcion","#cboRecepcion2");
			cargarCombo("listPersonaRecepcion","#cboRecepcion3");
			cargarCombo("listEspecialistas","#cboAnalista");
			
			if(id != -1){ //EDITAR
				setTimeout(function(){
					
					$('#cboMuestrea').val($('#cboMuestreaHidden').val());
					$('#cboMuestrea2').val($('#cboMuestreaHidden2').val());
					$('#cboRecepcion').val($('#cboRecepcionHidden').val());
					$('#cboRecepcion2').val($('#cboRecepcionHidden2').val());
					$('#cboRecepcion3').val($('#cboRecepcionHidden3').val());
					$('#cboAnalista').val($('#cboAnalistaHidden').val());
				}, 500);
				
				$('#strFechaMuestreo').datetimepicker({
			        format: 'DD/MM/YYYY',
			        ignoreReadonly: false,
//			        date: new Date(),
			        maxDate: new Date(),
			        locale: "es"
			    });
				
				$('#idModalTitle').html($('#idValEditModalTitle').html()); 

			}else{
				
				$('#strFechaMuestreo').datetimepicker({
			        format: 'DD/MM/YYYY',
			        ignoreReadonly: false,
			        date: new Date(),
			        maxDate: new Date(),
			        locale: "es"
			    });
				
				$('#idModalTitle').html($('#idValCrearModalTitle').html());
			}
			
			enableValidationRulesHeader();
			
		},complete: function() {
			
			$('#modal-registra-formularioHeader').modal('show'); //MUESTRA EN LA PANTALLA PRINCIPAL FORMULARIO HEADER
			$.unblockUI();
		}
	});
}

var idCabecera;
function modificarDetalle(idx) {
	idCabecera = idx;
	
	MYAPPL.blockPageLoad();
	
	$.ajax({
		type: 'GET',
		url: 'formularioDetalleGet222/'+idx,
		success: function(result) {
			$('#id-modal-content-detalle').replaceWith(result); //ESA PAGINA SE INYECTA EN LA PAGINA PRINCIPAL
			
			$('#idcabeceraHidden').val(idx);	//input definido en la pagina principal, LO USA formulario222TableDetalle
//			$('#idPadre').val(idx);
			
			$('#strfechaHora').datetimepicker({
		        format: 'DD/MM/YYYY',
		        ignoreReadonly: false,
		        date: new Date(),
		        locale: "es"
		    })
		    
		    cargarCombo("listPersonaMuestrea","#cboMuestrea_");
			cargarCombo("listPersonaMuestrea","#cboMuestrea2_");
			cargarCombo("listPersonaRecepcion","#cboRecepcion_");
			cargarCombo("listPersonaRecepcion","#cboRecepcion2_");
			cargarCombo("listPersonaRecepcion","#cboRecepcion3_");
			cargarCombo("listEspecialistas","#cboAnalista_");
			
            setTimeout(function(){
				
				$('#cboMuestrea_').val($('#cboMuestreaHidden_').val());
				$('#cboMuestrea2_').val($('#cboMuestreaHidden2_').val());
				$('#cboRecepcion_').val($('#cboRecepcionHidden_').val());
				$('#cboRecepcion2_').val($('#cboRecepcionHidden2_').val());
				$('#cboRecepcion3_').val($('#cboRecepcionHidden3_').val());
				$('#cboAnalista_').val($('#cboAnalistaHidden_').val());
			}, 500);
			
//			$('#idModalTitle').html($('#idValEditModalTitle').html());

			$('#idModalTitle').html($('#idValCrearModalTitle').html());
		
			
//			enableValidationRulesVerificacion();	
			
		},complete: function() {
			
			$("#strFechaMuestreo_").attr('disabled', 'disabled');
			$("#cboMuestrea_").attr('disabled', 'disabled');
			$("#cboMuestrea2_").attr('disabled', 'disabled');
			$("#cboRecepcion_").attr('disabled', 'disabled');
			$("#cboRecepcion2_").attr('disabled', 'disabled');
			$("#cboRecepcion3_").attr('disabled', 'disabled');
			$("#observacion_").attr('disabled', 'disabled');
			$("#cboAnalista_").attr('disabled', 'disabled');
			
			$('#modal-registra-detalle').modal('show'); //HACE VISIBLE EN LA PANTALLA PRINCIPAL EL FORMULARIO DETALLE
			$.unblockUI();
			
		}
	});
}

//boton agregar levanta el popup para registrar el detalle y activa el boostrat validator(enableValidationRulesDetalle2()) necesario para despues de grabar oculte popup y muestre mensaje de grabado ok 
function modificarDetalle2(cod) { 
//	alert(cod);
var accion;
	
	MYAPPL.blockPageLoad();
	$.ajax({
		type: 'GET',
		url: 'formularioDetalleGetEdit222/'+cod, 
		success: function(result) {
			$('#id-modal-content-detalle-edit').replaceWith(result);
			
//			$('#idcabeceraHidden').val($('#idPadre').val());
			
		    cargarCombo("listTipoMuestra", "#cboTipoMuestra");
			cargarCombo("listTipoFrasco","#cboTipoEnvase");
			cargarCombo("listPuntos2","#cboPuntos");
			cargarCombo("listTipoPreservacion","#cboPreservacion");
			
			$("#todos").change(function () {
			      $("input:checkbox").prop('checked', $(this).prop("checked"));
			});
					
			if(cod != -1){ //EDITAR
				accion = 'U';
				$('#accionHidden').val(accion);
				
                setTimeout(function(){
					
					$('#cboPuntos').val($('#cboMuestreoHidden').val());
					$('#cboTipoEnvase').val($('#cboTipoEnvaseHidden').val());
					$('#cboTipoMuestra').val($('#cboTipoMuestraHidden').val());
					$('#cboPreservacion').val($('#cboPreservacionHidden').val());
				
				}, 500);
                    
                if($('#intFeHide').val()==1){
    					setTimeout(function(){
    						
    						$("#id_chk01").prop("checked", true); //cambia el id del checkbox para que funcione
    					}, 500);
    		    }
                
                if($('#intMnHide').val()==1){
					setTimeout(function(){
						
						$("#id_chk02").prop("checked", true); //cambia el id del checkbox para que funcione
					}, 500);
		       }
                
               if($('#intCrHide').val()==1){
					setTimeout(function(){
						
						$("#id_chk03").prop("checked", true); //cambia el id del checkbox para que funcione
					}, 500);
		       }
               
               if($('#intPbHide').val()==1){
					setTimeout(function(){
						
						$("#id_chk04").prop("checked", true); //cambia el id del checkbox para que funcione
					}, 500);
		       }
               
               if($('#intZnHide').val()==1){
					setTimeout(function(){
						
						$("#id_chk05").prop("checked", true); //cambia el id del checkbox para que funcione
					}, 500);
		       }
               
               if($('#intAsHide').val()==1){
					setTimeout(function(){
						
						$("#id_chk06").prop("checked", true); //cambia el id del checkbox para que funcione
					}, 500);
		       }
               
               if($('#intCdHide').val()==1){
					setTimeout(function(){
						
						$("#id_chk07").prop("checked", true); //cambia el id del checkbox para que funcione
					}, 500);
		       }
               
               if($('#intBaHide').val()==1){
					setTimeout(function(){
						
						$("#id_chk08").prop("checked", true); //cambia el id del checkbox para que funcione
					}, 500);
		       }
               
               if($('#intSeHide').val()==1){
					setTimeout(function(){
						
						$("#id_chk09").prop("checked", true); //cambia el id del checkbox para que funcione
					}, 500);
		       }
               
               if($('#intCuHide').val()==1){
					setTimeout(function(){
						
						$("#id_chk10").prop("checked", true); //cambia el id del checkbox para que funcione
					}, 500);
		       }
               
               if($('#intNaHide').val()==1){
					setTimeout(function(){
						
						$("#id_chk11").prop("checked", true); //cambia el id del checkbox para que funcione
					}, 500);
		       }
               
               if($('#intSbHide').val()==1){
					setTimeout(function(){
						
						$("#id_chk12").prop("checked", true); //cambia el id del checkbox para que funcione
					}, 500);
		       }
               
               if($('#intHgHide').val()==1){
					setTimeout(function(){
						
						$("#id_chk13").prop("checked", true); //cambia el id del checkbox para que funcione
					}, 500);
		       }
               
               if($('#intAlHide').val()==1){
					setTimeout(function(){
						
						$("#id_chk14").prop("checked", true); //cambia el id del checkbox para que funcione
					}, 500);
		       }
               
               if($('#intKHide').val()==1){
					setTimeout(function(){
						
						$("#id_chk15").prop("checked", true); //cambia el id del checkbox para que funcione
					}, 500);
		       }
                
			   $('#idModalEditTitle').html($('#idValEditModalDetalleTitle').html()); 
				
			}else {
				
				$('#strfechaHora').val($('#fecha_header').val());
				$('#strfechaHoraHidden').val($('#fecha_header').val());
				$("#strfechaHora").attr('disabled', 'disabled');
				
				accion = 'S';
				
				$('#idheaderHidden').val(idCabecera);
				$('#accionHidden').val(accion);
//				$('#strfechaHora').datetimepicker({
////			        format: 'DD/MM/YYYY HH:mm:ss',
//			        format: 'DD/MM/YYYY',
//			        ignoreReadonly: false,
//			        date: new Date(),
//			        maxDate: new Date(),
//			        locale: "es"
//			    });
				
				$('#idModalEditTitle').html($('#idValCrearModalDetalleTitle').html());
				
			}
					
			enableValidationRulesDetalle2();
			
		},complete: function() {
			$('#modal-registra-detalle-edit').modal('show');
			$.unblockUI();
			
		}
	});
}


//FUNCION PARA INACTIVAR UN REGISTRO
function inactivarDetalle(ids) {
	$.confirm({
	    title: 'Confirmaci\u00f3n',
	    content: 'Confirma inactivar Registro ?',
	    buttons: {
	    	Aceptar: { 
	        	btnClass: 'btn-blue',
	        	action: function () {
		        	$('#iddetalle_inac222').val(ids); 
				    $.ajax({
			    	   type: 'POST',
			    	   url: $('#form-inactiva-detalle222').attr('action'),
			    	   data: $('#form-inactiva-detalle222').serialize(),  
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


function enableValidationRulesHeader() {

	var validator = $("#form-edit-formularioHeader222").bootstrapValidator({   //id del formulario que se va abrir (POPUP A LEVANTAR)
		message: 'El valor no es v\u00e1lido',
		feedbackIcons : {
			valid : "glyphicon glyphicon-ok",
			invalid : "glyphicon glyphico-remove",
			validating : "glyphicon glyphicon-refresh"
		},
		fields : {
			strFechaMuestreo: {
					validators : {
						
						notEmpty: {
	                        message: 'Ingrese la Fecha'
	                    }
					}
			},
			
			observacion: {
				validators : {
							
					stringLength : {
						max : 400,
						message : "El valor ha de ser como m\u00e1ximo 400 caracteres"
					}		
				}
			},
			
			codMuestra: {
				validators : {
							
					stringLength : {
						max : 8,
						message : "El valor ha de ser como m\u00e1ximo 8 caracteres"
					}		
				}
			},
			
			codMuestra2: {
				validators : {
							
					stringLength : {
						max : 8,
						message : "El valor ha de ser como m\u00e1ximo 8 caracteres"
					}		
				}
			},
			
			codMuestra3: {
				validators : {
							
					stringLength : {
						max : 8,
						message : "El valor ha de ser como m\u00e1ximo 8 caracteres"
					}		
				}
			},
			
			dup: {
				validators : {
							
					stringLength : {
						max : 8,
						message : "El valor ha de ser como m\u00e1ximo 8 caracteres"
					},			
					regexp: {
						 
						 regexp: /^[0-9]+([.][0-9]+)?$/, 
	 
						 message: 'Valor incorrecto'
	 
					}
				}
			},
			
			dup2: {
				validators : {
							
					stringLength : {
						max : 8,
						message : "El valor ha de ser como m\u00e1ximo 8 caracteres"
					},			
					regexp: {
						 
						 regexp: /^[0-9]+([.][0-9]+)?$/, 
	 
						 message: 'Valor incorrecto'
	 
					}
				}
			},
			
			dup3: {
				validators : {
							
					stringLength : {
						max : 8,
						message : "El valor ha de ser como m\u00e1ximo 8 caracteres"
					},			
					regexp: {
						 
						 regexp: /^[0-9]+([.][0-9]+)?$/, 
	 
						 message: 'Valor incorrecto'
	 
					}
				}
			},
			
			dup4: {
				validators : {
							
					stringLength : {
						max : 8,
						message : "El valor ha de ser como m\u00e1ximo 8 caracteres"
					},			
					regexp: {
						 
						 regexp: /^[0-9]+([.][0-9]+)?$/, 
	 
						 message: 'Valor incorrecto'
	 
					}
				}
			},
			
			dup5: {
				validators : {
							
					stringLength : {
						max : 8,
						message : "El valor ha de ser como m\u00e1ximo 8 caracteres"
					},			
					regexp: {
						 
						 regexp: /^[0-9]+([.][0-9]+)?$/, 
	 
						 message: 'Valor incorrecto'
	 
					}
				}
			},
			
			pro: {
				validators : {
							
					stringLength : {
						max : 8,
						message : "El valor ha de ser como m\u00e1ximo 8 caracteres"
					},			
					regexp: {
						 
						 regexp: /^[0-9]+([.][0-9]+)?$/, 
	 
						 message: 'Valor incorrecto'
	 
					}
				}
			},
			
			pro2: {
				validators : {
							
					stringLength : {
						max : 8,
						message : "El valor ha de ser como m\u00e1ximo 8 caracteres"
					},			
					regexp: {
						 
						 regexp: /^[0-9]+([.][0-9]+)?$/, 
	 
						 message: 'Valor incorrecto'
	 
					}
				}
			},
			
			pro3: {
				validators : {
							
					stringLength : {
						max : 8,
						message : "El valor ha de ser como m\u00e1ximo 8 caracteres"
					},			
					regexp: {
						 
						 regexp: /^[0-9]+([.][0-9]+)?$/, 
	 
						 message: 'Valor incorrecto'
	 
					}
				}
			},
			
			pro4: {
				validators : {
							
					stringLength : {
						max : 8,
						message : "El valor ha de ser como m\u00e1ximo 8 caracteres"
					},			
					regexp: {
						 
						 regexp: /^[0-9]+([.][0-9]+)?$/, 
	 
						 message: 'Valor incorrecto'
	 
					}
				}
			},
			
			pro5: {
				validators : {
							
					stringLength : {
						max : 8,
						message : "El valor ha de ser como m\u00e1ximo 8 caracteres"
					},			
					regexp: {
						 
						 regexp: /^[0-9]+([.][0-9]+)?$/, 
	 
						 message: 'Valor incorrecto'
	 
					}
				}
			},
			
			rds: {
				validators : {
							
					stringLength : {
						max : 8,
						message : "El valor ha de ser como m\u00e1ximo 8 caracteres"
					},			
					regexp: {
						 
						 regexp: /^[0-9]+([.][0-9]+)?$/, 
	 
						 message: 'Valor incorrecto'
	 
					}
				}
			},
			
			rds2: {
				validators : {
							
					stringLength : {
						max : 8,
						message : "El valor ha de ser como m\u00e1ximo 8 caracteres"
					},			
					regexp: {
						 
						 regexp: /^[0-9]+([.][0-9]+)?$/, 
	 
						 message: 'Valor incorrecto'
	 
					}
				}
			},
			
			rds3: {
				validators : {
							
					stringLength : {
						max : 8,
						message : "El valor ha de ser como m\u00e1ximo 8 caracteres"
					},			
					regexp: {
						 
						 regexp: /^[0-9]+([.][0-9]+)?$/, 
	 
						 message: 'Valor incorrecto'
	 
					}
				}
			},
			
			rds4: {
				validators : {
							
					stringLength : {
						max : 8,
						message : "El valor ha de ser como m\u00e1ximo 8 caracteres"
					},			
					regexp: {
						 
						 regexp: /^[0-9]+([.][0-9]+)?$/, 
	 
						 message: 'Valor incorrecto'
	 
					}
				}
			},
			
			rds5: {
				validators : {
							
					stringLength : {
						max : 8,
						message : "El valor ha de ser como m\u00e1ximo 8 caracteres"
					},			
					regexp: {
						 
						 regexp: /^[0-9]+([.][0-9]+)?$/, 
	 
						 message: 'Valor incorrecto'
	 
					}
				}
			},
				
		}
	})	
	.on('success.form.bv', function(e, data) {
		$("#guardarButton").html('Guardando...');
		$("#guardarButton").attr('disabled', 'disabled');
		e.preventDefault();
		var $formularioHeaderValidator222 = $(e.target);
		$.ajax({
			type: 'POST',
			url: $('#form-edit-formularioHeader222').attr('action'), //id del formulario que se va abrir (POPUP A LEVANTAR)
			data: $('#form-edit-formularioHeader222').serialize(),
			success: function(result){
				$formularioHeaderValidator222.bootstrapValidator('resetForm', true);
				$formularioHeaderValidator222[0].reset();
				$('.container_save').html(result);
			},
			complete: function() {
				$("#guardarButton").html('Guardar');
				$('#guardarButton').removeAttr("disabled");
			}
		});
	});	
}

function enableValidationRulesDetalle2() {
	
	var TIME_PATTERN = /^([01]?[0-9]|2[0-3]):([0-5][0-9])$/;
	
	$('#hora').datetimepicker({
		//defaultDate: new Date(),
        format: 'HH:mm',
        ignoreReadonly: true,
        locale: "es"
    }).on('dp.change dp.show', function (e) {
        $('#form-edit-Detalle-id').bootstrapValidator('revalidateField', 'hora');
    });

	var validator = $("#form-edit-registrarDetalle222").bootstrapValidator({
		message: 'El valor no es v\u00e1lido',
		feedbackIcons : {
			valid : "glyphicon glyphicon-ok",
			invalid : "glyphicon glyphico-remove",
			validating : "glyphicon glyphicon-refresh"
		},
		fields : {
			strfechaHora: {
					validators : {
						
						notEmpty: {
	                        message: 'Ingrese la Fecha'
	                    }
					}
			},
			
			hora : {
				verbose: false,
				message : "Ingrese la hora",
				validators : {
					
					regexp: {
						regexp: /^([01]?[0-9]|2[0-3]):([0-5][0-9])$/,
                        message: "Debe tener el formato HH:MM (24 horas)"
                    },
                    
                    stringLength : {
						max : 5,
						message : "El campo ha de ser como m\u00e1ximo 5 caracteres"
					},

					notEmpty: {
                        message: 'Ingrese la Hora'
                    },
				}
			},
			
			codMuestra: {
				validators : {
					
					notEmpty: {
                        message: 'Ingresar Codigo'
                    }
				  }
		    },
			
			od: {
				validators : {
							
					stringLength : {
						max : 8,
						message : "El valor ha de ser como m\u00e1ximo 8 caracteres"
					},			
					regexp: {
						 
						 regexp: /^[0-9]+([.][0-9]+)?$/, 
	 
						 message: 'Valor incorrecto'
	 
					}
				}
			},
			
			ph: {
				validators : {
							
					stringLength : {
						max : 8,
						message : "El valor ha de ser como m\u00e1ximo 8 caracteres"
					},			
					regexp: {
						 
						 regexp: /^[0-9]+([.][0-9]+)?$/, 
	 
						 message: 'Valor incorrecto'
	 
					}
				}
			},
			
			temp: {
				validators : {
							
					stringLength : {
						max : 8,
						message : "El valor ha de ser como m\u00e1ximo 8 caracteres"
					},			
					regexp: {
						 
						 regexp: /^[0-9]+([.][0-9]+)?$/, 
	 
						 message: 'Valor incorrecto'
	 
					}
				}
			},
			
			cond: {
				validators : {
							
					stringLength : {
						max : 8,
						message : "El valor ha de ser como m\u00e1ximo 8 caracteres"
					},			
					regexp: {
						 
						 regexp: /^[0-9]+([.][0-9]+)?$/, 
	 
						 message: 'Valor incorrecto'
	 
					}
				}
			},
			
			turb: {
				validators : {
							
					stringLength : {
						max : 8,
						message : "El valor ha de ser como m\u00e1ximo 8 caracteres"
					},			
					regexp: {
						 
						 regexp: /^[0-9]+([.][0-9]+)?$/, 
	 
						 message: 'Valor incorrecto'
	 
					}
				}
			},
				
		}
	})	
	.on('success.form.bv', function(e, data) {
		$("#guardarButton").html('Guardando...');
		$("#guardarButton").attr('disabled', 'disabled');
		e.preventDefault();
		var $formularioDetalleValidator222 = $(e.target);
		$.ajax({
			type: 'POST',
			url: $('#form-edit-registrarDetalle222').attr('action'), //id del formulario que se va abrir (POPUP A LEVANTAR)
			data: $('#form-edit-registrarDetalle222').serialize(),
			success: function(result){
				$formularioDetalleValidator222.bootstrapValidator('resetForm', true);
				$formularioDetalleValidator222[0].reset();
				$('.container_save').html(result);
			},
			complete: function() {
				$("#guardarButton").html('Guardar');
				$('#guardarButton').removeAttr("disabled");
			}
		});
	});	
}




function showToastFormulario222(mensajeTipo, mensajeError) {
	//Mensajes despues de grabar
	if(mensajeTipo==='grabadoOk'){
		 toastr["success"](mensajeError, "Registro correctamente guardado");
		 $('#modal-registra-formularioHeader').modal('hide');
		 $('#idBtnBuscarFormulario').click();
	 }
	 if(mensajeTipo==='grabadoNoOk'){
		 toastr["error"](mensajeError, "Hubo un error en el servidor, el registro no fue guardado");
	 }
	 //Mensajes despues de eliminar
	 if(mensajeTipo==='inactivadoOk'){
		 toastr["success"](mensajeError, "Registro correctamente inactivado");
		 $('#modal-registra-formularioHeader').modal('hide');
		 $('#idBtnBuscarTurbidimetroDigital').click();
	 }
	 if(mensajeTipo==='inactivadoNoOk'){
		 toastr["error"](mensajeError, "Hubo un error en el servidor, el registro no fue inactivado");
	 }
	 if(mensajeTipo==='RegDuplicado'){
		 toastr["success"](mensajeError, "Registro ya existe en la Tabla");
		 $('#modal-registra-formularioHeader').modal('hide');
		 //$('#idBtnBuscarTurbidimetroDigital').click();
	 }
	 if(mensajeTipo==='grabadoOkSubForm'){
		 toastr["success"](mensajeError, "Registro agregado correctamente");
		 $('#modal-registra-detalle-edit').modal('hide');
//		 $('#idCodigoVerifEquipo').val($('#intCodigo').val());
		 $('#myTableDetalle222').DataTable().ajax.reload();   //LLAMA AL DATATABLE DETALLE A TRAVES DE SU ID
	 }
	 if(mensajeTipo==='inactivadoOkSubForm'){

		 toastr["success"](mensajeError, "Registro correctamente inactivado");
//		 $('#idCodigoVerifEquipo').val($('#intCodigo').val());
		 $('#myTableDetalle222').DataTable().ajax.reload();
	 }
}

