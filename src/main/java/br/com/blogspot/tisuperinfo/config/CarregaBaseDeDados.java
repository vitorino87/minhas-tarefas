package br.com.blogspot.tisuperinfo.config;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import br.com.blogspot.tisuperinfo.model.Tarefa;
import br.com.blogspot.tisuperinfo.model.TarefaCategoria;
import br.com.blogspot.tisuperinfo.model.TarefaStatus;
import br.com.blogspot.tisuperinfo.model.Usuario;
import br.com.blogspot.tisuperinfo.repository.TarefaCategoriaRepository;
import br.com.blogspot.tisuperinfo.repository.TarefaRepository;
import br.com.blogspot.tisuperinfo.repository.UsuarioRepository;

@Configuration
@Profile("dev")
public class CarregaBaseDeDados {

	@Autowired
	private UsuarioRepository usuarioRepository;
	@Autowired
	private TarefaCategoriaRepository categoriaRepository;
	@Autowired
	private TarefaRepository tarefaRepository;
	
	@Bean
	CommandLineRunner executar() {
		return args->{
			Usuario usuario = new Usuario();
			usuario.setNome("Admin");
			usuario.setSenha("123456");
			usuarioRepository.save(usuario);
			
			TarefaCategoria categoria = new TarefaCategoria();
			categoria.setNome("Estudos");
			categoriaRepository.save(categoria);
			
			Tarefa tarefa = new Tarefa();
			tarefa.setDescricao("Aprender Spring Boot");
			tarefa.setDataEntrega(LocalDate.now().plusDays(1));
			tarefa.setStatus(TarefaStatus.ABERTO);
			tarefa.setVisivel(true);
			tarefa.setCategoria(categoria);
			tarefa.setUsuario(usuario);
			tarefaRepository.save(tarefa);
		};
	}
}
