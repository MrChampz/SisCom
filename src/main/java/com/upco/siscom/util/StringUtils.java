/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.upco.siscom.util;

/**
 *
 * @author felps
 */
public class StringUtils {
    public static String capitalize(String original) {
        if (original == null || original.length() <= 0) {
            return original;
        }
        
        return original.substring(0, 1).toUpperCase() + original.substring(1);
    }
}
