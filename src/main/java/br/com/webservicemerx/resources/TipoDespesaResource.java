package br.com.webservicemerx.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.webservicemerx.domain.TipoDespesa;
import br.com.webservicemerx.services.TipoDespesaService;

@RestController
@RequestMapping(value = "/tipo-despesas")
public class TipoDespesaResource {
	
	@Autowired
	private TipoDespesaService service;
	
	@CrossOrigin
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<TipoDespesa>> listarTodosOsTiposDespesa(){
		List<TipoDespesa> list = service.listarTodosOsTiposDespesa();
		return ResponseEntity.ok().body(list);
	} 
}
