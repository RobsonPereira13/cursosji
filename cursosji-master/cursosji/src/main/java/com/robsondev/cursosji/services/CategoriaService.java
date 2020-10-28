package com.robsondev.cursosji.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.robsondev.cursosji.domain.Categoria;
import com.robsondev.cursosji.repositories.CategoriaRepository;
import com.robsondev.cursosji.services.exceptions.ObjectNotFoundExeception;

@Service
public class CategoriaService {
	
	@Autowired
	private CategoriaRepository repo;
	
	public Categoria find(Integer id) {
		 Optional<Categoria> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundExeception(
		 "Objeto não encontrado! Id: " + id + ", Tipo: " + Categoria.class.getName())); 
		

	}

}
