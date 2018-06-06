/*
 * Copyright (c) 2018 Evgeny Dobrokvashin, All Rights Reserved.
 */

package ru.dobrokvashinevgeny.sprint.infrastructure;

import ru.dobrokvashinevgeny.sprint.infrastructure.services.identityaccess.GwtUserAuthorizationService;
import ru.dobrokvashinevgeny.sprint.services.*;
import ru.dobrokvashinevgeny.sprint.services.identityaccess.AuthorizedUserController;

/**
 * Класс Application
 */
public class Application {
//	private final static Logger LOG = Logger.getLogger("Main");
	private final ServicesRegistry servicesRegistry;
	private final ControllersRegistry controllersRegistry;
	private final ViewRegistry viewRegistry;

	public Application(ServicesRegistry servicesRegistry, ControllersRegistry controllersRegistry,
					   ViewRegistry	viewRegistry) {
		this.servicesRegistry = servicesRegistry;
		this.controllersRegistry = controllersRegistry;
		this.viewRegistry = viewRegistry;
	}

	public GwtUserAuthorizationService createUserAuthorizationService() {
		return new GwtUserAuthorizationService();
	}

	public AuthorizedUserController createAuthorizedUserController() {
		final ApplicationInterfaceService applicationInterfaceService =
			new ApplicationInterfaceService(servicesRegistry.applicationScopedDisplayEngine());

		final ApplicationModelController applicationModelController =
			new ApplicationModelController(applicationInterfaceService);

		return new AuthorizedUserController(servicesRegistry.applicationScopedAppModelService(),
											applicationModelController);
	}
}