package com.uce.edu.demo.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.uce.edu.demo.repository.modelo.CompraPasaje;
import com.uce.edu.demo.repository.modelo.VueloSencillo;
import com.uce.edu.demo.service.IGestorVuelosDisponibles;

@Controller
@RequestMapping("/compras")
public class CompraController {

	@Autowired
	private IGestorVuelosDisponibles disponibles;

	/*
	 * @GetMapping("/buscarVuelos/{origen}/{destino}/{fechaVuelo}") public String
	 * buscarVuelos(@PathVariable("origen") String origen, @PathVariable("destino")
	 * String destino, @PathVariable("fechaVuelo") String fechaVuelo, Model modelo)
	 * { LocalDateTime fecha = LocalDateTime.parse(fechaVuelo); List<VueloSencillo>
	 * lista = this.disponibles.buscarVuelosDisponibles(origen, destino, fecha);
	 * modelo.addAttribute("vuelos", lista); return "vistaElegirAsientos"; }
	 */

	@GetMapping("/buscarVuelos/{origen}/{destino}/{fechaVuelo}")
	public String buscarVuelosDisponibles(@PathVariable("origen") String origen,
			@PathVariable("destino") String destino, @PathVariable("fechaVuelo") String fechaVuelo, Model modelo) {
		LocalDateTime fecha = LocalDateTime.parse(fechaVuelo);
		List<VueloSencillo> lista = this.disponibles.buscarVuelosDisponibles(origen, destino, fecha);
		modelo.addAttribute("vuelos", lista);
		return "vistaBuscarVuelos";
	}

	@PostMapping("/reservar/{numero}")
	public String buscarV(@PathVariable("numero") String numero, CompraPasaje compraPasaje) {
		this.disponibles.reservarVuelo(numero, compraPasaje.getCantidadAsientosComprados(),
				compraPasaje.getCliente().getCedula());
		return "redirect:/clientes/buscarTodos";
	}

}
