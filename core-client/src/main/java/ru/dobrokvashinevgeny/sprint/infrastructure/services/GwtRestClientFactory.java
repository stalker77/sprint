/*
 * Copyright (c) 2018 Evgeny Dobrokvashin, All Rights Reserved.
 */

package ru.dobrokvashinevgeny.sprint.infrastructure.services;

import com.google.gwt.http.client.RequestBuilder;

/**
 * Класс GwtRestClientFactory
 */
public class GwtRestClientFactory {
	public static RequestBuilder createGetRequestTo(String resourceUri) {
		RequestBuilder request = new RequestBuilder(RequestBuilder.GET, resourceUri);
		request.setHeader("Content-type", "application/json");
		return request;
	}

	public static RequestBuilder createPostRequest(String resourceUri) {
		RequestBuilder request = new RequestBuilder(RequestBuilder.POST, resourceUri);
		request.setHeader("Content-type", "application/json");
		return request;
	}
}