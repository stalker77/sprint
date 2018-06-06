/*
 * Copyright (c) 2018 Evgeny Dobrokvashin, All Rights Reserved.
 */

package ru.dobrokvashinevgeny.sprint.services;

import ru.dobrokvashinevgeny.sprint.domain.model.ComponentApplication;

/**
 * Класс ApplicationInterfaceService
 */
public class ApplicationInterfaceService {
	private DisplayEngine displayEngine;

	public ApplicationInterfaceService(DisplayEngine displayEngine) {
		this.displayEngine = displayEngine;
	}


	public void createApplicationInterfaceFrom(ComponentApplication componentApplication) {
		componentApplication.build();

		displayEngine.showCurrentViewport();
	}
}