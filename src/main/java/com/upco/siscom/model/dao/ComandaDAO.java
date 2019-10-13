/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.upco.siscom.model.dao;

import com.upco.siscom.connection.ConnectionFactory;
import com.upco.siscom.model.bean.Comanda;
import com.upco.siscom.model.bean.Produto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author felps
 */
public class ComandaDAO {
    private static final String TAG = ComandaDAO.class.getName();
    
    public void create(Comanda comanda) {
        Connection conn = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
            // Inicio do bloco da transação
            conn.setAutoCommit(false);
        
            // Salva comanda
            int id = saveComanda(conn, stmt, comanda);
            
            // Assimila o id gerado
            if (id != Comanda.UNKNOWN_ID) {
                double valorTotal = comanda.getValorTotal();
                Date dataHora = comanda.getDataHora();
                Map<Produto, Integer> produtos = comanda.getProdutos();
               
                comanda = new Comanda(id, valorTotal, dataHora, produtos);
            }
            
            // Salva os produtos NA comanda
            saveProdutosIntoComanda(conn, comanda);
            
            // Fim do bloco de transação
            conn.commit();

            // Retorna ao estado anterior
            conn.setAutoCommit(true);
            
            JOptionPane.showMessageDialog(null, "Comanda salva com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar comanda!");
            Logger.getLogger(TAG).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(conn, stmt);
        }
    }
    
    public List<Comanda> read() {
        Connection conn = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<Comanda> comandas = new ArrayList<>();
        
        try {
            stmt = conn.prepareStatement("SELECT * FROM comanda");
            rs = stmt.executeQuery();
            
            while (rs.next()) {
                int id = rs.getInt("id");
                double valorTotal = rs.getDouble("valor_total");
                Timestamp ts = rs.getTimestamp("data_hora");
                Date dataHora = new Date(ts.getTime());
                
                // TODO: Recupera produtos dessa comanda
                
                Comanda comanda = new Comanda(id, valorTotal, dataHora, new HashMap<>());
                comandas.add(comanda);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(TAG).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(conn, stmt, rs);
        }
        
        return comandas;
    }
    
    private int saveComanda(
        Connection conn, PreparedStatement stmt, Comanda comanda
    ) throws SQLException {
        stmt = conn.prepareStatement(
            "INSERT INTO comanda (valor_total) VALUES (?)",
            Statement.RETURN_GENERATED_KEYS
        );
        
        // Salva a comanda
        stmt.setDouble(1, comanda.getValorTotal());
        stmt.executeUpdate();
        
        // Retorna o id gerado
        ResultSet keys = stmt.getGeneratedKeys();
        if (keys.next()) {
            return keys.getInt(1);
        }
        
        return Comanda.UNKNOWN_ID;
    }
    
    private void saveProdutosIntoComanda(
        Connection conn, Comanda comanda
    ) throws SQLException {
        PreparedStatement stmt = conn.prepareStatement(
            "INSERT INTO " +
            "produto_comanda (comanda_id, produto_codigo, quantidade, valor_total) " +
            "VALUES (?,?,?,?)"
        );
        
        // Salva cada um dos produtos NA comanda
        comanda.getProdutos().forEach((p, qtd) -> {
            try {
                stmt.setInt(1, comanda.getId());
                stmt.setString(2, p.getCodigo());
                stmt.setInt(3, qtd);
                stmt.setDouble(4, p.getPreco() * qtd);
                stmt.executeUpdate();
            } catch (SQLException ex) {
                // Em caso de erro, fecha a conexão e loga o erro
                ConnectionFactory.closeConnection(null, stmt);
                Logger.getLogger(TAG).log(Level.SEVERE, null, ex);
            }
        });
        
        // Fecha a conexão
        ConnectionFactory.closeConnection(null, stmt);
    }
}
