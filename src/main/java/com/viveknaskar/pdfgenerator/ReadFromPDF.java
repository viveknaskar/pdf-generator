package com.viveknaskar.pdfgenerator;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

import java.io.File;
import java.io.IOException;

public class ReadFromPDF {

    public static void main(String[] args) {
        try {
            PDDocument doc = PDDocument.load(new File("demoDocument.pdf"));
            String text = new PDFTextStripper().getText(doc);
            System.out.println("The text in the PDF is: \n---------------------------------");
            System.out.println(text);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
