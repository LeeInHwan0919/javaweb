package com.min.edu;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import com.itextpdf.html2pdf.HtmlConverter;

public class HTMLtoPDF {
    private static final String ORIG = "C:\\0420java\\eclipse\\20220512javaweb\\20220512_iText\\src\\main\\webapp\\WEB-INF\\views\\home.jsp";
    private static final String OUTPUT_FOLDER = "C:\\Users\\GDJ44\\Downloads\\";

    public static void main(String[] args) throws IOException {
        File htmlSource = new File(ORIG);
        File pdfDest = new File(OUTPUT_FOLDER + "output.pdf");
        HtmlConverter.convertToPdf(new FileInputStream(htmlSource), new FileOutputStream(pdfDest));
        System.out.println("컨버트 완료");
    }

}

