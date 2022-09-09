package com.uce.edu.demo.service;

import java.time.LocalDateTime;
import java.util.List;

import com.uce.edu.demo.repository.modelo.VueloSencillo;

public interface IGestorVuelosDisponibles {

	public List<VueloSencillo> buscarVuelosDisponibles(String origen, String destino, LocalDateTime fechaVuelo);
	
	public void reservarVuelo(String numero, Integer cantidad, String cedulaCliente);
}
