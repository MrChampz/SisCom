/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.upco.siscom.model.bean;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 *
 * @author felps
 */
public class Comanda {
    
    public static final int UNKNOWN_ID = -1;
    
    private int id;
    private double valorTotal;
    private Date dataHora;
    private Map<Produto, Integer> produtos;
    
    public Comanda(Map<Produto, Integer> produtos) {
        this.id = UNKNOWN_ID;
        this.valorTotal = 0.0;
        this.dataHora = new Date();
        this.produtos = produtos;
        calculaValorTotal();
    }
    
    public Comanda(int id, double valorTotal, Date dataHora, Map<Produto, Integer> produtos) {
        this.id = id;
        this.valorTotal = valorTotal;
        this.dataHora = dataHora;
        this.produtos = produtos;
    }
    
    private double calculaValorTotal() {
        produtos.forEach((p, qtd) -> {
            valorTotal += p.getPreco() * qtd;
        });
        return valorTotal;
    }

    public int getId() {
        return id;
    }
    
    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public Date getDataHora() {
        return dataHora;
    }

    public void setDataHora(Date dataHora) {
        this.dataHora = dataHora;
    }

    public Map<Produto, Integer> getProdutos() {
        return produtos;
    }
    
    public void setProdutos(Map<Produto, Integer> produtos) {
        this.produtos = produtos;
    }    
}
