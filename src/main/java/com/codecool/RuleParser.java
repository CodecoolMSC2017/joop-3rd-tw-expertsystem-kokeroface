package com.codecool;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;


public class RuleParser extends XMLParser {
    private RuleRepository repo = new RuleRepository();

    public RuleRepository getRuleRepository() {
        return repo;
    }


    public void loadXmlDocument(String xmlPath){
        Document doc = null;
        try {
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dbBuilder = dbFactory.newDocumentBuilder();
            doc = dbBuilder.parse(new File(xmlPath));
        }
        catch (Exception o) {
            o.printStackTrace();
        }
        String id;
        String question;
        Question quest;
        Answer answer = new Answer();
        Value value = new SingleValue("true",true);
        answer.addValue(value);
        answer.addValue(new SingleValue("false",false));
        NodeList nodes = doc.getElementsByTagName("Rule");
        for (int i = 0; i < nodes.getLength() ; i++) {
            Element element;
            element =  (Element) nodes.item(i);
            id = element.getAttribute("id");
            NodeList nodeList = element.getChildNodes();
            question = nodeList.item(1).getTextContent();

            quest = new Question(id, question, answer );
            repo.addQuestion(quest);
        }
    }
}