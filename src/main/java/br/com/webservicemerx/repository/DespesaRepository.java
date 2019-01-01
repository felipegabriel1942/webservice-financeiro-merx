package br.com.webservicemerx.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.webservicemerx.domain.Despesa;

public interface DespesaRepository extends JpaRepository<Despesa, Integer>{
	
	@Query("select d from Despesa d where d.fkUsuario = :fkUsuario")
	List<Despesa> buscarDespesasPorUsuario(@Param("fkUsuario") Integer fkUsuario);
}
