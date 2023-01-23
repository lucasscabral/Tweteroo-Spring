package com.tweteroospring.api.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record userDTO(
                @Pattern(regexp = "^[a-zA-Z0-9]{6,12}$", message = "o nome de usuário deve ter de 6 a 12 comprimentos sem caracteres especiais") @NotBlank String userName,
                @Pattern(regexp = "http(s?)://([\\w-]+\\.)+[\\w-]+(/[\\w- ./]*)+\\.(?:[gG][iI][fF]|[jJ][pP][gG]|[jJ][pP][eE][gG]|[pP][nN][gG]|[bB][mM][pP])", message = "Deve ser uma url de imagem válida") @NotBlank String avatar) {

}
