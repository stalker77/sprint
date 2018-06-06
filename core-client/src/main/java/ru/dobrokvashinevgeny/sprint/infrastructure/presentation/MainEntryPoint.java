/*
 * Copyright (c) 2018 Evgeny Dobrokvashin, All Rights Reserved.
 */

package ru.dobrokvashinevgeny.sprint.infrastructure.presentation;

import com.google.gwt.core.client.EntryPoint;
import ru.dobrokvashinevgeny.sprint.infrastructure.*;
import ru.dobrokvashinevgeny.sprint.infrastructure.services.identityaccess.GwtUserAuthorizationService;
import ru.dobrokvashinevgeny.sprint.services.identityaccess.AuthorizedUserController;

import java.util.logging.*;

/**
 * Класс MainEntryPoint
 */
public class MainEntryPoint implements EntryPoint {
	private final static Logger LOG = Logger.getLogger("Main");

	@Override
	public void onModuleLoad() {
		LOG.log(Level.SEVERE, "MainEntryPoint.onModuleLoad() begin");

		Application application = Applications.createFromConfig();
		GwtUserAuthorizationService userAuthorizationService = application.createUserAuthorizationService();
		AuthorizedUserController authorizedUserController = application.createAuthorizedUserController();
		userAuthorizationService.authorizeCurrentUserTo(authorizedUserController);

		LOG.log(Level.SEVERE, "MainEntryPoint.onModuleLoad() end");
	}
}