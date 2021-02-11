package com.viveknaskar.pdfgenerator;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.apache.pdfbox.text.TextPosition;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GetWordsFromPDF extends PDFTextStripper {

    static List<String> words = new ArrayList<>();

    public GetWordsFromPDF() throws IOException {
    }

    /**
     * @throws IOException If there is an error parsing the document.
     */
    public static void main(String[] args) throws IOException {
        String fileName = "demoDocument.pdf"; // replace with your PDF file name
        try (PDDocument document = PDDocument.load(new File(fileName))) {
            PDFTextStripper stripper = new GetWordsFromPDF();
            stripper.setSortByPosition(true);
            stripper.setStartPage(0);
            stripper.setEndPage(document.getNumberOfPages());

            Writer dummy = new OutputStreamWriter(new ByteArrayOutputStream());
            stripper.writeText(document, dummy);

            // print words
            for (String word : words) {
                System.out.println(word);
            }
        }
    }

    /**
     * Override the default functionality of PDFTextStripper.writeString()
     */
    @Override
    protected void writeString(String str, List<TextPosition> textPositions) {
        String[] wordsInStream = str.split(getWordSeparator());
        Collections.addAll(words, wordsInStream);
    }
}
