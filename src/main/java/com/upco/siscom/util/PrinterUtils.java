/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.upco.siscom.util;

import static com.upco.siscom.Config.APP_FULL_NAME;
import static com.upco.siscom.Config.APP_NAME;
import static com.upco.siscom.Config.APP_VERSION;
import static com.upco.siscom.Config.CUSTOMER_NAME;
import static com.upco.siscom.Config.PRINTER_COLUMNS;
import com.upco.siscom.model.bean.Produto;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.util.Date;
import java.util.Map;
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

/**
 *
 * @author felps
 */
public class PrinterUtils {
    
    private static final byte[] SEXP = { 0x1B, 'W', '1' };
    private static final byte[] EEXP = { 0x1B, 'W', '0' };
    private static final byte[] SBOL = { 0x1B, 'E' };
    private static final byte[] EBOL = { 0x1B, 'F' };
    public static final String START_EXPANDED = new String(SEXP);
    public static final String END_EXPANDED   = new String(EEXP);
    public static final String START_BOLD     = new String(SBOL);
    public static final String END_BOLD       = new String(EBOL);
    
    public static String getComandaHeader() {
        String title = StringUtils.centerText(
            APP_NAME.toUpperCase() + " - " + CUSTOMER_NAME, PRINTER_COLUMNS
        );
        String stroke = StringUtils.stroke(PRINTER_COLUMNS);
        String header =
            title + "\n\r" + 
            stroke + "\n\r" +
            START_BOLD + START_EXPANDED +
            "        COMANDA         \n\r\n\r" +
            END_BOLD + END_EXPANDED +
            "COD.      QTD.    DESCRICAO                     \n\r" +
            stroke + "\n\r";
        return header;
    }
    
    public static String getComandaContent(Map<Produto, Integer> produtos) {
        var w = new Object() { String content = ""; };
        
        // Itera por cada produto, e lança na comanda
        produtos.forEach((p, qtd) -> {
            w.content += String.format("%6s", p.getCodigo()) + "    " +
                         String.format("%-7s", qtd) + " " +
                         StringUtils.deAccent(p.getDescricao()) + "\n\r";
        });
        
        return w.content;
    }
    
    public static String getComandaFooter(String total) {
        // Pega a data e hora atual
        Date date = new Date();
        DateFormat fmt = DateFormat.getDateTimeInstance(
            DateFormat.FULL, DateFormat.DEFAULT
        );
        String dateTime = fmt.format(date);
        dateTime = StringUtils.capitalize(dateTime);
        dateTime = StringUtils.deAccent(dateTime);
        
        // Gera o rodapé
        String stroke = StringUtils.stroke(PRINTER_COLUMNS);
        String footer =
            stroke + "\n\r" +
            START_BOLD + "TOTAL" + END_BOLD +
            String.format("%43s", total) +
            stroke + "\n\r" +
            dateTime + "\n\r" +
            APP_FULL_NAME + " v" + APP_VERSION + "\n\r" +
            "\n\r\n\r\f\f";
        return footer;
    }
    
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
