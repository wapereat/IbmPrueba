package com.ibm.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Length;

@Entity
@Table(name="TARJETAS")
public class Tarjeta {
	
	@Id
	private String numeroTarjeta;
	
	@Length(min = 3, max = 4)
	private String ccv;
	
	@Column(length = 50)
	private String tipoTarjeta;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Cliente cliente;
	
	@OneToMany(mappedBy = "tarjeta"  ,fetch = FetchType.LAZY, cascade =  CascadeType.ALL)
	private List<Consumo> consumos;
	
	
	Tarjeta(){
		
		this.consumos =  new ArrayList<Consumo>();
	}


	public String getNumeroTarjeta() {
		return numeroTarjeta;
	}


	public void setNumeroTarjeta(String numeroTarjeta) {
		this.numeroTarjeta = numeroTarjeta;
	}


	public String getCcv() {
		return ccv;
	}


	public void setCcv(String ccv) {
		this.ccv = ccv;
	}


	public String getTipoTarjeta() {
		return tipoTarjeta;
	}


	public void setTipoTarjeta(String tipoTarjeta) {
		this.tipoTarjeta = tipoTarjeta;
	}


	public Cliente getCliente() {
		return cliente;
	}


	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}


	public List<Consumo> getConsumos() {
		return consumos;
	}


	public void setConsumos(List<Consumo> consumos) {
		this.consumos = consumos;
	}

	
	public void addConsumos(Consumo consumo) {
		
		this.consumos.add(consumo);
	}




	
	

}
