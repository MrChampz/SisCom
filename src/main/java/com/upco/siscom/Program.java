package com.upco.siscom;

import com.upco.siscom.view.TelaNovaComanda;
import java.util.logging.Logger;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author felps
 */
public class Program {
    private static final String TAG = Program.class.getName();
    
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        try {
            for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TAG).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(TAG).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(TAG).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            Logger.getLogger(TAG).log(java.util.logging.Level.SEVERE, null, ex);
        }

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new TelaNovaComanda().setVisible(true);
        });
    }
}
