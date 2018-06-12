/*
 * Copyright (c) 2018 Evgeny Dobrokvashin, All Rights Reserved.
 */

package ru.dobrokvashinevgeny.sprint.infrastructure.services.appmodel;

import com.google.gwt.json.client.*;
import ru.dobrokvashinevgeny.sprint.domain.model.*;
import ru.dobrokvashinevgeny.sprint.services.registry.ControllersRegistry;

/**
 * Класс GwtGuiComponentTranslator
 */
public class GwtGuiComponentTranslator {
	private final ControllersRegistry controllersRegistry;
	private GuiComponent guiComponent;

	public GwtGuiComponentTranslator(JSONObject childComponentObject, ControllersRegistry controllersRegistry) {
		this.controllersRegistry = controllersRegistry;
		parseChildComponentObject(childComponentObject);
	}

	private void parseChildComponentObject(JSONObject childComponentObject) {
		String name = getStringPropertyFrom(childComponentObject, "name");
		ComponentType componentType = getComponentTypePropertyFrom(childComponentObject, "componentType");
		switch (componentType) {
			case BorderLayout:
				guiComponent = new BorderLayoutContainer(name, controllersRegistry);
				break;
			case Button:
				guiComponent = new TextButton(name, controllersRegistry);
				break;
			default:
//				throw new Exception();
		}
	}

	private String getStringPropertyFrom(JSONObject jsonObject, String propertyName) {
		final JSONValue propertyValue = jsonObject.get(propertyName);
		JSONString propertyString = propertyValue.isString();
		return propertyString.stringValue();
	}

	private ComponentType getComponentTypePropertyFrom(JSONObject jsonObject, String propertyName) {
		final JSONValue propertyValue = jsonObject.get(propertyName);
		JSONString propertyString = propertyValue.isString();
		return ComponentType.valueOf(propertyString.stringValue());
	}

	public GuiComponent asGuiComponent() {
		return guiComponent;
	}
}