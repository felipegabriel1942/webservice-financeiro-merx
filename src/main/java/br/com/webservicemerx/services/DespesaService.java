package br.com.webservicemerx.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.webservicemerx.domain.Despesa;
import br.com.webservicemerx.repository.DespesaRepository;
import javassist.tools.rmi.ObjectNotFoundException;

@Service
public class DespesaService {

	@Autowired
	private DespesaRepository despesaRepository;

	public Despesa buscarDespesa(Integer id) {
		Optional<Despesa> obj = despesaRepository.findById(id);
		try {
			return obj.orElseThrow(() -> new ObjectNotFoundException("Despesa não encontrada"));
		} catch (ObjectNotFoundException e) {
			e.printStackTrace();
			return null;
		}
	}

	public Despesa atualizarDespesa(Despesa obj) {
		Despesa newObj = buscarDespesa(obj.getId());
		atualizarDados(newObj, obj);
		return despesaRepository.save(newObj);
	}

	public Despesa salvarDespesa(Despesa obj) {
		obj.setId(null);
		obj = despesaRepository.save(obj);
		return obj;
	}

	public void delete(Integer id) {
		buscarDespesa(id);
		try {
			despesaRepository.deleteById(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public List<Despesa> listarTodasAsDespesas(){
		return despesaRepository.findAll();
	}
	
	

	private void atualizarDados(Despesa newObj, Despesa obj) {
		newObj.setAnoMes(obj.getAnoMes());
		newObj.setDescricao(obj.getDescricao());
		newObj.setFkTipoDespesa(obj.getFkTipoDespesa());
		newObj.setFkUsuario(obj.getFkUsuario());
		newObj.setValor(obj.getValor());
	}

}
