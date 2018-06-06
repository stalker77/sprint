/*
 * Copyright (c) 2018 Evgeny Dobrokvashin, All Rights Reserved.
 */

package ru.dobrokvashinevgeny.sprint.infrastructure.services;

import ru.dobrokvashinevgeny.sprint.services.BaseView;
import ru.dobrokvashinevgeny.sprint.services.textbutton.*;

/**
 * Класс SimpleTextButtonController
 */
public class SimpleTextButtonController implements TextButtonController {
	private final TextButtonView view;

	public SimpleTextButtonController(TextButtonView view) {
		this.view = view;
	}

	@Override
	public void createView() {
		view.create();
	}

	@Override
	public BaseView getView() {
		return view;
	}
}