/*
 * Copyright (c) 2018 Evgeny Dobrokvashin, All Rights Reserved.
 */

package ru.dobrokvashinevgeny.sprint.infrastructure.services;

import ru.dobrokvashinevgeny.sprint.services.BaseView;
import ru.dobrokvashinevgeny.sprint.services.borderlayout.*;

/**
 * Класс SimpleBorderLayoutViewController
 */
public class SimpleBorderLayoutViewController implements BorderLayoutViewController {
	private final BorderLayoutView view;

	public SimpleBorderLayoutViewController(BorderLayoutView view) {
		this.view = view;
	}

	@Override
	public void createView() {
		view.create();
	}

	@Override
	public void addChildView(BaseView view) {
		this.view.addChildView(view);
	}

	@Override
	public BaseView getView() {
		return view;
	}
}