package com.ibm.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="CLIENTES")
//@NamedQuery(name="Cliente", query="SELECT a FROM Cliente")
public class Cliente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	private int idCliente;
	
	@Column(length = 50)
	private String nombre;
	
	@Column(length = 100)
	private String direccion;
	
	@Column(length = 30 )
	private String ciudad;
	
	@Column(length = 20 )
	private String telefono;
	
	@OneToMany(mappedBy = "cliente" , fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Tarjeta> tarjetas;
	
	public Cliente(){
		
		this.tarjetas = new ArrayList<Tarjeta>();
	}

	
	
	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public List<Tarjeta> getTarjetas() {
		return tarjetas;
	}

	public void setTarjetas(List<Tarjeta> tarjetas) {
		this.tarjetas = tarjetas;
	}

	
	public void addTarjeta(Tarjeta tarjeta) {
		
		this.tarjetas.add(tarjeta);
	}
	
	
	
	


}
