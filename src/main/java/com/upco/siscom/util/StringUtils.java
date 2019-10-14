/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.upco.siscom.util;

import java.text.Normalizer;

/**
 *
 * @author felps
 */
public class StringUtils {
    public static String capitalize(String str) {
        if (str == null || str.length() <= 0) {
            return str;
        }
        
        return str.substring(0, 1).toUpperCase() + str.substring(1);
    }
    
    public static String deAccent(String str) {
        return Normalizer.normalize(str, Normalizer.Form.NFD)
                         .replaceAll("[^\\p{ASCII}]", "");
    }
}
