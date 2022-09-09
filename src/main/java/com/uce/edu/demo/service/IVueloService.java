package com.uce.edu.demo.service;

import java.time.LocalDateTime;
import java.util.List;

import com.uce.edu.demo.repository.modelo.Vuelo;
import com.uce.edu.demo.repository.modelo.VueloSencillo;

public interface IVueloService {

	public List<VueloSencillo> buscarVuelosDisponibles(String origen, String destino, LocalDateTime fechaVuelo);
	
	public Vuelo buscarNumeroVuelo(String numero);
}
