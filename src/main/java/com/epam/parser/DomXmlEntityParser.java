package com.epam.parser;

import com.epam.entity.CardType;
import com.epam.entity.PostCard;
import com.epam.entity.Theme;
import com.epam.entity.Valuable;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.InputStream;
import java.time.Year;


public class DomXmlEntityParser implements XmlEntityParser {
    public PostCard parsePostCard(String fileName){
        PostCard postCard = null;
        try {
            InputStream stream = DomXmlEntityParser.class.getClassLoader().getResourceAsStream(fileName);
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document document = db.parse(stream);
            Element root = document.getDocumentElement();
            postCard = postCardBuilder(root);
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return postCard;
    }

    private PostCard postCardBuilder(Element root) {
        NodeList postCardsNodes = root.getElementsByTagName("card");
        PostCard postCard = new PostCard();
        for (int i = 0; i < postCardsNodes.getLength(); i++) {
            Element postCardElement = (Element)postCardsNodes.item(i);
            String theme = getElementTextContent(postCardElement, "Theme").toUpperCase();
            String cardType = getElementTextContent(postCardElement, "CardType").toUpperCase();
            String valuable = getElementTextContent(postCardElement, "Valuable").toUpperCase();

            postCard.setId(Long.parseLong(getElementTextContent(postCardElement, "ID")));
            postCard.setTheme(Theme.valueOf(theme));
            postCard.setCardType(CardType.valueOf(cardType));
            postCard.setCountry(getElementTextContent(postCardElement, "Country"));
            postCard.setYear(Year.parse(getElementTextContent(postCardElement, "Year")));
            postCard.setValuable(Valuable.valueOf(valuable));
            if (postCardElement.getElementsByTagName("Author").getLength()>0)
                postCard.setAuthor(getElementTextContent(postCardElement, "Author"));
        }
        return postCard;
    }

    private static String getElementTextContent(Element element, String elementName) {
        NodeList nList = element.getElementsByTagName(elementName);
        Node node = nList.item(0);
        String text = node.getTextContent();
        return text;
    }
}
