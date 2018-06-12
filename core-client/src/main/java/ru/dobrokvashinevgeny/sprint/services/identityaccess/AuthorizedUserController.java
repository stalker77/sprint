/*
 * Copyright (c) 2018 Evgeny Dobrokvashin, All Rights Reserved.
 */

package ru.dobrokvashinevgeny.sprint.services.identityaccess;

import ru.dobrokvashinevgeny.sprint.infrastructure.services.appmodel.GwtApplicationModelService;
import ru.dobrokvashinevgeny.sprint.services.ApplicationModelController;

import java.util.logging.*;

/**
 * Класс AuthorizedUserController
 */
public class AuthorizedUserController {
	private final static Logger LOG = Logger.getLogger("Main");
	private final GwtApplicationModelService applicationModelService;
	private final ApplicationModelController applicationModelController;

	public AuthorizedUserController(GwtApplicationModelService applicationModelService,
									ApplicationModelController applicationModelController) {
		this.applicationModelService = applicationModelService;
		this.applicationModelController = applicationModelController;
	}

	public void onReceiveAuthorization(UserDescriptor userDescriptor) {
		LOG.log(Level.SEVERE, "AuthorizedUserController.onReceiveAuthorization(\"" + userDescriptor.toString() + "\") begin");
		applicationModelService.appModelFromCodeTo(userDescriptor.appCode(), applicationModelController);
	}

	public void onReceiveAuthorizationError(Exception e) {

	}
}