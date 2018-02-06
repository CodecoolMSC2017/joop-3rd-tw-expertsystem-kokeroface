package com.codecool;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class RuleParser extends XMLParser {

    private String id, question, value;
    //private Question question;
    private Document doc;

    public RuleRepository getRuleRepository() throws Exception {

        loadXmlDocument("rules.xml");
        doc = getDoc();
        NodeList nList = doc.getElementsByTagName("Rule");
        RuleRepository ruleRepository = new RuleRepository();
        for (int temp = 0; temp < nList.getLength() ; temp++){

            Node nNode = nList.item(temp);
            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                Element eElement = (Element) nNode;
                id = eElement.getAttribute("id");
                question = eElement.getElementsByTagName("question").item(0).getTextContent());
                NodeList answer = doc.getElementsByTagName("Answer");
                for (int temp2 = 0; temp2 < answer.getLength() ; temp2++) {

                    Node nNode2 = answer.item(temp2);
                    if (nNode2.getNodeType() == Node.ELEMENT_NODE) {
                        NodeList selection = doc.getElementsByTagName("Selection");
                        for (int temp3 = 0; temp3 < nList.getLength(); temp3++) {

                            Node nNode3 = nList.item(temp3);
                            Element eElement2 = (Element) nNode;
                            value = eElement2.getElementsByTagName("value").item(0).getTextContent();
                            
                        }
                    }
                }
            }

        }
    }
}