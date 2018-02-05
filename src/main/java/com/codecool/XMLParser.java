package com.codecool;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public abstract class XMLParser {

    List<Fact> facts = new ArrayList<>();
    List<Question> questions = new ArrayList<>();

    public void loadXmlDocument(String xmlPath) {
        try {
            File fXmlFile = new File(xmlPath);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(fXmlFile);

            doc.getDocumentElement().normalize();
            try {
                NodeList nList = doc.getElementsByTagName("Fact");
                for (int temp = 0; temp < nList.getLength(); temp++) {
                    Node nNode = nList.item(temp);
                    if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                        Element eElement = (Element) nNode;
                        Fact fact = new Fact(eElement.getElementsByTagName("id").item(0).getTextContent(),
                                eElement.getElementsByTagName("value").item(0).getTextContent());
                        facts.add(fact);
                    }
                }
            } catch (Exception e) {
                NodeList nList = doc.getElementsByTagName("Rule");
                for (int temp = 0; temp < nList.getLength(); temp++) {
                    Node nNode = nList.item(temp);
                    if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                        Element eElement = (Element) nNode;
                        Question question = new Question(eElement.getElementsByTagName("id").item(0).getTextContent(),
                                eElement.getElementsByTagName("value").item(0).getTextContent());
                        questions.add(question);
                    }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    }
}
