package alura.com.forum.topicos;

import java.time.LocalDate;

public record DadosListagemTopicos(Long id, String titulo, String mensagem, 
		LocalDate dataCriacao, boolean ativo, String autor, Curso curso ) {
	
	public DadosListagemTopicos(Topicos topico) {
		this(topico.getId(), topico.getTitulo(), topico.getMensagem(), topico.getDataCriacao(),
				topico.isAtivo(), topico.getAutor(), topico.getCurso());
		
	}
	
}
