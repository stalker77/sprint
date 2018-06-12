/*
 * Copyright (c) 2018 Evgeny Dobrokvashin, All Rights Reserved.
 */

package ru.dobrokvashinevgeny.sprint.infrastructure.services.appmodel;

import ru.dobrokvashinevgeny.sprint.domain.model.ComponentType;

/**
 * Класс JsonGuiComponent
 */
public abstract class JsonGuiComponent extends JsonComponent {
	private int x;

	private int y;

	private String width;

	private String height;

	private String toolTip;

	private boolean visible;

	private boolean enabled;

	private int tabIndex;

	public JsonGuiComponent(String name, ComponentType componentType) {
		super(name, componentType);
	}
}