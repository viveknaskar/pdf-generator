package com.viveknaskar.pdfgenerator;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

import java.io.IOException;

public class GeneratePDF {

    public static void main(String[] args) {

        String filename = "demoDocument.pdf";
        String message = "Illustration of demo PDF doc created using PDFBox.";

        try (PDDocument doc = new PDDocument()) {
            PDPage page = new PDPage();
            doc.addPage(page);

            PDFont font = PDType1Font.TIMES_ROMAN;

            PDPageContentStream contents = new PDPageContentStream(doc, page);
            contents.beginText();
            contents.setFont(font, 20);
            contents.newLineAtOffset(40, 600);
            contents.showText(message);
            contents.endText();
            contents.close();

            doc.save(filename);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
