package ru.dobrokvashinevgeny.sprint.services.registry;

import ru.dobrokvashinevgeny.sprint.infrastructure.services.GwtApplicationModelService;
import ru.dobrokvashinevgeny.sprint.services.DisplayEngine;

/**
 * Класс ServicesRegistry
 */
public interface ServicesRegistry {
	GwtApplicationModelService applicationScopedAppModelService();

	DisplayEngine applicationScopedDisplayEngine();
}