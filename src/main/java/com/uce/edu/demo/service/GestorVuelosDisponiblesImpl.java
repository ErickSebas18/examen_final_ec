package com.uce.edu.demo.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.repository.ICompraPasajeRepository;
import com.uce.edu.demo.repository.IVueloRepository;
import com.uce.edu.demo.repository.modelo.CompraPasaje;
import com.uce.edu.demo.repository.modelo.Vuelo;
import com.uce.edu.demo.repository.modelo.VueloSencillo;

@Service
public class GestorVuelosDisponiblesImpl implements IGestorVuelosDisponibles{

	@Autowired
	private IVueloService iVueloService;
	
	@Autowired
	private ICompraPasajeRepository compraPasajeRepository;
	
	@Autowired
	private IVueloRepository iVueloRepository;
	
	@Override
	public List<VueloSencillo> buscarVuelosDisponibles(String origen, String destino, LocalDateTime fechaVuelo) {
		// TODO Auto-generated method stub
		List<VueloSencillo> lista = this.iVueloService.buscarVuelosDisponibles(origen, destino, fechaVuelo);
		
		List<VueloSencillo> vuelosDisponibles = lista.stream().filter(list -> list.getEstado().equals("DIS"))
				.collect(Collectors.toList());
		
		return vuelosDisponibles;
	}

	@Override
	@Transactional(value = TxType.REQUIRES_NEW)
	public void reservarVuelo(String numero, Integer cantidad, String cedulaCliente) {

		Vuelo vuelo = this.iVueloService.buscarNumeroVuelo(numero);
		
		if(vuelo.getEstado().equals("DIS")) {
			CompraPasaje cp = new CompraPasaje();
			cp.setCantidadAsientosComprados(cantidad);
			cp.setFechaCompra(LocalDateTime.now());
			cp.setVuelo(vuelo);
			cp.setEstado("RES");
			this.compraPasajeRepository.insertar(cp);
		}

		if (vuelo.getAsientosDisponibles() <= cantidad) {
			cantidad = vuelo.getAsientosDisponibles();
			new RuntimeException();
		}
		vuelo.setAsientosDisponibles(vuelo.getAsientosDisponibles() - cantidad);
		if (vuelo.getAsientosDisponibles() == 0) {
			vuelo.setEstado("ND");
		}

		this.iVueloRepository.actualizar(vuelo);

	}

}
