package com.epam.parser;

import com.epam.entity.CardType;
import com.epam.entity.PostCard;
import com.epam.entity.Theme;
import com.epam.entity.Valuable;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamReader;
import java.io.InputStream;
import java.time.Year;

public class StaxXmlEntityParser implements XmlEntityParser {
    private PostCard postCard;
    public PostCard parsePostCard(String fileName) {
        InputStream stream = StaxXmlEntityParser.class.getClassLoader().getResourceAsStream(fileName);
        String currentElement = null;
        XMLInputFactory factory = XMLInputFactory.newInstance();
        StringBuilder builder = new StringBuilder();
        try {
            XMLStreamReader reader = factory.createXMLStreamReader(stream);
            while (reader.hasNext()) {
                int next = reader.next();
                switch (next) {
                    case XMLStreamConstants.START_ELEMENT:
                        currentElement = reader.getLocalName();
                        builder.setLength(0);
                        break;
                    case XMLStreamConstants.CHARACTERS:
                        builder.append(reader.getText());
                        break;
                    case XMLStreamConstants.END_ELEMENT:
                        if (currentElement == null) break;
                        String s = builder.toString().trim();
                        switch (currentElement) {
                            case "ID":
                                postCard = new PostCard(Long.parseLong(s));
                                break;
                            case "Theme":
                                postCard.setTheme(Theme.valueOf(s.toUpperCase()));
                                break;
                            case "CardType":
                                postCard.setCardType(CardType.valueOf(s.toUpperCase()));
                                break;
                            case "Country":
                                postCard.setCountry(s);
                                break;
                            case "Year":
                                postCard.setYear(Year.parse(s));
                                break;
                            case "Author":
                                postCard.setAuthor(s);
                                break;
                            case "Valuable":
                                postCard.setValuable(Valuable.valueOf(s.toUpperCase()));
                                break;
                        }
                        currentElement = null;
                        break;
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return postCard;
    }
}