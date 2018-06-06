/*
 * Copyright (c) 2018 Evgeny Dobrokvashin, All Rights Reserved.
 */

package ru.dobrokvashinevgeny.sprint.infrastructure.services;

import com.google.gwt.http.client.*;
import com.google.gwt.json.client.*;
import ru.dobrokvashinevgeny.sprint.domain.model.ComponentApplication;
import ru.dobrokvashinevgeny.sprint.services.*;
import ru.dobrokvashinevgeny.sprint.services.registry.*;

/**
 * Класс GwtApplicationModelService
 */
public class GwtApplicationModelService {
	private final String APP_BASE_RESOURCE_URI = "rest/application/";
	private final String APP_MODEL_RESOURCE_URI = "/model/current";

	private final ControllersRegistry controllersRegistry;

	public GwtApplicationModelService(ControllersRegistry controllersRegistry) {
		this.controllersRegistry = controllersRegistry;
	}

	public void appModelFromCodeTo(String appCode, ApplicationModelController controller) {
		RequestBuilder request = GwtRestClientFactory.createGetRequestTo(appModelResourceFor(appCode));
		try {
			request.sendRequest(toAppCodeAsJsonString(appCode), new RequestCallback() {
				@Override
				public void onResponseReceived(Request request, Response response) {
					controller.onReceiveModel(toComponentApplication(response.getText()));
				}

				@Override
				public void onError(Request request, Throwable exception) {
					controller.onReceiveModelError(new AppModelException(exception));
				}
			});
		} catch (RequestException e) {
			controller.onReceiveModelError(new AppModelException(e));
		}
	}

	private String appModelResourceFor(String appCode) {
		return APP_BASE_RESOURCE_URI + appCode + APP_MODEL_RESOURCE_URI;
	}

	private String toAppCodeAsJsonString(String appCode) {
		JSONString appCodeString = new JSONString(appCode);
		JSONObject appCodeObject = new JSONObject();
		appCodeObject.put("appCode", appCodeString);
		return appCodeObject.toString();
	}

	private ComponentApplication toComponentApplication(String appModelString) {
		JSONValue appModelDescriptorAsJson = JSONParser.parseStrict(appModelString);
		JSONObject appModelDescriptorObject = appModelDescriptorAsJson.isObject();

		final String title = getStringPropertyFrom(appModelDescriptorObject, "title");
		final String code = getStringPropertyFrom(appModelDescriptorObject, "code");
		boolean enabled = getBooleanPropertyFrom(appModelDescriptorObject, "enabled");
		boolean guest = getBooleanPropertyFrom(appModelDescriptorObject, "guest");
		final String htmlHeader = getStringPropertyFrom(appModelDescriptorObject, "htmlHeader");
		return new ComponentApplication(/*title, code, enabled, guest, htmlHeader*/ controllersRegistry);
	}

	private String getStringPropertyFrom(JSONObject appModelDescriptorObject, String propertyName) {
		final JSONValue propertyValue = appModelDescriptorObject.get(propertyName);
		JSONString propertyString = propertyValue.isString();
		return propertyString.stringValue();
	}

	private boolean getBooleanPropertyFrom(JSONObject appModelDescriptorObject, String propertyName) {
		final JSONValue propertyValue = appModelDescriptorObject.get(propertyName);
		JSONBoolean propertyBoolean = propertyValue.isBoolean();
		return propertyBoolean.booleanValue();
	}
}