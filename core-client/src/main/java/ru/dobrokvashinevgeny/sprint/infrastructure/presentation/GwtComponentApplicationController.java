/*
 * Copyright (c) 2018 Evgeny Dobrokvashin, All Rights Reserved.
 */

package ru.dobrokvashinevgeny.sprint.infrastructure.presentation;

import com.google.gwt.user.client.ui.Widget;
import ru.dobrokvashinevgeny.sprint.domain.model.GuiComponent;
import ru.dobrokvashinevgeny.sprint.domain.model.ComponentRuntimeInfo;
import ru.dobrokvashinevgeny.sprint.services.ComponentApplicationController;

/**
 * Класс GwtComponentApplicationController
 */
public class GwtComponentApplicationController implements ComponentApplicationController {
	private final GxtEnvironment environment;

	public GwtComponentApplicationController(GxtEnvironment environment) {
		this.environment = environment;
	}

	@Override
	public void initDisplaySystem() {
	}

	@Override
	public void putComponentToDisplaySystem(GuiComponent component) {
		ComponentRuntimeInfo componentRuntimeInfo = component.getRuntimeInfo();
		Widget widget = environment.getCreatedComponentWithId(componentRuntimeInfo.getViewId());
		environment.setCurrentViewportWidget(widget);
	}

	@Override
	public void placeComponentAppToDisplaySystem() {
		environment.showCurrentViewport();
	}
}