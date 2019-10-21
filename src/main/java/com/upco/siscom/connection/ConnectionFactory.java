/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.upco.siscom.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author felps
 */
public class ConnectionFactory {
    private static final String TAG = ConnectionFactory.class.getName();
    
    private static final String URL = "jdbc:mysql://localhost:3306/siscom?useTimezone=true&serverTimezone=UTC";
    private static final String USER = "root";
    private static final String PASSWD = "123456789";
    
    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(URL, USER, PASSWD);
        } catch(SQLException ex) {
            JOptionPane.showMessageDialog(
                null,
                "Erro na conexão com o banco!", "Erro",
                JOptionPane.ERROR_MESSAGE
            );
            throw new RuntimeException("Erro na conexão com o banco: ", ex);
        }
    }
    
    public static void closeConnection(Connection conn) {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(TAG).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public static void closeConnection(Connection conn, PreparedStatement stmt) {
        closeConnection(conn);
        if (stmt != null) {
            try {
                stmt.close();
            } catch (SQLException ex) {
                Logger.getLogger(TAG).log(Level.SEVERE, null, ex);
            }
        }
    }
    
     public static void closeConnection(Connection conn, PreparedStatement stmt, ResultSet rs) {
        closeConnection(conn, stmt);
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException ex) {
                Logger.getLogger(TAG).log(Level.SEVERE, null, ex);
            }
        }
    }
}
