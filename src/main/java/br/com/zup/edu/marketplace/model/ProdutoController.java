package br.com.zup.edu.marketplace.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {
    Logger logger = LoggerFactory.getLogger(ProdutoController.class);

    @Autowired
    ProdutoProducer produtoProducer;

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?>inserir(@Valid @RequestBody ProdutoRequest produtoRequest){
        logger.info("Cadastrando um produto");

        var produto = produtoRequest.toModel();

        produtoProducer.send(produto);

        logger.info("Produto {} cadastrado com sucesso.", produto.getTitulo());

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(produto);
    }
}
