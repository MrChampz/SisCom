/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.upco.siscom.model.bean;

/**
 *
 * @author felps
 */
public class Produto {
    private final String codigo;
    private String descricao;
    private String porcao;
    private Double preco;
        
    public Produto(String codigo, String descricao, String porcao, Double preco) {
        this.codigo = codigo;
        this.descricao = descricao;
        this.porcao = porcao;
        this.preco = preco;
    }

    @Override
    public String toString() {
        return descricao;
    }
    
    public String getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getPorcao() {
        return porcao;
    }

    public void setPorcao(String porcao) {
        this.porcao = porcao;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }
}
