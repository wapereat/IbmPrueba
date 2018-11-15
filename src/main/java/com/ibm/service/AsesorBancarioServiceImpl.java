package com.ibm.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibm.dao.IAsesorBancarioDao;
import com.ibm.entity.AsesorBancario;

@Service
public class AsesorBancarioServiceImpl implements IAsesorBancarioService {
	
	@Autowired
	IAsesorBancarioDao asesorBancarioDao;
	

	@PersistenceContext
	EntityManager em;

	@Override
	public List<AsesorBancario> listarClientes() throws Exception {
		asesorBancarioDao.findAll();
		
		
		return asesorBancarioDao.findAll();	}

	@Override
	public void saveCliente(AsesorBancario asesorBancario) throws Exception {
		asesorBancarioDao.save(asesorBancario);

	}

	@Override
	public AsesorBancario findById(int id) throws Exception {
		return asesorBancarioDao.findById(id).get();
	}

	@Override
	public void eliminarById(int IdsesorBancario) throws Exception {
		AsesorBancario asesorBancario = new AsesorBancario();
		asesorBancario=findById(IdsesorBancario);
		asesorBancarioDao.delete(asesorBancario);

	}

}
