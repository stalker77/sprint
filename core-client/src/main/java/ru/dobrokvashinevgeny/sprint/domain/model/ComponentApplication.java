/*
 * Copyright (c) 2018 Evgeny Dobrokvashin, All Rights Reserved.
 */

package ru.dobrokvashinevgeny.sprint.domain.model;

import ru.dobrokvashinevgeny.sprint.services.ComponentApplicationController;
import ru.dobrokvashinevgeny.sprint.services.registry.ControllersRegistry;

import java.util.List;

/**
 * Класс ComponentApplication
 */
public class ComponentApplication {
	private final ComponentApplicationController controller;

	public ComponentApplication(ControllersRegistry controllersRegistry) {
		this.controller = controllersRegistry.componentApplicationController();
	}

	private List<GuiComponent> childComponentList;

	public void build() {
		controller.initDisplaySystem();

		buildChildComponents();

		controller.placeComponentAppToDisplaySystem();
	}

	private void buildChildComponents() {
		boolean isFirstComponent = true;
		for (GuiComponent component: childComponentList) {
			component.buildComponent();

			if (isFirstComponent) {
				controller.putComponentToDisplaySystem(component);
			} else {
				isFirstComponent = false;
			}
		}
	}
}