/*
 * Copyright (c) 2018 Evgeny Dobrokvashin, All Rights Reserved.
 */

package ru.dobrokvashinevgeny.sprint.infrastructure.services.appmodel;

import ru.dobrokvashinevgeny.sprint.domain.model.ComponentType;

/**
 * Класс JsonTextButton
 */
public class JsonTextButton extends JsonGuiComponent {
	public JsonTextButton(String name, ComponentType componentType) {
		super(name, componentType);
	}
}