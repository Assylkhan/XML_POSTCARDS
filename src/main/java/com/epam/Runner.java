package com.epam;

import com.epam.entity.PostCard;
import com.epam.parser.*;
import com.epam.validator.XsdValidator;

public class Runner {
    public static void main(String[] args) {
        String xmlName = "PostCard.xml";

        System.out.println("SAX:");
        XmlEntityParser saxParser = new SaxXmlEntityParser();
        PostCard saxPostCard = saxParser.parsePostCard(xmlName);
        System.out.println(saxPostCard);
        System.out.println("---------------------------------");

        System.out.println("STAX:");
        XmlEntityParser staxParser = new StaxXmlEntityParser();
        PostCard staxPostCard = staxParser.parsePostCard(xmlName);
        System.out.println(staxPostCard);
        System.out.println("---------------------------------");


        System.out.println("DOM:");
        XmlEntityParser domParser = new DomXmlEntityParser();
        PostCard domPostCard = domParser.parsePostCard(xmlName);
        System.out.println(domPostCard);

//        System.out.println("---------------------------------");
//        System.out.println("JAXB:");
//        XmlEntityParser jaxbParser = new JaxbXmlEntityParser();
//        PostCard jaxbPostCard = jaxbParser.parsePostCard(xmlName);
//        System.out.println(jaxbPostCard);

//      XSD  Validating
        XsdValidator.validate("PostCard.xml", "PostCard.xsd");
    }
}