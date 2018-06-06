/*
 * Copyright (c) 2018 Evgeny Dobrokvashin, All Rights Reserved.
 */

package ru.dobrokvashinevgeny.sprint.infrastructure.presentation.registry;

import ru.dobrokvashinevgeny.sprint.infrastructure.presentation.*;
import ru.dobrokvashinevgeny.sprint.infrastructure.services.GwtApplicationModelService;
import ru.dobrokvashinevgeny.sprint.services.*;
import ru.dobrokvashinevgeny.sprint.services.registry.*;

/**
 * Класс GwtServicesRegistry
 */
public class GwtServicesRegistry implements ServicesRegistry {
	private final GwtApplicationModelService applicationModelService;

	private final ControllersRegistry controllersRegistry;

	private final DisplayEngine displayEngine;

	public GwtServicesRegistry(ControllersRegistry controllersRegistry) {
		this.controllersRegistry = controllersRegistry;
		applicationModelService = new GwtApplicationModelService(controllersRegistry);
		displayEngine = new GwtDisplayEngine();
	}

	@Override
	public GwtApplicationModelService applicationScopedAppModelService() {
		return this.applicationModelService;
	}

	@Override
	public DisplayEngine applicationScopedDisplayEngine() {
		return this.displayEngine;
	}
}