package br.com.webservicemerx.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.webservicemerx.domain.TipoDespesa;
import br.com.webservicemerx.repository.TipoDespesaRepository;

@Service
public class TipoDespesaService {
	@Autowired
	private TipoDespesaRepository tipoDespesaRepository;
	
	public List<TipoDespesa> listarTodosOsTiposDespesa() {
		return tipoDespesaRepository.findAll();
	}
	
}
