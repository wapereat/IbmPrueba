package com.ibm.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ibm.entity.Cliente;

public interface IClienteDao extends JpaRepository<Cliente, Integer> {

}
