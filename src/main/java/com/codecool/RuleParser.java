package com.codecool;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class RuleParser extends XMLParser {

    public RuleRepository getRuleRepository() throws Exception {
        loadXmlDocument("rules.xml");
        Document doc = getDoc();
        NodeList nList = doc.getElementsByTagName("Rule");
        RuleRepository ruleRepository = new RuleRepository();
        for (int temp = 0; temp < nList.getLength() ; temp++){

            Node nNode = nList.item(temp);
            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                Element eElement = (Element) nNode;
                String id = eElement.getAttribute("id");
                Answer answer = new Answer();
                answer.addValue(new SingleValue("true", true));
                answer.addValue(new SingleValue("false", false));
                Question question = new Question(id, eElement.getElementsByTagName("Question").item(0).getTextContent(), answer);
                /*for (int temp2 = 0; temp2 < answer.getLength() ; temp2++) {
                    Node nNode2 = answer.item(temp2);
                    if (nNode2.getNodeType() == Node.ELEMENT_NODE) {
                        NodeList selection = doc.getElementsByTagName("Selection");
                        for (int temp3 = 0; temp3 < nList.getLength(); temp3++) {
                            Node nNode3 = nList.item(temp3);
                            Element eElement2 = (Element) nNode;
                            String value = eElement2.getElementsByTagName("value").item(0).getTextContent();
                        }
                    }
                }*/
                ruleRepository.addQuestion(question);
            }
        }
        return ruleRepository;
    }
}