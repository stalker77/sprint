/*
 * Copyright (c) 2018 Evgeny Dobrokvashin, All Rights Reserved.
 */

package ru.dobrokvashinevgeny.sprint.infrastructure.presentation.components;

import com.sencha.gxt.widget.core.client.button.TextButton;
import ru.dobrokvashinevgeny.sprint.infrastructure.presentation.GxtEnvironment;
import ru.dobrokvashinevgeny.sprint.services.textbutton.TextButtonView;

/**
 * Класс GxtTextButtonView
 */
public class GxtTextButtonView extends AbstractView implements TextButtonView {
	private final GxtEnvironment environment;

	private TextButton button;

	public GxtTextButtonView(GxtEnvironment environment) {
		this.environment = environment;
	}

	@Override
	public void create() {
		String componentId = environment.nextComponentId();
		setInternalComponentId(componentId);
		button = environment.newTextButtonWithId(componentId);
	}

	@Override
	public String getId() {
		return getInternalComponentId();
	}
}