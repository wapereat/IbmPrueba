package com.ibm.service;

import java.util.List;

import com.ibm.entity.AsesorBancario;

public interface IAsesorBancarioService {
	
public List<AsesorBancario> listarClientes()throws Exception;
	
	public void saveCliente(AsesorBancario asesorBancario) throws Exception;
	
	public AsesorBancario findById(int id) throws Exception; 
	
	public void eliminarById(int IdsesorBancario) throws Exception; 
	

}
