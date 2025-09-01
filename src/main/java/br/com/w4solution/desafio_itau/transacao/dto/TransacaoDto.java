package br.com.w4solution.desafio_itau.transacao.dto;

import jakarta.validation.constraints.NotNull;

import java.time.OffsetDateTime;

public record TransacaoDto(@NotNull Double valor, @NotNull OffsetDateTime dataHora) {
}
