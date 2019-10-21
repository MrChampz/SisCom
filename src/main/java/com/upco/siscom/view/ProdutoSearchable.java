/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.upco.siscom.view;

import com.upco.siscom.model.bean.Produto;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Implementation of the Searchable interface that searches a List of Produto
 * objects.
 * This implementation searches only the beggining of the words, and is not be
 * optimized for very large Lists.
 * @author felps
 */
public class ProdutoSearchable implements Searchable<Produto, String> {

    private List<Produto> produtos = new ArrayList<>();
    
    
    /**
     * Construct a new object based upon the parameter produtos.
     * @param produtos The inventory of produtos to search.
     */
    public ProdutoSearchable(List<Produto> produtos) {
        this.produtos.addAll(produtos);
    }
    
    @Override
    public Collection<Produto> search(String value) {
        List<Produto> founds = new ArrayList<>();
        
        value = value.toLowerCase();
        for (Produto p : produtos) {
            String descricao = p.getDescricao().toLowerCase();
            if (descricao.indexOf(value) == 0) {
                founds.add(p);
            }
        }
        
        return founds;
    }

    @Override
    public void add(Produto produto) {
        this.produtos.add(produto);
    }
}
