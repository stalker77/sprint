/*
 * Copyright (c) 2018 Evgeny Dobrokvashin, All Rights Reserved.
 */

package ru.dobrokvashinevgeny.sprint.infrastructure.configuration;

import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;

import java.util.*;

/**
 * Класс AppsConfigLocationsHandler
 */
public class AppsConfigLocationsHandler extends DefaultHandler {
	private static final String APPLICATION_ELEMENT_NAME = "application";
	private static final String SERVER_ID_ATTR_NAME = "serverId";
	private static final String CONFIGURATION_FILE_PATH_ATTR_NAME = "configurationFilePath";

	private final Map<String, String> appsConfigLocations;

	public AppsConfigLocationsHandler() {
		appsConfigLocations = new HashMap<>();
	}

	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		if (qName.equalsIgnoreCase(APPLICATION_ELEMENT_NAME)) {
			try {
				parseAppAttributes(attributes);
			} catch (ConfigurationException e) {
				throw new SAXException(e);
			}
		}
	}

	private void parseAppAttributes(Attributes appAttributes) throws ConfigurationException {
		String serverId = appAttributes.getValue(SERVER_ID_ATTR_NAME);
		if (serverId == null || "".equals(serverId.trim())) {
			throw new ConfigurationException("Attribute " + SERVER_ID_ATTR_NAME + " - not found or empty!");
		}

		String configurationFilePath = appAttributes.getValue(CONFIGURATION_FILE_PATH_ATTR_NAME);
		if (configurationFilePath == null || "".equals(configurationFilePath.trim())) {
			throw new ConfigurationException("Attribute " + CONFIGURATION_FILE_PATH_ATTR_NAME +
				" - not found or empty!");
		}

		appsConfigLocations.put(serverId, configurationFilePath);
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
	public Map<String, String> getAppsConfigLocations() {
		return appsConfigLocations;
	}
}