/*
 * Copyright (c) 2018 Evgeny Dobrokvashin, All Rights Reserved.
 */

package ru.dobrokvashinevgeny.sprint.infrastructure.configuration;

import org.junit.*;
import org.xml.sax.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Класс AppConfigHandlerTest
 */
public class AppConfigHandlerTest {
	private static final String CORE_DATASOURCE_ELEMENT_NAME = "CORE-DATASOURCE";
	private static final String DS_NAME_ATTR_NAME = "dsName";
	private static final String DS_NAME_VALUE = "java:/testDS";

	private AppConfigHandler handler;
	private Attributes attributes;

	@Before
	public void setUp() {
		handler = new AppConfigHandler();
		attributes = mock(Attributes.class);
	}

	@Test
	public void coreDataSourceNameContainsRightValueWhenProcessCoreDataSourceElement() throws Exception {
		when(attributes.getValue(DS_NAME_ATTR_NAME)).thenReturn(DS_NAME_VALUE);

		handler.startElement("", "", CORE_DATASOURCE_ELEMENT_NAME, attributes);

		assertThat(handler.getCoreDataSourceName(), equalTo(DS_NAME_VALUE));
	}

	@Test(expected = SAXException.class)
	public void throwSAXExceptionWhenDsNameIsEmpty() throws Exception {
		when(attributes.getValue(DS_NAME_ATTR_NAME)).thenReturn("");

		handler.startElement("", "", CORE_DATASOURCE_ELEMENT_NAME, attributes);
	}

	@Test(expected = SAXException.class)
	public void throwSAXExceptionWhenDsNameIsNull() throws Exception {
		when(attributes.getValue(DS_NAME_ATTR_NAME)).thenReturn(null);

		handler.startElement("", "", CORE_DATASOURCE_ELEMENT_NAME, attributes);
	}
}