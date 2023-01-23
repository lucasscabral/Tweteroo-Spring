package com.tweteroospring.api.dto;

import jakarta.validation.constraints.NotBlank;

public record twetDTO(@NotBlank String twet, @NotBlank String userName) {

}
