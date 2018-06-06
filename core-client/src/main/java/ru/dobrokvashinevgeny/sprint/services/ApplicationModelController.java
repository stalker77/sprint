/*
 * Copyright (c) 2018 Evgeny Dobrokvashin, All Rights Reserved.
 */

package ru.dobrokvashinevgeny.sprint.services;

import ru.dobrokvashinevgeny.sprint.domain.model.ComponentApplication;

/**
 * Класс ApplicationModelController
 */
public class ApplicationModelController {
	private final ApplicationInterfaceService applicationInterfaceService;

	public ApplicationModelController(ApplicationInterfaceService applicationInterfaceService) {
		this.applicationInterfaceService = applicationInterfaceService;
	}

	public void onReceiveModel(ComponentApplication componentApplication) {
		applicationInterfaceService.createApplicationInterfaceFrom(componentApplication);
	}

	public void onReceiveModelError(Exception e) {

	}
}