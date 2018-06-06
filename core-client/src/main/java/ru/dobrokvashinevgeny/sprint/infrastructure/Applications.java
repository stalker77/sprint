/*
 * Copyright (c) 2018 Evgeny Dobrokvashin, All Rights Reserved.
 */

package ru.dobrokvashinevgeny.sprint.infrastructure;

import ru.dobrokvashinevgeny.sprint.infrastructure.presentation.GxtEnvironment;
import ru.dobrokvashinevgeny.sprint.infrastructure.presentation.registry.*;
import ru.dobrokvashinevgeny.sprint.services.registry.*;

/**
 * Класс Applications
 */
public class Applications {
//	private final static Logger LOG = Logger.getLogger("Main");

	public static Application createFromConfig() {
//		LOG.log(Level.SEVERE, "Application.createFromConfig() begin");
		final GxtEnvironment environment = new GxtEnvironment();
		final ViewRegistry viewRegistry = new GxtViewRegistry(environment);
		final ControllersRegistry controllersRegistry = new GwtControllersRegistry(viewRegistry, environment);
		final ServicesRegistry servicesRegistry = new GwtServicesRegistry(controllersRegistry);

		return new Application(servicesRegistry, controllersRegistry, viewRegistry);
//		LOG.log(Level.SEVERE, "Application.createFromConfig() end");
	}
}