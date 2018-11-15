package com.ibm.controller;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ibm.entity.AsesorBancario;
import com.ibm.service.IAsesorBancarioService;

@Controller
@SessionAttributes("asesorBancario")
public class AsesorBancarioController {

	@Autowired
	IAsesorBancarioService asesorBancarioService;
	
	
	//lleva a la vista de listado cliente
		@GetMapping("/listaAsesoresBancarios")
		public String listarCliente(Model model) throws Exception {
			model.addAttribute("titulo", "Listado lista Asesores Bancarios");
			model.addAttribute("asesorBancarios",asesorBancarioService.listarClientes());
			return "listaAsesoresBancarios";//nombre del archivo html
		}
		

		//Guardar
			//lleva a la vista de creación cliente 

			@RequestMapping(value = "/formAsesor")
			public String crear(Map<String, Object> model) {

				AsesorBancario asesorBancario = new AsesorBancario();
				model.put("asesorBancario", asesorBancario);
				model.put("titulo", "Formulario de Asesor Bancario");
				return "formAsesor";
			}
			
			

		//Editar
			
			@RequestMapping(value="/formAsesor/{id}")
			public String editar(@PathVariable(value="id") int id, Map<String, Object> model) throws Exception {
				
				AsesorBancario asesorBancario = null;
				
				if(id > 0) {
					asesorBancario = asesorBancarioService.findById(id);
				} else {
					return "redirect:listaAsesoresBancarios";
				}
				model.put("asesorBancario", asesorBancario);
				model.put("titulo", "Editar Cliente");
				return "formAsesor";
			}
			
			//elimina
			

			
			@RequestMapping(value="/eliminarAsesor/{id}")
			public String eliminar(@PathVariable(value="id") int id) throws Exception {
				
				if(id > 0) {
					asesorBancarioService.eliminarById(id);
				}
				return "redirect:/listaAsesoresBancarios";
			}

			

		//guarda 
			@RequestMapping(value = "/formAsesor", method = RequestMethod.POST)
			public String guardar(@Valid AsesorBancario asesorBancario, BindingResult result, Model model, SessionStatus status) throws Exception {

				if (result.hasErrors()) {
					model.addAttribute("titulo", "Formulario de Asesor");
					return "form";
				}

				asesorBancarioService.saveCliente(asesorBancario);
				status.setComplete();
				return "redirect:listaAsesoresBancarios";
			}
			

			
		
			
	
}
