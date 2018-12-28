package br.com.webservicemerx.resources;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
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
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@Valid @RequestBody TipoDespesa obj){
		obj = service.insert(obj);
		
		/**
		 * Quando quer receber um objeto de retorno
		 */
		//URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		//return ResponseEntity.created(uri).build();
		
		/**
		 * Quando não quer receber um objeto de retorno
		 */		
		return ResponseEntity.noContent().build();
	}
}
