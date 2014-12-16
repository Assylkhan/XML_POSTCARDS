package com.epam;

import com.epam.entity.PostCard;
import com.epam.parser.DomXmlEntityParser;
import com.epam.parser.SaxXmlEntityParser;
import com.epam.parser.StaxXmlEntityParser;
import com.epam.parser.XmlEntityParser;
import com.epam.validator.XsdValidator;

import java.util.List;

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

//      XSD  Validating
        XsdValidator.validate("PostCard.xml", "PostCard.xsd");
    }
}