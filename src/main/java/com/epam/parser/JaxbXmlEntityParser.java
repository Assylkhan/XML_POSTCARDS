package com.epam.parser;

import com.epam.entity.PostCard;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.InputStream;

public class JaxbXmlEntityParser implements XmlEntityParser {
    public PostCard parsePostCard(String fileName){
        try {
            InputStream stream = JaxbXmlEntityParser.class.getClassLoader().getResourceAsStream(fileName);
            JAXBContext context = JAXBContext.newInstance(PostCard.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            return (PostCard)unmarshaller.unmarshal(stream);
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }
    }
}
