package com.br.desafioprofissional.ubs.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.br.desafioprofissional.ubs.model.UsuarioModel;



public interface UsuarioRepository extends JpaRepository<UsuarioModel, Long>{
	
	UsuarioModel findByEmailOrCpfOrCartaoSus(String email, String cpf, String cartaoSus);
	
}
