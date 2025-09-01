package br.com.w4solution.desafio_itau.transacao.services;

import br.com.w4solution.desafio_itau.transacao.domain.Transacao;
import br.com.w4solution.desafio_itau.transacao.dto.TransacaoDto;
import br.com.w4solution.desafio_itau.transacao.exceptions.TransacaoException;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class TransacaoService {

    List<Transacao> transacoes = new ArrayList<>();

    public void cadastrarTransacao(TransacaoDto dados) {

        OffsetDateTime dataAtual = OffsetDateTime.now();
        /*Checagem data futura */
        if(dataAtual.plusDays(1).equals(dados.dataHora()) || dados.dataHora().isAfter(dataAtual.plusDays(1))){
            throw new TransacaoException("A data não pode estar no futuro.");
        }
        /*Checagem de valores negativos */
        if(dados.valor() < 0){
            throw new TransacaoException("O valor não pode ser negativo.");
        }

        var transacao = new Transacao(dados.valor(), dados.dataHora());

        transacoes.add(transacao);

        transacoes.forEach(System.out::println);
    }

    public void deletarTodosRegistros() {
        transacoes.clear();
    }
}
