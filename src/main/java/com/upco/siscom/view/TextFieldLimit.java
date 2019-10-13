/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.upco.siscom.view;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

/**
 *
 * @author felps
 */
public class TextFieldLimit extends PlainDocument {
    private int limit;
    
    public TextFieldLimit(int limit) {
        super();
        this.limit = limit;
    }
    
    @Override
    public void insertString(
        int offs, String str, AttributeSet a
    ) throws BadLocationException {
        if (str == null) return;

        if ((getLength() + str.length()) <= limit) {
            super.insertString(offs, str, a);
        }
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }
}
