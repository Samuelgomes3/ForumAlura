package alura.com.forum.topicos;

import java.time.LocalDate;

import alura.com.forum.controller.DadosTopicos;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity(name = "Topicos")
@Table(name = "topicos")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@EqualsAndHashCode(of = "id")
public class Topicos {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String autor;

	@Column(name = "data_criacao")
	private LocalDate dataCriacao;

	@Enumerated(EnumType.STRING)
	private Curso curso;

	private String mensagem;
	private boolean ativo;
	private String titulo;
	
	public Topicos() {
		
	}

	public Topicos(@Valid DadosTopicos dados) {
		this.ativo = true;
		this.dataCriacao = LocalDate.now();
		this.autor = dados.autor();
		this.titulo = dados.titulo();
		this.mensagem = dados.mensagem();
		this.curso = dados.curso();

	}

	public Long getId() {
		return id;
	}

	public String getAutor() {
		return autor;
	}

	public LocalDate getDataCriacao() {
		return dataCriacao;
	}

	public Curso getCurso() {
		return curso;
	}

	public String getMensagem() {
		return mensagem;
	}

	public boolean isAtivo() {
		return ativo;
	}

	public String getTitulo() {
		return titulo;
	}

	public void atualizar(DadosTopicos dados) {
		if (dados.autor() != null) {
			this.autor = dados.autor();
		}
		if (dados.titulo() != null) {
			this.titulo = dados.titulo();
		}
		if (dados.mensagem() != null) {
			this.mensagem = dados.mensagem();
		}
		if (dados.curso() != null) {
			this.curso = dados.curso();
		}	
		
	}	

}
