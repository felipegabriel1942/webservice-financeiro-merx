package br.com.webservicemerx.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.webservicemerx.domain.Receita;

public interface ReceitaRepository extends JpaRepository<Receita, Integer>{

}
