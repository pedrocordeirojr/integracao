package com.bb.integracao.controller;

import com.bb.integracao.controller.dto.ResponseCotacaoBBDto;
import com.bb.integracao.service.CotacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
@RequestMapping("api/cotacao")
public class CotacaoController {

    @Autowired
    CotacaoService cotacaoService;

    @GetMapping
    public ResponseCotacaoBBDto getCotacao(@RequestParam LocalDate data) {
        return cotacaoService.getCotacao(data);
    }
}
