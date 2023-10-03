package alura.com.forum.controller;

import alura.com.forum.topicos.Curso;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosTopicos(
		
		@NotBlank
		String titulo, 
		
		@NotBlank
		String mensagem, 
		
		@NotBlank
		String autor, 
		
		@NotNull
		Curso curso) {

}
