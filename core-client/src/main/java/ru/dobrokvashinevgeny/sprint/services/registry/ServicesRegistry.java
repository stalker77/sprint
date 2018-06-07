package ru.dobrokvashinevgeny.sprint.services.registry;

import ru.dobrokvashinevgeny.sprint.infrastructure.services.GwtApplicationModelService;

/**
 * Класс ServicesRegistry
 */
public interface ServicesRegistry {
	GwtApplicationModelService applicationScopedAppModelService();
}