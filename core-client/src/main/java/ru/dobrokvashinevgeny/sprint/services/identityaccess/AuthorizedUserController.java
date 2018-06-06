/*
 * Copyright (c) 2018 Evgeny Dobrokvashin, All Rights Reserved.
 */

package ru.dobrokvashinevgeny.sprint.services.identityaccess;

import ru.dobrokvashinevgeny.sprint.infrastructure.services.GwtApplicationModelService;
import ru.dobrokvashinevgeny.sprint.services.ApplicationModelController;

/**
 * Класс AuthorizedUserController
 */
public class AuthorizedUserController {
	private final GwtApplicationModelService applicationModelService;
	private final ApplicationModelController applicationModelController;

	public AuthorizedUserController(GwtApplicationModelService applicationModelService,
									ApplicationModelController applicationModelController) {
		this.applicationModelService = applicationModelService;
		this.applicationModelController = applicationModelController;
	}

	public void onReceiveAuthorization(UserDescriptor userDescriptor) {
		applicationModelService.appModelFromCodeTo(userDescriptor.appCode(), applicationModelController);
	}

	public void onReceiveAuthorizationError(Exception e) {

	}
}