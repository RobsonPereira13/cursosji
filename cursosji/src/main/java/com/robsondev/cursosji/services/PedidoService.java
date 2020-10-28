package com.robsondev.cursosji.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.robsondev.cursosji.domain.Pedido;
import com.robsondev.cursosji.repositories.PedidoRepository;
import com.robsondev.cursosji.services.exceptions.ObjectNotFoundExeception;

@Service
public class PedidoService {
	
	@Autowired
	private PedidoRepository repo;
	
	public Pedido find(Integer id) {
		 Optional<Pedido> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundExeception(
		 "Objeto não encontrado! Id: " + id + ", Tipo: " + Pedido.class.getName())); 
		

	}

}
