package com.br.desafioprofissional.ubs.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.desafioprofissional.ubs.dto.LoginRecordDTO;
import com.br.desafioprofissional.ubs.dto.UsuarioRecordDTO;
import com.br.desafioprofissional.ubs.model.UsuarioModel;
import com.br.desafioprofissional.ubs.repository.UsuarioRepository;
import com.br.desafioprofissional.ubs.service.UsuarioService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
	
	
	private final UsuarioService service;
	
	private final UsuarioRepository repository;
	
	public UsuarioController(UsuarioService service, UsuarioRepository repository) {
		super();
		this.service = service;
		this.repository = repository;
	}
	
	@PostMapping("/login")
	public ResponseEntity<String> realizarLogin(@RequestBody @Valid LoginRecordDTO login){
		
		UsuarioModel usuario = service.autenticarUsuario(login.login(), login.senha());
		if(usuario == null){
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("falha na autenticação");
		}
			return ResponseEntity.status(HttpStatus.OK).body("Login realizado com Sucesso");
	}

	@GetMapping("/{id}")
	public ResponseEntity<UsuarioModel> buscarUsuariosPeloId (@PathVariable(value="id")Long id){
		
		Optional<UsuarioModel> usuario = repository.findById(id);
		
		if(usuario == null) {
			ResponseEntity.status(HttpStatus.NOT_FOUND);
		}
		
		return ResponseEntity.status(HttpStatus.OK).body(usuario.get());
	}
	
	@GetMapping
	public ResponseEntity<List<UsuarioModel>> buscarTodosUsuarios(){
		
		List<UsuarioModel> usuarioModelList = repository.findAll();
		
		if(usuarioModelList.isEmpty()) {
			
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
		}
		return ResponseEntity.status(HttpStatus.OK).body(usuarioModelList);
	}
	
	@PostMapping
	public ResponseEntity<UsuarioModel> criarUsuario (@RequestBody @Valid UsuarioRecordDTO usuarioRecordDTO){
		
		UsuarioModel usuario =  service.salvarUsuario(usuarioRecordDTO);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(usuario);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<UsuarioModel> atualizarUsuario(@PathVariable(value="id")Long id, @RequestBody @Valid UsuarioRecordDTO usuarioRecordDTO){
		
		UsuarioModel usuario = service.atualizarUsuario(id, usuarioRecordDTO);
		
		if(usuario != null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
		
		return ResponseEntity.status(HttpStatus.OK).body(usuario);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deletarUsuarioPeloId (@PathVariable(value="id")Long id){
		
		Optional<UsuarioModel> usuario = repository.findById(id);
		
		if(usuario.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuario não encontrado");
		}
		repository.deleteById(id);
	
		return ResponseEntity.status(HttpStatus.OK).body("Usuario deletado");
	}
	
}
