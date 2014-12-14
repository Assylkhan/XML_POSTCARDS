package com.epam;

import com.epam.entity.PostCard;
import com.epam.parser.SaxXmlEntityParser;
import com.epam.parser.XmlEntityParser;

import java.io.InputStream;

public class Runner {
    public static void main(String[] args) {
        InputStream stream = Runner.class.getClassLoader().getResourceAsStream("PostCard.xml");
        XmlEntityParser saxParser = new SaxXmlEntityParser();
        PostCard saxPostCard = saxParser.parsePostCard(stream);
        System.out.println(saxPostCard);
    }
}