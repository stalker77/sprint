/*
 * Copyright (c) 2018 Evgeny Dobrokvashin, All Rights Reserved.
 */

package ru.dobrokvashinevgeny.sprint.infrastructure.presentation.registry;

import ru.dobrokvashinevgeny.sprint.infrastructure.services.*;
import ru.dobrokvashinevgeny.sprint.services.*;
import ru.dobrokvashinevgeny.sprint.services.borderlayout.BorderLayoutViewController;
import ru.dobrokvashinevgeny.sprint.services.textbutton.TextButtonController;

/**
 * Класс GwtControllersRegistry
 */
public class GwtControllersRegistry implements ControllersRegistry {
	private final ViewRegistry viewRegistry;

	public GwtControllersRegistry(ViewRegistry viewRegistry) {
		this.viewRegistry = viewRegistry;
	}

	@Override
	public TextButtonController textButtonController() {
		return new SimpleTextButtonController(viewRegistry.textButtonView());
	}

	@Override
	public BorderLayoutViewController borderLayoutViewController() {
		return new SimpleBorderLayoutViewController(viewRegistry.borderLayoutView());
	}
}