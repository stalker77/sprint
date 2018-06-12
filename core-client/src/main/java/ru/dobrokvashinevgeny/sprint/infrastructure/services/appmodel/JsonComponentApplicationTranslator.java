/*
 * Copyright (c) 2018 Evgeny Dobrokvashin, All Rights Reserved.
 */

package ru.dobrokvashinevgeny.sprint.infrastructure.services.appmodel;

import com.github.nmorel.gwtjackson.client.ObjectMapper;
import com.google.gwt.core.client.GWT;
import com.google.gwt.json.client.*;
import ru.dobrokvashinevgeny.sprint.domain.model.ComponentApplication;
import ru.dobrokvashinevgeny.sprint.services.registry.ControllersRegistry;

/**
 * Класс JsonComponentApplicationTranslator
 */
public class JsonComponentApplicationTranslator {
	private final ControllersRegistry controllersRegistry;
	private ComponentApplication componentApplication;
	interface ComponentApplicationMapper extends ObjectMapper<JsonComponentApplication> {}

	public JsonComponentApplicationTranslator(String componentApplicationAsString,
											  ControllersRegistry controllersRegistry) {
		this.controllersRegistry = controllersRegistry;
		parseComponentApplicationString(componentApplicationAsString);
	}

	/*private void parseComponentApplicationString(String appModelString) {
		JSONValue componentApplicationAsJson = JSONParser.parseStrict(appModelString);
		JSONObject componentApplicationObject = componentApplicationAsJson.isObject();
		final JSONValue childComponentListValue = componentApplicationObject.get("childComponentList");
		final JSONArray childComponentListArray = childComponentListValue.isArray();
		List<GuiComponent> childComponentList = new ArrayList<>();
		for(int componentCounter = 0; componentCounter < childComponentListArray.size(); componentCounter++) {
			JSONValue childComponentValue = childComponentListArray.get(componentCounter);
			JSONObject childComponentObject = childComponentValue.isObject();
			childComponentList.add(new GwtGuiComponentTranslator(childComponentObject, controllersRegistry).asGuiComponent());
		}

		componentApplication = new ComponentApplication(childComponentList, controllersRegistry);
	}*/

	private void parseComponentApplicationString(String appModelString) {
		ComponentApplicationMapper mapper = GWT.create(ComponentApplicationMapper.class);
		JsonComponentApplication jsonComponentApplication = mapper.read(appModelString);
		componentApplication = new ComponentApplication(jsonComponentApplication.getChildComponentList(),
														controllersRegistry);
	}

	public ComponentApplication translateToComponentApplication() {
		return this.componentApplication;
	}

	private String getStringPropertyFrom(JSONObject jsonObject, String propertyName) {
		final JSONValue propertyValue = jsonObject.get(propertyName);
		JSONString propertyString = propertyValue.isString();
		return propertyString.stringValue();
	}

	private boolean getBooleanPropertyFrom(JSONObject jsonObject, String propertyName) {
		final JSONValue propertyValue = jsonObject.get(propertyName);
		JSONBoolean propertyBoolean = propertyValue.isBoolean();
		return propertyBoolean.booleanValue();
	}
}