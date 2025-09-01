package br.com.w4solution.desafio_itau.transacao.controller;

import br.com.w4solution.desafio_itau.transacao.dto.TransacaoDto;
import br.com.w4solution.desafio_itau.transacao.services.TransacaoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("transacao")
public class TransacaoController {

    @Autowired
    TransacaoService service;

    @PostMapping
    public ResponseEntity<?> transacao(@RequestBody @Valid TransacaoDto dados, UriComponentsBuilder uri){
        service.cadastrarTransacao(dados);
        var uripath = uri.path("transacao/id").buildAndExpand().toUri();
        return ResponseEntity.created(uripath).build();
    }

    @DeleteMapping
    public ResponseEntity<?> transacaoDelete(){
        service.deletarTodosRegistros();
        return ResponseEntity.ok().build();
    }
}
