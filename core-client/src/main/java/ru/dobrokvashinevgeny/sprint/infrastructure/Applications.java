/*
 * Copyright (c) 2018 Evgeny Dobrokvashin, All Rights Reserved.
 */

package ru.dobrokvashinevgeny.sprint.infrastructure;

import ru.dobrokvashinevgeny.sprint.infrastructure.presentation.registry.*;
import ru.dobrokvashinevgeny.sprint.services.*;

/**
 * Класс Applications
 */
public class Applications {
//	private final static Logger LOG = Logger.getLogger("Main");

	public static Application createFromConfig() {
//		LOG.log(Level.SEVERE, "Application.createFromConfig() begin");
		final ServicesRegistry servicesRegistry = new GwtServicesRegistry();
		final ViewRegistry viewRegistry = new GxtViewRegistry();
		final ControllersRegistry controllersRegistry = new GwtControllersRegistry(viewRegistry);

		return new Application(servicesRegistry, controllersRegistry, viewRegistry);
//		LOG.log(Level.SEVERE, "Application.createFromConfig() end");
	}
}