/*
 * Copyright (c) 2018 Evgeny Dobrokvashin, All Rights Reserved.
 */

package ru.dobrokvashinevgeny.sprint.infrastructure.services;

import com.google.gwt.core.client.GWT;
import com.google.gwt.http.client.RequestBuilder;

import java.util.logging.Logger;

/**
 * Класс GwtRestClientFactory
 */
public class GwtRestClientFactory {
	private final static Logger LOG = Logger.getLogger("Main");

	public static RequestBuilder createGetRequestTo(String localResourceUri) {
//		LOG.log(Level.SEVERE, "localResourceUri: " + ((localResourceUri == null) ? "null" : localResourceUri));
		RequestBuilder request = new RequestBuilder(RequestBuilder.GET, getFullResourceUriFor(localResourceUri));
		request.setHeader("Content-type", "application/json");
		return request;
	}

	private static String getFullResourceUriFor(String localResourceUri) {
		return GWT.getHostPageBaseURL() + localResourceUri;
	}

	public static RequestBuilder createPostRequest(String localResourceUri) {
		RequestBuilder request = new RequestBuilder(RequestBuilder.POST, getFullResourceUriFor(localResourceUri));
		request.setHeader("Content-type", "application/json");
		return request;
	}
}