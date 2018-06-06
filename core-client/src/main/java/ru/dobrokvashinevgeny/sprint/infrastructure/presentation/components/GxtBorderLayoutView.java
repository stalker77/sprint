/*
 * Copyright (c) 2018 Evgeny Dobrokvashin, All Rights Reserved.
 */

package ru.dobrokvashinevgeny.sprint.infrastructure.presentation.components;

import com.sencha.gxt.widget.core.client.container.BorderLayoutContainer;
import ru.dobrokvashinevgeny.sprint.infrastructure.presentation.GxtEnvironment;
import ru.dobrokvashinevgeny.sprint.services.BaseView;
import ru.dobrokvashinevgeny.sprint.services.borderlayout.BorderLayoutView;

/**
 * Класс GxtBorderLayoutView
 */
public class GxtBorderLayoutView extends AbstractView implements BorderLayoutView {
	private final GxtEnvironment environment;

	private BorderLayoutContainer container;

	public GxtBorderLayoutView(GxtEnvironment environment) {
		this.environment = environment;
	}

	@Override
	public void create() {
		String componentId = environment.nextComponentId();
		setInternalComponentId(componentId);
		container = environment.newBorderLayoutContainerWithId(componentId);
	}

	@Override
	public String getId() {
		return getInternalComponentId();
	}

	@Override
	public void addChildView(BaseView view) {
		container.add(
			environment.getCreatedComponentWithId(view.getId())
		);
	}
}