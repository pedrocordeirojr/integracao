package com.bb.integracao.service;


import com.bb.integracao.controller.dto.ResponseCotacaoBBDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Service
public class CotacaoService {

    @Value("${bcb.consultar.cotacao.dolar.dia}")
    private String urlBcb;


    public ResponseCotacaoBBDto getCotacao(LocalDate data) {

        RestTemplate restTemplate = new RestTemplate();

        String url = urlBcb.concat("'").concat(data.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"))).concat("'");

        ResponseEntity <ResponseCotacaoBBDto> responseCotacaoBBDtoResponseEntity = restTemplate.getForEntity(url, ResponseCotacaoBBDto.class);

        return responseCotacaoBBDtoResponseEntity.getBody();
     }
}
