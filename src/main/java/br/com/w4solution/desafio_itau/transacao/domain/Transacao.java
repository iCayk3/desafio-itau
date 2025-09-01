package br.com.w4solution.desafio_itau.transacao.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.OffsetDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Transacao {
    private Double valor;
    private OffsetDateTime dataHora;

    @Override
    public String toString() {
        return """
                valor: %s, data e hora: %s
                """.formatted(valor, dataHora);
    }
}
