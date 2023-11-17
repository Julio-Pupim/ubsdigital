package com.br.desafioprofissional.ubs.dto;

import jakarta.validation.constraints.NotBlank;

public record LoginRecordDTO(@NotBlank String login, @NotBlank String senha) {

}
