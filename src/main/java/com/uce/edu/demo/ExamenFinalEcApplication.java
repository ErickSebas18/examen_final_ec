package com.uce.edu.demo;

import java.time.LocalDateTime;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.demo.repository.modelo.VueloSencillo;
import com.uce.edu.demo.service.IGestorVuelosDisponibles;
import com.uce.edu.demo.service.IVueloService;

@SpringBootApplication
public class ExamenFinalEcApplication implements CommandLineRunner{

	private static Logger logJava = Logger.getLogger(ExamenFinalEcApplication.class);
	
	@Autowired
	private IGestorVuelosDisponibles iGestorVuelosDisponibles;
	
	public static void main(String[] args) {
		SpringApplication.run(ExamenFinalEcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		List<VueloSencillo> lista = this.iGestorVuelosDisponibles.buscarVuelosDisponibles("Portugal", "Londres", LocalDateTime.of(2022,05,23, 0, 0));
		
		for (VueloSencillo s : lista) {
			logJava.info(s);
		}
	}

}
