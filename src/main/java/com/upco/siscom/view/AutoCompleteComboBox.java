/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.upco.siscom.view;

import com.upco.siscom.model.bean.Produto;
import java.awt.Component;
import java.awt.Container;
import java.awt.Rectangle;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.swing.JComboBox;
import javax.swing.SwingUtilities;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.plaf.metal.MetalComboBoxUI;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.JTextComponent;
import javax.swing.text.PlainDocument;

/**
 *
 * @author felps
 */
public class AutoCompleteComboBox extends JComboBox {
    
    private final Searchable<Produto, String> searchable;
    
    public AutoCompleteComboBox() {
        searchable = null;
    }
    
    public AutoCompleteComboBox(Searchable<Produto, String> s) {
        super();
        this.searchable = s;
        
        // Only select an item on ENTER press or mouse click
        putClientProperty("JComboBox.isTableCellEditor", Boolean.TRUE);
        
        setEditable(true);
        Component comp = getEditor().getEditorComponent();
        if (comp instanceof JTextComponent) {
            final JTextComponent editor = (JTextComponent)comp;
            editor.getDocument().addDocumentListener(new DocumentListener() {
                
                @Override
                public void insertUpdate(DocumentEvent e) {
                    update();
                }

                @Override
                public void removeUpdate(DocumentEvent e) {
                    update();
                }
                
                @Override
                public void changedUpdate(DocumentEvent e) {}
                
                public void update() {
                    SwingUtilities.invokeLater(() -> {
                        List<Produto> founds = new ArrayList<>(
                            searchable.search(editor.getText())
                        );
                        
                        Set<String> foundSet = new HashSet<>();
                        for (Produto p : founds) {
                            foundSet.add(p.getDescricao().toLowerCase());
                        }
                        
                        setEditable(false);
                        removeAllItems();
                        
                        // If founds contains the search text, then only add once
                        if (!foundSet.contains(editor.getText().toLowerCase())) {
                            addItem(editor.getText());
                        }
                        
                        for (Produto p : founds) {
                            addItem(p);
                        }
                        
                        setPopupVisible(true);
                        setEditable(true);
                        editor.requestFocus();
                    });
                }
                
                
            });
            
            editor.addFocusListener(new FocusListener() {
                @Override
                public void focusGained(FocusEvent e) {
                    if (editor.getText().length() > 0) {
                        setPopupVisible(true);
                    }
                }

                @Override
                public void focusLost(FocusEvent e) {}
            });
        } else {
            throw new IllegalStateException(
                "Editing component is not a JTextComponent!"
            );
        }
    }
}
