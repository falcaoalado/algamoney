package com.algamoney.api.service;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.algamoney.api.model.Pessoa;
import com.algamoney.api.repository.PessoaRepository;

@Service
public class PessoaService {

	@Autowired
	private PessoaRepository repository;
	
	public Pessoa atualizar(Long id, Pessoa pessoa) {
		Optional<Pessoa> pessoaSalva = repository.findById(id);
		
		if (!pessoaSalva.isPresent())
			throw new EmptyResultDataAccessException(1);
		
		BeanUtils.copyProperties(pessoa, pessoaSalva.get(), "id");
		
		return repository.save(pessoaSalva.get());
	}
}
