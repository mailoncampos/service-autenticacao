package br.com.onlinecarlinda.serviceautenticacao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.onlinecarlinda.serviceautenticacao.model.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, String>{
	
	Usuario findByUsuario(String usuario);
}
