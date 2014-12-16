package com.epam.validator;

import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.IOException;
import java.io.InputStream;


public class XsdValidator {
    public static void validate(String xmlLocation, String schemaLocation){
        InputStream xmlStream = XsdValidator.class.getClassLoader().getResourceAsStream(xmlLocation);
        InputStream xsdStream = XsdValidator.class.getClassLoader().getResourceAsStream(schemaLocation);
        SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
        Schema schema = null;
        try {
            System.out.println("-------------------");
            System.out.println("validation:");
            schema = factory.newSchema(new StreamSource(xsdStream));
            Validator validator = schema.newValidator();
            Source source = new StreamSource(xmlStream);
            validator.validate(source);
            System.out.println(xmlLocation + " is valid");
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
