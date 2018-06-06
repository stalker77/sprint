/*
 * Copyright (c) 2018 Evgeny Dobrokvashin, All Rights Reserved.
 */

package ru.dobrokvashinevgeny.sprint.domain.model;

import ru.dobrokvashinevgeny.sprint.services.*;
import ru.dobrokvashinevgeny.sprint.services.textbutton.TextButtonController;

/**
 * Класс TextButton
 */
public class TextButton extends GuiComponent {
	private final TextButtonController controller;

	public TextButton(String name, ControllersRegistry controllersRegistry) {
		super(name, ComponentType.Button);
		this.controller = controllersRegistry.textButtonController();
	}

	@Override
	public void buildComponent() {
		controller.createView();
	}

	@Override
	protected void locateInOwnerController(BaseViewContainerController ownerController) {
		ownerController.addChildView(controller.getView());
	}
}