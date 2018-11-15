package com.ibm.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibm.dao.IClienteDao;
import com.ibm.entity.Cliente;

@Service
public class ClienteServiceImpl implements IClienteService {
	
	@Autowired
	IClienteDao clienteDao;
	
	@PersistenceContext
	EntityManager em;

	@Override
	public List<Cliente> listarClientes() throws Exception {
		
		clienteDao.findAll();
		
	
		return clienteDao.findAll();
	}

	@Override
	public void saveCliente(Cliente cliente) throws Exception {
		/*if(cliente.getIdCliente() > 0 )
		{
			em.merge(cliente);
			
		}
		else*/
		clienteDao.save(cliente);
		
	}

	@Override
	public Cliente findById(int id) throws Exception {
		
		return clienteDao.findById(id).get();
	}

	@Override
	public void eliminarById(int idCliente) throws Exception {
		
		Cliente cliente = new Cliente();
		cliente=findById(idCliente);
		clienteDao.delete(cliente);
		
	}

}
