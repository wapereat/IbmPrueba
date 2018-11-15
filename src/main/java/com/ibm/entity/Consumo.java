package com.ibm.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="CONSUMOS")
public class Consumo {
	
	@Id
	private int idConsumo;
	
	private Date consumo;
	
	@Column(length = 100)
	private String descripcion;
	
	@Column(length = 12)
	private Double monto;
	
	@ManyToOne(fetch =  FetchType.LAZY)
	private Tarjeta tarjeta;
	

	public Date getConsumo() {
		return consumo;
	}

	public void setConsumo(Date consumo) {
		this.consumo = consumo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Double getMonto() {
		return monto;
	}

	public void setMonto(Double monto) {
		this.monto = monto;
	}

	public int getIdConsumo() {
		return idConsumo;
	}

	public void setIdConsumo(int idConsumo) {
		this.idConsumo = idConsumo;
	}

	public Tarjeta getTarjeta() {
		return tarjeta;
	}

	public void setTarjeta(Tarjeta tarjeta) {
		this.tarjeta = tarjeta;
	}
	
	

}
