/*
 * Copyright (c) 2018 Evgeny Dobrokvashin, All Rights Reserved.
 */

package ru.dobrokvashinevgeny.sprint.infrastructure.configuration;

import org.slf4j.*;
import ru.dobrokvashinevgeny.sprint.infrastructure.services.*;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import java.util.Map;

/**
 * Класс ConfigurationPropertyProducer
 */
@RequestScoped
public class ConfigurationPropertyProducer {
	private static final Logger LOG = LoggerFactory.getLogger(ConfigurationPropertyProducer.class);
	private static final String APP_CONFIGURATION_SCHEMA_FILE_NAME = "app-configuration.xsd";

	private String coreDataSourceName;

	private String currentServerId = "single";

	@Inject @ConfigurationPropertyWithName(propertyName = "appsConfigLocations")
	private Map<String, String> appsConfigLocations;

	@Produces @ConfigurationPropertyWithName(propertyName = "coreDataSourceName")
	public String getCoreDataSourceName() {
		return coreDataSourceName;
	}

	@PostConstruct
	private void loadCurrentApplicationConfiguration() throws Exception {
		String configFileLocation = getCurrentAppConfigFileLocation();

		parseCurrentAppConfigFrom(configFileLocation);
	}

	private String getCurrentAppConfigFileLocation() throws ConfigurationException {
		String configFileLocation = appsConfigLocations.get(currentServerId);

		if (configFileLocation == null) {
			LOG.error("Current application configuration for ServerId = " + currentServerId + " - not found! " +
				"Current application configuration not loaded.");
			throw new ConfigurationException("Current application configuration not loaded.");
		}

		return configFileLocation;
	}

	private void parseCurrentAppConfigFrom(String configFileLocation) throws ConfigurationException {
		try {
			SaxXmlParsingService xmlParsingService = new SaxXmlParsingService(APP_CONFIGURATION_SCHEMA_FILE_NAME);
			final AppConfigHandler handler = new AppConfigHandler();

			xmlParsingService.parseXmlFileWithHandler(configFileLocation, handler);

			coreDataSourceName = handler.getCoreDataSourceName();
		} catch (XmlParsingServiceException e) {
			throw new ConfigurationException(e);
		}
	}
}