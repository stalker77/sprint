/*
 * Copyright (c) 2018 Evgeny Dobrokvashin, All Rights Reserved.
 */

package ru.dobrokvashinevgeny.sprint.domain.model;

import ru.dobrokvashinevgeny.sprint.services.*;
import ru.dobrokvashinevgeny.sprint.services.borderlayout.BorderLayoutViewController;
import ru.dobrokvashinevgeny.sprint.services.registry.ControllersRegistry;

import java.util.List;

/**
 * Класс BorderLayoutContainer
 */
public class BorderLayoutContainer extends Container {
	private BorderLayoutViewController controller;

	public BorderLayoutContainer(String name, ControllersRegistry controllersRegistry) {
		super(name, ComponentType.BorderLayout);
		this.controller = controllersRegistry.borderLayoutViewController();
	}

	@Override
	public void buildComponent() {
		buildChildComponents();

		controller.createView();

		List<GuiComponent> childComponents = getChildComponents();
		for (GuiComponent component : childComponents) {
			component.locateInOwnerController(controller);
		}
	}

	@Override
	protected void locateInOwnerController(BaseViewContainerController ownerController) {
		ownerController.addChildView(controller.getView());
	}

	@Override
	public ComponentRuntimeInfo getRuntimeInfo() {
		final BaseView view = controller.getView();
		return new ComponentRuntimeInfo(view.getId());
	}
}