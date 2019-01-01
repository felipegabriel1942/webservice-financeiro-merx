package br.com.webservicemerx.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.webservicemerx.domain.Usuario;
import br.com.webservicemerx.repository.UsuarioRepository;
import javassist.tools.rmi.ObjectNotFoundException;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;

	public Usuario find(Integer id) throws ObjectNotFoundException {
		Optional<Usuario> obj = usuarioRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Usúario não encontado"));
	}
	
	public Usuario validarUsuario(String login, String senha) throws ObjectNotFoundException {
		Usuario obj = usuarioRepository.validarUsuario(login, senha);
		if(obj == null) {
			throw new ObjectNotFoundException("Usuario não localizado");
		} else {
			return obj;
		}
	}
}
