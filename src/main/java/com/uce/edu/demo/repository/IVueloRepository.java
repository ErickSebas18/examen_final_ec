package com.uce.edu.demo.repository;

import java.time.LocalDateTime;
import java.util.List;

import com.uce.edu.demo.repository.modelo.Vuelo;
import com.uce.edu.demo.repository.modelo.VueloSencillo;

public interface IVueloRepository {

	public List<VueloSencillo> buscar(String origen, String destino, LocalDateTime fechaVuelo);
	
	public Vuelo buscarNumeroVuelo(String numero);
	
	public void actualizar(Vuelo vuelo);
}
