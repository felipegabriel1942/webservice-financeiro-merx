package br.com.webservicemerx.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.webservicemerx.domain.Receita;
import br.com.webservicemerx.repository.ReceitaRepository;
import javassist.tools.rmi.ObjectNotFoundException;

@Service
public class ReceitaService {
	
	@Autowired
	private ReceitaRepository receitaRepository;
	
	public Receita buscarReceita(Integer id) {
		Optional<Receita> obj = receitaRepository.findById(id);
		try {
			return obj.orElseThrow(() -> new ObjectNotFoundException("Receita não encontrada"));
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public Receita atualizarReceita(Receita obj) {
		Receita newObj = buscarReceita(obj.getId());
		atualizarDados(newObj, obj);
		return receitaRepository.save(newObj);
	}
	
	public void delete(Integer id) {
		buscarReceita(id);
		try {
			receitaRepository.deleteById(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public List<Receita> listarTodasAsReceitas(){
		return receitaRepository.findAll();
	}
	
	public List<Receita> listarDespesasPorUsuario(Integer fkUsuario) {
		return receitaRepository.buscarReceitasPorUsuario(fkUsuario);
	}
	
	public void atualizarDados(Receita newObj, Receita obj) {
		newObj.setAnoMes(obj.getAnoMes());
		newObj.setDescricao(obj.getDescricao());
		newObj.setCodigoUsuario(obj.getCodigoUsuario());
		newObj.setValor(obj.getValor());
	}
}
