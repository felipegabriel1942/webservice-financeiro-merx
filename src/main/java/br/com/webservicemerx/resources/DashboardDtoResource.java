package br.com.webservicemerx.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.webservicemerx.dto.DashboardDto;
import br.com.webservicemerx.services.DashboardDtoService;

@RestController
@RequestMapping(value = "/dashboard")
public class DashboardDtoResource {

	@Autowired
	private DashboardDtoService service;

	@CrossOrigin
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> buscarDespesa(@PathVariable Integer id) {
		List<Double> listaDeDespesaMesAMes = service.buscarDadosDespesaMesAMes(id);
		List<Double> listaDeReceitasMesAMes = service.buscarDadosReceitaMesAMes(id);

		DashboardDto obj = new DashboardDto();
		obj.setDespesaMesAMes(listaDeDespesaMesAMes);
		obj.setReceitaMesAMes(listaDeReceitasMesAMes);

		return ResponseEntity.ok().body(obj);
	}
}
