package com.uce.edu.demo.repository;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.stereotype.Repository;

import com.uce.edu.demo.repository.modelo.Vuelo;
import com.uce.edu.demo.repository.modelo.VueloSencillo;

@Repository
@Transactional
public class VueloRepositoryImpl implements IVueloRepository{

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	@Transactional(value = TxType.NOT_SUPPORTED)
	public List<VueloSencillo> buscar(String origen, String destino, LocalDateTime fechaVuelo) {
		// TODO Auto-generated method stub
		TypedQuery<VueloSencillo> query = this.entityManager.createNamedQuery("Vuelo.buscarVuelos", VueloSencillo.class);
		query.setParameter("origen", origen);
		query.setParameter("destino", destino);
		query.setParameter("fechaVuelo", fechaVuelo);
		return query.getResultList();
	}

	@Override
	@Transactional(value = TxType.NOT_SUPPORTED)
	public Vuelo buscarNumeroVuelo(String numero) {
		// TODO Auto-generated method stub
		TypedQuery<Vuelo> query = this.entityManager.createQuery("Select v from Vuelo v where v.numero = :numero", Vuelo.class);
		query.setParameter("numero", numero);
		return query.getSingleResult();
	}

	@Override
	public void actualizar(Vuelo vuelo) {
		// TODO Auto-generated method stub
		this.entityManager.merge(vuelo);
	}

}
