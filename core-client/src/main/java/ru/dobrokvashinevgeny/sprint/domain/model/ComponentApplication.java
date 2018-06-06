/*
 * Copyright (c) 2018 Evgeny Dobrokvashin, All Rights Reserved.
 */

package ru.dobrokvashinevgeny.sprint.domain.model;

import java.util.List;

/**
 * Класс ComponentApplication
 */
public class ComponentApplication {
	private List<GuiComponent> childComponentList;

	public void buildChildComponents() {
		for (GuiComponent component: childComponentList) {
			component.buildComponent();
		}
	}
}