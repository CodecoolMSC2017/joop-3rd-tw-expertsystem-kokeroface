package com.codecool;

import org.w3c.dom.Document;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

abstract class XMLParser {

    private Document doc;

    void loadXmlDocument(String xmlPath) throws Exception {
        try {
            File input = new File(xmlPath);
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            doc = documentBuilder.parse(input);
            doc.getDocumentElement().normalize();
        } catch (Exception e) {
            throw new Exception();
        }
    }

    Document getDoc() {
        return doc;
    }
}

