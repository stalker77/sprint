/*
 * Copyright (c) 2018 Evgeny Dobrokvashin, All Rights Reserved.
 */

package ru.dobrokvashinevgeny.sprint.infrastructure.configuration;

import org.junit.*;
import org.xml.sax.*;

import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasEntry;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Класс AppsConfigLocationsHandlerTest
 */
public class AppsConfigLocationsHandlerTest {
	private static final String APPLICATION_ELEMENT_NAME = "application";
	private static final String SERVER_ID_ATTR_NAME = "serverId";
	private static final String CONFIGURATION_FILE_PATH_ATTR_NAME = "configurationFilePath";
	private static final String SINGLE_SERVER_ID_VALUE = "single";
	private static final String CONFIGURATION_FILE_PATH_VALUE = "/opt/wildfly/test.xml";
	private AppsConfigLocationsHandler handler;
	private Attributes attributes;

	@Before
	public void setUp() {
		handler = new AppsConfigLocationsHandler();
		attributes = mock(Attributes.class);
	}

	@Test
	public void handlerResultContainsRightValuesWhenProcessApplicationElement() throws Exception {
		when(attributes.getValue(SERVER_ID_ATTR_NAME)).thenReturn(SINGLE_SERVER_ID_VALUE);
		when(attributes.getValue(CONFIGURATION_FILE_PATH_ATTR_NAME)).thenReturn(CONFIGURATION_FILE_PATH_VALUE);

		handler.startElement("", "", APPLICATION_ELEMENT_NAME, attributes);
		Map<String, String> result = handler.getAppsConfigLocations();

		assertThat(result.size(), is(1));
		assertThat(result, hasEntry(SINGLE_SERVER_ID_VALUE, CONFIGURATION_FILE_PATH_VALUE));
	}

	@Test(expected = SAXException.class)
	public void throwSAXExceptionWhenServerIdIsEmpty() throws Exception {
		when(attributes.getValue(SERVER_ID_ATTR_NAME)).thenReturn("");
		when(attributes.getValue(CONFIGURATION_FILE_PATH_ATTR_NAME)).thenReturn(CONFIGURATION_FILE_PATH_VALUE);

		handler.startElement("", "", APPLICATION_ELEMENT_NAME, attributes);
	}

	@Test(expected = SAXException.class)
	public void throwSAXExceptionWhenServerIdIsNull() throws Exception {
		when(attributes.getValue(SERVER_ID_ATTR_NAME)).thenReturn(null);
		when(attributes.getValue(CONFIGURATION_FILE_PATH_ATTR_NAME)).thenReturn(CONFIGURATION_FILE_PATH_VALUE);

		handler.startElement("", "", APPLICATION_ELEMENT_NAME, attributes);
	}

	@Test(expected = SAXException.class)
	public void throwSAXExceptionWhenConfigurationFilePathIsEmpty() throws Exception {
		when(attributes.getValue(SERVER_ID_ATTR_NAME)).thenReturn(SINGLE_SERVER_ID_VALUE);
		when(attributes.getValue(CONFIGURATION_FILE_PATH_ATTR_NAME)).thenReturn("");

		handler.startElement("", "", APPLICATION_ELEMENT_NAME, attributes);
	}

	@Test(expected = SAXException.class)
	public void throwSAXExceptionWhenConfigurationFilePathIsNull() throws Exception {
		when(attributes.getValue(SERVER_ID_ATTR_NAME)).thenReturn(SINGLE_SERVER_ID_VALUE);
		when(attributes.getValue(CONFIGURATION_FILE_PATH_ATTR_NAME)).thenReturn(null);

		handler.startElement("", "", APPLICATION_ELEMENT_NAME, attributes);
	}
}