package br.com.webservicemerx.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.webservicemerx.domain.Despesa;
import br.com.webservicemerx.domain.Receita;
import br.com.webservicemerx.repository.DespesaRepository;
import br.com.webservicemerx.repository.ReceitaRepository;
import lombok.Getter;
import lombok.Setter;

@Service
public class DashboardDtoService {

	@Autowired
	private DespesaRepository despesaRepository;

	@Autowired
	private ReceitaRepository receitaRepository;

	@Getter
	@Setter
	private String[] meses = { "2018-01", "2018-02", "2018-03", "2018-04", "2018-05", "2018-06", "2018-07", "2018-08",
			"2018-09", "2018-10", "2018-11", "2018-12" };

	public List<Double> buscarDadosDespesaMesAMes(Integer id) {
		List<Despesa> despesas = despesaRepository.buscarDespesasPorUsuario(id);
		List<Double> listaDadosMesAMes = new ArrayList<>();
		
		for (String m : meses) {
			double valor = 0;
			for (Despesa d : despesas) {
				if (d.getAnoMes().equals(m)) {
					valor = valor + d.getValor();
				}
			}
			
			listaDadosMesAMes.add(valor);
		}
		return listaDadosMesAMes;
	}

	public List<Double> buscarDadosReceitaMesAMes(Integer id) {
		List<Receita> receitas = receitaRepository.buscarReceitasPorUsuario(id);
		List<Double> listaDadosMesAMes = new ArrayList<>();
		
		for (String m : meses) {
			double valor = 0;
			for (Receita r : receitas) {
				if (r.getAnoMes().equals(m)) {
					valor = valor + r.getValor();
				}
			}			
			listaDadosMesAMes.add(valor);
		}
		
		return listaDadosMesAMes;

	}

}
