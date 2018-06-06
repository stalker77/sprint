/*
 * Copyright (c) 2018 Evgeny Dobrokvashin, All Rights Reserved.
 */

package ru.dobrokvashinevgeny.sprint.infrastructure.presentation.registry;

import ru.dobrokvashinevgeny.sprint.infrastructure.presentation.GxtEnvironment;
import ru.dobrokvashinevgeny.sprint.infrastructure.presentation.components.*;
import ru.dobrokvashinevgeny.sprint.services.registry.ViewRegistry;
import ru.dobrokvashinevgeny.sprint.services.borderlayout.BorderLayoutView;
import ru.dobrokvashinevgeny.sprint.services.textbutton.TextButtonView;

/**
 * Класс GxtViewRegistry
 */
public class GxtViewRegistry implements ViewRegistry {
	private final GxtEnvironment environment;

	public GxtViewRegistry(GxtEnvironment environment) {
		this.environment = environment;
	}

	@Override
	public BorderLayoutView borderLayoutView() {
		return new GxtBorderLayoutView(environment);
	}

	@Override
	public TextButtonView textButtonView() {
		return new GxtTextButtonView(environment);
	}
}