package com.algamoney.api.resource;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.algamoney.api.model.Categoria;
import com.algamoney.api.repository.CategoriaRepository;
import com.fasterxml.jackson.databind.exc.UnrecognizedPropertyException;

@RestController
@RequestMapping("/categorias")
public class CategoriaResource {

	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@GetMapping
	public List<Categoria> listar() {
		return categoriaRepository.findAll();
	}
	
	@PostMapping
	public ResponseEntity<Categoria> criar(@RequestBody Categoria categoria) {
		Categoria save = categoriaRepository.save(categoria);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri()
											 .path("/{codigo}")
								   			 .buildAndExpand(save.getId())
								   			 .toUri();
		
		return ResponseEntity.created(uri).body(save);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> buscarPeloCodigo(@PathVariable Long id) {
		Optional<Categoria> findById = categoriaRepository.findById(id);
		
		return findById.isPresent() ? ResponseEntity.ok(findById) : ResponseEntity.notFound().build();
	}
	
	//TODO: remover
	@ExceptionHandler({UnrecognizedPropertyException.class})
	public HttpStatus UnrecognizedPropertyHandler(UnrecognizedPropertyException e) {
		return HttpStatus.ALREADY_REPORTED;
	}
}
