/*
 * Copyright (c) 2018 Evgeny Dobrokvashin, All Rights Reserved.
 */

package ru.dobrokvashinevgeny.sprint.infrastructure.services.appmodel;

import ru.dobrokvashinevgeny.sprint.domain.model.*;

import java.util.List;

/**
 * Класс JsonContainer
 */
public class JsonContainer extends JsonGuiComponent {
	private List<JsonGuiComponent> childComponents;

	public JsonContainer(String name, ComponentType componentType) {
		super(name, componentType);
	}
}