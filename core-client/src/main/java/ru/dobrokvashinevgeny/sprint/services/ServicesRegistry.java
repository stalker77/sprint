package ru.dobrokvashinevgeny.sprint.services;

import ru.dobrokvashinevgeny.sprint.infrastructure.services.GwtApplicationModelService;

/**
 * Класс ServicesRegistry
 */
public interface ServicesRegistry {
	GwtApplicationModelService applicationScopedAppModelService();

	DisplayEngine applicationScopedDisplayEngine();
}