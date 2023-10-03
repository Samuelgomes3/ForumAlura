package alura.com.forum.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import alura.com.forum.topicos.DadosListagemTopicos;
import alura.com.forum.topicos.Topicos;
import alura.com.forum.topicos.TopicosRepository;
import jakarta.validation.Valid;

@RestController
@RequestMapping("topicos")
public class TopicosController {
	
	@Autowired
	private TopicosRepository repository;
	
	@PostMapping
	@Transactional
	public void salvar(@RequestBody @Valid DadosTopicos dados) {
		DadosTopicos topicoExistente = repository.getByTitulo(dados.titulo());
		if (topicoExistente == null) {
			repository.save(new Topicos(dados));
		} else {
			throw new RuntimeException("Já existe um topico com o mesmo título");
		}
		
		
	}
	
	@GetMapping
	public Page<DadosListagemTopicos> listar(@PageableDefault(size = 10, 
	sort = {"dataCriacao"}, direction = Direction.ASC) Pageable paginacao) {
		return repository.findAll(paginacao).map(DadosListagemTopicos::new);
	}
	
	@GetMapping("/{id}")
	public DadosListagemTopicos detalhar(@PathVariable Long id) {
		Topicos topico = repository.getReferenceById(id);
		return new DadosListagemTopicos(topico);
	}
	
	@PutMapping("/{id}")
	@Transactional
	public void atualizar(@PathVariable Long id, @RequestBody @Valid DadosTopicos dados) {
		var topicos = repository.getReferenceById(id);
		var topicoExistente = repository.getByTitulo(dados.titulo());
		if (topicoExistente == null) {
			topicos.atualizar(dados);
		} else {
			throw new RuntimeException("Já existe um topico com o mesmo título!");
		}		
		
	}
	
	@DeleteMapping("/{id}")
	@Transactional
	public void delete(@PathVariable Long id) {
		repository.deleteById(id);		
	}

}
