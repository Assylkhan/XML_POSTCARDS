package com.epam.parser;

import com.epam.entity.CardType;
import com.epam.entity.PostCard;
import com.epam.entity.Theme;
import com.epam.entity.Valuable;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.InputStream;
import java.time.Year;

public class SaxXmlEntityParser implements XmlEntityParser {
    private PostCard postCard = new PostCard();

    public PostCard parsePostCard(String fileName){
        InputStream stream = SaxXmlEntityParser.class.getClassLoader().getResourceAsStream(fileName);
        SAXParserFactory spf = SAXParserFactory.newInstance();
        try{
            SAXParser saxParser = spf.newSAXParser();
            saxParser.parse(stream, new CardDefaultHandler());
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
            super.startDocument();
        }

        public void endDocument() throws SAXException {
            super.endDocument();
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
                case "id": postCard = new PostCard(Long.parseLong(s)); break;
                case "theme": postCard.setTheme(Theme.valueOf(s.toUpperCase())); break;
                case "cardType": postCard.setCardType(CardType.valueOf(s.toUpperCase())); break;
                case "country": postCard.setCountry(s); break;
                case "year": postCard.setYear(Year.parse(s)); break;
                case "author": postCard.setAuthor(s); break;
                case "valuable": postCard.setValuable(Valuable.valueOf(s.toUpperCase())); break;
            }
            currentElement = null;
        }
    }

}
