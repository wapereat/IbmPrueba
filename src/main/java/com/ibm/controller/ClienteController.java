package com.ibm.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

import com.ibm.entity.Cliente;
import com.ibm.service.IClienteService;

@Controller
@SessionAttributes("cliente")
public class ClienteController {
	
	@Value("${application.controllers.mensaje}")
	private String mensaje;
	
	@Autowired
	IClienteService clienteService;
	
	
	@GetMapping("listaCliente")
	public ResponseEntity<List <Cliente>>  listaClientes(){
		
		List<Cliente> clientes= new ArrayList<Cliente>();
		
		try {
			clientes = clienteService.listarClientes();
		}
	
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return new ResponseEntity<List <Cliente>> (clientes, HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/findById")
	public ResponseEntity<Cliente>  findById(){
		
	    Cliente clientes= new Cliente();
		
		try {
			clientes = clienteService.findById(1);
		}
	
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return new ResponseEntity<Cliente> (clientes, HttpStatus.ACCEPTED);
	}
	
	
	//lleva a la vista de listado cliente
	@GetMapping("/listaClientes")
	public String listarCliente(Model model) throws Exception {
		model.addAttribute("titulo", "Listado Cliente");
		model.addAttribute("clientes",clienteService.listarClientes());
		return "listaClientes";//nombre del archivo html
	}
	
//Guardar
	//lleva a la vista de creación cliente 

	@RequestMapping(value = "/form")
	public String crear(Map<String, Object> model) {

		Cliente cliente = new Cliente();
		model.put("cliente", cliente);
		model.put("titulo", "Formulario de Cliente");
		return "formCliente";
	}
	
	

//Editar
	
	@RequestMapping(value="/form/{id}")
	public String editar(@PathVariable(value="id") int id, Map<String, Object> model) throws Exception {
		
		Cliente cliente = null;
		
		if(id > 0) {
			cliente = clienteService.findById(id);
		} else {
			return "redirect:listaClientes";
		}
		model.put("cliente", cliente);
		model.put("titulo", "Editar Cliente");
		return "formCliente";
	}
	
	//elimina
	

	
	@RequestMapping(value="/eliminar/{id}")
	public String eliminar(@PathVariable(value="id") int id) throws Exception {
		
		if(id > 0) {
			clienteService.eliminarById(id);
		}
		return "redirect:/listaClientes";
	}

	

//guarda 
	@RequestMapping(value = "/form", method = RequestMethod.POST)
	public String guardar(@Valid Cliente cliente, BindingResult result, Model model, SessionStatus status) throws Exception {

		if (result.hasErrors()) {
			model.addAttribute("titulo", "Formulario de Cliente");
			return "form";
		}

		clienteService.saveCliente(cliente);
		status.setComplete();
		return "redirect:listaClientes";
	}
	

	
	@GetMapping(value = "/ver/{id}")
	public String ver(@PathVariable(value = "id") int id, Map<String, Object> model, RedirectAttributes flash) throws Exception {

		Cliente cliente = clienteService.findById(id);
		if (cliente == null) {
			flash.addFlashAttribute("error", "El cliente no existe en la base de datos");
			return "redirect:/listaClientes";
		}

		model.put("cliente", cliente);
		model.put("titulo", "Tarjetas del cliente: " + cliente.getNombre());
		return "ver";
	}
	
}
