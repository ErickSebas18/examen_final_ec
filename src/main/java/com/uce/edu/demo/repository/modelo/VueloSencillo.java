package com.uce.edu.demo.repository.modelo;

public class VueloSencillo {

	private String numeroVuelo;
	private String origen;
	private String destino;
	private String nombreAvion;
	private String valorAsiento;
	private String estado;

	public VueloSencillo() {
		// TODO Auto-generated constructor stub
	}
	
	public VueloSencillo(String numeroVuelo, String origen, String destino, String nombreAvion, String valorAsiento, String estado) {
		this.numeroVuelo = numeroVuelo;
		this.origen = origen;
		this.destino = destino;
		this.nombreAvion = nombreAvion;
		this.valorAsiento = valorAsiento;
		this.estado = estado;
	}

	//SET Y GET
	public String getNumeroVuelo() {
		return numeroVuelo;
	}

	public void setNumeroVuelo(String numeroVuelo) {
		this.numeroVuelo = numeroVuelo;
	}

	public String getOrigen() {
		return origen;
	}

	public void setOrigen(String origen) {
		this.origen = origen;
	}

	public String getDestino() {
		return destino;
	}

	public void setDestino(String destino) {
		this.destino = destino;
	}

	public String getNombreAvion() {
		return nombreAvion;
	}

	public void setNombreAvion(String nombreAvion) {
		this.nombreAvion = nombreAvion;
	}

	public String getValorAsiento() {
		return valorAsiento;
	}

	public void setValorAsiento(String valorAsiento) {
		this.valorAsiento = valorAsiento;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	@Override
	public String toString() {
		return "VueloSencillo [numeroVuelo=" + numeroVuelo + ", origen=" + origen + ", destino=" + destino
				+ ", nombreAvion=" + nombreAvion + ", valorAsiento=" + valorAsiento + "]";
	}

}
