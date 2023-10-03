package alura.com.forum.topicos;

import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

import alura.com.forum.controller.DadosTopicos;

public interface TopicosRepository extends JpaRepository<Topicos, Long>{

	DadosTopicos getByTitulo(String titulo);


}
