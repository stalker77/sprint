/*
 * Copyright (c) 2018 Evgeny Dobrokvashin, All Rights Reserved.
 */

package ru.dobrokvashinevgeny.sprint.infrastructure.configuration;

import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;

/**
 * Класс AppConfigHandler
 */
public class AppConfigHandler extends DefaultHandler {
	private static final String CORE_DATASOURCE_ELEMENT_NAME = "CORE-DATASOURCE";
	private static final String DS_NAME_ATTR_NAME = "dsName";

	private String coreDataSourceName;

	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		if (qName.equalsIgnoreCase(CORE_DATASOURCE_ELEMENT_NAME)) {
			try {
				parseCoreDataSourceAttributes(attributes);
			} catch (ConfigurationException e) {
				throw new SAXException(e);
			}
		}
	}

	private void parseCoreDataSourceAttributes(Attributes coreDSAttributes) throws ConfigurationException {
		coreDataSourceName = coreDSAttributes.getValue(DS_NAME_ATTR_NAME);

		if (coreDataSourceName == null || "".equals(coreDataSourceName.trim())) {
			throw new ConfigurationException("Attribute " + DS_NAME_ATTR_NAME + " - not found or empty!");
		}
	}

	@Override
	public void error(SAXParseException e) throws SAXException {
		throw e;
	}

	/**
	 * Возвращает
	 *
	 * @return
	 */
	public String getCoreDataSourceName() {
		return coreDataSourceName;
	}
}