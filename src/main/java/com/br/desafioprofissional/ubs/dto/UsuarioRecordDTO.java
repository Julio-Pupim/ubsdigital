package com.br.desafioprofissional.ubs.dto;

import jakarta.validation.constraints.NotBlank;

public record UsuarioRecordDTO(String nome, String sobrenome, @NotBlank String email, @NotBlank String cpf,@NotBlank String cartaoSus, String bairro, @NotBlank String senha) {

}
