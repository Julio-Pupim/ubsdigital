package com.br.desafioprofissional.ubs.service;

import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.br.desafioprofissional.ubs.dto.UsuarioRecordDTO;
import com.br.desafioprofissional.ubs.model.UsuarioModel;
import com.br.desafioprofissional.ubs.repository.UsuarioRepository;

@Service
public class UsuarioService {
	
	private final UsuarioRepository repository;
	
	public UsuarioService(UsuarioRepository repository) {
		this.repository = repository;
	}
	
	public UsuarioModel salvarUsuario (UsuarioRecordDTO usuario) {
		
		
		UsuarioModel novoUsuario = new UsuarioModel();
		
		BeanUtils.copyProperties(usuario, novoUsuario);
		
	 	repository.save(novoUsuario);
		
		return novoUsuario;
	}
	
	public UsuarioModel atualizarUsuario (Long id,UsuarioRecordDTO usuario) {
		
		Optional<UsuarioModel> usuarioAntigo =  repository.findById(id);
		if(usuarioAntigo.isEmpty()) {
			return null;
		}
		
		BeanUtils.copyProperties(usuario, usuarioAntigo.get());
		
		repository.save(usuarioAntigo.get());
		
		return usuarioAntigo.get();
	}
	
	public UsuarioModel autenticarUsuario(String login, String senha) {
		
		UsuarioModel usuario = repository.findByEmailOrCpfOrCartaoSus(login, login, login);
			
		  if (usuario != null && Objects.equals(senha, usuario.getSenha())) {
	            return usuario; 
	        }
		  return null;
	}

	
}


