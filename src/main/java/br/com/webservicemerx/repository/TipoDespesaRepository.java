package br.com.webservicemerx.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.webservicemerx.domain.TipoDespesa;

@Repository
public interface TipoDespesaRepository extends JpaRepository<TipoDespesa, Integer>{

}
