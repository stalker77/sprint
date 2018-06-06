/*
 * Copyright (c) 2018 Evgeny Dobrokvashin, All Rights Reserved.
 */

package ru.dobrokvashinevgeny.sprint.infrastructure.services;

import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.XMLConstants;
import javax.xml.parsers.*;
import javax.xml.validation.*;
import java.io.*;
import java.net.URL;

/**
 * Класс SaxXmlParsingService
 */
public class SaxXmlParsingService {
	private final SAXParserFactory factory;

	private final SAXParser parser;

	public SaxXmlParsingService() throws XmlParsingServiceException {
		this(null);
	}

	public SaxXmlParsingService(String schemaFileName) throws XmlParsingServiceException {
		factory = SAXParserFactory.newInstance();

		try {
			setupSchemaFrom(schemaFileName);

			parser = factory.newSAXParser();
		} catch (ParserConfigurationException | SAXException e) {
			throw new XmlParsingServiceException(e);
		}
	}

	private void setupSchemaFrom(String schemaFileName) throws SAXException, XmlParsingServiceException {
		if (schemaFileName != null) {
			String language = XMLConstants.W3C_XML_SCHEMA_NS_URI;
			SchemaFactory schemaFactory = SchemaFactory.newInstance(language);
			String schemaFileLocation = getFileLocationInResourcesByName(schemaFileName);
			Schema schema = schemaFactory.newSchema(new File(schemaFileLocation));
			factory.setSchema(schema);
		}
	}

	private String getFileLocationInResourcesByName(String fileName) throws XmlParsingServiceException {
		ClassLoader classLoader = getClass().getClassLoader();
		final URL sprintAppsSchemaUrl = classLoader.getResource(fileName);

		if (sprintAppsSchemaUrl == null) {
			throw new XmlParsingServiceException("Schema file resource " + fileName + " - not found!");
		}

		return sprintAppsSchemaUrl.getFile();
	}

	public void parseXmlFileWithHandler(String xmlFileLocation, DefaultHandler handler)
		throws XmlParsingServiceException {
		try {
			parser.parse(xmlFileLocation, handler);
		} catch (IOException | SAXException e) {
			throw new XmlParsingServiceException(e);
		}
	}
}