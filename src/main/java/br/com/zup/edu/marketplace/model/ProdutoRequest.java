package br.com.zup.edu.marketplace.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

public class ProdutoRequest {

    @NotBlank
    @NotNull
    private String titulo;

    @NotNull
    @NotBlank
    private String descricao;

    private String statusProduto;

    @NotNull
    private BigDecimal preco;

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setStatusProduto(String statusProduto) {
        this.statusProduto = statusProduto;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public Produto toModel(){
        return new Produto(this.titulo, this.descricao, this.preco);
    }
}
