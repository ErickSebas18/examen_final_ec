package com.uce.edu.demo.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.repository.IVueloRepository;
import com.uce.edu.demo.repository.modelo.Vuelo;
import com.uce.edu.demo.repository.modelo.VueloSencillo;

@Service
public class VueloServiceImpl implements IVueloService{

	@Autowired
	private IVueloRepository iVueloRepository;
	
	@Override
	public List<VueloSencillo> buscarVuelosDisponibles(String origen, String destino, LocalDateTime fechaVuelo) {
		// TODO Auto-generated method stub
		return this.iVueloRepository.buscar(origen, destino, fechaVuelo);
	}

	@Override
	public Vuelo buscarNumeroVuelo(String numero) {
		// TODO Auto-generated method stub
		return this.iVueloRepository.buscarNumeroVuelo(numero);
	}

}
