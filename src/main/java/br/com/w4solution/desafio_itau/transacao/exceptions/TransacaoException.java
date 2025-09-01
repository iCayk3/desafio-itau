package br.com.w4solution.desafio_itau.transacao.exceptions;

public class TransacaoException extends RuntimeException {
    public TransacaoException(String message) {
        super(message);
    }
}
