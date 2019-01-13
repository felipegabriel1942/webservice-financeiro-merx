package br.com.webservicemerx.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.webservicemerx.domain.Receita;

public interface ReceitaRepository extends JpaRepository<Receita, Integer>{
	
	@Query("select r from Receita r where r.codigoUsuario = :fkUsuario")
	List<Receita> buscarReceitasPorUsuario(@Param("fkUsuario") Integer fkUsuario);
}
