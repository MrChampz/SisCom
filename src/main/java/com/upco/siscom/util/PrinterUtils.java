/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.upco.siscom.util;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import javax.print.DocFlavor;
import javax.print.DocPrintJob;
import javax.print.PrintException;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.print.SimpleDoc;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;
import javax.print.attribute.standard.JobName;
import javax.print.attribute.standard.MediaSizeName;
import javax.print.attribute.standard.OrientationRequested;
import javax.swing.JOptionPane;

/**
 *
 * @author felps
 */
public class PrinterUtils {
    
    public static void print(String text) throws IOException, PrintException {
        InputStream prin = new ByteArrayInputStream(text.getBytes());
        DocFlavor docFlavor = DocFlavor.INPUT_STREAM.AUTOSENSE;
        SimpleDoc doc = new SimpleDoc(prin, docFlavor, null);
        PrintService printer = PrintServiceLookup.lookupDefaultPrintService();

        PrintRequestAttributeSet printerAttrs = new HashPrintRequestAttributeSet();
        printerAttrs.add(new JobName("Impressao", null));
        printerAttrs.add(OrientationRequested.PORTRAIT);
        printerAttrs.add(MediaSizeName.ISO_A4);

        DocPrintJob printJob = printer.createPrintJob();

        printJob.print(doc, printerAttrs);

        prin.close();
    }
}
