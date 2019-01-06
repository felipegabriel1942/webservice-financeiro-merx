package br.com.webservicemerx.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.webservicemerx.domain.TipoDespesa;
import br.com.webservicemerx.repository.TipoDespesaRepository;
import javassist.tools.rmi.ObjectNotFoundException;

@Service
public class TipoDespesaService {
	@Autowired
	private TipoDespesaRepository tipoDespesaRepository;
	
	public List<TipoDespesa> listarTodosOsTiposDespesa() {
		return tipoDespesaRepository.findAll();
	}
	
	public TipoDespesa buscarTipoDespesa(Integer id) {
		Optional<TipoDespesa> obj = tipoDespesaRepository.findById(id);
		try {
			return obj.orElseThrow(() -> new ObjectNotFoundException("Tipo de despesa não encontrada"));
		} catch (ObjectNotFoundException e) {
			e.printStackTrace();
			return null;
		}
	}
	
}
