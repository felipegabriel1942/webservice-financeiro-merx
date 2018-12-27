package br.com.webservicemerx.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.webservicemerx.domain.Despesa;

public interface DespesaRepository extends JpaRepository<Despesa, Integer>{

}
