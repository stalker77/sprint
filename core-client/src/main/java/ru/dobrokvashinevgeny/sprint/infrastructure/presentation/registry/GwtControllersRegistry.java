/*
 * Copyright (c) 2018 Evgeny Dobrokvashin, All Rights Reserved.
 */

package ru.dobrokvashinevgeny.sprint.infrastructure.presentation.registry;

import ru.dobrokvashinevgeny.sprint.infrastructure.presentation.*;
import ru.dobrokvashinevgeny.sprint.infrastructure.services.*;
import ru.dobrokvashinevgeny.sprint.services.ComponentApplicationController;
import ru.dobrokvashinevgeny.sprint.services.borderlayout.BorderLayoutViewController;
import ru.dobrokvashinevgeny.sprint.services.registry.*;
import ru.dobrokvashinevgeny.sprint.services.textbutton.TextButtonController;

/**
 * Класс GwtControllersRegistry
 */
public class GwtControllersRegistry implements ControllersRegistry {
	private final ViewRegistry viewRegistry;
	private final GxtEnvironment environment;

	public GwtControllersRegistry(ViewRegistry viewRegistry, GxtEnvironment environment) {
		this.viewRegistry = viewRegistry;
		this.environment = environment;
	}

	@Override
	public TextButtonController textButtonController() {
		return new SimpleTextButtonController(viewRegistry.textButtonView());
	}

	@Override
	public ComponentApplicationController componentApplicationController() {
		return new GwtComponentApplicationController(environment);
	}

	@Override
	public BorderLayoutViewController borderLayoutViewController() {
		return new SimpleBorderLayoutViewController(viewRegistry.borderLayoutView());
	}
}