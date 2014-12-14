package com.epam.parser;

import com.epam.entity.CardType;
import com.epam.entity.PostCard;
import com.epam.entity.Theme;
import com.epam.entity.Valueable;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.InputStream;

public class SaxXmlEntityParser implements XmlEntityParser {
    private PostCard postCard = new PostCard();

    public PostCard parsePostCard(InputStream is){
        SAXParserFactory spf = SAXParserFactory.newInstance();
        try{
            SAXParser saxParser = spf.newSAXParser();
            saxParser.parse(is, new CardDefaultHandler());
        } catch (Exception e){
            throw new RuntimeException(e);
        }
        return postCard;
    }

    private class CardDefaultHandler extends DefaultHandler {
        private String currentElement;
        private StringBuilder stringBuilder = new StringBuilder();

        public void error(SAXParseException e){
            System.err.println("ERROR: line " + e.getLineNumber() + ": " + e.getMessage());
        }

        @Override
        public void startDocument() throws SAXException {
            System.out.println("parsing started");
        }

        public void endDocument() throws SAXException {
            System.out.println("parsing ended");
        }

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException{
            currentElement = qName;
            stringBuilder.setLength(0);
        }

        @Override
        public void characters(char[] buffer, int start, int length) throws SAXException {
            stringBuilder.append(buffer, start, length);
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            if (currentElement == null) return;
            String s = stringBuilder.toString().trim();
            switch (currentElement){
                case "ID": postCard = new PostCard(Long.parseLong(s)); break;
                case "Theme": postCard.setTheme(Theme.valueOf(s.toUpperCase())); break;
                case "CardType": postCard.setCardType(CardType.valueOf(s.toUpperCase())); break;
                case "Country": postCard.setCountry(s); break;
                case "Year": postCard.setYear(s); break;
                case "Author": postCard.setAuthor(s); break;
                case "Valuable": postCard.setValueable(Valueable.valueOf(s.toUpperCase())); break;
            }
            currentElement = null;
        }
    }

}
