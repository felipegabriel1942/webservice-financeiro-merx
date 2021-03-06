package br.com.webservicemerx.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.webservicemerx.domain.Usuario;
import br.com.webservicemerx.services.UsuarioService;
import javassist.tools.rmi.ObjectNotFoundException;

@RestController
@RequestMapping(value = "/usuarios")
public class UsuarioResource {

	@Autowired
	private UsuarioService service;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Usuario> find(@PathVariable Integer id) throws ObjectNotFoundException {
		Usuario obj = service.find(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@CrossOrigin
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<Usuario> validarUsuario(
			@RequestParam(value="login") String login,
			@RequestParam(value="senha") String senha) throws ObjectNotFoundException{
		Usuario obj = service.validarUsuario(login, senha);
		return ResponseEntity.ok().body(obj);
	}
	

}
