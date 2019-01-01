package br.com.webservicemerx.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.webservicemerx.domain.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{
	
	@Query("select u from Usuario u where u.login = :login and u.senha = :senha")
	Usuario validarUsuario(@Param("login") String login, @Param("senha") String senha);
}
