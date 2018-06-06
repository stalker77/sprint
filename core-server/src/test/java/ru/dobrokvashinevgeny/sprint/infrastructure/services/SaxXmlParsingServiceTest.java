/*
 * Copyright (c) 2018 Evgeny Dobrokvashin, All Rights Reserved.
 */

package ru.dobrokvashinevgeny.sprint.infrastructure.services;

import org.junit.Test;
import ru.dobrokvashinevgeny.sprint.infrastructure.configuration.AppsConfigLocationsHandler;

import java.net.URL;

/**
 * Класс SaxXmlParsingServiceTest
 */
public class SaxXmlParsingServiceTest {
	@Test
	public void test1() throws Exception {
		SaxXmlParsingService parsingService = new SaxXmlParsingService("sprint-applications.xsd");
		ClassLoader classLoader = getClass().getClassLoader();
		final URL xmlFileUrl = classLoader.getResource("sprint-applications.xml");
		final String xmlFileLocation = xmlFileUrl.getFile();
		final AppsConfigLocationsHandler handler = new AppsConfigLocationsHandler();
		parsingService.parseXmlFileWithHandler(xmlFileLocation, handler);
		System.out.println(handler.getAppsConfigLocations());
	}
}