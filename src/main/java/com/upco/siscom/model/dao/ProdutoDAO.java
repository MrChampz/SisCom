/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.upco.siscom.model.dao;

import com.upco.siscom.connection.ConnectionFactory;
import com.upco.siscom.model.bean.Produto;
import java.awt.Component;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author felps
 */
public class ProdutoDAO {
    private static final String TAG = ProdutoDAO.class.getName();
    
    // TODO: Substituir parent por um listener, assim, desacoplando o código
    public void create(Component parent, Produto p) {
        Connection conn = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = conn.prepareStatement(
                "INSERT INTO produto (codigo, descricao, porcao, preco) VALUES (?,?,?,?)"
            );
            
            stmt.setString(1, p.getCodigo());
            stmt.setString(2, p.getDescricao());
            stmt.setString(3, p.getPorcao());
            stmt.setDouble(4, p.getPreco());
            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(
                parent,
                "Produto salvo com sucesso!", "Novo Produto",
                JOptionPane.INFORMATION_MESSAGE
            );
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(
                parent,
                "Erro ao salvar produto!", "Erro",
                JOptionPane.ERROR_MESSAGE
            );
            Logger.getLogger(TAG).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(conn, stmt);
        }
    }
    
    public List<Produto> read() {
        Connection conn = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<Produto> produtos = new ArrayList<>();
        
        try {
            stmt = conn.prepareStatement("SELECT * FROM produto");
            rs = stmt.executeQuery();
            
            while (rs.next()) {
                String codigo = rs.getString("codigo");
                String descricao = rs.getString("descricao");
                String porcao = rs.getString("porcao");
                double preco = rs.getDouble("preco");
                
                Produto produto = new Produto(codigo, descricao, porcao, preco);
                produtos.add(produto);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(TAG).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(conn, stmt, rs);
        }
        
        return produtos;
    }
}
