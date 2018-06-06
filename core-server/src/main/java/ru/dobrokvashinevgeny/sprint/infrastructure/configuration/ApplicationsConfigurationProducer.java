/*
 * Copyright (c) 2018 Evgeny Dobrokvashin, All Rights Reserved.
 */

package ru.dobrokvashinevgeny.sprint.infrastructure.configuration;

import org.slf4j.*;
import ru.dobrokvashinevgeny.sprint.infrastructure.services.*;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import java.util.*;

/**
 * Класс ApplicationsConfigurationProducer
 */
@ApplicationScoped
public class ApplicationsConfigurationProducer {
	private static final Logger LOG = LoggerFactory.getLogger(ApplicationsConfigurationProducer.class);
	private static final String SPRINT_APPS_CONFIG_LOCATION_PROP_NAME = "sprint.apps.config.location";
	private static final String SPRINT_APPLICATIONS_SCHEMA_FILE_NAME = "sprint-applications.xsd";

	private Map<String, String> appsConfigLocations;

	@Produces @ConfigurationPropertyWithName(propertyName = "appsConfigLocations")
	public Map<String, String> getAppsConfigLocations() {
		return appsConfigLocations;
	}

	@PostConstruct
	private void loadApplicationsConfigLocations() throws Exception {
		String configFileLocation = getAppsConfigFileLocation();

		appsConfigLocations = new HashMap<>();
		populateAppsConfigurationFrom(appsConfigLocations, configFileLocation);
	}

	private String getAppsConfigFileLocation() throws ConfigurationException {
		String configFileLocation = System.getProperty(SPRINT_APPS_CONFIG_LOCATION_PROP_NAME);

		if (configFileLocation == null) {
			LOG.error("Configuration parameter: " + SPRINT_APPS_CONFIG_LOCATION_PROP_NAME + " - not found! " +
				"Applications configuration not loaded.");
			throw new ConfigurationException("Applications configuration not loaded.");
		}

		return configFileLocation;
	}

	private void populateAppsConfigurationFrom(Map<String, String> appsConfigLocations, String configFileLocation)
		throws ConfigurationException {
		try {
			SaxXmlParsingService xmlParsingService = new SaxXmlParsingService(SPRINT_APPLICATIONS_SCHEMA_FILE_NAME);
			final AppsConfigLocationsHandler handler = new AppsConfigLocationsHandler();

			xmlParsingService.parseXmlFileWithHandler(configFileLocation, handler);

			appsConfigLocations.putAll(handler.getAppsConfigLocations());
		} catch (XmlParsingServiceException e) {
			throw new ConfigurationException(e);
		}
	}
}