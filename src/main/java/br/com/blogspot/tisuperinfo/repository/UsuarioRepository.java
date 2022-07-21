package br.com.blogspot.tisuperinfo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.blogspot.tisuperinfo.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario,Integer>{

}
