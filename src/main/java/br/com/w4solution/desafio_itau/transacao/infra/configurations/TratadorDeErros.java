package br.com.w4solution.desafio_itau.transacao.infra.configurations;

import br.com.w4solution.desafio_itau.transacao.exceptions.TransacaoException;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class TratadorDeErros {
    @ExceptionHandler(TransacaoException.class)
    public ResponseEntity<?> tratarErro422(TransacaoException ex){
        return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(ex);
    }

}
