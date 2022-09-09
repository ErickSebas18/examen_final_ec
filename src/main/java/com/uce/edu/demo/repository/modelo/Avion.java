package com.uce.edu.demo.repository.modelo;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "avion")
public class Avion {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "avio_seq_id")
	@SequenceGenerator(name = "avio_seq_id", sequenceName = "avio_seq_id", allocationSize = 1)
	@Column(name = "avio_id")
	private Integer id;
	@Column(name = "avio_numero")
	private String numero;
	@Column(name = "avio_capacidad_asientos")
	private Integer capacidadAsientos;
	@Column(name = "avio_nombre")
	private String nombre;

	@OneToMany(mappedBy = "avion")
	private List<Vuelo> vuelos;

	//SET Y GET
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getCapacidadAsientos() {
		return capacidadAsientos;
	}

	public void setCapacidadAsientos(Integer capacidadAsientos) {
		this.capacidadAsientos = capacidadAsientos;
	}

	public List<Vuelo> getVuelos() {
		return vuelos;
	}

	public void setVuelos(List<Vuelo> vuelos) {
		this.vuelos = vuelos;
	}

}
