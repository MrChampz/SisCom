/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.upco.siscom.util;

import java.text.DateFormat;
import java.util.Date;
import javax.swing.JLabel;

/**
 *
 * @author felps
 */
public class DateTimeUpdater {
    
    public static void start(final JLabel lbDate, final JLabel lbTime) {
        DateFormat dateFmt = DateFormat.getDateInstance(DateFormat.FULL);
        DateFormat timeFmt = DateFormat.getTimeInstance(DateFormat.DEFAULT);
        
        Thread updateTime = new Thread(() -> {
            try {
                while (true) {
                    Date date = new Date();
                    
                    String str = StringUtils.capitalize(dateFmt.format(date));
                    lbDate.setText(str);
                    lbTime.setText(timeFmt.format(date));
                    
                    Thread.sleep(1000);
                    lbDate.revalidate();
                    lbTime.revalidate();
                }
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        });
        
        updateTime.start();
    }
}
