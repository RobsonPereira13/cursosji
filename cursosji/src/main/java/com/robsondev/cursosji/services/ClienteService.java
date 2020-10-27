package com.robsondev.cursosji.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.robsondev.cursosji.domain.Cliente;
import com.robsondev.cursosji.repositories.ClienteRepository;
import com.robsondev.cursosji.services.exceptions.ObjectNotFoundExeception;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository repo;
	
	public Cliente find(Integer id) {
		 Optional<Cliente> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundExeception(
		 "Objeto não encontrado! Id: " + id + ", Tipo: " + Cliente.class.getName())); 
		

	}

}
