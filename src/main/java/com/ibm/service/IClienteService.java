package com.ibm.service;

import java.util.List;

import com.ibm.entity.Cliente;

public interface IClienteService {
	
	public List<Cliente> listarClientes()throws Exception;
	
	public void saveCliente(Cliente cliente) throws Exception;
	
	public Cliente findById(int id) throws Exception; 
	
	public void eliminarById(int idcliente) throws Exception; 
	

}
